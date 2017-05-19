package uk.ac.cam.intdes.gr1.ui;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import uk.ac.cam.intdes.gr1.api.ResortWeather;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class HomeContent extends Content {
    private static HomeContent instance = new HomeContent();

    private HomeContent(){
        super();

        List<ResortWeather> resorts = new ArrayList<>();
        resorts.add(new ResortWeather("Lake Tahoa"));
        resorts.add(new ResortWeather("Zel am See"));
        resorts.add(new ResortWeather("Prahova"));
        resorts.add(new ResortWeather("Val Thorens"));


        double height = getPrefHeight();
        TextField searchBar = new TextField();
        searchBar.setPrefHeight(Math.max(20, 0.05 * height));
        VBox.setMargin(searchBar, new Insets(5, 5, 5, 5));

        double rowsHeight = height - searchBar.getPrefHeight();
        VBox rows = new VBox();
        rows.setFillWidth(true);
        rows.setPrefWidth(getPrefWidth());
        rows.setSpacing(0);

        // there is a bug that introduces spacing between hboxes here, thus we subtract 40
        // TODO: try to fix
        DoubleBinding rowHeightBinding =
                Bindings.divide(Bindings.subtract(Bindings.subtract(
                        heightProperty(), searchBar.heightProperty()), 40.0), 3.0);

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
