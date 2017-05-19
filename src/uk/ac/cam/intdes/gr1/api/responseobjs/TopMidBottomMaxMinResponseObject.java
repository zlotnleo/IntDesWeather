package uk.ac.cam.intdes.gr1.api.responseobjs;

public class TopMidBottomMaxMinResponseObject
{
	private int maxTempC;
	private int maxTempF;
	
	private int minTempC;
	private int minTempF;
	
	public TopMidBottomMaxMinResponseObject(int maxTempC, int maxTempF, int minTempC, int minTempF)
	{
		this.maxTempC = maxTempC;
		this.maxTempF = maxTempF;
		this.minTempC = minTempC;
		this.minTempF = minTempF;
	}

	public int getMaxTempC()
	{
		return maxTempC;
	}
	
	public int getMaxTempF()
	{
		return maxTempF;
	}
	
	public int getMinTempC()
	{
		return minTempC;
	}
	
	public int getMinTempF()
	{
		return minTempF;
	}
}