package uk.ac.cam.intdes.gr1;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Consts {
    public static final int SCREEN_WIDTH = 405;
    public static final int SCREEN_HEIGHT = 720;
    public static final int TOP_BAR_HEIGHT = (int) (0.1 * SCREEN_HEIGHT);
    public static final int CONTENT_HEIGHT = SCREEN_HEIGHT - TOP_BAR_HEIGHT;
    public static final int SEARCHBAR_HEIGHT = (int) (0.05 * CONTENT_HEIGHT);
    public static final int WEATHERCARDROW_HEIGHT = (int) ((CONTENT_HEIGHT - SEARCHBAR_HEIGHT) / 3.0);

    public static final Background LIGHTBLUE_BACKGROUND = new Background(new BackgroundFill(Color.color(0.0, 0.7, 1.0), null, null));
    public static final Background TRANSPARENT_BACKGROUND = new Background(new BackgroundFill(Color.TRANSPARENT, null, null));

//    public static final String BUTTON_STYLE = Consts.class.getResource("/static/css/button.css").toExternalForm();
}
