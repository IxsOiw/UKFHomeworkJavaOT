package com.example.ukfhomeworkjavaot;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Elevator extends Rectangle{
  private int currentFloor = 0;
  private boolean moving = false;
  private double pendingY = Double.NaN;


  public Elevator(double width, double height){
    super(width,height);
    setFill(Color.STEELBLUE);
  }
  public int getCurrentFloor(){
    return currentFloor;
  }
public void moveToY(double targetY) {
    if (moving) {
        pendingY = targetY;
        return;
    }
    moving = true;

    TranslateTransition tt = new TranslateTransition(Duration.seconds(1), this);
    tt.setToY(targetY - getY());
    tt.setOnFinished(e -> {
        if (Double.isNaN(pendingY)) {
            moving = false;
        } else {
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(ev -> {
                double next = pendingY;
                pendingY = Double.NaN;
                moving = false;
                moveToY(next);
            });
            pause.play();
        }
    });
    tt.play();
}
  public boolean isMoving(){
    return moving;
  }

}
