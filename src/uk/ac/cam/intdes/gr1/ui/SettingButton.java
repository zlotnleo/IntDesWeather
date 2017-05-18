package uk.ac.cam.intdes.gr1.ui;

import com.sun.istack.internal.Nullable;
import javafx.beans.NamedArg;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class SettingButton extends Pane{

    public SettingButton(@NamedArg("Button text") String text, @NamedArg("Event Handler") @Nullable EventHandler<?
            super MouseEvent> onClick, int height, int width, Color backColor){

        super();

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setColor(backColor);
    }

    public SettingButton(@NamedArg("Button text") String text, @NamedArg("Event Handler") @Nullable EventHandler<?
            super MouseEvent> onClick, int height, int width){

        super();

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);
        this.setPrefWidth(width);
        this.setPrefHeight(height);
    }

    public void setColor(Color c){
        this.setBackground(new Background(new BackgroundFill(c, new CornerRadii(1),
                new Insets(0,0,0,0))));
    }

}
