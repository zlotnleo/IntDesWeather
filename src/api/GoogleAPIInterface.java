package api;

import java.util.ArrayList;
import java.util.List;

import api.responseobjs.Coordinate;
import api.responseobjs.LocationResponseObject;
import api.xml.XMLObject;

public class GoogleAPIInterface
{
	private static final String GOOGLE_API_URL = "maps.googleapis.com/maps/api/place/textsearch/xml";
	private static final String GOOGLE_API_KEY = "AIzaSyCuZmZka615kDgM7P-3d429nlfnZkl6x0w";
	
	private API api;
	
	public GoogleAPIInterface()
	{
		api = new API(GOOGLE_API_URL);
	}
	
	public List<LocationResponseObject> getNearbySkiLocations(Coordinate loc)
	{
		List<LocationResponseObject> r = new ArrayList<>();
		
		api.startNewRequest();
		
		api.setParameter("location", loc.toString()); // the alps
		api.setParameter("type", "point_of_interest");
		api.setParameter("query", "ski+mountain");
		api.setParameter("key", GOOGLE_API_KEY);
		
		XMLObject responseObject = api.execute();
		
		XMLObject response = responseObject.getChildOfTag("PlaceSearchResponse");
		
		List<XMLObject> ress = response.getChildrenOfTag("result");
		
		for (XMLObject o : ress)
		{
			String name = o.getChildOfTag("name").getData();
			XMLObject geom = o.getChildOfTag("geometry");
			XMLObject location = geom.getChildOfTag("location");
			
			int lat = Integer.parseInt(location.getChildOfTag("lat").getData());
			int lon = Integer.parseInt(location.getChildOfTag("lng").getData());
			
			Coordinate c = new Coordinate(lon, lat);
			
			LocationResponseObject obj = new LocationResponseObject(name, c);
			
			r.add(obj);
		}
		
		return r;
	}
}