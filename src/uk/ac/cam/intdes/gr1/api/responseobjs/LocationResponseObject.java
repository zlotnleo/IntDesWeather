package uk.ac.cam.intdes.gr1.api.responseobjs;

public class LocationResponseObject
{
	private String name;
	private Coordinate coord;
	
	public LocationResponseObject(String n, Coordinate c)
	{
		this.name = n;
		this.coord = c;
	}

	public String getName()
	{
		return name;
	}

	public Coordinate getCoordinate()
	{
		return coord;
	}
	
	@Override
	public String toString()
	{
		return name + " " + coord;
	}
}