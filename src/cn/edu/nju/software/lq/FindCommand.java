package cn.edu.nju.software.lq;

public class FindCommand extends Command{
	@Override
	public void execute() {
		//�����γ̱�
		CourseSchedule courseSchedule = new CourseSchedule("CurriculumSchedule.txt");
		//����¿γ�
		Course course = new Course(arguments.split("��")[0],arguments.split("��")[1]);
		courseSchedule.process(cmd, course);
	}
}
