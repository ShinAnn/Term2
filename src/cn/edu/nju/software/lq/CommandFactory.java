package cn.edu.nju.software.lq;

public class CommandFactory {

	public static Command newCommand(String s) {
		
		try {
			Command command = null;

			String[] split = s.split(" ");
			String cmdString = "cn.edu.nju.software.lq."+split[0] + "Command";
			@SuppressWarnings("rawtypes")
			Class c = Class.forName(cmdString);
			command = (Command) c.newInstance();
			command.setCommandAndArguments(split[0],split[1]);
			return command;
		} catch (Exception e) {
			System.out.println("����ȷ��ָ�����������");
			return null;
		}
	}
}
