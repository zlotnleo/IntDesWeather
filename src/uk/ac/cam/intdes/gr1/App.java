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

import java.util.Stack;


public class App extends Application {
    private Stage primaryStage;

    private Scene home;
    private Scene settings;
    private Scene locationWeather;

    private Stack<Scene> screenStack = new Stack<>();

    private EventHandler<MouseEvent> to_home = e -> {
        screenStack.add(primaryStage.getScene());
        setScene(home);
    };
    private EventHandler<MouseEvent> to_settings = e -> {
        screenStack.add(primaryStage.getScene());
        setScene(settings);
    };
    private EventHandler<MouseEvent> go_back = e -> {
        if(!screenStack.empty())
            setScene(screenStack.pop());
    };

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        BackButton backButtonFromSettings = new BackButton();
        backButtonFromSettings.addEventHandler(MouseEvent.MOUSE_CLICKED, go_back);
        settings = MainFrame.createScene(
                new TopPanel(
                        backButtonFromSettings,
                        "Settings",
                        null
                ),
                SettingsContent.getInstance()
        );


        SettingsButton settingsButtonFromHome = new SettingsButton();
        settingsButtonFromHome.addEventHandler(MouseEvent.MOUSE_CLICKED, to_settings);
        home = MainFrame.createScene(
                new TopPanel(
                        null,
                        "WTS",
                        settingsButtonFromHome
                ),
                HomeContent.getInstance()
        );

        BackButton backButtonFromLocation = new BackButton();
        backButtonFromLocation.addEventHandler(MouseEvent.MOUSE_CLICKED, go_back);
        SettingsButton settingsButtonFromLocation = new SettingsButton();
        settingsButtonFromLocation.addEventHandler(MouseEvent.MOUSE_CLICKED, to_settings);
        locationWeather = MainFrame.createScene(
                new TopPanel(
                        backButtonFromLocation,
                        "Location name HERE!",
                        settingsButtonFromLocation
                ),
                LocationWeatherContent.getInstance()
        );

        screenStack.add(home);
        primaryStage.setScene(home);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void setScene(Scene s) {
        primaryStage.setScene(s);
    }
}
