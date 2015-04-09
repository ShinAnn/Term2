package cn.edu.nju.software.lq;

public class CLIClient {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		run();
	}
	
	public static void run(){
		//����������
		MyConsole console = new MyConsole();
		//ѭ��ִ������
		while(true){
			//�������
			String input = console.inputFromConsole();
			//��������õ���Ӧ��������
			Command command = CommandFactory.newCommand(input);
			//����ִ��
			command.execute();
		}
		
	}
}
