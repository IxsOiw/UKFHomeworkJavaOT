
package com.example.ukfhomeworkjavaot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConversionController {

    @FXML
    private TextField vstup1;

    @FXML
    private Label vystup1, vystup2, vystup3, vystup4;

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML 
    private void goBack() {
        mainController.showMenu();
    }

    @FXML
    private void conversion(){
        try {
            double m = Double.parseDouble(vstup1.getText());

            vystup1.setText(format(m * 1000 ));
            vystup2.setText(format(m * 100 ));
            vystup3.setText(format(m));
            vystup4.setText(format(m / 1000));
        } catch(NumberFormatException e) {
            vystup1.setText("Wrong input");
        }
    }


    private String format(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}
