package uk.ac.cam.intdes.gr1.ui;

public class HomeContent extends Content {

    private static HomeContent instance = new HomeContent();

    private HomeContent(){
        super();
    }

    public static HomeContent getInstance(){
        return instance;
    }
}
