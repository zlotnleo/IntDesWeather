package uk.ac.cam.intdes.gr1.api.responseobjs;

import java.util.List;

public class WeatherReport
{
	private String date;
	private int chanceOfSnow;
	private double totalSnowfall; //cm
	
	private TopMidBottomMaxMinResponseObject top;
	private TopMidBottomMaxMinResponseObject mid;
	private TopMidBottomMaxMinResponseObject bottom;
	
	private List<HourlyWeatherReport> hws;
	
	public WeatherReport(String date, int chanceOfSnow, double totalSnowfall, TopMidBottomMaxMinResponseObject top, TopMidBottomMaxMinResponseObject mid, TopMidBottomMaxMinResponseObject bottom, List<HourlyWeatherReport> hs)
	{
		this.date = date;
		this.chanceOfSnow = chanceOfSnow;
		this.totalSnowfall = totalSnowfall;
		this.top = top;
		this.mid = mid;
		this.bottom = bottom;
		this.hws = hs;
	}

	public String getDate()
	{
		return date;
	}
	
	public int getChanceOfSnow()
	{
		return chanceOfSnow;
	}
	
	public double getTotalSnowfall()
	{
		return totalSnowfall;
	}
	
	public TopMidBottomMaxMinResponseObject getTop()
	{
		return top;
	}
	
	public TopMidBottomMaxMinResponseObject getMid()
	{
		return mid;
	}
	
	public TopMidBottomMaxMinResponseObject getBottom()
	{
		return bottom;
	}
	
	public List<HourlyWeatherReport> getHourlyReports()
	{
		return hws;
	}
}