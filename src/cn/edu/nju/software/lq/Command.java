package cn.edu.nju.software.lq;

public class Command {
	
	String cmd;
	String arguments;

	public void execute(){
		//�����γ̱�
		CourseSchedule courseSchedule = new CourseSchedule("CurriculumSchedule.txt");
		//����¿γ�
		Course course = new Course(arguments);
		courseSchedule.process(cmd, course);
	}

	public void setCommandAndArguments(String cmd,String arguments) {
		this.cmd = cmd;
		this.arguments = arguments;
	}

}
