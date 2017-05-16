package api.xml;

import java.util.ArrayList;

//Please don't exploit the fact that this class is entirely mutable
public class XMLObject
{
	private String name;
	private String data;
	
	private ArrayList<XMLObject> children;
	
	public XMLObject(String n)
	{
		this.name = n;
		children = new ArrayList<>();
	}
	
	public void addChild(XMLObject o)
	{
		children.add(o);
	}
	
	public ArrayList<XMLObject> getChildrenOfTag(String n)
	{
		ArrayList<XMLObject> r = new ArrayList<XMLObject>();
		for (XMLObject o : children)
		{
			if (o.name.equals(n))
				r.add(o);
		}
		return r;
	}
	
	public XMLObject getChildOfTag(String n)
	{
		for (XMLObject o : children)
		{
			if (o.name.equals(n))
				return o;
		}
		return null;
	}
	
	public void setData(String d)
	{
		data = d;
	}
	
	public String getData()
	{
		return data;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}