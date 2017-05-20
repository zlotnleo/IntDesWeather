package uk.ac.cam.intdes.gr1.api;

import uk.ac.cam.intdes.gr1.api.responseobjs.Coordinate;
import uk.ac.cam.intdes.gr1.api.responseobjs.ResortWeather;

import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SkiMapApi {
    private static final String API_URL = "https://skimap.org/SkiAreas/view/";
    private static SkiMapApi instance;

    private API api;

    private List<ResortWeather> resorts = new ArrayList<>();

    private SkiMapApi() {
        api = new API(API_URL);
        readDb();
    }
    public static SkiMapApi getInstance() {
        if (instance == null) {
            instance = new SkiMapApi();
        }
        return instance;
    }

    private void readDb() {
        try {
            String path = getClass().getResource("/resorts.txt").getFile();

            path = URLDecoder.decode(path, "UTF-8");

            try (Stream<String> stream = Files.lines(Paths.get(path))) {
                stream.forEach(line -> {
                    String[] s = line.split("\\s+");
                    int id = Integer.valueOf(s[0]);
                    double lat = Double.valueOf(s[s.length - 2]);
                    double lng = Double.valueOf(s[s.length - 1]);

                    StringBuilder nameBuilder = new StringBuilder();
                    for (int i = 1; i < s.length - 2; i += 1) {
                        if (i > 1) {
                            nameBuilder.append(" ");
                        }
                        nameBuilder.append(s[i]);
                    }
                    String name = nameBuilder.substring(1, nameBuilder.length() - 1);

                    resorts.add(new ResortWeather(name, new Coordinate(lat, lng)));
                });
            }
        } catch (Exception e) {
            System.out.println("Resort database not working!");
            e.printStackTrace();
        }
    }

    /**
     * Search resorts around location. Return them sorted by distance in km
     * @param location Location around which to search
     * @param maxDist set maximum distance
     */
    public List<ResortWeather> searchResorts(Coordinate location, double maxDist) {
        return sortResortsByDistance(location, resorts.stream().filter(resort ->
                Coordinate.getDistanceInKm(location, resort.getCoordinate()) <= maxDist
        ).collect(Collectors.toList()));
    }

    public List<ResortWeather> searchResorts(Coordinate location) {
        return sortResortsByDistance(location, resorts);
    }

    private List<ResortWeather> sortResortsByDistance(Coordinate location, List<ResortWeather> resortList) {
        List<ResortWeather> sorted = new ArrayList<>(resortList);
        sorted.sort(Comparator.comparingDouble(resort -> Coordinate.getDistanceInKm(resort.getCoordinate(), location)));
        return sorted;
    }

    public List<ResortWeather> getResorts() {
        return resorts;
    }
}
