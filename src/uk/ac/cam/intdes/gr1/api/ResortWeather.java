package uk.ac.cam.intdes.gr1.api;

import uk.ac.cam.intdes.gr1.api.responseobjs.Coordinate;

public class ResortWeather {
    private String name;
    private Coordinate location;

    public ResortWeather() {

    }
    public ResortWeather(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }
}
