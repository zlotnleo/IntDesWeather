package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
import uk.ac.cam.intdes.gr1.AppSettings;

public class SettingPane extends GridPane{

    /*
        TODONE: allow EventHandlers to update colours of all VBox children (i.e. colour highlighting for selected option
        TODO: set default colours on program load.
        TODO: Internal border for SettingPane.
        TODO: Fonts and colours
        TODO:

        Was thinking of using Javafx Node ID to identify boxes safely but it's not being recognised for some reason.
        Resorting to messy getParent() calls.

    */

    AppSettings context = AppSettings.getInstance();


    public SettingPane(int prefHeight, int prefWidth) {

        this.setGridLinesVisible(true);
        // Grid lines visible (testing purposes)
        this.setPrefWidth(prefWidth);
        this.setPrefHeight(prefHeight);
        ColumnConstraints c1 = new ColumnConstraints(), c2 = new ColumnConstraints();
        c1.setPercentWidth(50); c2.setPercentWidth(50);
        // c1 contains setting names, c2 contains setting values
        Label lb1 = new Label("Temperature Units:");
        Label lb2 = new Label("Distance Units:");
        VBox TempBox = new VBox(
				new SettingButton("Celcius", true, false, (int)getPrefHeight()/4, (int)getPrefWidth()/2 - 30),
				new SettingButton("Fahrenheit", true, true, (int)getPrefHeight()/4, (int)getPrefWidth()/2 - 30)
			);
        VBox DistBox = new VBox(
        		new SettingButton("Kilometres", false, false, (int)getPrefHeight()/4, (int)getPrefWidth()/2 - 30),
				new SettingButton("Celcius", false, true, (int)getPrefHeight()/4, (int)getPrefWidth()/2 - 30)
			);

        this.getColumnConstraints().addAll(c1,c2);
        addRow(0,lb1,TempBox);
        addRow(1, lb2,DistBox);
    }

}