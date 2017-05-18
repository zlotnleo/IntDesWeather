package uk.ac.cam.intdes.gr1.api;

import java.util.ArrayList;

import uk.ac.cam.intdes.gr1.api.xml.XMLObject;

public class WeatherAPITester
{
	private static API api;
	
	public static void main(String args[])
	{
		api = new API();
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