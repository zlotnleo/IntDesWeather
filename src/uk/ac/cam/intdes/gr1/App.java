package uk.ac.cam.intdes.gr1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import uk.ac.cam.intdes.gr1.ui.MainFrame;
import uk.ac.cam.intdes.gr1.ui.TopPanel;
import uk.ac.cam.intdes.gr1.ui.SettingsContent;

public class App extends Application {
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Example
        Pane left_contol = new Pane();
        left_contol.setBackground(new Background(new BackgroundFill(Color.AQUA, null, null)));
        Pane right_control = new Pane();
        right_control.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
        SettingsContent sc = new SettingsContent(/*params*/);

        scene = MainFrame.createScene(new TopPanel(left_contol, "WTS", right_control), sc);

        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void setScene(Scene s) {
        scene = s;
    }
}
