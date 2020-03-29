package dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import persistent.FoodItem;

public class WeeklyReport implements ReportFactory {

	@Override
	public void generateReport() {

		Calendar c = GregorianCalendar.getInstance(Locale.UK);
		c.setFirstDayOfWeek(Calendar.MONDAY);
	
		Date end_date = c.getTime();
		c.add(Calendar.DATE, -6);
		Date start_date= c.getTime();
		int nr = 0;
		String all="This week, from " + start_date.toString() + " to " + end_date.toString() +
				", the following products were wasted:\n";
		FoodItemDao d = new FoodItemDao();
		List<FoodItem> list = d.getAlldata();
		for(FoodItem item:list) {
			if(item.getExpiration_date().compareTo(start_date) >= 0 && item.getExpiration_date().compareTo(end_date) <= 0) {
				if(item.waste() == true) {
					all+="	-> " + item.getName() + "\n";
					nr++;
				}
			}
		}
		all += "\n\n The total number of wasted products this week is: " + nr;
		System.out.println(all);
	}
	
	public static void main(String[] args) {
		WeeklyReport r = new WeeklyReport();
		r.generateReport();
	}
}
