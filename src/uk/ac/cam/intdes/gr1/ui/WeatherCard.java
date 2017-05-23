package uk.ac.cam.intdes.gr1.ui;
import java.io.IOException;
import java.util.HashMap;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import uk.ac.cam.intdes.gr1.App;
import uk.ac.cam.intdes.gr1.AppSettings;
import uk.ac.cam.intdes.gr1.api.responseobjs.HourlyWeatherReport;
import uk.ac.cam.intdes.gr1.api.responseobjs.ResortWeather;
import uk.ac.cam.intdes.gr1.api.responseobjs.WeatherReport;

public class WeatherCard extends HBox {
    private App app;
    private ResortWeather resort;

    public ResortWeather getResortWeather() {
        return resort;
    }

    public enum WeatherType {Sunny, Cloudy, MostlyCloudy, MostlySunny, Fog, Snow, Rain, Storm, Sleet, SnowShower} // TODO: add all
    public enum SkiingConditions {Good, Bad, Impossible}

    private static String iconPathBase = "/icons/";
    private static HashMap<Integer, WeatherType> weatherCodeMap = new HashMap<>();
    private static HashMap<WeatherType, String> iconPath = new HashMap<>();
    static {
        weatherCodeMap.put(395, WeatherType.Storm); // Moderate or heavy snow in area with thunder
        weatherCodeMap.put(392, WeatherType.Storm); // Patchy light snow in area with thunder
        weatherCodeMap.put(389, WeatherType.Storm); // Moderate or heavy rain in area with thunder
        weatherCodeMap.put(386, WeatherType.Storm); // Patchy light rain in area with thunder
        weatherCodeMap.put(377, WeatherType.Sleet); // Moderate or heavy showers of ice pellets
        weatherCodeMap.put(374, WeatherType.Sleet); // Light showers of ice pellets
        weatherCodeMap.put(371, WeatherType.SnowShower); // Moderate or heavy snow showers
        weatherCodeMap.put(368, WeatherType.SnowShower); // Light snow showers
        weatherCodeMap.put(365, WeatherType.Sleet); // Moderate or heavy sleet showers
        weatherCodeMap.put(362, WeatherType.Sleet); // Light sleet showers
        weatherCodeMap.put(359, WeatherType.Rain); // Torrential rain shower
        weatherCodeMap.put(356, WeatherType.Rain); // Moderate or heavy rain shower
        weatherCodeMap.put(353, WeatherType.Rain); // Light rain shower
        weatherCodeMap.put(350, WeatherType.Sleet); // Ice pellets
        weatherCodeMap.put(338, WeatherType.SnowShower); // Heavy snow
        weatherCodeMap.put(335, WeatherType.SnowShower); // Patchy heavy snow
        weatherCodeMap.put(332, WeatherType.Snow); // Moderate snow
        weatherCodeMap.put(329, WeatherType.Snow); // Patchy moderate snow
        weatherCodeMap.put(326, WeatherType.Snow); // Light snow
        weatherCodeMap.put(323, WeatherType.Snow); // Patchy light snow
        weatherCodeMap.put(320, WeatherType.Sleet); // Moderate or heavy sleet
        weatherCodeMap.put(317, WeatherType.Sleet); // Light sleet
        weatherCodeMap.put(314, WeatherType.Sleet); // Moderate or Heavy freezing rain
        weatherCodeMap.put(311, WeatherType.Sleet); // Light freezing rain
        weatherCodeMap.put(308, WeatherType.Rain); // Heavy rain
        weatherCodeMap.put(305, WeatherType.Rain); // Heavy rain at times
        weatherCodeMap.put(302, WeatherType.Rain); // Moderate rain
        weatherCodeMap.put(299, WeatherType.Rain); // Moderate rain at times
        weatherCodeMap.put(296, WeatherType.Rain); // Light rain
        weatherCodeMap.put(293, WeatherType.Rain); // Patchy light rain
        weatherCodeMap.put(284, WeatherType.SnowShower); // Heavy freezing drizzle
        weatherCodeMap.put(281, WeatherType.SnowShower); // Freezing drizzle
        weatherCodeMap.put(266, WeatherType.SnowShower); // Light drizzle
        weatherCodeMap.put(263, WeatherType.SnowShower); // Patchy light drizzle
        weatherCodeMap.put(260, WeatherType.Fog); // Freezing fog
        weatherCodeMap.put(248, WeatherType.Fog); // Fog
        weatherCodeMap.put(230, WeatherType.SnowShower); // Blizzard
        weatherCodeMap.put(227, WeatherType.SnowShower); // Blowing snow
        weatherCodeMap.put(200, WeatherType.Storm); // Thundery outbreaks in nearby
        weatherCodeMap.put(185, WeatherType.Rain); // Patchy freezing drizzle nearby
        weatherCodeMap.put(182, WeatherType.Sleet); // Patchy sleet nearby
        weatherCodeMap.put(179, WeatherType.Snow); // Patchy snow nearby
        weatherCodeMap.put(176, WeatherType.Rain); // Patchy rain nearby
        weatherCodeMap.put(143, WeatherType.Fog); // Mist
        weatherCodeMap.put(122, WeatherType.MostlyCloudy); // Overcast
        weatherCodeMap.put(119, WeatherType.Cloudy); // Cloudy
        weatherCodeMap.put(116, WeatherType.MostlySunny); // Partly Cloudy
        weatherCodeMap.put(113, WeatherType.Sunny); // Clear/Sunny

        iconPath.put(WeatherType.Sunny, "sunny.png");
        iconPath.put(WeatherType.Cloudy, "cloudy.png");
        iconPath.put(WeatherType.Fog, "fog.png");
        iconPath.put(WeatherType.Snow, "snow.png");
        iconPath.put(WeatherType.Rain, "rain.png");
        iconPath.put(WeatherType.MostlyCloudy, "mostlycloudy.png");
        iconPath.put(WeatherType.MostlySunny, "mostlysunny.png");
        iconPath.put(WeatherType.Storm, "tstorms.png");
        iconPath.put(WeatherType.Sleet, "sleet.png");
    }

