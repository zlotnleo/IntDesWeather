package api.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class IterativeXMLParser
{
	//I'll be honest I don't really know what I'm doing with this...
	private static final int READ_AHEAD_LIMIT = 9999;
	
	private static BufferedReader reader;
	
	//
	//Setup the buffered reader pointing to the XML document you wish to be parsed
	//
	//PARAMS:
	//		r = Buffered Reader pointing to desired XML document
	//
	public static void registerReader(BufferedReader r)
	{
		reader = r;
	}
	
	//
	//Parse the currently registered XML document
	//
	//RETURN:
	//		The parent XML tag of the XML document. All other data can then be retrieved via 
	//		recursive iteration through the children of this object
	//
	public static XMLObject parse()
	{
		Stack<XMLObject> objStack = new Stack<>();
		
		try
		{
			char c = 0;
			
			do
			{
				c = (char) reader.read();
			} while (c != '<');
			
			String start = readTag();
			objStack.push(new XMLObject(start));
			
			while (true)
			{
				reader.mark(READ_AHEAD_LIMIT);
				
				int i = reader.read();
				
				if (i == -1)
				{
					break;
				}
				
				c = (char) i;
				
				if (c == '<')
				{
					String tag = readTag();
					if (tag.startsWith("/"))
					{
						while (!objStack.peek().getName().equals(tag.replace("/", "")))
						{
							objStack.pop();
						}
						
						objStack.pop();
					}
					else
					{
						XMLObject obj = new XMLObject(tag);
						objStack.peek().addChild(obj);
						objStack.push(obj);
					}
				}
				else
				{
					reader.reset();
					String data = readData();
					objStack.peek().setData(data);
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return objStack.elementAt(0);
	}
	
	//
	//Reads in the name of a tag in the current location in the XML document (Implies the < has already been read)
	//
	//RETURN:
	//		The name of the tag represented as a string
	//
	private static String readTag() throws IOException
	{
		String curTag = "";
		
		char c = 0;
		
		while ((c = (char) reader.read()) != '>')
		{
			curTag += c;
		}
		
		return curTag;
	}

	//
	//Reads in the data of a tag in the current location in the XML document
	//
	//RETURN:
	//		The data represented as a string
	//
	private static String readData() throws IOException
	{
		String curData = "";
		
		int ic = 0;
		char c = 0;
		
		while ((ic = reader.read()) != '<')
		{
			if (ic == -1)
				break;
			
			c = (char) ic;
			
			reader.mark(READ_AHEAD_LIMIT);
			curData += c;
		}
		
		reader.reset();
		
		return curData;
	}
}