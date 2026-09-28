package com.example.ukfhomeworkjavaot;

import javafx.fxml.FXML;

public class CalculatorController {

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void goBack() {
        mainController.showMenu();
    }
}
