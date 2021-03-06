package uk.ac.cam.intdes.gr1.ui;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import uk.ac.cam.intdes.gr1.api.responseobjs.ResortWeather;

import java.util.List;

public class WeatherCardRow extends BorderPane {
    private HBox cardBox;
    private Text titleLabel;

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
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setCenter(sp);
        cardBox.getStyleClass().addAll("card-row", "scroll-pane");

        titleLabel = new Text();
        titleLabel.getStyleClass().add("top-text");

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
            HBox.setMargin(card, new Insets(0, 10.0, 0, 10.0));
            card.maxHeightProperty().bind(Bindings.multiply(cardBox.heightProperty(), 0.4));
            cardBox.getChildren().add(card);
        }
    }
}
