package uk.ac.cam.intdes.gr1.ui;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import uk.ac.cam.intdes.gr1.Consts;
import uk.ac.cam.intdes.gr1.api.CurrentLocationApi;
import uk.ac.cam.intdes.gr1.api.GoogleAPIInterface;
import uk.ac.cam.intdes.gr1.api.SkiMapApi;
import uk.ac.cam.intdes.gr1.api.responseobjs.Coordinate;
import uk.ac.cam.intdes.gr1.api.responseobjs.ResortWeather;

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
        resorts.add(new ResortWeather("Lake Tahoa", new Coordinate(49.315355179835, -114.42647097722)));
        resorts.add(new ResortWeather("Zel am See", new Coordinate(50.3385584502358, -115.826282501221)));
        resorts.add(new ResortWeather("Prahova", new Coordinate(53.4842024615732, -113.556683063507)));
        resorts.add(new ResortWeather("Val Thorens", new Coordinate(50.442417862094, -116.22459981596)));

        searchBar = new TextField();
        searchBar.setPrefHeight(Consts.SEARCHBAR_HEIGHT);
        searchBar.setPromptText("Search");
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

        executeSearch("");
    }

    private void executeSearch(String searchTerm) {
        if (searchTerm.equals(oldSearchTerm)) {
            return;
        }
        oldSearchTerm = searchTerm;

        Coordinate searchLocation;
        if (searchTerm.isEmpty()) {
            searchLocation = CurrentLocationApi.getInstance().getLocation();
        } else {
            searchLocation = GoogleAPIInterface.getInstance().getLocation(searchTerm);
        }

        List<ResortWeather> resorts = SkiMapApi.getInstance().searchResorts(searchLocation, Consts.MAX_SEARCH_DIST);
        resorts.subList(Math.min(Consts.MAX_ROW_CARDS, resorts.size()), resorts.size()).clear(); // eliminate extra resorts

        nearbyRow.setResorts(resorts);
    }

    public static HomeContent getInstance(){
        return instance;
    }
}
