package com.example.ukfhomeworkjavaot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField vstup1, vstup2;

    @FXML
    private Label vystup3;

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void goBack() {
        mainController.showMenu();
    }

    @FXML
    private void plus() {
        try {

            double a = Double.parseDouble(vstup1.getText());
            double b = Double.parseDouble(vstup2.getText());

            vystup3.setText(format(a + b));

        } catch (NumberFormatException e) {
            vystup3.setText("Wrong input");
        }
    }

    @FXML
    private void minus() {
        try {

            double a = Double.parseDouble(vstup1.getText());
            double b = Double.parseDouble(vstup2.getText());

            vystup3.setText(format(a - b));
        } catch (NumberFormatException e) {
            vystup3.setText("Wrong input");
        }
    }

    @FXML
    private void multiply() {
        try {

            double a = Double.parseDouble(vstup1.getText());
            double b = Double.parseDouble(vstup2.getText());

            vystup3.setText(format(a * b));
        } catch (NumberFormatException e) {
            vystup3.setText("Wrong input");
        }
    }

    @FXML
    private void divide() {
        try {

            double a = Double.parseDouble(vstup1.getText());
            double b = Double.parseDouble(vstup2.getText());

            if (b == 0) {
                vystup3.setText("Divide by 0");
                return;
            }

            vystup3.setText(format(a / b));
        } catch (NumberFormatException e) {
            vystup3.setText("Wrong input");
        }
    }

    private String format(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}
