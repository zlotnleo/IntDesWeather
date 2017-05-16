package api.responseobjs;

public class Coordinate
{
	private int longitude;
	private int lattitude;
	
	public Coordinate(int lo, int la)
	{
		this.longitude = lo;
		this.lattitude = la;
	}

	public int getLongitude()
	{
		return longitude;
	}

	public int getLattitude()
	{
		return lattitude;
	}
	
	@Override
	public String toString()
	{
		return longitude + "," + lattitude;
	}
}