package Java.OOP.IR3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AboutController {

    // @FXML необхідний лише тут, для полів
    @FXML
    private ComboBox<String> group;
    @FXML
    private TextField date;
    @FXML
    private Spinner<Integer> mark;
    @FXML
    private ImageView imageME;
    @FXML
    private Button exitButton;

    // @FXML перед initialize() є необов'язковим, оскільки він public і викликається
    // автоматично
    public void initialize() {
        exitButton.setOnAction(actionEvent -> Platform.exit());

        // Використання try-with-resources для безпечного закриття потоку (більше не
        // потрібен inputStream.close())
        try (FileInputStream inputStream = new FileInputStream(
                "C:\\Users\\SIN\\Desktop\\JavaGit\\Java\\OOP\\IR3\\photo_2025-11-18_43-42.jpg")) {
            Image image = new Image(inputStream);
            imageME.setImage(image);
        } catch (IOException e) {
            System.err.println("Помилка завантаження зображення: " + e.getMessage());
            // Можливо, тут потрібно додати fallback зображення
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = LocalDateTime.now().format(formatter);
        date.setText(currentDateTime);

        group.getItems().addAll("AнД-21", "КН-21", "КН-22");
        mark.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));
    }
}
