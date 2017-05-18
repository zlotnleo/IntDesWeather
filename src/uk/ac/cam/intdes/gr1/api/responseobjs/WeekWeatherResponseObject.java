package uk.ac.cam.intdes.gr1.api.responseobjs;

import java.util.List;

public class WeekWeatherResponseObject
{
	private List<DailyWeatherResponseObject> days;
	
	public WeekWeatherResponseObject(List<DailyWeatherResponseObject> ds)
	{
		this.days = ds;
	}

	public List<DailyWeatherResponseObject> getDayReports()
	{
		return days;
	}
}