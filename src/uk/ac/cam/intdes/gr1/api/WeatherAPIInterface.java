package uk.ac.cam.intdes.gr1.api;

import java.util.ArrayList;
import java.util.List;

import uk.ac.cam.intdes.gr1.api.responseobjs.Coordinate;
import uk.ac.cam.intdes.gr1.api.responseobjs.WeatherReport;
import uk.ac.cam.intdes.gr1.api.responseobjs.HourlyWeatherReport;
import uk.ac.cam.intdes.gr1.api.responseobjs.TopMidBottomMaxMinResponseObject;
import uk.ac.cam.intdes.gr1.api.responseobjs.TopMidBottomWeatherResponseObject;
import uk.ac.cam.intdes.gr1.api.xml.XMLObject;

public class WeatherAPIInterface
{
	private static final String API_URL = "api.worldweatheronline.com/premium/v1/ski.ashx";
//	private static final String API_KEY = "e6d4c684320349cab8b131651171105"; // change to this one for release
    private static final String API_KEY = "319b714191034c3289e92300172305"; // this is for testing
//	private static final String API_KEY = "cdb9677bc3154f8f9d1142317172305";

	private API api;
	private static WeatherAPIInterface instance;
	
	private WeatherAPIInterface()
	{
		api = new API(API_URL);
	}
	public static WeatherAPIInterface getInstance() {
		if (instance == null) {
		    instance = new WeatherAPIInterface();
        }
        return instance;
	}
	
