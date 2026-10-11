
package com.example.ukfhomeworkjavaot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ElevatorController {

    @FXML private Pane root;
    @FXML private Label floorLabel;
    private Elevator elevator;

    private static final double FLOOR_HEIGHT = 20;
    private static final double PANE_HEIGHT = 200;

@FXML
private void initialize() {
    elevator = new Elevator(50, FLOOR_HEIGHT);
    elevator.setX(175);
    elevator.setY(floorToY(0));
    root.getChildren().add(elevator);

    root.sceneProperty().addListener((obs, oldScene, newScene) -> {
        if (newScene != null) {
            newScene.setOnKeyPressed(e -> {
                String text = e.getText();
                if (text.matches("[0-8]")) {
                    int floor = Integer.parseInt(text);
                    elevator.moveToY(floorToY(floor));
                }
            });
        }
    });

    elevator.translateYProperty().addListener((obs, oldV, newV) -> {
        double currentY = elevator.getY() + newV.doubleValue();
        long floor = Math.round(((PANE_HEIGHT - FLOOR_HEIGHT) - currentY) / FLOOR_HEIGHT);
        floorLabel.setText("Poschodie: " + floor);
    });
}

    private double floorToY(int floor){
      return (PANE_HEIGHT - FLOOR_HEIGHT) - floor * FLOOR_HEIGHT;
    }
}
