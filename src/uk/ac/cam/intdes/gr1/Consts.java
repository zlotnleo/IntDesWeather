package uk.ac.cam.intdes.gr1;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Consts {
    public static final int SCREEN_WIDTH = 480;
    public static final int SCREEN_HEIGHT = 720;

    public static final int TOP_BAR_HEIGHT = (int) (0.1 * SCREEN_HEIGHT);

    public static final Background LIGHTBLUE_BACKGROUND = new Background(new BackgroundFill(Color.color(0.0, 0.7, 1.0), null, null));

    public static final String BUTTON_STYLE = Consts.class.getResource("/static/css/button.css").toExternalForm();
}
