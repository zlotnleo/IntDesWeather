package api;

import java.util.ArrayList;

import api.xml.XMLObject;

public class APITester
{
	private static WeatherAPI api;
	
	public static void main(String args[])
	{
		api = new WeatherAPI();
		api.startNewRequest();
		api.setParameter("q", "New+York");
		
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