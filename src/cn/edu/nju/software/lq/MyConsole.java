package cn.edu.nju.software.lq;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MyConsole {
	/**
	 * �ӿ���̨�������
	 */
	public String inputFromConsole(){
		String input = null;
		BufferedReader br1;
		//��ʾ
		System.out.println("-----------------------------------------");
		System.out.println("���������");
		try {
			//�������
			br1 = new BufferedReader(new InputStreamReader(System.in));//,"UTF-8"
			input=br1.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return input;
	}
	/**
	 * ���������̨
	 */
	public void outputToConsole(String s){
		System.out.println(s);
	}

}
