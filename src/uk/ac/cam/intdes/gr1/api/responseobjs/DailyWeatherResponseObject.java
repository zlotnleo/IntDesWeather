package uk.ac.cam.intdes.gr1.api.responseobjs;

public class DailyWeatherResponseObject
{
	private String date;
	private int chanceOfSnow;
	private double totalSnowfall; //cm
	
	private TopMidBottomMaxMinResponseObject top;
	private TopMidBottomMaxMinResponseObject mid;
	private TopMidBottomMaxMinResponseObject bottom;
	
	private HourlyWeatherResponseObject h0000;
	private HourlyWeatherResponseObject h0300;
	private HourlyWeatherResponseObject h0600;
	private HourlyWeatherResponseObject h0900;
	private HourlyWeatherResponseObject h1200;
	private HourlyWeatherResponseObject h1500;
	private HourlyWeatherResponseObject h1800;
	private HourlyWeatherResponseObject h2100;
	
	public DailyWeatherResponseObject(String date, int chanceOfSnow, double totalSnowfall, TopMidBottomMaxMinResponseObject top, TopMidBottomMaxMinResponseObject mid, TopMidBottomMaxMinResponseObject bottom, HourlyWeatherResponseObject h0000, HourlyWeatherResponseObject h0300, HourlyWeatherResponseObject h0600, HourlyWeatherResponseObject h0900, HourlyWeatherResponseObject h1200, HourlyWeatherResponseObject h1500, HourlyWeatherResponseObject h1800, HourlyWeatherResponseObject h2100)
	{
		this.date = date;
		this.chanceOfSnow = chanceOfSnow;
		this.totalSnowfall = totalSnowfall;
		this.top = top;
		this.mid = mid;
		this.bottom = bottom;
		this.h0000 = h0000;
		this.h0300 = h0300;
		this.h0600 = h0600;
		this.h0900 = h0900;
		this.h1200 = h1200;
		this.h1500 = h1500;
		this.h1800 = h1800;
		this.h2100 = h2100;
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
	
	public HourlyWeatherResponseObject getH0000()
	{
		return h0000;
	}
	
	public HourlyWeatherResponseObject getH0300()
	{
		return h0300;
	}
	
	public HourlyWeatherResponseObject getH0600()
	{
		return h0600;
	}
	
	public HourlyWeatherResponseObject getH0900()
	{
		return h0900;
	}
	
	public HourlyWeatherResponseObject getH1200()
	{
		return h1200;
	}
	
	public HourlyWeatherResponseObject getH1500()
	{
		return h1500;
	}
	
	public HourlyWeatherResponseObject getH1800()
	{
		return h1800;
	}
	
	public HourlyWeatherResponseObject getH2100()
	{
		return h2100;
	}
}