package nju.java.job02;

import java.util.Calendar;
import java.util.Scanner;

public class DateCompute {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/**
		 * 今天到Java1.0的天数
		 */
		Calendar myCalendar = Calendar.getInstance();
		//获得年
		int myYear = myCalendar.get(Calendar.YEAR);
		//获得月
		int myMonth = myCalendar.get(Calendar.MONTH)+1;
		//获得日
		int myDate = myCalendar.get(Calendar.DATE);
		//打印
		System.out.println("运行程序时的日期到Java 1.0发布日相差的天数为" + myDateFromJava1(myYear, myMonth, myDate) + "天");
		
		/**
		 * 自己设计算法
		 */
		System.out.println("输入一个日期（年 月 日）");
		//获得年
		int year1 = input.nextInt();
		//获得月
		int month1 = input.nextInt();
		//获得日
		int date1 = input.nextInt();
		System.out.println("再输入一个日期（年 月 日）");
		//获得年
		int year2 = input.nextInt();
		//获得月
		int month2 = input.nextInt();
		//获得日
		int date2 = input.nextInt();
		// 调用myDateBetweenTwoDays得到两天相差的天数
		int myDay = myDateBetweenTwoDays(year1, month1, date1,year2, month2, date2);
		//打印
		System.out.println( year1+"-"+month1+"-"+date1+"距离"+year2+"-"+month2+"-"+date2+"为"+myDay+"天");
		
		/**
		 * 调用Calendar类计算
		 */
		// 创建一个日历（今天的时间）
		Calendar calendar = Calendar.getInstance();
		// 调用dateFromJava1得到和Java1.0发布日相差的天数
		int dayFromJava1 = dateFromJava1(calendar);
		// 打印
		System.out.println("运行程序时的日期到Java 1.0发布日相差的天数为" + dayFromJava1 + "天");
		/**
		 * 调用Calendar类计算
		 */
		// 创建一个日历1
		Calendar calendar1 = Calendar.getInstance();
		// 设定日历1的时间
		System.out.println("输入一个日期（年 月 日）");
		calendar1.set(input.nextInt(), (input.nextInt() - 1), input.nextInt(),
				0, 0, 0);
		// 创建一个日历2
		Calendar calendar2 = Calendar.getInstance();
		// 设定日历2的时间
		System.out.println("再输入一个日期（年 月 日）");
		calendar2.set(input.nextInt(), (input.nextInt() - 1), input.nextInt(),
				0, 0, 0);
		// 调用dateBetweenTwoDays得到两天相差的天数
		int dayBetweenTwoDay = dateBetweenTwoDays(calendar2, calendar1);
		// 打印
		System.out.println("日历1和日历2相差的天数为" + dayBetweenTwoDay + "天");
		input.close();
	}

	/**
	 * 计算得到和Java1.0发布日相差的天数
	 * 
	 * @param calendar
	 *            运行程序时的日期
	 * @return 运行程序时的日期到Java 1.0发布日相差的天数
	 */
	public static int dateFromJava1(Calendar calendar) {
		// 创建一个日历
		Calendar calendarJava1 = Calendar.getInstance();
		// 设定日历的时间为Java 1.0发布的日期
		calendarJava1.set(1995, (5 - 1), 23, 0, 0, 0);
		// 计算Java 1.0发布的日期的毫秒数
		long timeJava1InMillis = calendarJava1.getTimeInMillis();
		// 计算运行程序时的日期到Java 1.0发布日相差的毫秒数
		long timeBetweenTwoCalendarInMillis = calendar.getTimeInMillis()
				- timeJava1InMillis;
		// 将毫秒数转化为日期数
		int dayBetweenTwoCalendar = (int) (timeBetweenTwoCalendarInMillis / (1000 * 60 * 60 * 24));
		// 返回运行程序时的日期到Java 1.0发布日相差的天数
		return dayBetweenTwoCalendar;
	}

	/**
	 * 计算日历1和日历2相差的天数（结果为正）
	 * 
	 * @param calendar1
	 *            日历1
	 * @param calendar2
	 *            日历2
	 * @return 日历1和日历2相差的天数（结果为正）
	 */
	public static int dateBetweenTwoDays(Calendar calendar1, Calendar calendar2) {
		// 计算日历1的毫秒数和日历2的毫秒数的差
		long timeBetweenTwoCalendarInMillis = calendar1.getTimeInMillis()
				- calendar2.getTimeInMillis();
		// 将毫秒数转化为日期数
		int dayBetweenTwoCalendar = (int) (timeBetweenTwoCalendarInMillis / (1000 * 60 * 60 * 24));
		// 判断日期数是否为正，正则返回，负则取反返回
		if (dayBetweenTwoCalendar < 0) {
			return -dayBetweenTwoCalendar;
		}
		return dayBetweenTwoCalendar;
	}

	/**
	 * 判断某年是否是闰年
	 * 
	 * @param year
	 *            年份
	 * @return 是否闰年
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 != 0) {
			// 不被4整除的年不是闰年
			return false;
		} else if (year % 400 != 0 && year % 100 == 0) {
			// 被100整除的年且不被400整除的年不是闰年
			return false;
		} else
			// 其他为闰年
			return true;
	}
	/**
	 * 计算计算两天相差的天数（结果为正）
	 * @return 两天相差的天数（结果为正）
	 */
	public static int myDateBetweenTwoDays(int year1, int month1, int date1,	int year2, int month2, int date2) {
		//保证year1<year2
		if (year1 > year2) {
			return myDateBetweenTwoDays(year2, month2, date2, year1, month1,	date1);
		}
		//计算day2是一年中的第多少天
		int day2 = dayToOneOne(year2, month2, date2);
		//计算day1是一年中的第多少天
		int day1 = dayToOneOne(year1, month1, date1);
		//从year1到year2循环
		for (int i = year1; i < year2; i++) {
			if (isLeapYear(i)) {
				day2 += 366;
			} else
				day2 += 365;
		}
		//返回
		int day = day2 - day1;
		return day;
	}
	/**
	 * 计算当天是一年中的第多少天
	 */
	public static int dayToOneOne(int year, int month, int date) {
		//初始化
		int day = date;
		//闰年
		if (isLeapYear(year)) {
			switch (month-1) {
		case 11:			day += 30;
		case 10:		day += 31;
		case 9:			day += 30;
		case 8:			day += 31;
		case 7:			day += 31;
		case 6:			day += 30;
		case 5:			day += 31;
		case 4:			day += 30;
		case 3:			day += 31;
		case 2:			day += 29;
		case 1:			day += 31;
		default:
			break;
			}
		}else{
			//非闰年
			switch (month-1) {
			case 11:			day += 30;
			case 10:		day += 31;
			case 9:			day += 30;
			case 8:			day += 31;
			case 7:			day += 31;
			case 6:			day += 30;
			case 5:			day += 31;
			case 4:			day += 30;
			case 3:			day += 31;
			case 2:			day += 28;
			case 1:			day += 31;
			default:
				break;
				}
			}
		return day;
	}
	/**
	 * 计算得到和Java1.0发布日相差的天数
	 */
	public static int myDateFromJava1(int year, int month, int date){
		int yearJ = 1995;
		int monthJ = 5;
		int dateJ = 23;
		//调用myDateBetweenTwoDays得到和Java1.0发布日相差的天数
		return myDateBetweenTwoDays(year, month, date,yearJ, monthJ, dateJ);
	}
}
