package com.example.ukfhomeworkjavaot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController {

    @FXML
    private StackPane content;

    @FXML
    private AnchorPane menuPage;

    @FXML
    private void showCalculator() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("calculator-view.fxml")
        );

        Node calculatorView = loader.load();

        CalculatorController calculatorController = loader.getController();
        calculatorController.setMainController(this);

        content.getChildren().setAll(calculatorView);
    }

    public void showMenu() {
        content.getChildren().setAll(menuPage);
    }
}
