package uk.ac.cam.intdes.gr1;

public class AppSettings {

    private static AppSettings Current = new AppSettings();
    public static AppSettings getInstance(){return Current;}

    private boolean useFahrenheit = false;
    private boolean useMiles = false;
    // By default, use metric system (celcius and kilometres).

    private AppSettings(){
        super();
        loadSettings();
    }

    private void loadSettings(){
        // TODO: load settings from file for consistency.
        
    }

    public void setFahrenheit(boolean mode){
        Current.useFahrenheit = mode;
    }
    public boolean getFahrenheit(){
        return Current.useFahrenheit;
    }

    public void setMiles(boolean mode){
        Current.useMiles = mode;
    }
    public boolean getMiles(){
        return Current.useMiles;
    }

}
