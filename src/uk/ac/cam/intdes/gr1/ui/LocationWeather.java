package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.layout.Pane;
import uk.ac.cam.intdes.gr1.api.*;
import uk.ac.cam.intdes.gr1.api.responseobjs.*;

import java.util.*;

public class LocationWeather extends Pane {

    private ResortWeather weather;
    private int dayIndex;

    public LocationWeather(int width, int height){
        super();
        setPrefSize(width, height);
    }

//	public void showWeather(){
//
//	}

	public void setResortWeather(ResortWeather weather){
	    this.weather = weather;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
//        System.out.println("Clicked day " + dayIndex);
    }
}
