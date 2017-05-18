package uk.ac.cam.intdes.gr1.ui;

import com.sun.istack.internal.Nullable;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import uk.ac.cam.intdes.gr1.AppSettings;

public class SettingPane extends GridPane{

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
        VBox TempBox = new VBox(new SettingButton("sadf", new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Hey you clicked on a thing");
            }
        }, (int)getPrefHeight()/4, (int)getPrefWidth()/2-30));
        VBox DistBox = new VBox(new SettingButton("sadf", new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Hey you clicked on a different thing");
            }
        }, (int)getPrefHeight()/4, (int)getPrefWidth()/2 - 30));

        this.getColumnConstraints().addAll(c1,c2);
        addRow(0,lb1,TempBox);
        addRow(1, lb2,DistBox);
    }

}