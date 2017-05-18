package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class SettingPane extends GridPane{

    public SettingPane(){
        ColumnConstraints c1 = new ColumnConstraints(), c2 = new ColumnConstraints();
        c1.setPercentWidth(50); c2.setPercentWidth(50);
        // c1 contains setting names, c2 contains setting values
        Label lb1 = new Label("Temperature Units:");
        Label lb2 = new Label("Distance Units:");
        setConstraints(lb1,0,0);
        setConstraints(lb2, 0,2);
        // Need to clear up exactly how formatting is to be done.
    }

}
