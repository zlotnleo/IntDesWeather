package weather_card;
import java.io.IOException;
import java.util.HashMap;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class WeatherCard extends VBox {
    public enum WeatherType {Sunny, Clear, Cloudy, Fog, Snow, Rain}; // TODO: add all
    public enum SkiingConditions {Good, Bad, Impossible};

    private static String iconPathBase = "static/icons/";
    private static HashMap<WeatherType, String> iconPath;
    static {
        iconPath = new HashMap<>();
        iconPath.put(WeatherType.Sunny, "sunny.png");
        iconPath.put(WeatherType.Sunny, "clear.png");
        iconPath.put(WeatherType.Sunny, "cloudy.png");
        iconPath.put(WeatherType.Sunny, "fog.png");
        iconPath.put(WeatherType.Sunny, "snow.png");
        iconPath.put(WeatherType.Sunny, "rain.png");
    }

    @FXML private ImageView weatherIcon;
    @FXML private Label locationLabel;

    public void setLocationName(String locationName) {
        this.locationName = locationName;
        this.locationLabel.setText(locationName);
    }

    private String locationName;

    public void setWeatherType(WeatherType weatherType) {
        this.weatherType = weatherType;
        this.weatherIcon.setImage(new Image(iconPathBase + iconPath.get(weatherType)));
    }

    private WeatherType weatherType;
    private SkiingConditions conditions;
    private double temperature; // celsius

    public WeatherCard() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "custom_control.fxml"));
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
    }


    @FXML
    protected void doSomething() {
        System.out.println("The button was clicked!");
    }
}