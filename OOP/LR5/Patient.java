package LR5;

import java.io.Serializable;

public class Patient implements Serializable {
    enum District {
        Holosiivskyi,
        Darnytskyi,
        Desniansky,
        Dniprovsky,
        Obolonsky,
        Pechersky,
        Podilsky,
        Svyatoshinsky,
        Solomiansky,
        Shevchenkivsky,
        Unknown
    }

    public String full_name_p, full_name_d;
    public District district;
    public int med_card_number, day, month, year;

    public Patient() {
        this(0, "Unknown", "Unknown", "Unknown", 1, 1, 2000);
    }

    public Patient(int cardNumber, String patientName, String district, String doctorName, int day, int month,
            int year) {
        this.med_card_number = cardNumber;
        this.full_name_p = patientName;
        this.full_name_d = doctorName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.district = parseDistrict(district);
    }

    private District parseDistrict(String district) {
        try {
            return District.valueOf(district);
        } catch (IllegalArgumentException e) {
            return District.Unknown;
        }
    }

    @Override
    public String toString() {
        return full_name_p + ", " + "\tCard Number: " + med_card_number + ", " + "\tDoctor: " + full_name_d + ", "
                + "\tDistrict: " + full_name_p + ", " + "\tLast visit: " + day + "." + month + "." + year;
    }
}
