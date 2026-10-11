package com.example.ukfhomeworkjavaot;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

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

    @FXML
    private void showConversion() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("conversion-view.fxml")
                );

        Node conversionView = loader.load();

        ConversionController conversionController = loader.getController();
        conversionController.setMainController(this);

        content.getChildren().setAll(conversionView);
    }
    
    @FXML
    private void showElevator() throws IOException{
      FXMLLoader loader = new FXMLLoader(
          getClass().getResource("elevator-view.fxml")
          );

      Node elevatorView = loader.load();

      content.getChildren().setAll(elevatorView);
    }

    public void showMenu() {
        content.getChildren().setAll(menuPage);
    }
}
