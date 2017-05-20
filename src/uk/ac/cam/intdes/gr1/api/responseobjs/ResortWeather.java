package uk.ac.cam.intdes.gr1.api.responseobjs;

import java.util.ArrayList;
import java.util.List;

public class ResortWeather
{
	private String name;
	private Coordinate coord;
    private List<WeatherReport> dailyReports = new ArrayList<>();

    public ResortWeather() {

    }

	public ResortWeather(String name, Coordinate location)
	{
		this.name = name;
		this.coord = location;
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
        return dailyReports;
    }

    public void setDailyReports(List<WeatherReport> dailyReports) {
        this.dailyReports = dailyReports;
    }

	@Override
	public String toString()
	{
		return name + " " + coord;
	}
}