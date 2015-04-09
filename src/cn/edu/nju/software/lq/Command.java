package cn.edu.nju.software.lq;

public class Command {
	
	String cmd;
	String arguments;

	public void execute(){
		//创建课程表
		CourseSchedule courseSchedule = new CourseSchedule("CurriculumSchedule.txt");
		//获得新课程
		Course course = new Course(arguments);
		courseSchedule.process(cmd, course);
	}

	public void setCommandAndArguments(String cmd,String arguments) {
		this.cmd = cmd;
		this.arguments = arguments;
	}

}
