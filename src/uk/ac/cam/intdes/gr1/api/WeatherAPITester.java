package uk.ac.cam.intdes.gr1.api;

public class WeatherAPITester
{
	private static WeatherAPIInterface weatherAPI;
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
		
//		googleAPI = new GoogleAPIInterface();
//		
////		List<LocationResponseObject> resp = googleAPI.getNearbySkiLocations(new Coordinate(42.3675294, -71.186966));
//		List<LocationResponseObject> resp = googleAPI.getNearbySkiLocations(new Coordinate(52.205, 0.119));
//		
//		for (LocationResponseObject r : resp)
//		{
//			System.out.println(r);
//		}
		
		weatherAPI = new WeatherAPIInterface();
		
		weatherAPI
	}
}