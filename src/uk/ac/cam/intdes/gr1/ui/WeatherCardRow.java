package uk.ac.cam.intdes.gr1.ui;

import com.sun.istack.internal.Nullable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;

public class WeatherCardRow extends TitledPane{
    private HBox cardBox;

    public WeatherCardRow() {
        super();

        setCollapsible(false);

        ScrollPane sp = new ScrollPane();
        cardBox = new HBox();

        sp.setContent(cardBox);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setContent(sp);
    }

    public WeatherCardRow(String title) {
        // TODO: needs to take list of weather location objects
        this();
        setText(title);
    }
}