    @FXML private ImageView weatherIcon;
    @FXML private Label locationLabel;
    @FXML private Label tempLabel;
    @FXML private Label windLabel;
    @FXML private Circle conditionsCircle;
    @FXML private Label snowfallLabel;

    private String locationName;

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

        setOnMouseClicked(e -> App.getApp().weatherCardClick(this));

        weatherIcon.fitHeightProperty().bind(Bindings.multiply(heightProperty(), 0.8));
        weatherIcon.setPreserveRatio(true);

        locationLabel.setWrapText(true);
        locationLabel.setAlignment(Pos.CENTER);

//        HBox.setMargin(conditionsCircle, new Insets(2, 2, 2, 2));
    }

    public WeatherCard(ResortWeather resort) {
        this();
        this.resort = resort;

        setLocationName(resort.getName());

        if (!resort.getDailyReports().isEmpty()) {
            WeatherReport today = resort.getDailyReports().get(0);

            setTemperature(today);

            setSnowfall(today);

            if (!today.getHourlyReports().isEmpty()) {
                HourlyWeatherReport now = today.getHourlyReports().get(0);
                WeatherType weatherType = weatherCodeMap.get(now.getBottom().getWeatherCode());

                setWeatherType(weatherType);
                setWindSpeed(now);

                SkiingConditions conditions;
                switch (weatherType) {
                    case Storm: case Rain: case Sleet:
                        conditions = SkiingConditions.Impossible;
                        break;
                    case Fog:
                        conditions = SkiingConditions.Bad;
                        break;
                    default:
                        conditions = SkiingConditions.Good;
                }

                if (today.getChanceOfSnow() == 0 && today.getTotalSnowfall() == 0) {
                    conditions = SkiingConditions.Bad;
                }
                setConditions(conditions);
            }

        }
    }

    public void setWeatherType(WeatherType weatherType) {
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

    public void setLocationName(String locationName) {
        this.locationName = locationName;
        locationLabel.setText(locationName);
    }
    public String getLocationName(){
        return this.locationName;
    }
    
    public void setTemperature(WeatherReport today ) {
        tempLabel.textProperty().bind(
                Bindings.when(AppSettings.getInstance().getFahrenheitProperty())
                        .then(String.valueOf(today.getBottom().getMaxTempC()) + " °C")
                        .otherwise(String.valueOf(today.getBottom().getMaxTempF()) + " °F"));
    }

    public void setWindSpeed(HourlyWeatherReport now) {
        windLabel.textProperty().bind(
                Bindings.when(AppSettings.getInstance().getMilesProperty())
                        .then(String.valueOf(now.getBottom().getWindSpeedKmph()) + " Km/h")
                        .otherwise(String.valueOf(now.getBottom().getWindSpeedKmph()) + " M/h"));
    }

    public void setSnowfall(WeatherReport today ) {
        snowfallLabel.setText(String.valueOf(today.getTotalSnowfall()) + " cm");
    }

    public void setConditions(SkiingConditions conditions) {
        if (conditions.equals(SkiingConditions.Good)) {
            conditionsCircle.setFill(Paint.valueOf("GREEN"));
        } else if (conditions.equals(SkiingConditions.Bad)) {
            conditionsCircle.setFill(Paint.valueOf("YELLOW"));
        } else {
            conditionsCircle.setFill(Paint.valueOf("RED"));
        }
    }
}