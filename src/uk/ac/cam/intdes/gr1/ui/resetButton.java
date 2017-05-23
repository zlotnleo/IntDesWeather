package uk.ac.cam.intdes.gr1.ui;

import javafx.scene.paint.Color;
import uk.ac.cam.intdes.gr1.RecentLocations;

public class resetButton extends SettingButton{

	public resetButton(int height, int width){
		super("Reset", e -> RecentLocations.getInstance().clear(), height, width, Color.color(0.0,0.7,1.0,0.7));
		this.setOnMousePressed(e -> this.setColor(Color.color(0.0,0.7,1.0,0.3)));
		this.setOnMouseReleased(e -> this.setColor(Color.color(0.0,0.7,1.0,0.7)));
	}

}
