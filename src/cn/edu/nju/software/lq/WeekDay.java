package cn.edu.nju.software.lq;

public enum WeekDay {
	Mon("����һ"),Tue("���ڶ�"),Wen("������"),Thu("������"),Fri("������"),Sat("������"),Sun("������");
	
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
