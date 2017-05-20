package uk.ac.cam.intdes.gr1.ui;

import com.sun.istack.internal.Nullable;
import javafx.beans.NamedArg;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import uk.ac.cam.intdes.gr1.AppSettings;


public class SettingButton extends Pane{

    AppSettings currentStatus = AppSettings.getInstance();

    public SettingButton(@NamedArg("Button text") String text, @NamedArg("Event Handler") @Nullable EventHandler<?
            super MouseEvent> onClick, int height, int width, Color startColor){

        super();

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setColor(startColor);
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

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {

			((VBox)this.getParent()).getChildren().forEach(e -> {
				((SettingButton)e).setColor(Color.BLACK);
			});
			setColor(Color.color(0.0,0.7,1.0));
			if (tempOrDist) {
				currentStatus.setFahrenheit(modeToSet);
			} else {
				currentStatus.setMiles(modeToSet);
			}
        });
    }

    public void setColor(Color c){
        this.setBackground(new Background(new BackgroundFill(c, new CornerRadii(1),
                new Insets(0,0,0,0))));
    }

}
