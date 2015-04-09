package cn.edu.nju.software.lq;


public class Course {
	WeekDay day;
	String time;
	String name;
	String location;
	String dayString;
	
	public Course(String c){
		//get day and time
		String[] split = c.split("£»");

		day = WeekDay.getWeekDay(split[0]);
		time = split[1];
		name = split[2];
		location = split[3];
	}
	public Course(String split0, String split1) {
		day = WeekDay.getWeekDay(split0);
		time = split1;
	}
	
	public Course() {}
	
	public String toString(){
		return day+"£»"+time+"£»"+name+"£»"+location;
	}

}
