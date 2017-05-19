package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import uk.ac.cam.intdes.gr1.Consts;

public class Content extends Pane {

    public static final Background MOUNTAIN_BACKGROUND = new Background(new BackgroundImage(new Image("bg.png"),
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(
                    1.0, 1.0, true, true,
                    false, true
            )
    ));

    public Content() {
        setPrefSize(Consts.SCREEN_WIDTH, Consts.SCREEN_HEIGHT - Consts.TOP_BAR_HEIGHT);
        setBackground(MOUNTAIN_BACKGROUND);
    }
}
