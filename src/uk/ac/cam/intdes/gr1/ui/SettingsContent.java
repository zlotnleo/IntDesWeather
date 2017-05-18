package uk.ac.cam.intdes.gr1.ui;

public class SettingsContent extends Content {

    private static SettingsContent instance = new SettingsContent();

    private SettingsContent(){
        super();

        SettingPane SPane = new SettingPane((int)this.getPrefHeight(), (int)this.getPrefWidth());
        this.getChildren().add(SPane);

    }

    public static SettingsContent getInstance(){
        return instance;
    }
}
