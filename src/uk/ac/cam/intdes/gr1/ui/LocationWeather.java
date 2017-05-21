package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.layout.Pane;
import uk.ac.cam.intdes.gr1.api.*;
import uk.ac.cam.intdes.gr1.api.responseobjs.*;

import java.util.*;

public class LocationWeather extends Pane {

	WeatherAPIInterface wapii = WeatherAPIInterface.getInstance();

    public LocationWeather(int width, int height){
        super();
        setPrefSize(width, height);
    }

	public void showWeather(WeatherReport weatherHereNow){

	}

}
