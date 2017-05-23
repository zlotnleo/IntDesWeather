package uk.ac.cam.intdes.gr1.ui;

import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import uk.ac.cam.intdes.gr1.AppSettings;
import uk.ac.cam.intdes.gr1.RecentLocations;

public class SettingPane extends GridPane{

		private static Color activeColor = Color.color(0.0,0.7,1.0,0.7);
		private static Color inactiveColor = Color.color(0.0,0.7,1.0,0.3);

		AppSettings currentStatus = AppSettings.getInstance();

    /*
        TODO: Internal border for SettingPane.
        TODONE: Fonts and colours

    */


    public SettingPane(int prefHeight, int prefWidth, boolean fileTemp, boolean fileDist) {

        this.setGridLinesVisible(true);
        // Grid lines visible (testing purposes)

        this.setPrefWidth(prefWidth);
        this.setPrefHeight(prefHeight);
        ColumnConstraints c1 = new ColumnConstraints(), c2 = new ColumnConstraints();
        c1.setPercentWidth(50); c2.setPercentWidth(50);
		StackPane align1 = new StackPane(), align2 = new StackPane(), align3 = new StackPane();
		align1.setPrefWidth(this.getPrefWidth() / 2 - 10);
		align2.setPrefWidth(this.getPrefWidth() / 2 - 10);
		align3.setPrefWidth(this.getPrefWidth() / 2 - 10);
        Label lb1 = new Label("Temperature\nUnits:");
        Label lb2 = new Label("Distance\nUnits:");
        Label lb3 = new Label("Reset recent\nlocations");
		lb1.setTextAlignment(TextAlignment.CENTER);
		lb2.setTextAlignment(TextAlignment.CENTER);
		lb3.setTextAlignment(TextAlignment.CENTER);
		lb1.setTextFill(Color.color(0,0.7,1));
		lb1.setFont(Font.font("Courier", FontWeight.BOLD, 20));
		lb2.setTextFill(Color.color(0,0.7,1));
		lb2.setFont(Font.font("Courier", FontWeight.BOLD, 20));
		lb3.setTextFill(Color.color(0,0.7,1));
		lb3.setFont(Font.font("Courier", FontWeight.BOLD, 20));
		align1.getChildren().add(lb1);
		StackPane.setAlignment(lb1, Pos.CENTER);
		align2.getChildren().add(lb2);
		StackPane.setAlignment(lb2, Pos.CENTER);
		align3.getChildren().add(lb3);
        VBox TempBox = new VBox();
        TempBox.getChildren().addAll(new SettingButton("Celsius", event -> {
            try{
                SettingButton evtsource = (SettingButton)event.getSource();
                TempBox.getChildren().forEach(e -> ((SettingButton)e).setColor(inactiveColor));
                evtsource.setColor(activeColor);
                currentStatus.setFahrenheit(false);
            }
            catch(ClassCastException cce){
                System.out.println(String.format("Found a cast exception from source of type %s", event.getSource().getClass().getName()));
            }
        }, (int)getPrefHeight()/5, (int)getPrefWidth()/2 - 20, fileTemp ? inactiveColor : activeColor),
				new SettingButton("Fahrenheit", event -> {
                    try{
                        SettingButton evtsource = (SettingButton)event.getSource();
                        TempBox.getChildren().forEach(e -> ((SettingButton)e).setColor(inactiveColor));
                        evtsource.setColor(activeColor);
                        currentStatus.setFahrenheit(true);
                    }
                    catch(ClassCastException cce){
                        System.out.println(String.format("Found a cast exception from source of type %s", event.getSource().getClass().getName()));
                    }
                }, (int)getPrefHeight()/5, (int)getPrefWidth()/2 - 20, fileTemp ? activeColor : inactiveColor)
			);
        VBox DistBox = new VBox();
        DistBox.getChildren().addAll(
        		new SettingButton("Kilometres", event -> {
                    try{
                        SettingButton evtsource = (SettingButton)event.getSource();
                        DistBox.getChildren().forEach(e -> ((SettingButton)e).setColor(inactiveColor));
                        evtsource.setColor(activeColor);
                        currentStatus.setMiles(false);
                    }
                    catch(ClassCastException cce){
                        System.out.println(String.format("Found a cast exception from source of type %s", event.getSource().getClass().getName()));
                    }
                }, (int)getPrefHeight()/5, (int)getPrefWidth()/2 - 20, fileDist ? inactiveColor : activeColor),

				new SettingButton("Miles", event -> {
                    try{
                        SettingButton evtsource = (SettingButton)event.getSource();
                        DistBox.getChildren().forEach(e ->((SettingButton)e).setColor(inactiveColor));
                        evtsource.setColor(activeColor);
                        currentStatus.setMiles(true);
                    }
                    catch(ClassCastException cce){
                        System.out.println(String.format("Found a cast exception from source of type %s", event.getSource().getClass().getName()));
                    }
                }, (int)getPrefHeight()/5, (int)getPrefWidth()/2 - 20, fileDist ? activeColor : inactiveColor)
			);
		VBox resetButton = new VBox();
		resetButton.getChildren().add(
				new SettingButton("Reset", e -> RecentLocations.getInstance().clear(), (int)getPrefHeight() / 5, (int)getPrefWidth() / 2 - 20, activeColor)
		);

        this.getColumnConstraints().addAll(c1,c2);
        addRow(0,align1,TempBox);
        addRow(1, align2,DistBox);
        addRow(2,align3,resetButton);
    }

}