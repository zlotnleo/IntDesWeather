package uk.ac.cam.intdes.gr1.api.responseobjs;

public class WeekWeatherResponseObject
{
	private DailyWeatherResponseObject d0;
	private DailyWeatherResponseObject d1;
	private DailyWeatherResponseObject d2;
	private DailyWeatherResponseObject d3;
	private DailyWeatherResponseObject d4;
	private DailyWeatherResponseObject d5;
	private DailyWeatherResponseObject d6;
	
	public WeekWeatherResponseObject(DailyWeatherResponseObject d0, DailyWeatherResponseObject d1, DailyWeatherResponseObject d2, DailyWeatherResponseObject d3, DailyWeatherResponseObject d4, DailyWeatherResponseObject d5, DailyWeatherResponseObject d6)
	{
		this.d0 = d0;
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
		this.d4 = d4;
		this.d5 = d5;
		this.d6 = d6;
	}

	public DailyWeatherResponseObject getD0()
	{
		return d0;
	}
	
	public DailyWeatherResponseObject getD1()
	{
		return d1;
	}
	
	public DailyWeatherResponseObject getD2()
	{
		return d2;
	}
	
	public DailyWeatherResponseObject getD3()
	{
		return d3;
	}
	
	public DailyWeatherResponseObject getD4()
	{
		return d4;
	}
	
	public DailyWeatherResponseObject getD5()
	{
		return d5;
	}
	
	public DailyWeatherResponseObject getD6()
	{
		return d6;
	}
}