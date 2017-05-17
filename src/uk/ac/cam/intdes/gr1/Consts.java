package uk.ac.cam.intdes.gr1;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Consts {
    public static final int SCREEN_WIDTH = 480;
    public static final int SCREEN_HEIGHT = 720;

    public static final int TOP_BAR_HEIGHT = (int) (0.12 * SCREEN_HEIGHT);

    public static final Background LIGHTBLUE_BACKGROUND = new Background(new BackgroundFill(Color.color(0.0, 0.7, 1.0), null, null));

    public static final Background SETTING_ICON_BACKGROUND = new Background(new BackgroundImage(new Image("/gear.png"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
            new BackgroundSize(
                    1.0, 1.0, true, true,
                    true, false
            )));

    public static final Background BACK_ICON_BACKGROUND = new Background(new BackgroundImage(new Image("/back.png"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
            new BackgroundSize(
                    1.0, 1.0, true, true,
                    true, false
            )));
}
