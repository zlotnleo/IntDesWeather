package uk.ac.cam.intdes.gr1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import uk.ac.cam.intdes.gr1.api.responseobjs.WeatherReport;
import uk.ac.cam.intdes.gr1.ui.*;

import java.util.Stack;


public class App extends Application {
    private Stage primaryStage;

    private Scene home;
    private Scene settings;
    private Scene locationWeather;

    private WeatherReport currentReport;

    private Stack<Scene> screenStack = new Stack<>();

//    private EventHandler<MouseEvent> to_home = e -> {
//        screenStack.clear();    //No back button from home
//        screenStack.add(home);
//        setScene(home);
//    };
    private EventHandler<MouseEvent> to_settings = e -> {
        screenStack.add(primaryStage.getScene());
        setScene(settings);
    };
    private EventHandler<MouseEvent> go_back = e -> {
        if(!screenStack.empty())
            setScene(screenStack.pop());
    };

    private static App app;
    public static App getApp() {
        return app;
    }

    public void weatherCardClick(WeatherCard wc) {
        BackButton backButtonFromLocation = new BackButton();
        backButtonFromLocation.addEventHandler(MouseEvent.MOUSE_CLICKED, go_back);
        SettingsButton settingsButtonFromLocation = new SettingsButton();
        settingsButtonFromLocation.addEventHandler(MouseEvent.MOUSE_CLICKED, to_settings);
        LocationWeatherContent content = LocationWeatherContent.getInstance();
        content.setWeather(wc.getResortWeather());
        content.getLocationWeather().showWeather();

        locationWeather = MainFrame.createScene(
                new TopPanel(
                        backButtonFromLocation,
                        new Label(wc.getLocationName()),
                        settingsButtonFromLocation
                ),
                content
        );
        screenStack.add(primaryStage.getScene());
        setScene(locationWeather);
        RecentLocations.getInstance().addLocation(wc.getResortWeather());
        HomeContent.getInstance().setRecentLocations(RecentLocations.getInstance().getLocations());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("WTS");
        app = this;

        Label appTitleLabel = new Label("Weather To Ski");

        SettingsButton settingsButtonFromHome = new SettingsButton();
        settingsButtonFromHome.addEventHandler(MouseEvent.MOUSE_CLICKED, to_settings);
        home = MainFrame.createScene(
                new TopPanel(
                        null,
                        appTitleLabel,
                        settingsButtonFromHome
                ),
                HomeContent.getInstance()
        );
        String homeCss = getClass().getResource("/css/home.css").toExternalForm();
        home.getStylesheets().add(homeCss);

        BackButton backButtonFromSettings = new BackButton();
        backButtonFromSettings.addEventHandler(MouseEvent.MOUSE_CLICKED, go_back);
        Label settingsLabel = new Label("Settings");
        settings = MainFrame.createScene(
                new TopPanel(
                        backButtonFromSettings,
                        settingsLabel,
                        null
                ),
                SettingsContent.getInstance()
        );

        screenStack.add(home);
        primaryStage.setScene(home);
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void setScene(Scene s) {
        primaryStage.setScene(s);
    }

    public static void main(String[] argv){
        launch(argv);
    }
}
