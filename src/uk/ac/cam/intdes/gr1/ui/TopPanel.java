package uk.ac.cam.intdes.gr1.ui;

import com.sun.istack.internal.Nullable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import uk.ac.cam.intdes.gr1.Consts;

public class TopPanel extends HBox {
    public TopPanel(@Nullable Region left, @Nullable Region middle, @Nullable Region right){
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

        DoubleBinding controlSize = Bindings.multiply(heightProperty(), 0.4);
        Insets controlMargin = new Insets(5.0, 5.0, 5.0, 5.0);

        left.prefHeightProperty().bind(controlSize);
        left.prefWidthProperty().bind(controlSize);
        HBox.setMargin(left, controlMargin);

        right.prefHeightProperty().bind(controlSize);
        right.prefWidthProperty().bind(controlSize);
        HBox.setMargin(right, controlMargin);

        Region leftSpacing = new Region();
        HBox.setHgrow(leftSpacing, Priority.ALWAYS);
        Region rightSpacing = new Region();
        HBox.setHgrow(rightSpacing, Priority.ALWAYS);

        getChildren().addAll(left, leftSpacing, middle, rightSpacing, right);
    }
}
