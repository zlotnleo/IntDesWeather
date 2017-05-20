package uk.ac.cam.intdes.gr1.ui;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import uk.ac.cam.intdes.gr1.Consts;
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
        resorts.add(new ResortWeather("Val Thorens"));


        TextField searchBar = new TextField();
        searchBar.setPrefHeight(Consts.SEARCHBAR_HEIGHT);

        VBox.setMargin(searchBar, new Insets(5, 5, 5, 5));

        VBox rows = new VBox();
        rows.setFillWidth(true);
        rows.setPrefWidth(getPrefWidth());


        // subtract 20 for the margins and a bit of space
        DoubleBinding rowHeightBinding =
                Bindings.divide(Bindings.subtract(
                        heightProperty(), searchBar.getPrefHeight() + 20.0), 3.0);

        WeatherCardRow nearby = new WeatherCardRow("Nearby", resorts);
        nearby.prefHeightProperty().bind(rowHeightBinding);

        WeatherCardRow recent = new WeatherCardRow("Recent", resorts);
        recent.prefHeightProperty().bind(rowHeightBinding);

        WeatherCardRow suggested = new WeatherCardRow("Suggested", resorts);
        suggested.prefHeightProperty().bind(rowHeightBinding);

        rows.getChildren().addAll(searchBar, nearby, recent, suggested);

        this.getChildren().add(rows);
    }

    public static HomeContent getInstance(){
        return instance;
    }
}
