package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.layout.VBox;
import uk.ac.cam.intdes.gr1.api.*;
import uk.ac.cam.intdes.gr1.api.responseobjs.*;

import java.text.*;
import java.time.*;
import java.util.*;

public class LocationWeatherContent extends Content{

	private WeatherAPIInterface wapii = WeatherAPIInterface.getInstance();
	private static LocationWeatherContent instance = new LocationWeatherContent();
	// Reference to the current LocationWeather pane. Shouldn't actually need updating at any point, so could probably be made static/final.
	private  LocationWeather locationWeather;

	// Indexes weather by date for the current location.
	private HashMap<String, WeatherReport> weatherHere = new HashMap<>();

    private LocationWeatherContent(){
        super();

        VBox vbox = new VBox();
        locationWeather = new LocationWeather((int) getPrefWidth(), 0 /*Actually set below!*/);
        DatePicker datePicker = new DatePicker(locationWeather, (int) getPrefWidth());
        locationWeather.setPrefHeight(getHeight() - datePicker.getHeight());

        vbox.getChildren().addAll(datePicker, locationWeather);
        getChildren().addAll(vbox);
    }

	// To update by dateselector, retrieve relevant date string from selector, find correct WeatherReport in
	// weatherHere and pass to LocationWeather.showWeather()
//    public void setLocation(Coordinate location){
//		List<WeatherReport> weatherH = wapii.getWeatherReportAt(location);
//		weatherH.forEach(e -> weatherHere.put(e.getDate(),e));
		// Needs testing
//		String today = new SimpleDateFormat("yyyy-MM-dd").format(LocalDate.now());

//		locationWeather.showWeather(weatherHere.get(today));

        //TODO: COMPLETE REWRITE: no need for duplicate API calls
        //P.S. locationWeather already has a ResortWeather

//	}

    public static LocationWeatherContent getInstance(){
        return instance;
    }

    public void setWeather(ResortWeather resortWeather) {
        locationWeather.setResortWeather(resortWeather);
    }
}
