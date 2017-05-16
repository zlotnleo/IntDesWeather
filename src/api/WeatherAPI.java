package api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import api.xml.IterativeXMLParser;
import api.xml.XMLObject;

public class WeatherAPI
{
	private static final String PROTOCOL = "http";
	private static final String URL = "api.worldweatheronline.com/premium/v1/ski.ashx";
	private static final String API_KEY = "e6d4c684320349cab8b131651171105";
	private static final String FORMAT = "xml";

	private Map<String, String> parameters;

	//
	// Set the value of any parameter currently being sent to the server
	//
	// PARAMS:
	// p = Name of the parameter to be set
	// v = Value of that parameter
	//
	public void setParameter(String p, String v)
	{
		if (p.equals("key") || p.equals("format"))
		{
			System.err.println("Parameter: " + p + " can not be altered");
			return;
		}

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
		req += URL;
		req += "?";
		req += "key=" + API_KEY;

		for (String s : parameters.keySet())
		{
			String p = s;
			String v = parameters.get(s);

			req += "&" + p + "=" + v;
		}

		req += "&format=" + FORMAT;

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