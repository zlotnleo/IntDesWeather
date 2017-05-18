package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import uk.ac.cam.intdes.gr1.Consts;

public class SettingsButton extends Button {
    public static final Image SETTING_ICON = new Image("/icons/gear.png");

    public static final Background SETTING_ICON_BACKGROUND = new Background(new BackgroundImage(SETTING_ICON,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
            new BackgroundSize(
                    1.0, 1.0, true, true,
                    true, false
            )));


    public SettingsButton() {
        super();

        setBackground(SETTING_ICON_BACKGROUND);

        setOnMouseClicked(e -> {

        });
    }
}
