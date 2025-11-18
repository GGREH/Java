package LR5;

import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String savefilename = "C:\\Users\\SIN\\Desktop\\JavaGit\\Java\\OOP\\LR5\\out.txt";
        List<Patient> listOfPatients = new ArrayList<>();

        try {
            patientAddToList(listOfPatients);
        } catch (IOException e) {
            System.out.println("Error reading patients: " + e.getMessage());
        }

        int opt;
        do {
            pickAction();
            opt = in.nextInt();
            in.nextLine();

            switch (opt) {
                case 1 -> certainDoctor(listOfPatients);
                case 2 -> visit(listOfPatients);
                case 3 -> districtDoctor(listOfPatients);
                case 4 -> sortByCardNumber(listOfPatients);
                case 5 -> filterByDistrict(listOfPatients);
                case 6 -> countByDistrict(listOfPatients);
                case 7 -> collectionOutput(listOfPatients);
                case 8 -> {
                    savePatientsToFile(savefilename, listOfPatients);
                    System.out.println("Exiting the programm...");
                    return;
                }
                default -> System.out.println("Try again.");
            }
        } while (opt != 8);

    }

    static int patientCount = 0;

    static void increasePatientCount() {
        patientCount++;
    }

    static void patientAddToList(List<Patient> Patients) throws IOException {
        try (FileReader fileReader = new FileReader("C:\\Users\\SIN\\Desktop\\JavaGit\\Java\\OOP\\LR5\\patients.txt");
                BufferedReader reader = new BufferedReader(fileReader)) {

            String line;
            System.out.println("\n--- Patients ---");

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 9) {
                    try {
                        String patientName = parts[0] + " " + parts[1];
                        String district = parts[2];
                        int cardNumber = Integer.parseInt(parts[3]);
                        String doctorName = parts[4] + " " + parts[5];
                        int day = Integer.parseInt(parts[6]);
                        int month = Integer.parseInt(parts[7]);
                        int year = Integer.parseInt(parts[8]);

                        Patient newPatient = new Patient(cardNumber, patientName, district, doctorName, day, month,
                                year);
                        Patients.add(newPatient);
                        System.out.println(newPatient.toString());

                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid number format in line: " + line);
                    }
                } else {
                    System.out.println("Error: Invalid number of fields: " + line);
                }
            }
        }
    }

    static void pickAction() {
        System.out.println("\t Select an option:");
        System.out.println("1. Patients of a certain doctor");
        System.out.println("2. Patients who haven't visited after a specified date");
        System.out.println("3. One district, one doctor");
        System.out.println("4. Sort patients by card number");
        System.out.println("5. Filter patients by district");
        System.out.println("6. Count patients by district");
        System.out.println("7. Output entire collection");
        System.out.println("8. Exit");
    }

    static void certainDoctor(List<Patient> listOfPatients) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter doctor's name: ");
        String doc = in.nextLine().trim();

        boolean found = false;
        for (Patient patient : listOfPatients) {
            if (patient.full_name_d.contains(doc)) {
                System.out.println(patient);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Patients of this doctor not found");
        }

    }

    static void visit(List<Patient> listOfPatients) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the last visit date (day month year): ");
        int d = in.nextInt();
        int m = in.nextInt();
        int y = in.nextInt();

        LocalDate inputDate = LocalDate.of(y, m, d);

        boolean found = false;
        for (Patient patient : listOfPatients) {
            LocalDate visitDate = LocalDate.of(patient.year, patient.month, patient.day);
            if (visitDate.isBefore(inputDate)) {
                System.out.println(patient);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Patients who haven't visited after this date were not found");
        }

    }

    static void districtDoctor(List<Patient> listOfPatients) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter doctor's name: ");
        String doc = in.nextLine();

        System.out.println("Enter district: ");
        String dist = in.nextLine();

        boolean found = false;
        for (Patient patient : listOfPatients) {
            if (patient.full_name_d.contains(doc) && patient.district.name().equalsIgnoreCase(dist)) {
                System.out.println(patient);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Patients in this district and of this doctor not found");
        }

    }

    static void sortByCardNumber(List<Patient> listOfPatients) {
        listOfPatients.sort((p1, p2) -> Integer.compare(p1.med_card_number, p2.med_card_number));
        System.out.println("Patients sorted by card number:");
        collectionOutput(listOfPatients);
    }

    static void filterByDistrict(List<Patient> listOfPatients) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter district: ");
        String dist = in.nextLine().trim();

        Patient.District district;
        try {
            district = Patient.District.valueOf(dist);
        } catch (IllegalArgumentException e) {
            System.out.println("Unknown district");
            return;
        }
        listOfPatients.stream().filter(p -> p.district == district).forEach(System.out::println);

    }

    static void countByDistrict(List<Patient> listOfPatients) {
        Map<Patient.District, Long> countByArea = listOfPatients.stream()
                .collect(Collectors.groupingBy(p -> p.district, Collectors.counting()));

        countByArea.forEach((area, count) -> System.out.println(area + ": " + count));
    }

    static void collectionOutput(List<Patient> listOfPatients) {
        if (listOfPatients.isEmpty()) {
            System.out.println("Collection is empty");
        } else {
            for (Patient patient : listOfPatients) {
                System.out.println(patient);
            }
        }
    }

    static void savePatientsToFile(String filename, List<Patient> listOfPatients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(listOfPatients);
            System.out.println("Data successfully saved to file");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}