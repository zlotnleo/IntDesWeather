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
import javafx.event.EventType;
import uk.ac.cam.intdes.gr1.AppSettings;


public class SettingButton extends Pane{

    AppSettings currentStatus = AppSettings.getInstance();

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

    // VERY messy solution to allow buttons to know which setting they need to update. Should really replace
    // with fancy dynamic handlers, but this will do for proof-of-concept (aka high-fidelity prototype.
    public SettingButton(String buttonText, boolean tempOrDist, boolean modeToSet, int height, int width){
        super();
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                setColor(Color.LIGHTGOLDENRODYELLOW);
                // TODO: FILL THIS IN.
            }
        });
    }

    public void setColor(Color c){
        this.setBackground(new Background(new BackgroundFill(c, new CornerRadii(1),
                new Insets(0,0,0,0))));
    }

}
