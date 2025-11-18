package IR3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;

public class CalcController {
    @FXML
    private TextField lengthTextField;
    @FXML
    private TextField widthTextField;
    @FXML
    private RadioButton rectangleButton;
    @FXML
    private RadioButton squareButton;
    @FXML
    private CheckBox areaCheckBox;
    @FXML
    private Button exitButton;
    @FXML
    private Button aboutButton;
    @FXML
    private CheckBox perimeterCheckBox;
    @FXML
    private CheckBox diagonalCheckBox;
    @FXML
    private Label resultLabel;
    @FXML
    private Button calculateButton;
    @FXML
    private Pane shapePane;
    @FXML
    private Rectangle shapeRectangle;

    private Model model = new Model();

    @FXML
    private void initialize() {
        ToggleGroup shapeGroup = new ToggleGroup();
        rectangleButton.setToggleGroup(shapeGroup);
        squareButton.setToggleGroup(shapeGroup);

        calculateButton.setOnAction(event -> calculate());
        exitButton.setOnAction(actionEvent -> Platform.exit());

        rectangleButton.setOnAction(event -> updateShapeDisplay());
        squareButton.setOnAction(event -> updateShapeDisplay());

        lengthTextField.textProperty().addListener((observable, oldValue, newValue) -> updateShapeDisplay());
        widthTextField.textProperty().addListener((observable, oldValue, newValue) -> updateShapeDisplay());

        aboutButton.setOnAction(actionEvent -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Aboutview.fxml"));
                Parent nextWindowRoot = fxmlLoader.load();
                Scene nextScene = new Scene(nextWindowRoot);
                Stage currentStage = (Stage) aboutButton.getScene().getWindow();
                currentStage.setScene(nextScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void updateShapeDisplay() {
        try {
            double a = Double.parseDouble(lengthTextField.getText());
            double b = Double.parseDouble(widthTextField.getText());

            double multiplier = 10.0;

            double displayWidth = a * multiplier;
            double displayHeight = b * multiplier;

            double maxSize = 150.0;
            if (displayWidth > maxSize || displayHeight > maxSize) {
                double scale = maxSize / Math.max(displayWidth, displayHeight);
                displayWidth *= scale;
                displayHeight *= scale;
            }

            double centerX = (shapePane.getWidth() - displayWidth) / 2;
            double centerY = (shapePane.getHeight() - displayHeight) / 2;

            shapeRectangle.setX(centerX);
            shapeRectangle.setY(centerY);
            shapeRectangle.setWidth(displayWidth);
            shapeRectangle.setHeight(displayHeight);
            shapeRectangle.setVisible(true);

        } catch (NumberFormatException e) {
            shapeRectangle.setVisible(false);
        }
    }

    @FXML
    private void calculate() {
        try {
            double a = Double.parseDouble(lengthTextField.getText());
            double b = Double.parseDouble(widthTextField.getText());

            if (rectangleButton.isSelected() || squareButton.isSelected()) {
                if (!areaCheckBox.isSelected() && !perimeterCheckBox.isSelected() && !diagonalCheckBox.isSelected()) {
                    resultLabel.setText("Оберіть що обчислювати (Площа, Периметр, або Діагональ)");
                    return;
                }

                if (squareButton.isSelected() && a != b) {
                    resultLabel.setText("Для квадрата довжина і ширина мають бути рівні");
                    return;
                }

                StringBuilder result = new StringBuilder("Результат:\n");

                if (areaCheckBox.isSelected()) {
                    double area = model.calculateArea(a, b);
                    result.append("Площа S (a * b)= ").append(area).append("\n");
                }

                if (perimeterCheckBox.isSelected()) {
                    double perimeter = model.calculatePerimeter(a, b);
                    result.append("Периметр P 2 * (a + b) = ").append(perimeter).append("\n");
                }

                if (diagonalCheckBox.isSelected()) {
                    double diagonal = model.calculateDiagonal(a, b);
                    result.append("Діагональ d = ").append(diagonal).append("\n");
                }

                resultLabel.setText(result.toString());

                updateShapeDisplay();
            } else {
                resultLabel.setText("Виберіть фігуру (Прямокутник або Квадрат)");
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Введіть значення сторін фігури");
            shapeRectangle.setVisible(false);
        }
    }
}