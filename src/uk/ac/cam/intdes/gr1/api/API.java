package uk.ac.cam.intdes.gr1.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import uk.ac.cam.intdes.gr1.api.xml.IterativeXMLParser;
import uk.ac.cam.intdes.gr1.api.xml.XMLObject;

public class API
{
	private String baseURL;
	
	private static final String PROTOCOL = "https";

	private Map<String, String> parameters;
	
	public API(String u)
	{
		baseURL = u;
	}

	//
	// Set the value of any parameter currently being sent to the server
	//
	// PARAMS:
	// p = Name of the parameter to be set
	// v = Value of that parameter
	//
	public void setParameter(String p, String v)
	{
		parameters.put(p, v);
	}

	//
	// Clears all stored data from any previous requests to ready the system for
	// a new request
	//
	public void startNewRequest()
	{
		parameters = new HashMap<>();
		currentRequestInputStream = null;
	}

	//
	// Generates the raw URL request to be sent to the server
	//
	// RETURN:
	// String URL to be sent to the server
	//
	private String formRequestURL()
	{
		String req = "";

		req += PROTOCOL;
		req += "://";
		req += baseURL;
		
		boolean first = true;

		for (String s : parameters.keySet())
		{
			String p = s;
			String v = parameters.get(s);

			if (first)
			{
				req += "?" + p + "=" + v;
				first = false;
			} else
			{
				req += "&" + p + "=" + v;
			}
		}

		return req;
	}

	private InputStream currentRequestInputStream;

	//
	// Sends an HTTP request to the server with the given URL
	// PARAMS:
	// The
	//
	private boolean sendHTTPRequest(String reqURL)
	{
		HttpURLConnection conn = null;
		try
		{
			URL url = new URL(reqURL);
			conn = (HttpURLConnection) url.openConnection();
			currentRequestInputStream = conn.getInputStream();
			System.out.println("Request executed with response code: " + conn.getResponseCode());
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	public XMLObject execute()
	{
		String req = formRequestURL();
		sendHTTPRequest(req);

		System.out.println("Sent HTTP request: " + req);

		InputStreamReader isr = new InputStreamReader(currentRequestInputStream);
		BufferedReader br = new BufferedReader(isr);

		IterativeXMLParser.registerReader(br);

		return IterativeXMLParser.parse();
	}
}