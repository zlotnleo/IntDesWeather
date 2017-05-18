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