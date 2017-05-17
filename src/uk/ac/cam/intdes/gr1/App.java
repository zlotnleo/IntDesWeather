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

        settings = MainFrame.createScene(
                new TopPanel(
                        new TopPanelButton(to_home, Consts.BACK_ICON_BACKGROUND),
                        "Settings",
                        new TopPanelButton(null, null)
                ),
                SettingsContent.getInstance()
        );


        home = MainFrame.createScene(
                new TopPanel(
                        new TopPanelButton(null, null),
                        "WTS",
                        new TopPanelButton(to_settings, Consts.SETTING_ICON_BACKGROUND)
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
