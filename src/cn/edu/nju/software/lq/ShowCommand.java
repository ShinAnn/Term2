package cn.edu.nju.software.lq;

public class ShowCommand extends Command{
	@Override
	public void execute() {
		//�����γ̱�
		CourseSchedule courseSchedule = new CourseSchedule("CurriculumSchedule.txt");
		Course course = new Course();
		courseSchedule.process(cmd, course);
	}
}
