package uk.ac.cam.intdes.gr1.ui;

public class SettingsContent extends Content {

    private static SettingsContent instance = new SettingsContent();

    private SettingsContent(){
        super();
    }

    public static SettingsContent getInstance(){
        return instance;
    }
}
