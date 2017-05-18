package api;

import java.util.List;

import api.responseobjs.Coordinate;
import api.responseobjs.LocationResponseObject;
import api.xml.XMLObject;

public class WeatherAPITester
{
	// Weather example request:
	// https://api.worldweatheronline.com/premium/v1/ski.ashx?q=New+York&format=xml&key=e6d4c684320349cab8b131651171105
	// Google example request:
	// https://maps.googleapis.com/maps/api/place/textsearch/xml?query=ski+mountain&location=45.833611,6.865&type=point_of_interest&key=AIzaSyCuZmZka615kDgM7P-3d429nlfnZkl6x0w

	private static final String WEATHER_API_URL = "api.worldweatheronline.com/premium/v1/ski.ashx";

	private static final String WEATHER_API_KEY = "e6d4c684320349cab8b131651171105";

	private static final String FORMAT = "xml"; // Only used in the weather API,
												// Google API is xml defined in
												// the URL

	private static API weatherAPI;
	private static GoogleAPIInterface googleAPI;

	public static void main(String args[])
	{
//		Old test code
//		
//		weatherAPI = new API(WEATHER_API_URL);
//		googleAPI = new API(GOOGLE_API_URL);
//		
//		weatherAPI.startNewRequest();
//		
//		weatherAPI.setParameter("q", "New+York");
//		weatherAPI.setParameter("key", WEATHER_API_KEY);
//		weatherAPI.setParameter("format", FORMAT);
//		
//		XMLObject weatherResponseObj = weatherAPI.execute();
//		XMLObject data = weatherResponseObj.getChildOfTag("data");
//		
//		List<XMLObject> weathers = data.getChildrenOfTag("weather");
//		
//		System.out.println(weathers.size());
//		
//		for (XMLObject o : weathers)
//		{
//			System.out.println(o.getChildOfTag("date").getData());
//		}
//		
//		googleAPI.startNewRequest();
//		
//		googleAPI.setParameter("location", "45.833611,6.865"); // the alps
//		googleAPI.setParameter("type", "point_of_interest");
//		googleAPI.setParameter("query", "ski+mountain");
//		googleAPI.setParameter("key", GOOGLE_API_KEY);
//		
//		XMLObject googleResponseObject = googleAPI.execute();
//		
//		XMLObject response = googleResponseObject.getChildOfTag("PlaceSearchResponse");
//		
//		List<XMLObject> ress = response.getChildrenOfTag("result");
//		
//		for (XMLObject o : ress)
//		{
//			System.out.println(o.getChildOfTag("name").getData());
//		}
		
		googleAPI = new GoogleAPIInterface();
		
		List<LocationResponseObject> resp = googleAPI.getNearbySkiLocations(new Coordinate(42.3675294, -71.186966));
		
		for (LocationResponseObject r : resp)
		{
			System.out.println(r);
		}
	}
}