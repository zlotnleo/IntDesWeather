package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainFrame {
    public static Scene createScene(TopPanel tp, Pane contents){
        VBox vbox = new VBox();
        vbox.getChildren().addAll(tp, contents);
        return new Scene(vbox);
    }
}
