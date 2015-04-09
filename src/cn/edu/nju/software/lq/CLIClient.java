package cn.edu.nju.software.lq;

public class CLIClient {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		run();
	}
	
	public static void run(){
		//创建控制器
		MyConsole console = new MyConsole();
		//循环执行命令
		while(true){
			//获得输入
			String input = console.inputFromConsole();
			//根据输入得到对应的命令类
			Command command = CommandFactory.newCommand(input);
			//命令执行
			command.execute();
		}
		
	}
}
