package uk.ac.cam.intdes.gr1.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import uk.ac.cam.intdes.gr1.AppSettings;
import uk.ac.cam.intdes.gr1.api.*;
import uk.ac.cam.intdes.gr1.api.responseobjs.*;

import java.util.*;

public class LocationWeather extends GridPane {

    private ResortWeather weather;
    private int dayIndex;

    public LocationWeather(int width, int height){
        super();
        dayIndex = 0;
        showWeather();
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

        //Weather at top

        GridPane topPane = new GridPane();
        topPane.setStyle("-fx-background-color: #00b3ff;");
        Label topLabel = new Label("Top");
        topLabel.setStyle("-fx-font: 18 system; -fx-font-weight: bold; -fx-text-fill: white;");
        topPane.add(topLabel,0,0);

        Label topMinTemp = new Label();
        topMinTemp.setStyle("-fx-font: 18 system; -fx-text-fill: white;");
        if (!AppSettings.getInstance().getFahrenheitProperty().getValue()) {
            //int minTemp = dailyWeather.getTop().getMinTempC();
            //topMinTemp.setText("Min Temperature: " + String.valueOf(dailyWeather.getTop().getMinTempC()));
            topMinTemp.setText("Min Temperature: " + "3C");
        } else {
            //int minTemp = dailyWeather.getTop().getMinTempF();
            //topMinTemp.setText("Min Temperature: " + String.valueOf(dailyWeather.getTop().getMinTempF()));
            topMinTemp.setText("Min Temperature: " + "30F");
        }
        topPane.add(topMinTemp,1,1);

        Label topMaxTemp = new Label();
        topMaxTemp.setStyle("-fx-font: 18 system; -fx-text-fill: white;");
        if (!AppSettings.getInstance().getFahrenheitProperty().getValue()) {
            //int maxTemp = dailyWeather.getTop().getMaxTempC();
            //topMaxTemp.setText("Max Temperature: " + String.valueOf(dailyWeather.getTop().getMaxTempC()));
            topMaxTemp.setText("Max Temperature: " + "5C");
        } else {
            //int maxTemp = dailyWeather.getTop().getMaxTempF();
            //topMaxTemp.setText("Max Temperature: " + String.valueOf(dailyWeather.getTop().getMaxTempF()));
            topMaxTemp.setText("Max Temperature: " + "36F");
        }
        topPane.add(topMaxTemp,1,2);

        add(topPane,0,2);


        //Weather at middle

        GridPane midPane = new GridPane();
        midPane.setStyle("-fx-background-color: #00b3ff;");
        Label midLabel = new Label("Middle");
        midLabel.setStyle("-fx-font: 18 system; -fx-font-weight: bold; -fx-text-fill: white;");
        midPane.add(midLabel,0,0);

        Label midMinTemp = new Label();
        midMinTemp.setStyle("-fx-font: 18 system; -fx-text-fill: white;");
        if (!AppSettings.getInstance().getFahrenheitProperty().getValue()) {
            //int minTemp = dailyWeather.getMid().getMinTempC();
            //midMinTemp.setText("Min Temperature: " + String.valueOf(dailyWeather.getMid().getMinTempC()));
            midMinTemp.setText("Min Temperature: " + "5C");
        } else {
            //int minTemp = dailyWeather.getMid().getMinTempF();
            //midMinTemp.setText("Min Temperature: " + String.valueOf(dailyWeather.getMid().getMinTempF()));
            midMinTemp.setText("Min Temperature: " + "38F");
        }
        midPane.add(midMinTemp,1,1);

        Label midMaxTemp = new Label();
        midMaxTemp.setStyle("-fx-font: 18 system; -fx-text-fill: white;");
        if (!AppSettings.getInstance().getFahrenheitProperty().getValue()) {
            //int maxTemp = dailyWeather.getMid().getMaxTempC();
            //midMaxTemp.setText("Max Temperature: " + String.valueOf(dailyWeather.getMid().getMaxTempC()));
            midMaxTemp.setText("Max Temperature: " + "7C");
        } else {
            //int maxTemp = dailyWeather.getMid().getMaxTempF();
            //midMaxTemp.setText("Max Temperature: " + String.valueOf(dailyWeather.getMid().getMaxTempF()));
            midMaxTemp.setText("Max Temperature: " + "42F");
        }
        midPane.add(midMaxTemp,1,2);

        add(midPane,0,3);


        //Weather at Bottom

        GridPane bottomPane = new GridPane();
        bottomPane.setStyle("-fx-background-color: #00b3ff;");
        Label bottomLabel = new Label("Bottom");
        bottomLabel.setStyle("-fx-font: 18 system; -fx-font-weight: bold; -fx-text-fill: white;");
        bottomPane.add(bottomLabel,0,0);

        Label bottomMinTemp = new Label();
        bottomMinTemp.setStyle("-fx-font: 18 system; -fx-text-fill: white;");
        if (!AppSettings.getInstance().getFahrenheitProperty().getValue()) {
            //int bottomTemp = dailyWeather.getBottom().getMinTempC();
            //bottomMinTemp.setText("Min Temperature: " + String.valueOf(dailyWeather.getBottom().getMinTempC()));
            bottomMinTemp.setText("Min Temperature: " + "8C");
        } else {
            //int bottomTemp = dailyWeather.getBottom().getMinTempF();
            //bottomMinTemp.setText("Min Temperature: " + String.valueOf(dailyWeather.getBottom().getMinTempF()));
            bottomMinTemp.setText("Min Temperature: " + "44F");
        }
        bottomPane.add(bottomMinTemp,1,1);


        Label bottomMaxTemp = new Label();
        bottomMaxTemp.setStyle("-fx-font: 18 system; -fx-text-fill: white;");
        if (!AppSettings.getInstance().getFahrenheitProperty().getValue()) {
            //int maxTemp = dailyWeather.getBottom().getMaxTempC();
            //bottomMaxTemp.setText("Max Temperature: " + String.valueOf(dailyWeather.getBottom().getMaxTempC()));
            bottomMaxTemp.setText("Max Temperature: " + "10C");
        } else {
            //int maxTemp = dailyWeather.getBottom().getMaxTempF();
            //bottomMaxTemp.setText("Max Temperature: " + String.valueOf(dailyWeather.getBottom().getMaxTempF()));
            bottomMaxTemp.setText("Max Temperature: " + "47F");
        }
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
