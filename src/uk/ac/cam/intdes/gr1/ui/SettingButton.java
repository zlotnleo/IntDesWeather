package uk.ac.cam.intdes.gr1.ui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;


public class SettingButton extends StackPane{

    public SettingButton(String text, EventHandler<?
            super MouseEvent> onClick, int height, int width, Color startColor){
        super();
        Label lbl = new Label(text);
        this.getChildren().add(lbl);
		lbl.setTextFill(Color.WHITE);
		lbl.setFont(Font.font("Courier", FontWeight.BOLD, 20));
        this.setAlignment(lbl, Pos.CENTER);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setColor(startColor);
    }

    public void setColor(Color c){
        this.setBackground(new Background(new BackgroundFill(c, new CornerRadii(0),
                new Insets(0,0,0,0))));
    }

}
