package uk.ac.cam.intdes.gr1.api;

import java.util.ArrayList;
import java.util.List;

import com.sun.istack.internal.Nullable;
import uk.ac.cam.intdes.gr1.api.responseobjs.Coordinate;
import uk.ac.cam.intdes.gr1.api.responseobjs.LocationResponseObject;
import uk.ac.cam.intdes.gr1.api.xml.XMLObject;

public class GoogleAPIInterface
{
	private static final String API_URL = "maps.googleapis.com/maps/api/place/textsearch/xml";
	private static final String API_KEY = "AIzaSyCuZmZka615kDgM7P-3d429nlfnZkl6x0w";
	
	private API api;
	private static GoogleAPIInterface instance;

	private GoogleAPIInterface() {
		api = new API(API_URL);
	}

	public static GoogleAPIInterface getInstance() {
		if (instance == null) {
			instance = new GoogleAPIInterface();
		}
		return instance;
	}

	public Coordinate getLocation(String searchInput) {
		api.startNewRequest();

		api.setParameter("query", String.join("+", searchInput.trim().split("\\s+")));
		api.setParameter("key", API_KEY);

		XMLObject responseObject = api.execute();
		XMLObject response = responseObject.getChildOfTag("PlaceSearchResponse");

		List<XMLObject> ress = response.getChildrenOfTag("result");

		if (ress.size() == 0) {
			//TODO: could no find. what to do?
			return new Coordinate(0, 0);
		}

		XMLObject res = ress.get(0);
		XMLObject loc = res.getChildOfTag("geometry").getChildOfTag("location");
		double lat = Double.valueOf(loc.getChildOfTag("lat").getData());
		double lng = Double.valueOf(loc.getChildOfTag("lng").getData());

		return new Coordinate(lat, lng);
	}
	
	public List<LocationResponseObject> getNearbySkiLocations(@Nullable Coordinate loc)
	{
		List<LocationResponseObject> r = new ArrayList<>();
		
		api.startNewRequest();

		if (loc != null) {
            api.setParameter("location", loc.getLatitude() + "," + loc.getLongitude());
        }
		api.setParameter("query", "ski+resort");
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