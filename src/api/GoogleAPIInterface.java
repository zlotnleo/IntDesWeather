package api;

import java.util.ArrayList;
import java.util.List;

import api.responseobjs.Coordinate;
import api.responseobjs.LocationResponseObject;
import api.xml.XMLObject;

public class GoogleAPIInterface
{
	private static final String API_URL = "maps.googleapis.com/maps/api/place/textsearch/xml";
	private static final String API_KEY = "AIzaSyCuZmZka615kDgM7P-3d429nlfnZkl6x0w";
	
	private API api;
	
	public GoogleAPIInterface()
	{
		api = new API(API_URL);
	}
	
	//https://maps.googleapis.com/maps/api/place/textsearch/xml?query=ski+mountain&location=42.3675294,-71.186966&radius=10000&key=AIzaSyAvhCQhMsA2L4Aebimf5OT6wLVYRLjP6co
	
	public List<LocationResponseObject> getNearbySkiLocations(Coordinate loc)
	{
		List<LocationResponseObject> r = new ArrayList<>();
		
		api.startNewRequest();
		
		api.setParameter("location", loc.getLongitude() + "," + loc.getLattitude()); // the alps
		api.setParameter("type", "point_of_interest");
		api.setParameter("query", "ski+mountain");
		api.setParameter("key", API_KEY);
		
		XMLObject responseObject = api.execute();
		
		XMLObject response = responseObject.getChildOfTag("PlaceSearchResponse");
		
		List<XMLObject> ress = response.getChildrenOfTag("result");
		
		for (XMLObject o : ress)
		{
			String name = o.getChildOfTag("name").getData();
			XMLObject geom = o.getChildOfTag("geometry");
			XMLObject location = geom.getChildOfTag("location");
			
			double lat = Double.parseDouble(location.getChildOfTag("lat").getData());
			double lon = Double.parseDouble(location.getChildOfTag("lng").getData());
			
			Coordinate c = new Coordinate(lon, lat);
			
			LocationResponseObject obj = new LocationResponseObject(name, c);
			
			r.add(obj);
		}
		
		return r;
	}
}