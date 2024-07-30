package com.tek.OFOS.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class Fileutility {
	public String getdataPropertiesfile(String key) throws Exception
	{
		//step 1: get the java representation object of the physical file
		FileInputStream fis=new FileInputStream("./Configdata/User.properties");
		
		// step2: using properties class , load all the key
		Properties pobj=new Properties();
		pobj.load(fis);
		String data = pobj.getProperty(key);
		return data;
		
	}

}
