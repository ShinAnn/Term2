package cn.edu.nju.software.lq;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MyConsole {
	/**
	 * 从控制台获得输入
	 */
	public String inputFromConsole(){
		String input = null;
		BufferedReader br1;
		//提示
		System.out.println("-----------------------------------------");
		System.out.println("请输入命令：");
		try {
			//获得输入
			br1 = new BufferedReader(new InputStreamReader(System.in));//,"UTF-8"
			input=br1.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return input;
	}
	/**
	 * 输出到控制台
	 */
	public void outputToConsole(String s){
		System.out.println(s);
	}

}
