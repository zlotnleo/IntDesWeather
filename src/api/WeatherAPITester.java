package api;

import java.util.ArrayList;
import java.util.List;

import api.xml.XMLObject;

public class WeatherAPITester
{
	//Google example request: https://maps.googleapis.com/maps/api/place/textsearch/xml?location=45.833611,6.865&type=point_of_interest&query=ski+mountain&key=AIzaSyCuZmZka615kDgM7P-3d429nlfnZkl6x0w
	
	private static final String WEATHER_API_URL = "api.worldweatheronline.com/premium/v1/ski.ashx";
	private static final String GOOGLE_API_URL = "maps.googleapis.com/maps/api/place/textsearch/xml";
	
	private static final String WEATHER_API_KEY = "e6d4c684320349cab8b131651171105";
	private static final String GOOGLE_API_KEY = "AIzaSyCuZmZka615kDgM7P-3d429nlfnZkl6x0w";
	
	private static final String FORMAT = "xml"; //Only used in the weather API, Google API is xml defined in the URL
	
	private static API weatherAPI;
	private static API googleAPI;
	
	public static void main(String args[])
	{
		weatherAPI = new API(WEATHER_API_URL);
		googleAPI = new API(GOOGLE_API_URL);
		
		weatherAPI.startNewRequest();
		
		weatherAPI.setParameter("q", "New+York");
		weatherAPI.setParameter("key", WEATHER_API_KEY);
		weatherAPI.setParameter("format", FORMAT);
		
		XMLObject weatherResponseObj = weatherAPI.execute();
		XMLObject data = weatherResponseObj.getChildOfTag("data");
		
		List<XMLObject> weathers = data.getChildrenOfTag("weather");
		
		System.out.println(weathers.size());
		
		for (XMLObject o : weathers)
		{
			System.out.println(o.getChildOfTag("date").getData());
		}
		
		googleAPI.startNewRequest();
		
		googleAPI.setParameter("location", "45.833611,6.865"); // the alps
		googleAPI.setParameter("type", "point_of_interest");
		googleAPI.setParameter("query", "ski+mountain");
		googleAPI.setParameter("key", GOOGLE_API_KEY);
		
		XMLObject googleResponseObject = googleAPI.execute();
		
		XMLObject response = googleResponseObject.getChildOfTag("PlaceSearchResponse");
		
		List<XMLObject> ress = response.getChildrenOfTag("result");
		
		for (XMLObject o : ress)
		{
			System.out.println(o.getChildOfTag("name").getData());
		}
	}
}