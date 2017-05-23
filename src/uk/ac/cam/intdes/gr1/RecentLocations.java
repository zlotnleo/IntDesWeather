package uk.ac.cam.intdes.gr1;

import uk.ac.cam.intdes.gr1.api.responseobjs.Coordinate;
import uk.ac.cam.intdes.gr1.api.responseobjs.ResortWeather;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RecentLocations {

    private List<ResortWeather> recent;
    private static RecentLocations instance;

    private RecentLocations(){
        try {
            recent = Files.readAllLines(new File(getClass().getResource("/recents.txt").toURI()).toPath())
                    .stream()
                    .map(s -> {
                        String[] t = s.split(" ");
                        StringBuilder name = new StringBuilder("");
                        for(int i = 0; i < t.length - 3; i++)
                            name.append(t[i]).append(" ");
                        name.append(t[t.length - 3]);
                        return new ResortWeather(name.toString(), new Coordinate(Double.parseDouble(t[t.length - 2]), Double.parseDouble(t[t.length - 1])));
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
        recent = recent.stream().filter(r -> !c.getName().equals(r.getName())).collect(Collectors.toList());
        recent.add(0, c);
        recent = recent.subList(0, Math.min(Consts.MAX_ROW_CARDS, recent.size()));
        save();
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
        if(instance == null)
            instance = new RecentLocations();
        return instance;
    }
}
