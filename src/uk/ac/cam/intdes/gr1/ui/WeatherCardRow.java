package uk.ac.cam.intdes.gr1.ui;

import com.sun.istack.internal.Nullable;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import uk.ac.cam.intdes.gr1.api.ResortWeather;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherCardRow extends TitledPane {
    private HBox cardBox;

    private String title;
    private List<ResortWeather> resorts;

    public WeatherCardRow() {
        super();

        setCollapsible(false);

        ScrollPane sp = new ScrollPane();
        cardBox = new HBox();
        cardBox.setAlignment(Pos.CENTER_LEFT);

        sp.setContent(cardBox);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        setContent(sp);
    }

    public WeatherCardRow(String title, List<ResortWeather> resorts) {
        this();

        getStylesheets().add(getClass().getResource("/css/weather_card_row.css").toExternalForm());

        setTitle(title);
        setResorts(resorts);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        setText(title);
    }

    public List<ResortWeather> getResorts() {
        return resorts;
    }

    public void setResorts(List<ResortWeather> resorts) {
        this.resorts = resorts;

        for (ResortWeather resort : resorts) {
            WeatherCard card = new WeatherCard(resort);
            card.prefHeightProperty().bind(Bindings.multiply(cardBox.heightProperty(), 0.8));
            cardBox.getChildren().add(card);
        }
    }
}
