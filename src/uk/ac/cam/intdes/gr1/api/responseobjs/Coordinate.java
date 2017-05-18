package uk.ac.cam.intdes.gr1.api.responseobjs;

public class Coordinate
{
	private double lattitude;
	private double longitude;
	
	public Coordinate(double la, double lo)
	{
		this.lattitude = la;
		this.longitude = lo;
	}

	public double getLattitude()
	{
		return lattitude;
	}

	public double getLongitude()
	{
		return longitude;
	}
	
	@Override
	public String toString()
	{
		return "Lat: " + lattitude + ", Long: " + longitude;
	}
}