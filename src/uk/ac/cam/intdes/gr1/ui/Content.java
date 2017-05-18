package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.layout.Pane;
import uk.ac.cam.intdes.gr1.Consts;

public class Content extends Pane {
    public Content(){
        setPrefSize(Consts.SCREEN_WIDTH, Consts.SCREEN_HEIGHT - Consts.TOP_BAR_HEIGHT);
    }
}
