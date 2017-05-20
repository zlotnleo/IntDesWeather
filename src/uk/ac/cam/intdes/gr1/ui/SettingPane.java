package uk.ac.cam.intdes.gr1.ui;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import uk.ac.cam.intdes.gr1.AppSettings;

public class SettingPane extends GridPane{

		private static Color activeColor = Color.color(0.0,0.7,1.0,0.7);
		private static Color inactiveColor = Color.color(0.0,0.7,1.0,0.3);

		AppSettings currentStatus = AppSettings.getInstance();

    /*
        TODO: Internal border for SettingPane.
        TODO: Fonts and colours

    */


    public SettingPane(int prefHeight, int prefWidth, boolean fileTemp, boolean fileDist) {

        this.setGridLinesVisible(true);
        // Grid lines visible (testing purposes)

        this.setPrefWidth(prefWidth);
        this.setPrefHeight(prefHeight);
        ColumnConstraints c1 = new ColumnConstraints(), c2 = new ColumnConstraints();
        c1.setPercentWidth(50); c2.setPercentWidth(50);
        Label lb1 = new Label("Temperature Units:");
        Label lb2 = new Label("Distance Units:");
        VBox TempBox = new VBox();
        TempBox.getChildren().addAll(new SettingButton("Celcius", new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						try{
							SettingButton evtsource = (SettingButton)event.getSource();
							TempBox.getChildren().forEach(e -> ((SettingButton)e).setColor(inactiveColor));
							evtsource.setColor(activeColor);
						}
						catch(ClassCastException cce){
							System.out.println(String.format("Found a cast exception from source of type %s", event.getSource().getClass().getName()));
						}
					}
				}, (int)getPrefHeight()/4, (int)getPrefWidth()/2 - 20, fileTemp ? inactiveColor : activeColor),
				new SettingButton("Fahrenheit", new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						try{
							SettingButton evtsource = (SettingButton)event.getSource();
							TempBox.getChildren().forEach(e -> ((SettingButton)e).setColor(inactiveColor));
							evtsource.setColor(activeColor);
						}
						catch(ClassCastException cce){
							System.out.println(String.format("Found a cast exception from source of type %s", event.getSource().getClass().getName()));
						}
					}
				}, (int)getPrefHeight()/4, (int)getPrefWidth()/2 - 20, fileTemp ? activeColor : inactiveColor)
			);
        VBox DistBox = new VBox();
        DistBox.getChildren().addAll(
        		new SettingButton("Kilometres", new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						try{
							SettingButton evtsource = (SettingButton)event.getSource();
							DistBox.getChildren().forEach(e -> ((SettingButton)e).setColor(inactiveColor));
							evtsource.setColor(activeColor);
							currentStatus.setMiles(false);
						}
						catch(ClassCastException cce){
							System.out.println(String.format("Found a cast exception from source of type %s", event.getSource().getClass().getName()));
						}
					}
				}, (int)getPrefHeight()/4, (int)getPrefWidth()/2 - 20, fileDist ? inactiveColor : activeColor),

				new SettingButton("Miles", new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						try{
							SettingButton evtsource = (SettingButton)event.getSource();
							DistBox.getChildren().forEach(e ->((SettingButton)e).setColor(inactiveColor));
							evtsource.setColor(activeColor);
							currentStatus.setMiles(true);
						}
						catch(ClassCastException cce){
							System.out.println(String.format("Found a cast exception from source of type %s", event.getSource().getClass().getName()));
						}
					}
				}, (int)getPrefHeight()/4, (int)getPrefWidth()/2 - 20, fileDist ? activeColor : inactiveColor)
			);

        this.getColumnConstraints().addAll(c1,c2);
        addRow(0,lb1,TempBox);
        addRow(1, lb2,DistBox);
    }

}