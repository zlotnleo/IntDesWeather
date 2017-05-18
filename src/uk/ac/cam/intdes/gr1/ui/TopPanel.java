package uk.ac.cam.intdes.gr1.ui;

import com.sun.istack.internal.Nullable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import uk.ac.cam.intdes.gr1.Consts;

public class TopPanel extends HBox {
    public TopPanel(@Nullable Region left, String text, @Nullable Region right){
        super(0);

        if (left == null) {
            left = new Pane();
        }
        if (right == null) {
            right = new Pane();
        }

        setPrefSize(Consts.SCREEN_WIDTH, Consts.TOP_BAR_HEIGHT);
        setBackground(Consts.LIGHTBLUE_BACKGROUND);
        setAlignment(Pos.CENTER);

        final int controlSize = (int)(Consts.TOP_BAR_HEIGHT * 0.4);

        left.setPrefSize(controlSize, controlSize);

        Label middle = new Label(text);
        middle.setAlignment(Pos.CENTER);

        right.setPrefSize(controlSize, controlSize);

        middle.setPrefSize(Consts.SCREEN_WIDTH - (int)(2.8 * controlSize), Consts.TOP_BAR_HEIGHT);

        getChildren().addAll(left, middle, right);
    }
}
