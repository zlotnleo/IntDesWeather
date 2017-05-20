package uk.ac.cam.intdes.gr1.api;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Location;
import uk.ac.cam.intdes.gr1.api.responseobjs.Coordinate;
import uk.ac.cam.intdes.gr1.api.responseobjs.ResortWeather;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;


public class CurrentLocationApi {
    private static CurrentLocationApi instance;

    private static DatabaseReader dbReader;

    private CurrentLocationApi() {
        try {
            URL filepath = CurrentLocationApi.class.getResource("/GeoLite2-City.mmdb");
            File locationDb = new File(filepath.getFile());
            // BUG: will fail if the pathname to db has spaces in it
            dbReader = new DatabaseReader.Builder(locationDb).build();
        } catch (Exception e) {
            dbReader = null;
        }
    }

    public static CurrentLocationApi getInstance() {
        if (instance == null) {
            instance = new CurrentLocationApi();
        }
        return instance;
    }

    /*
        code from: http://stackoverflow.com/questions/2939218/getting-the-external-ip-address-in-java
     */
    public String getIp() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Coordinate getLocation() {
        try {
            String ipString = getIp();
            InetAddress ipAddress = InetAddress.getByName(ipString);

            CityResponse response = dbReader.city(ipAddress);

            City city = response.getCity();
            Location location = response.getLocation();

            return new Coordinate(location.getLatitude(), location.getLongitude());
        } catch (Exception e) {
            return new Coordinate(52.210808,0.091348); // Cambridge CL
        }
    }
}
