package dateAndCalendar;

import java.util.*;
import java.text.*;

public class Test
{
	public static void main(String[] args)
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = sdf.format(d);
		System.out.println(today);
		
		String newYear = "01.01.2018 00:00:00";
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		Date d2;
		try
		{
			d2 = df.parse(newYear);
			System.out.println(d2);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar calendar = new GregorianCalendar();
		System.out.println("now is " + calendar.get(Calendar.YEAR) + " year");
		
		
	}
}
