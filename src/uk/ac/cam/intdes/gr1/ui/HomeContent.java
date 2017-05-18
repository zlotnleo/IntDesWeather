package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import uk.ac.cam.intdes.gr1.api.ResortWeather;

import java.util.ArrayList;
import java.util.List;

public class HomeContent extends Content {
    private static HomeContent instance = new HomeContent();

    private HomeContent(){
        super();

        List<ResortWeather> resorts = new ArrayList<>();
        resorts.add(new ResortWeather("Lake Tahoa"));
        resorts.add(new ResortWeather("Zel am See"));
        resorts.add(new ResortWeather("Prahova"));

        double height = getPrefHeight();
        TextField searchBar = new TextField();
        searchBar.setPrefHeight(Math.max(20, 0.05 * height));

        double rowsHeight = height - searchBar.getPrefHeight();
        VBox rows = new VBox();
        rows.setPrefWidth(getPrefWidth());

        double rowHeight = rowsHeight / 3;
        WeatherCardRow nearby = new WeatherCardRow("Nearby", resorts);
        nearby.setMaxHeight(rowHeight);

        WeatherCardRow recent = new WeatherCardRow("Recent", resorts);
        recent.setPrefHeight(rowHeight);

        WeatherCardRow suggested = new WeatherCardRow("Suggested", resorts);
        suggested.setPrefHeight(rowHeight);

        rows.getChildren().addAll(searchBar, nearby, recent, suggested);

        this.getChildren().add(rows);
    }

    public static HomeContent getInstance(){
        return instance;
    }
}
