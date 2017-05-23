package uk.ac.cam.intdes.gr1;

import uk.ac.cam.intdes.gr1.api.responseobjs.Coordinate;
import uk.ac.cam.intdes.gr1.api.responseobjs.ResortWeather;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RecentLocations {

    private List<ResortWeather> recent;
    private static RecentLocations instance = new RecentLocations();

    private RecentLocations(){
        try {
            recent = Files.readAllLines(new File(getClass().getResource("/recents.txt").toURI()).toPath())
                    .stream()
                    .map(s -> {
                        String[] t = s.split(" ");
                        return new ResortWeather(t[0], new Coordinate(Double.parseDouble(t[1]), Double.parseDouble(t[2])));
                    })
                    .collect(Collectors.toList());

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            recent = new LinkedList<>();
        }
    }

    public void clear(){
        recent.clear();
    }

    public void addLocation(ResortWeather c){
        recent.add(0, c);
    }

    public List<ResortWeather> getLocations(){
        return recent;
    }

    public void save(){
        try {
            Files.write(
                    new File(getClass().getResource("/recents.txt").toURI()).toPath(),
                    recent.stream()
                            .map(rw -> rw.getName() + " " + rw.getCoord().getLatitude() + " " + rw.getCoord().getLongitude())
                            .collect(Collectors.toList())
            );
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static RecentLocations getInstance(){
        return instance;
    }
}
