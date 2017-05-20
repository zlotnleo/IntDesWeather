package uk.ac.cam.intdes.gr1.ui;

import java.io.*;

public class SettingsContent extends Content {

	// TODO: save settings on app close.
	// TODO: actually make this look anything like the rest of the app.
	// TODO: HUGE visual difference between settings and other parts. My bad ¯\_(ツ)_/¯

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

		SettingPane SPane = new SettingPane((int)this.getPrefHeight(), (int)this.getPrefWidth(),
				tempMode, distMode);
        this.getChildren().add(SPane);
    }

    public static SettingsContent getInstance(){
        return instance;
    }
}
