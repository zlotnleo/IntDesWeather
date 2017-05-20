package uk.ac.cam.intdes.gr1.ui;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import uk.ac.cam.intdes.gr1.api.responseobjs.ResortWeather;

import java.util.List;

public class WeatherCardRow extends BorderPane {
    private HBox cardBox;
    private Label titleLabel;

    private List<ResortWeather> resorts;

    public WeatherCardRow() {
        super();

        getStyleClass().addAll("card-row", "border-pane");

        ScrollPane sp = new ScrollPane();
        cardBox = new HBox();
        cardBox.setAlignment(Pos.CENTER_LEFT);
        sp.getStyleClass().addAll("card-row", "hbox");

        sp.setContent(cardBox);
        sp.setFitToHeight(true);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        setCenter(sp);
        cardBox.getStyleClass().addAll("card-row", "scroll-pane");

        // make scroll horizontal
        sp.setOnScroll(e -> {
            if(e.getDeltaX() == 0 && e.getDeltaY() != 0) {
                sp.setHvalue(sp.getHvalue() - 3.0 * e.getDeltaY() / cardBox.getWidth());
            }
        });
    }

    public WeatherCardRow(String title, List<ResortWeather> resorts) {
        this();

        getStylesheets().add(getClass().getResource("/css/weather_card_row.css").toExternalForm());

        setTitle(title);
        setTop(titleLabel);
        setResorts(resorts);
    }

    public String getTitle() {
        return titleLabel.getText();
    }

    public void setTitle(String title) {
        if (titleLabel == null) {
            titleLabel = new Label();
        }
        titleLabel.setText(title);
    }

    public List<ResortWeather> getResorts() {
        return resorts;
    }

    public void setResorts(List<ResortWeather> resorts) {
        this.resorts = resorts;

        cardBox.getChildren().clear();

        for (ResortWeather resort : resorts) {
            WeatherCard card = new WeatherCard(resort);
            HBox.setMargin(card, new Insets(15.0, 10.0, 15.0, 10.0));
            card.prefHeightProperty().bind(Bindings.multiply(cardBox.heightProperty(), 0.6));
            cardBox.getChildren().add(card);
        }
    }
}
