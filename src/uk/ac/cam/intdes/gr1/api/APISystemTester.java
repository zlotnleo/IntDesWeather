package uk.ac.cam.intdes.gr1.api;

import java.util.List;

import uk.ac.cam.intdes.gr1.api.responseobjs.Coordinate;
import uk.ac.cam.intdes.gr1.api.responseobjs.LocationResponseObject;
import uk.ac.cam.intdes.gr1.api.responseobjs.WeekWeatherResponseObject;

public class APISystemTester
{
	private static WeatherAPIInterface weatherAPI;
	private static GoogleAPIInterface googleAPI;
	
	public static void main(String args[])
	{
        SkiMapApi skiApi = new SkiMapApi();
        skiApi.create_db();

//		weatherAPI = new WeatherAPIInterface();
//		googleAPI = new GoogleAPIInterface();
//
//		try {
//            String ipString = CurrentLocationApi.getIp();
//            System.out.println("ip is: " + ipString);
//        } catch (Exception e) {
//		    System.out.println("Could not fetch ip!");
//        }
//
//		LocationResponseObject currentLoc = CurrentLocationApi.getLocation();
//		System.out.println("Current Location: " + currentLoc.toString());
//
//        List<LocationResponseObject> resp = googleAPI.getNearbySkiLocations(currentLoc.getCoordinate());
//
//		//Returns a list of the nearest ski resort areas to the inputed location
////		List<LocationResponseObject> resp = googleAPI.getNearbySkiLocations(new Coordinate(47.376068,8.536694));
////		List<LocationResponseObject> resp = googleAPI.getNearbySkiLocations(new Coordinate(52.210808,0.091348));
//
////
//		for (LocationResponseObject l : resp)
//		{
//			System.out.println(l);
////            WeekWeatherResponseObject w = weatherAPI.getWeatherReportAt(l.getCoordinate());
////            w.
//		}

//		WeekWeatherResponseObject w = weatherAPI.getWeatherReportAt(new Coordinate(56.34,-56.23));
		
		//Each weekly weather report has 7 daily reports in it (indexed 0 - 6)
		//Each weekly report has 8 3-hourly weather reports (indexed 0-7) starting with 0300 indexed at 0 and 2100 indexed at 7
		//Do note that day reports and hourly reports do contain their own data as well
		//All the attributes you can see just by looking in the relevant classes or the XML document and they should be fairly self-explanatory
		
//		System.out.println(w.getDayReports().get(0).getHourlyReports().get(0).getPressure());
	}
}