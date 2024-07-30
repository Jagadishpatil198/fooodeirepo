package com.tek.OFOS.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Javautility {
	public int getrandomnumber()
	{
		Random random=new Random();
		         int randomnumber = random.nextInt(5000);
		         return randomnumber;
	}
	public String getsystemdateYYYYMMDD()
	{
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("YYYY-MM-DD");
		String data = sim.format(dateobj);
		return data;
	}
	public String getrequiredateYYYYMMDD(int days)
	{
		
		SimpleDateFormat sim=new SimpleDateFormat("YYYY-MM-DD");
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqdate = sim.format(cal.getTime());
		return reqdate;
		
	}

}
