package uk.ac.cam.intdes.gr1.ui;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import uk.ac.cam.intdes.gr1.Consts;
import uk.ac.cam.intdes.gr1.api.GoogleAPIInterface;
import uk.ac.cam.intdes.gr1.api.ResortWeather;

import javax.swing.event.HyperlinkEvent;
import java.util.ArrayList;
import java.util.List;

public class HomeContent extends Content {
    private static HomeContent instance = new HomeContent();

    WeatherCardRow nearbyRow;
    WeatherCardRow recentRow;
    WeatherCardRow suggestedRow;

    private String oldSearchTerm;
    TextField searchBar;


    private HomeContent(){
        super();

        List<ResortWeather> resorts = new ArrayList<>();
        resorts.add(new ResortWeather("Lake Tahoa"));
        resorts.add(new ResortWeather("Zel am See"));
        resorts.add(new ResortWeather("Prahova"));
        resorts.add(new ResortWeather("Val Thorens"));

        searchBar = new TextField();
        searchBar.setPrefHeight(Consts.SEARCHBAR_HEIGHT);
        searchBar.setPromptText("Search");
        oldSearchTerm = searchBar.getText();
        searchBar.setOnAction(e -> executeSearch(searchBar.getText()));

        VBox.setMargin(searchBar, new Insets(5, 5, 5, 5));

        VBox rows = new VBox();
        rows.setFillWidth(true);
        rows.setPrefWidth(getPrefWidth());


        // subtract 20 for the margins and a bit of space
        DoubleBinding rowHeightBinding =
                Bindings.divide(Bindings.subtract(
                        heightProperty(), searchBar.getPrefHeight() + 20.0), 3.0);

        nearbyRow = new WeatherCardRow("Nearby", resorts);
        nearbyRow.prefHeightProperty().bind(rowHeightBinding);

        recentRow = new WeatherCardRow("Recent", resorts);
        recentRow.prefHeightProperty().bind(rowHeightBinding);

        suggestedRow = new WeatherCardRow("Suggested", resorts);
        suggestedRow.prefHeightProperty().bind(rowHeightBinding);

        rows.getChildren().addAll(searchBar, nearbyRow, recentRow, suggestedRow);

        this.getChildren().add(rows);
    }

    private void executeSearch(String searchTerm) {
        if (searchTerm.equals(oldSearchTerm)) {
            return;
        }
        oldSearchTerm = searchTerm;
    }

    public static HomeContent getInstance(){
        return instance;
    }
}
