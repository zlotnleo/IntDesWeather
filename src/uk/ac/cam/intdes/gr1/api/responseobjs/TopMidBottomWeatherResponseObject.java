package uk.ac.cam.intdes.gr1.api.responseobjs;

public class TopMidBottomWeatherResponseObject
{
	private int tempC;
	private int tempF;
	private int windSpeedMiles;
	private int windSpeedKmph;
	private int winDirDegree;
	private String windDir16Point;
	
	private int weatherCode;

	public TopMidBottomWeatherResponseObject(int tempC, int tempF, int windSpeedMiles, int windSpeedKmph, int winDirDegree, String windDir16Point, int weatherCode)
	{
		this.tempC = tempC;
		this.tempF = tempF;
		this.windSpeedMiles = windSpeedMiles;
		this.windSpeedKmph = windSpeedKmph;
		this.winDirDegree = winDirDegree;
		this.windDir16Point = windDir16Point;
		this.weatherCode = weatherCode;
	}

	public int getTempC()
	{
		return tempC;
	}

	public int getTempF()
	{
		return tempF;
	}

	public int getWindSpeedMiles()
	{
		return windSpeedMiles;
	}

	public int getWindSpeedKmph()
	{
		return windSpeedKmph;
	}

	public int getWinDirDegree()
	{
		return winDirDegree;
	}

	public String getWindDir16Point()
	{
		return windDir16Point;
	}

	public int getWeatherCode()
	{
		return weatherCode;
	}
}