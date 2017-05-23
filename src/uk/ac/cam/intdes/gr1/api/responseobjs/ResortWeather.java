package uk.ac.cam.intdes.gr1.api.responseobjs;

import uk.ac.cam.intdes.gr1.api.WeatherAPIInterface;

import java.util.ArrayList;
import java.util.List;

public class ResortWeather
{
	private String name;
	private Coordinate coord;
    private List<WeatherReport> dailyReports;
    private WeatherAPIInterface weatherApi;

	public ResortWeather(String name, Coordinate location)
	{
		this.name = name;
		this.coord = location;
		weatherApi = WeatherAPIInterface.getInstance();
	}

	public String getName()
	{
		return name;
	}

	public Coordinate getCoordinate()
	{
		return coord;
	}

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public List<WeatherReport> getDailyReports() {
	    if (dailyReports == null) {
	        return new ArrayList<>();
        }
        return dailyReports;
    }
    public void fetchWeather() {
	    if (dailyReports == null) {
//            dailyReports = weatherApi.getWeatherReportAt(coord); // TODO uncomment for real API call
        }
    }

    @Override
	public String toString()
	{
		return name + " " + coord;
	}
}