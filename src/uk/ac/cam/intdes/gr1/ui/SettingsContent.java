package uk.ac.cam.intdes.gr1.ui;

import javafx.geometry.*;
import javafx.scene.layout.*;

import java.io.*;

public class SettingsContent extends Content {

	// TODO: save settings on app close.

    private static SettingsContent instance = new SettingsContent();

    private SettingsContent(){
        super();
		boolean tempMode = false, distMode = false;
        try{
			BufferedReader bfr = new BufferedReader(new FileReader(new File("res/settings/settings.txt")));
			tempMode = Boolean.parseBoolean(bfr.readLine());
			distMode = Boolean.parseBoolean(bfr.readLine());
		}
		catch(FileNotFoundException fnfe){
        	System.out.println("Failed to find file settings.txt - check file path?");
		}
		catch(IOException ioe){
			System.out.println("ReadLine failed.");
		}

		SettingPane SPanel = new SettingPane((int)this.getPrefHeight(), (int)this.getPrefWidth(), tempMode, distMode);
		StackPane SPaneWrapper = new StackPane();
		SPaneWrapper.setPrefSize(this.getPrefWidth(), this.getPrefHeight());
		SPaneWrapper.getChildren().add(SPanel);
		SPaneWrapper.setMargin(SPanel,new Insets(10,10,10,10));


        this.getChildren().add(SPaneWrapper);
    }

    public static SettingsContent getInstance(){
        return instance;
    }
}
