package uk.ac.cam.intdes.gr1.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import uk.ac.cam.intdes.gr1.api.*;
import uk.ac.cam.intdes.gr1.api.responseobjs.*;

import java.util.*;

public class LocationWeather extends GridPane {

    private ResortWeather weather;
    private int dayIndex;

    public LocationWeather(int width, int height){
        super();
        setPrefSize(width, height);
    }

	public void showWeather(){
        getChildren().clear();
        //List<WeatherReport> weatherReports = weather.getDailyReports();
        //WeatherReport dailyWeather = weatherReports.get(dayIndex);
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25,25,25,25));

        Label snowChance = new Label("Chance of Snow: " + "67%");
        //Label snowChance = new Label("Chance of Snow: " + String.valueOf(dailyWeather.getChanceOfSnow()));
        snowChance.setStyle("-fx-font: 18 system;");
        add(snowChance,0,0);

        Label totalSnow = new Label("Total Snowfall: " + "117cm");
        //Label totalSnow = new Label("Total Snowfall: " + String.valueOf(dailyWeather.getTotalSnowfall()));
        totalSnow.setStyle("-fx-font: 18 system;");
        add(totalSnow,0,1);

        GridPane topPane = new GridPane();
        topPane.setStyle("-fx-background-color: #00b3ff;");
        Label topLabel = new Label("Top");
        topLabel.setStyle("-fx-font: 18 system; -fx-font-weight: bold; -fx-text-fill: white;");
        topPane.add(topLabel,0,0);
        Label topMinTemp = new Label("Min Temperature: " + "3C");
        //Label topMinTemp = new Label("Min Temperature: " + String.valueOf(dailyWeather.getTop().getMinTempC()));
        topMinTemp.setStyle("-fx-font: 18 system; -fx-text-fill: white;");
        topPane.add(topMinTemp,1,1);
        Label topMaxTemp = new Label("Max Temperature: " + "7C");
        //Label totalMinTemp = new Label("Min Temperature: " + String.valueOf(dailyWeather.getTop().getMaxTempC()));
        topMaxTemp.setStyle("-fx-font: 18 system; -fx-text-fill: white;");
        topPane.add(topMaxTemp,1,2);
        add(topPane,0,2);

        GridPane midPane = new GridPane();
        midPane.setStyle("-fx-background-color: #00b3ff;");
        Label midLabel = new Label("Middle");
        midLabel.setStyle("-fx-font: 18 system; -fx-font-weight: bold; -fx-text-fill: white;");
        midPane.add(midLabel,0,0);
        Label midMinTemp = new Label("Min Temperature: " + "5C");
        //Label midMinTemp = new Label("Min Temperature: " + String.valueOf(dailyWeather.getMid().getMinTempC()));
        midMinTemp.setStyle("-fx-font: 18 system; -fx-text-fill: white;");
        midPane.add(midMinTemp,1,1);
        Label midMaxTemp = new Label("Max Temperature: " + "9C");
        //Label midMinTemp = new Label("Min Temperature: " + String.valueOf(dailyWeather.getMid().getMaxTempC()));
        midMaxTemp.setStyle("-fx-font: 18 system; -fx-text-fill: white;");
        midPane.add(midMaxTemp,1,2);
        add(midPane,0,3);

        GridPane bottomPane = new GridPane();
        bottomPane.setStyle("-fx-background-color: #00b3ff;");
        Label bottomLabel = new Label("Bottom");
        bottomLabel.setStyle("-fx-font: 18 system; -fx-font-weight: bold; -fx-text-fill: white;");
        bottomPane.add(bottomLabel,0,0);
        Label bottomMinTemp = new Label("Min Temperature: " + "7C");
        //Label bottomMinTemp = new Label("Min Temperature: " + String.valueOf(dailyWeather.getBottom().getMinTempC()));
        bottomMinTemp.setStyle("-fx-font: 18 system; -fx-text-fill: white;");
        bottomPane.add(bottomMinTemp,1,1);
        Label bottomMaxTemp = new Label("Max Temperature: " + "11C");
        //Label bottomMinTemp = new Label("Min Temperature: " + String.valueOf(dailyWeather.getBottom().getMaxTempC()));
        bottomMaxTemp.setStyle("-fx-font: 18 system; -fx-text-fill: white;");
        bottomPane.add(bottomMaxTemp,1,2);
        add(bottomPane,0,4);


	}

	public void setResortWeather(ResortWeather weather){
	    this.weather = weather;
    }

    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
        this.showWeather();

//      System.out.println("Clicked day " + dayIndex);
    }
}
