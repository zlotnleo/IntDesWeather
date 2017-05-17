package uk.ac.cam.intdes.gr1.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import uk.ac.cam.intdes.gr1.Consts;

public class TopPanel extends HBox{
    public TopPanel(TopPanelButton left, String text, TopPanelButton right){
        super(0);

        setPrefSize(Consts.SCREEN_WIDTH, Consts.TOP_BAR_HEIGHT);
        setBackground(Consts.LIGHTBLUE_BACKGROUND);

        left.setPrefSize(Consts.TOP_BAR_HEIGHT, Consts.TOP_BAR_HEIGHT);

        Label middle = new Label(text);
        middle.setAlignment(Pos.CENTER);
        middle.setPrefSize(Consts.SCREEN_WIDTH - 2 * Consts.TOP_BAR_HEIGHT, Consts.TOP_BAR_HEIGHT);

        right.setPrefSize(Consts.TOP_BAR_HEIGHT, Consts.TOP_BAR_HEIGHT);

        getChildren().addAll(left, middle, right);
    }
}