	public List<WeatherReport> getWeatherReportAt(Coordinate c)
	{
		double lat = c.getLatitude();
		double lon = c.getLongitude();
		
		api.startNewRequest();
		
		api.setParameter("format", "xml");
		api.setParameter("q", lat + "," + lon);
		api.setParameter("key", API_KEY);
		
		XMLObject resp = api.execute();
		
		XMLObject data = resp.getChildOfTag("data");
		
		List<XMLObject> weathers = data.getChildrenOfTag("weather");
		
		List<WeatherReport> dailies = new ArrayList<>();

		for (XMLObject w : weathers)
		{
			String date = w.getChildOfTag("date").getData();
			int chanceOfSnow = Integer.parseInt(w.getChildOfTag("chanceofsnow").getData());
			double totalSnowfall = Double.parseDouble(w.getChildOfTag("totalSnowfall_cm").getData());

			//TOP
			XMLObject topTag = w.getChildOfTag("top");
			int tMaxTempC = Integer.parseInt(topTag.getChildOfTag("maxtempC").getData());
			int tMaxTempF = Integer.parseInt(topTag.getChildOfTag("maxtempF").getData());
			int tMinTempC = Integer.parseInt(topTag.getChildOfTag("mintempC").getData());
			int tMinTempF = Integer.parseInt(topTag.getChildOfTag("mintempF").getData());

			TopMidBottomMaxMinResponseObject top = new TopMidBottomMaxMinResponseObject(tMaxTempC, tMaxTempF, tMinTempC, tMinTempF);

			//MID
			XMLObject midTag = w.getChildOfTag("mid");
			int mMaxTempC = Integer.parseInt(midTag.getChildOfTag("maxtempC").getData());
			int mMaxTempF = Integer.parseInt(midTag.getChildOfTag("maxtempF").getData());
			int mMinTempC = Integer.parseInt(midTag.getChildOfTag("mintempC").getData());
			int mMinTempF = Integer.parseInt(midTag.getChildOfTag("mintempF").getData());

			TopMidBottomMaxMinResponseObject mid = new TopMidBottomMaxMinResponseObject(mMaxTempC, mMaxTempF, mMinTempC, mMinTempF);

			//BOT
			XMLObject botTag = w.getChildOfTag("bottom");
			int bMaxTempC = Integer.parseInt(botTag.getChildOfTag("maxtempC").getData());
			int bMaxTempF = Integer.parseInt(botTag.getChildOfTag("maxtempF").getData());
			int bMinTempC = Integer.parseInt(botTag.getChildOfTag("mintempC").getData());
			int bMinTempF = Integer.parseInt(botTag.getChildOfTag("mintempF").getData());

			TopMidBottomMaxMinResponseObject bot = new TopMidBottomMaxMinResponseObject(bMaxTempC, bMaxTempF, bMinTempC, bMinTempF);

			List<HourlyWeatherReport> hourlies = new ArrayList<>();

			List<XMLObject> hourlyTags = w.getChildrenOfTag("hourly");

			for (XMLObject o : hourlyTags)
			{
				//ITOP
				XMLObject iTopTag = o.getChildOfTag("top");
				int tTempC = Integer.parseInt(iTopTag.getChildOfTag("tempC").getData());
				int tTempF = Integer.parseInt(iTopTag.getChildOfTag("tempF").getData());
				int tWindSpeedMiles = Integer.parseInt(iTopTag.getChildOfTag("windspeedMiles").getData());
				int tWindspeedKmph = Integer.parseInt(iTopTag.getChildOfTag("windspeedKmph").getData());
				int tWindDirDegree = Integer.parseInt(iTopTag.getChildOfTag("winddirDegree").getData());
				String tWindDir16Point = iTopTag.getChildOfTag("winddir16Point").getData();
				int tWeatherCode = Integer.parseInt(iTopTag.getChildOfTag("weatherCode").getData());

				TopMidBottomWeatherResponseObject iTop = new TopMidBottomWeatherResponseObject(tTempC, tTempF, tWindSpeedMiles, tWindspeedKmph, tWindDirDegree, tWindDir16Point, tWeatherCode);

				//IMID
				XMLObject iMidTag = o.getChildOfTag("mid");
				int mTempC = Integer.parseInt(iMidTag.getChildOfTag("tempC").getData());
				int mTempF = Integer.parseInt(iMidTag.getChildOfTag("tempF").getData());
				int mWindSpeedMiles = Integer.parseInt(iMidTag.getChildOfTag("windspeedMiles").getData());
				int mWindspeedKmph = Integer.parseInt(iMidTag.getChildOfTag("windspeedKmph").getData());
				int mWindDirDegree = Integer.parseInt(iMidTag.getChildOfTag("winddirDegree").getData());
				String mWindDir16Point = iMidTag.getChildOfTag("winddir16Point").getData();
				int mWeatherCode = Integer.parseInt(iMidTag.getChildOfTag("weatherCode").getData());

				TopMidBottomWeatherResponseObject iMid = new TopMidBottomWeatherResponseObject(mTempC, mTempF, mWindSpeedMiles, mWindspeedKmph, mWindDirDegree, mWindDir16Point, mWeatherCode);

				//IBOT
				XMLObject iBotTag = o.getChildOfTag("bottom");
				int bTempC = Integer.parseInt(iMidTag.getChildOfTag("tempC").getData());
				int bTempF = Integer.parseInt(iMidTag.getChildOfTag("tempF").getData());
				int bWindSpeedMiles = Integer.parseInt(iMidTag.getChildOfTag("windspeedMiles").getData());
				int bWindspeedKmph = Integer.parseInt(iMidTag.getChildOfTag("windspeedKmph").getData());
				int bWindDirDegree = Integer.parseInt(iMidTag.getChildOfTag("winddirDegree").getData());
				String bWindDir16Point = iMidTag.getChildOfTag("winddir16Point").getData();
				int bWeatherCode = Integer.parseInt(iBotTag.getChildOfTag("weatherCode").getData());

				TopMidBottomWeatherResponseObject iBot = new TopMidBottomWeatherResponseObject(bTempC, bTempF, bWindSpeedMiles, bWindspeedKmph, bWindDirDegree, bWindDir16Point, bWeatherCode);

				int time = Integer.parseInt(o.getChildOfTag("time").getData());
				double snowfall = Double.parseDouble(o.getChildOfTag("snowfall_cm").getData());
				int freezeLevel = Integer.parseInt(o.getChildOfTag("freezeLevel").getData());
				double precip = Double.parseDouble(o.getChildOfTag("precipMM").getData());
				int humidity = Integer.parseInt(o.getChildOfTag("humidity").getData());
				int visibility = Integer.parseInt(o.getChildOfTag("visibility").getData());
				int pressure = Integer.parseInt(o.getChildOfTag("pressure").getData());
				int cloudCover = Integer.parseInt(o.getChildOfTag("cloudcover").getData());
				int chanceOfRain = Integer.parseInt(o.getChildOfTag("chanceofrain").getData());
				int chanceOfRemDry = Integer.parseInt(o.getChildOfTag("chanceofremdry").getData());
				int chanceOfWindy = Integer.parseInt(o.getChildOfTag("chanceofwindy").getData());
				int chanceOfOvercast = Integer.parseInt(o.getChildOfTag("chanceofovercast").getData());
				int chanceOfSunshine = Integer.parseInt(o.getChildOfTag("chanceofsunshine").getData());
				int chanceOfFrost = Integer.parseInt(o.getChildOfTag("chanceoffrost").getData());
				int chanceOfHighTemp = Integer.parseInt(o.getChildOfTag("chanceofhightemp").getData());
				int chanceOfFog = Integer.parseInt(o.getChildOfTag("chanceoffog").getData());
				int dChanceOfSnow = Integer.parseInt(o.getChildOfTag("chanceofsnow").getData());
				int chanceOfThunder = Integer.parseInt(o.getChildOfTag("chanceofthunder").getData());

				HourlyWeatherReport h = new HourlyWeatherReport(time, snowfall, freezeLevel, precip, humidity, visibility, pressure, cloudCover, chanceOfRain, chanceOfRemDry, chanceOfWindy, chanceOfOvercast, chanceOfSunshine, chanceOfFrost, chanceOfHighTemp, chanceOfFog, dChanceOfSnow, chanceOfThunder, iTop, iMid, iBot);

				hourlies.add(h);
			}

			WeatherReport daily = new WeatherReport(date, chanceOfSnow, totalSnowfall, top, mid, bot, hourlies);

			dailies.add(daily);
		}

		return dailies;

	}
}