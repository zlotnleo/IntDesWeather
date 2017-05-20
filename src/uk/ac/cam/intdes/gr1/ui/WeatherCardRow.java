package uk.ac.cam.intdes.gr1.ui;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import uk.ac.cam.intdes.gr1.Consts;
import uk.ac.cam.intdes.gr1.api.ResortWeather;

import java.util.List;

public class WeatherCardRow extends BorderPane {
    private HBox cardBox;
    private Label label;

    private List<ResortWeather> resorts;

    public WeatherCardRow() {
        super();

        ScrollPane sp = new ScrollPane();
        cardBox = new HBox();
        cardBox.setAlignment(Pos.CENTER_LEFT);

        sp.setContent(cardBox);
//        sp.setFitToHeight(true);
        sp.setPrefWidth(Consts.SCREEN_WIDTH);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        setCenter(sp);

        //TODO: Set cardBox's background to transparent to make the mountain visible
        cardBox.setBackground(Consts.TRANSPARENT_BACKGROUND); //Doesn't work, maybe?? due to card insets

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
//        setPrefHeight(Consts.WEATHERCARDROW_HEIGHT);

        setTitle(title);
        setTop(label);
        setResorts(resorts);
    }

    public String getTitle() {
        return label.getText();
    }

    public void setTitle(String title) {
        if(label == null)
            label = new Label();
        label.setText(title);
    }

    public List<ResortWeather> getResorts() {
        return resorts;
    }

    public void setResorts(List<ResortWeather> resorts) {
        this.resorts = resorts;

        for (ResortWeather resort : resorts) {
            WeatherCard card = new WeatherCard(resort);
            HBox.setMargin(card, new Insets(15.0, 10.0, 15.0, 10.0));
            card.prefHeightProperty().bind(Bindings.multiply(cardBox.heightProperty(), 0.6));
            cardBox.getChildren().add(card);
        }
    }
}
