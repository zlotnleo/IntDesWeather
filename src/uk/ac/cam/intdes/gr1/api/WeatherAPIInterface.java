package uk.ac.cam.intdes.gr1.api;

import uk.ac.cam.intdes.gr1.api.responseobjs.Coordinate;
import uk.ac.cam.intdes.gr1.api.xml.XMLObject;

public class WeatherAPIInterface
{
	private static final String API_URL = "api.worldweatheronline.com/premium/v1/ski.ashx";
	private static final String API_KEY = "e6d4c684320349cab8b131651171105";
	
	private API api;
	
	public WeatherAPIInterface()
	{
		api = new API(API_URL);
	}
	
	public void getWeatherReportAt(Coordinate c)
	{
		double lat = c.getLattitude();
		double lon = c.getLongitude();
		
		api.startNewRequest();
		
		api.setParameter("format", "xml");
		api.setParameter("q", lat + "," + lon);
		api.setParameter("key", API_KEY);
		
		XMLObject resp = api.execute();
		
		System.out.println(resp);
	}
}