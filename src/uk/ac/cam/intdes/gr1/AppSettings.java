package uk.ac.cam.intdes.gr1;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;

public class AppSettings {

    private static AppSettings Current = new AppSettings();
    public static AppSettings getInstance(){return Current;}

    private BooleanProperty useFahrenheit = new SimpleBooleanProperty(false);
    private BooleanProperty useMiles = new SimpleBooleanProperty(false);
    // By default, use metric system (celsius and kilometres).

    private AppSettings(){
        super();
        loadSettings();
    }

    private void loadSettings(){
        // TODO: load settings from file for consistency.
        
    }

    public void setFahrenheit(boolean mode){
        Current.useFahrenheit.setValue(mode);
    }
    public boolean getFahrenheit(){
        return Current.useFahrenheit.getValue();
    }

    public void setMiles(boolean mode){
        Current.useMiles.setValue(mode);
    }
    public boolean getMiles(){
        return Current.useMiles.getValue();
    }

    public BooleanProperty getFahrenheitProperty() {
        return useFahrenheit;
    }

    public BooleanProperty getMilesProperty() {
        return useMiles;
    }
}
