package nju.java.job02;

import java.util.Calendar;
import java.util.Scanner;

public class DateCompute {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/**
		 * ���쵽Java1.0������
		 */
		Calendar myCalendar = Calendar.getInstance();
		//�����
		int myYear = myCalendar.get(Calendar.YEAR);
		//�����
		int myMonth = myCalendar.get(Calendar.MONTH)+1;
		//�����
		int myDate = myCalendar.get(Calendar.DATE);
		//��ӡ
		System.out.println("���г���ʱ�����ڵ�Java 1.0��������������Ϊ" + myDateFromJava1(myYear, myMonth, myDate) + "��");
		
		/**
		 * �Լ�����㷨
		 */
		System.out.println("����һ�����ڣ��� �� �գ�");
		//�����
		int year1 = input.nextInt();
		//�����
		int month1 = input.nextInt();
		//�����
		int date1 = input.nextInt();
		System.out.println("������һ�����ڣ��� �� �գ�");
		//�����
		int year2 = input.nextInt();
		//�����
		int month2 = input.nextInt();
		//�����
		int date2 = input.nextInt();
		// ����myDateBetweenTwoDays�õ�������������
		int myDay = myDateBetweenTwoDays(year1, month1, date1,year2, month2, date2);
		//��ӡ
		System.out.println( year1+"-"+month1+"-"+date1+"����"+year2+"-"+month2+"-"+date2+"Ϊ"+myDay+"��");
		
		/**
		 * ����Calendar�����
		 */
		// ����һ�������������ʱ�䣩
		Calendar calendar = Calendar.getInstance();
		// ����dateFromJava1�õ���Java1.0��������������
		int dayFromJava1 = dateFromJava1(calendar);
		// ��ӡ
		System.out.println("���г���ʱ�����ڵ�Java 1.0��������������Ϊ" + dayFromJava1 + "��");
		/**
		 * ����Calendar�����
		 */
		// ����һ������1
		Calendar calendar1 = Calendar.getInstance();
		// �趨����1��ʱ��
		System.out.println("����һ�����ڣ��� �� �գ�");
		calendar1.set(input.nextInt(), (input.nextInt() - 1), input.nextInt(),
				0, 0, 0);
		// ����һ������2
		Calendar calendar2 = Calendar.getInstance();
		// �趨����2��ʱ��
		System.out.println("������һ�����ڣ��� �� �գ�");
		calendar2.set(input.nextInt(), (input.nextInt() - 1), input.nextInt(),
				0, 0, 0);
		// ����dateBetweenTwoDays�õ�������������
		int dayBetweenTwoDay = dateBetweenTwoDays(calendar2, calendar1);
		// ��ӡ
		System.out.println("����1������2��������Ϊ" + dayBetweenTwoDay + "��");
		input.close();
	}

	/**
	 * ����õ���Java1.0��������������
	 * 
	 * @param calendar
	 *            ���г���ʱ������
	 * @return ���г���ʱ�����ڵ�Java 1.0��������������
	 */
	public static int dateFromJava1(Calendar calendar) {
		// ����һ������
		Calendar calendarJava1 = Calendar.getInstance();
		// �趨������ʱ��ΪJava 1.0����������
		calendarJava1.set(1995, (5 - 1), 23, 0, 0, 0);
		// ����Java 1.0���������ڵĺ�����
		long timeJava1InMillis = calendarJava1.getTimeInMillis();
		// �������г���ʱ�����ڵ�Java 1.0���������ĺ�����
		long timeBetweenTwoCalendarInMillis = calendar.getTimeInMillis()
				- timeJava1InMillis;
		// ��������ת��Ϊ������
		int dayBetweenTwoCalendar = (int) (timeBetweenTwoCalendarInMillis / (1000 * 60 * 60 * 24));
		// �������г���ʱ�����ڵ�Java 1.0��������������
		return dayBetweenTwoCalendar;
	}

	/**
	 * ��������1������2�������������Ϊ����
	 * 
	 * @param calendar1
	 *            ����1
	 * @param calendar2
	 *            ����2
	 * @return ����1������2�������������Ϊ����
	 */
	public static int dateBetweenTwoDays(Calendar calendar1, Calendar calendar2) {
		// ��������1�ĺ�����������2�ĺ������Ĳ�
		long timeBetweenTwoCalendarInMillis = calendar1.getTimeInMillis()
				- calendar2.getTimeInMillis();
		// ��������ת��Ϊ������
		int dayBetweenTwoCalendar = (int) (timeBetweenTwoCalendarInMillis / (1000 * 60 * 60 * 24));
		// �ж��������Ƿ�Ϊ�������򷵻أ�����ȡ������
		if (dayBetweenTwoCalendar < 0) {
			return -dayBetweenTwoCalendar;
		}
		return dayBetweenTwoCalendar;
	}

	/**
	 * �ж�ĳ���Ƿ�������
	 * 
	 * @param year
	 *            ���
	 * @return �Ƿ�����
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 != 0) {
			// ����4�������겻������
			return false;
		} else if (year % 400 != 0 && year % 100 == 0) {
			// ��100���������Ҳ���400�������겻������
			return false;
		} else
			// ����Ϊ����
			return true;
	}
	/**
	 * ������������������������Ϊ����
	 * @return �����������������Ϊ����
	 */
	public static int myDateBetweenTwoDays(int year1, int month1, int date1,	int year2, int month2, int date2) {
		//��֤year1<year2
		if (year1 > year2) {
			return myDateBetweenTwoDays(year2, month2, date2, year1, month1,	date1);
		}
		//����day2��һ���еĵڶ�����
		int day2 = dayToOneOne(year2, month2, date2);
		//����day1��һ���еĵڶ�����
		int day1 = dayToOneOne(year1, month1, date1);
		//��year1��year2ѭ��
		for (int i = year1; i < year2; i++) {
			if (isLeapYear(i)) {
				day2 += 366;
			} else
				day2 += 365;
		}
		//����
		int day = day2 - day1;
		return day;
	}
	/**
	 * ���㵱����һ���еĵڶ�����
	 */
	public static int dayToOneOne(int year, int month, int date) {
		//��ʼ��
		int day = date;
		//����
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
			//������
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
	 * ����õ���Java1.0��������������
	 */
	public static int myDateFromJava1(int year, int month, int date){
		int yearJ = 1995;
		int monthJ = 5;
		int dateJ = 23;
		//����myDateBetweenTwoDays�õ���Java1.0��������������
		return myDateBetweenTwoDays(year, month, date,yearJ, monthJ, dateJ);
	}
}
