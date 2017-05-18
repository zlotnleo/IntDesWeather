package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.layout.VBox;

public class LocationWeatherContent extends Content{

    private static LocationWeatherContent instance = new LocationWeatherContent();

    private LocationWeatherContent(){
        super();

        VBox vbox = new VBox();
        //TODO init date selector
        LocationWeather locationWeather = new LocationWeather((int) getWidth(), (int) (getHeight() - 0.0 /*replace with height of date selector*/));
        //TODO subscribe to date selector
        vbox.getChildren().addAll(/*placeholder for dateselector, */locationWeather);
        getChildren().addAll(vbox);
    }

    public static LocationWeatherContent getInstance(){
        return instance;
    }
}
