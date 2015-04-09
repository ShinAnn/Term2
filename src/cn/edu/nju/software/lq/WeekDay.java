package cn.edu.nju.software.lq;

public enum WeekDay {
	Mon("星期一"),Tue("星期二"),Wen("星期三"),Thu("星期四"),Fri("星期五"),Sat("星期六"),Sun("星期日");
	
	private String day = null;
	
	WeekDay(String s){
		day = s;
	}
	public String toString(){
		return day;
	}
	public String getString(){
		return day;
	}

	public static WeekDay getWeekDay(String s) {
		
		for (WeekDay weekDay : WeekDay.values()) {
			if (s.equals(weekDay.getString()))
				return weekDay;
		}
		return null;
	}
}
