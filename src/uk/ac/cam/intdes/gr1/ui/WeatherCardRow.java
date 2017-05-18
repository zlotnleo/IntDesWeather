package uk.ac.cam.intdes.gr1.ui;

import com.sun.istack.internal.Nullable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import uk.ac.cam.intdes.gr1.api.ResortWeather;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherCardRow extends TitledPane{
    private HBox cardBox;

    public WeatherCardRow() {
        super();

        setCollapsible(false);

        ScrollPane sp = new ScrollPane();
        cardBox = new HBox();

        sp.setContent(cardBox);
        sp.setFitToHeight(true);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        setContent(sp);
    }

    public WeatherCardRow(String title, List<ResortWeather> resorts) {
        // TODO: needs to take list of weather location objects
        this();
        setText(title);

        cardBox.getChildren().addAll(resorts.stream().map(WeatherCard::new).collect(Collectors.toList()));
    }
}
