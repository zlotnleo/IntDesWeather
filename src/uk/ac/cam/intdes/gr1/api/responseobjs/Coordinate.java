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

	public double getLatitude()
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

	/*
		from stackoverflow:
		http://stackoverflow.com/questions/27928/calculate-distance-between-two-latitude-longitude-points-haversine-formula
	 */
	public static double getDistanceInKm(Coordinate c1, Coordinate c2) {
		double R = 6371; // Radius of the earth in km
		double dlat = Math.toDegrees(c1.getLatitude() - c2.getLatitude());
		double dlon = Math.toDegrees(c1.getLatitude() - c2.getLatitude());
		double a =
				Math.sin(dlat / 2.0) * Math.sin(dlat / 2.0) +
				Math.cos(Math.toDegrees(c1.getLatitude())) *
					Math.cos(Math.toDegrees(c2.getLatitude())) *
					Math.sin(dlon / 2.0) * Math.sin(dlon / 2.0);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a));
		double d = R * c; // Distance in km
		return d;
	}
}