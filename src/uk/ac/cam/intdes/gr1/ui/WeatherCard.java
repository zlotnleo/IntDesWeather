package uk.ac.cam.intdes.gr1.ui;
import java.io.IOException;
import java.util.HashMap;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import uk.ac.cam.intdes.gr1.App;
import uk.ac.cam.intdes.gr1.api.responseobjs.ResortWeather;

public class WeatherCard extends HBox {
    private App app;
    private ResortWeather resort;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public enum WeatherType {Sunny, Clear, Cloudy, Fog, Snow, Rain} // TODO: add all
    public enum SkiingConditions {Good, Bad, Impossible}

    private static String iconPathBase = "/icons/";
    private static HashMap<WeatherType, String> iconPath;
    static {
        iconPath = new HashMap<>();
        iconPath.put(WeatherType.Sunny, "sunny@3x.png");
        iconPath.put(WeatherType.Clear, "clear@3x.png");
        iconPath.put(WeatherType.Cloudy, "cloudy@3x.png");
        iconPath.put(WeatherType.Fog, "fog@3x.png");
        iconPath.put(WeatherType.Snow, "snow@3x.png");
        iconPath.put(WeatherType.Rain, "rain@3x.png");
    }

    @FXML private ImageView weatherIcon;
    @FXML private Label locationLabel;

    public void setLocationName(String locationName) {
        this.locationName = locationName;
        locationLabel.setText(locationName);
    }
    public String getLocationName(){
        return this.locationName;
    }

    private String locationName;

    public void setWeatherType(WeatherType weatherType) {
        this.weatherType = weatherType;
        String iconUrl = iconPathBase + iconPath.get(weatherType);
        Image img;
        try {
            img = new Image(iconUrl);
        } catch (IllegalArgumentException e) {
            System.out.println("could not find image");
            return;
        }
        weatherIcon.setImage(img);
    }

    private WeatherType weatherType;
    private SkiingConditions conditions;
    private double temperature; // celsius

    public WeatherCard() {
        // TODO: might not want default constructor
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/weather_card.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.setOnMouseClicked(e -> {
            // TODO: need to to go to detailed vew
        });

        weatherIcon.fitHeightProperty().bind(Bindings.multiply(heightProperty(), 0.8));
        weatherIcon.setPreserveRatio(true);

        addEventHandler(MouseEvent.MOUSE_CLICKED, e -> App.getApp().weatherCardClick(this));
    }

    public WeatherCard(ResortWeather resort) {
        this();
        this.resort = resort;

        setLocationName(resort.getName());
    }
}