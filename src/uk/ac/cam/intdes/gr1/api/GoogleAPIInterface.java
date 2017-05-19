package uk.ac.cam.intdes.gr1.api;

import java.util.ArrayList;
import java.util.List;

import uk.ac.cam.intdes.gr1.api.responseobjs.Coordinate;
import uk.ac.cam.intdes.gr1.api.responseobjs.LocationResponseObject;
import uk.ac.cam.intdes.gr1.api.xml.XMLObject;

public class GoogleAPIInterface
{
	private static final String API_URL = "maps.googleapis.com/maps/api/place/textsearch/xml";
	private static final String API_KEY = "AIzaSyCuZmZka615kDgM7P-3d429nlfnZkl6x0w";
	
	private API api;
	
	public GoogleAPIInterface()
	{
		api = new API(API_URL);
	}
	
	public List<LocationResponseObject> getNearbySkiLocations(Coordinate loc)
	{
		List<LocationResponseObject> r = new ArrayList<>();
		
		api.startNewRequest();
		
		api.setParameter("location", loc.getLattitude() + "," + loc.getLongitude()); // the alps
		api.setParameter("radius", "100");
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
			
			Coordinate c = new Coordinate(lat, lon);
			
			LocationResponseObject obj = new LocationResponseObject(name, c);
			
			r.add(obj);
		}
		
		return r;
	}
}