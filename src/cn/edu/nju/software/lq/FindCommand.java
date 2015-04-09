package cn.edu.nju.software.lq;

public class FindCommand extends Command{
	@Override
	public void execute() {
		//创建课程表
		CourseSchedule courseSchedule = new CourseSchedule("CurriculumSchedule.txt");
		//获得新课程
		Course course = new Course(arguments.split("；")[0],arguments.split("；")[1]);
		courseSchedule.process(cmd, course);
	}
}
