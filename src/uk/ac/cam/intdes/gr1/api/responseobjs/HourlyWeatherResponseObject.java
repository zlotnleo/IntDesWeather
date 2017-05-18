package uk.ac.cam.intdes.gr1.api.responseobjs;

public class HourlyWeatherResponseObject
{
	private int time; //HHMM
	
	private double snowfall; //cm
	private int freezeLevel;
	private double precip; //mm
	private int humidity;
	private int visibility;
	private int pressure;
	private int cloudCover;
	private int chanceOfRain;
	private int chanceOfRemDry;
	private int chanceOfWindy;
	private int chanceOfOvercast;
	private int chanceOfSunshine;
	private int chanceOfFrost;
	private int chanceOfHighTemp;
	private int chanceOfFog;
	private int chanceOfSnow;
	private int chanceOfThunder;
	
	public HourlyWeatherResponseObject(int time, double snowfall, int freezeLevel, double precip, int humidity, int visibility, int pressure, 
			int cloudCover, int chanceOfRain, int chanceOfRemDry, int chanceOfWindy, int chanceOfOvercast, int chanceOfSunshine, int chanceOfFrost, 
			int chanceOfHighTemp, int chanceOfFog, int chanceOfSnow, int chanceOfThunder)
	{
		this.time = time;
		this.snowfall = snowfall;
		this.freezeLevel = freezeLevel;
		this.precip = precip;
		this.humidity = humidity;
		this.visibility = visibility;
		this.pressure = pressure;
		this.cloudCover = cloudCover;
		this.chanceOfRain = chanceOfRain;
		this.chanceOfRemDry = chanceOfRemDry;
		this.chanceOfWindy = chanceOfWindy;
		this.chanceOfOvercast = chanceOfOvercast;
		this.chanceOfSunshine = chanceOfSunshine;
		this.chanceOfFrost = chanceOfFrost;
		this.chanceOfHighTemp = chanceOfHighTemp;
		this.chanceOfFog = chanceOfFog;
		this.chanceOfSnow = chanceOfSnow;
		this.chanceOfThunder = chanceOfThunder;
	}
	
	public int getTime()
	{
		return time;
	}
	
	public double getSnowfall()
	{
		return snowfall;
	}
	
	public int getFreezeLevel()
	{
		return freezeLevel;
	}
	
	public double getPrecip()
	{
		return precip;
	}
	
	public int getHumidity()
	{
		return humidity;
	}
	
	public int getVisibility()
	{
		return visibility;
	}
	
	public int getPressure()
	{
		return pressure;
	}
	
	public int getCloudCover()
	{
		return cloudCover;
	}
	
	public int getChanceOfRain()
	{
		return chanceOfRain;
	}
	
	public int getChanceOfRemDry()
	{
		return chanceOfRemDry;
	}
	
	public int getChanceOfWindy()
	{
		return chanceOfWindy;
	}
	
	public int getChanceOfOvercast()
	{
		return chanceOfOvercast;
	}
	
	public int getChanceOfSunshine()
	{
		return chanceOfSunshine;
	}
	
	public int getChanceOfFrost()
	{
		return chanceOfFrost;
	}
	
	public int getChanceOfHighTemp()
	{
		return chanceOfHighTemp;
	}
	
	public int getChanceOfFog()
	{
		return chanceOfFog;
	}
	
	public int getChanceOfSnow()
	{
		return chanceOfSnow;
	}
	
	public int getChanceOfThunder()
	{
		return chanceOfThunder;
	}
}