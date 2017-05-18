package uk.ac.cam.intdes.gr1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import uk.ac.cam.intdes.gr1.ui.*;


public class App extends Application {
    private Stage primaryStage;

    private Scene home;
    private Scene settings;

    private EventHandler<MouseEvent> to_home = e -> setScene(home);
    private EventHandler<MouseEvent> to_settings = e -> setScene(settings);


    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        BackButton backButton = new BackButton();
        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, to_home);
        settings = MainFrame.createScene(
                new TopPanel(
                        backButton,
                        "Settings",
                        null
                ),
                SettingsContent.getInstance()
        );


        SettingsButton settingsButton = new SettingsButton();
        settingsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, to_settings);
        home = MainFrame.createScene(
                new TopPanel(
                        null,
                        "WTS",
                        settingsButton
                ),
                HomeContent.getInstance()
        );

        primaryStage.setScene(home);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void setScene(Scene s) {
        primaryStage.setScene(s);
    }
}
