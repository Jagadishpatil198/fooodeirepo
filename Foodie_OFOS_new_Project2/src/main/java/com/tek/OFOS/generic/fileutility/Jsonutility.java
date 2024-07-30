package com.tek.OFOS.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Jsonutility {
	public String getdatafromJSONfile(String key) throws Exception
	{
		FileReader fileR=new FileReader("dknvk");
		JSONParser PARSER=new JSONParser();
		Object obj = PARSER.parse(fileR);
	         JSONObject map=(JSONObject)obj;
	         String data = (String) map.get(key);
	         return data;
	}

}
