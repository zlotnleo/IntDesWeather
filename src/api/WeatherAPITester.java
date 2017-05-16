package api;

import java.util.ArrayList;

import api.xml.XMLObject;

public class WeatherAPITester
{
	private static final String URL = "api.worldweatheronline.com/premium/v1/ski.ashx";
	private static final String API_KEY = "e6d4c684320349cab8b131651171105";
	private static final String FORMAT = "xml";
	
	private static API api;
	
	public static void main(String args[])
	{
		api = new API(URL);
		
		api.startNewRequest();
		
		api.setParameter("q", "New+York");
		api.setParameter("key", API_KEY);
		api.setParameter("format", FORMAT);
		
		XMLObject obj = api.execute();
		XMLObject data = obj.getChildOfTag("data");
		
		ArrayList<XMLObject> weathers = data.getChildrenOfTag("weather");
		
		System.out.println(weathers.size());
		
		for (XMLObject o : weathers)
		{
			System.out.println(o.getChildOfTag("date").getData());
		}
	}
}