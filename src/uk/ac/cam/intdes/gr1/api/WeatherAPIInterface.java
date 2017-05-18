package api;

public class WeatherAPIInterface
{
	private static final String API_URL = "api.worldweatheronline.com/premium/v1/ski.ashx";
	private static final String API_KEY = "e6d4c684320349cab8b131651171105";
	
	private API api;
	
	public WeatherAPIInterface()
	{
		api = new API(API_URL);
	}
	
	public void getWeatherReportAt(Coordinate c)
	{
		
	}
}