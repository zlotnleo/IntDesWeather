package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import uk.ac.cam.intdes.gr1.Consts;

public class BackButton extends Button {
    public static final Image BACK_ICON = new Image("/icons/back.png");
    public static final Background BACK_ICON_BACKGROUND = new Background(new BackgroundImage(
            BACK_ICON,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(
                    1.0, 1.0, true, true,
                    true, false
            )));

    public BackButton() {
        super();
        setBackground(BACK_ICON_BACKGROUND);
        setOnMouseClicked(e -> {

        });
    }
}
