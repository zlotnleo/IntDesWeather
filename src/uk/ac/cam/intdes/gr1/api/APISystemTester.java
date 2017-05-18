package uk.ac.cam.intdes.gr1.api;

import uk.ac.cam.intdes.gr1.api.responseobjs.Coordinate;
import uk.ac.cam.intdes.gr1.api.responseobjs.WeekWeatherResponseObject;

public class APISystemTester
{
	private static WeatherAPIInterface weatherAPI;
	private static GoogleAPIInterface googleAPI;
	
	public static void main(String args[])
	{
		weatherAPI = new WeatherAPIInterface();
		googleAPI = new GoogleAPIInterface();
		
//		List<LocationResponseObject> resp = googleAPI.getNearbySkiLocations(new Coordinate(56.34,-56.23));
//		
//		for (LocationResponseObject l : resp)
//		{
//			System.out.println(l);
//		}
		
		WeekWeatherResponseObject w = weatherAPI.getWeatherReportAt(new Coordinate(56.34,-56.23));
		
		System.out.println(w.getDayReports().get(0).getHourlyReports().get(0).getPressure());
	}
}