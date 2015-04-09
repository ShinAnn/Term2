package cn.edu.nju.software.lq;

import java.util.ArrayList;

public class CourseSchedule {
	
	ArrayList<Course> courseList = new ArrayList<Course>();
	IFileIO file;

	
	public CourseSchedule(String fileName){
		//����ļ�
		file = new MyFileIO(fileName);
		//��ӡ�ļ���
		System.out.println("File : "+file);
		//��õ����γ����ݵ�����
		ArrayList<String> list = file.readFromFile();
		//ѭ����γ̱�����ӿγ�
		for(String s:list)
			courseList.add(new Course(s));
	}

	
	/**
	 * �����ж���
	 * @param cmd ����
	 * @param course �γ�
	 */
	public void process(String cmd, Course course){
		 switch(cmd){
		 case "Add": add(course);break;
		 case "Remove": remove(course);break;
		 case "Update": update(course);break;
		 case "Find": find(course);break;
		 case "Show": show();break;
	 }
	}
	
	/**
	 * ��ӿγ̲���
	 */
	public void add(Course c){
		System.out.println("Adding...");
		boolean isOK = false;
		//�ж��Ƿ�ɼ�
		isOK = isOKtoAdd(c);
		//����ɼ����ڿγ̱�����ӿγ�
		if (isOK) {
			courseList.add(c);
			// ���ļ�����ӿγ�
			file.appendToFile(c.toString() + "\n");
			
			System.out.println("����ӵ��ļ���");
		}else
		System.out.println("��Ӧʱ�����пγ̣����ʧ��");
		
	}
	/**
	 * �ж��Ƿ�ɼ�
	 */
	public boolean isOKtoAdd(Course c){
		boolean isOK = true;
		
		for(Course course:courseList){
			String s1 = (course.day).toString();
			String s2 = (c.day).toString();
			if(s1.equals(s2)&&course.time.equals(c.time)){
				isOK = false;
				
				break;
			}
		}
		
		return isOK;
	}
	/**
	 * ɾ���γ̲���
	 */
	public void remove(Course delCourse){
		//Remove
		System.out.println("Removing...");
		
		for (int i=0;i<this.courseList.size();i++) {
			if(isCourseEquals(courseList.get(i),delCourse)){
				this.courseList.remove(i);
				file.rewriteToFile(this.courseList);
				System.out.println("�Ѵ��ļ�ɾ��");
				return;
			}
		}
		System.out.println("ɾ��ʧ��");
	}
	/**
	 * �ж��Ƿ�����Ӧ�γ�
	 */
	private boolean isCourseEquals(Course course, Course delCourse) {
		String s1 = (course.day).toString();
		String s2 = (delCourse.day).toString();
		//�ж����γ��Ƿ���ȫһ��
		if(				s1.equals(s2)&&
				course.time.equals(delCourse.time)&&
				course.name.equals(delCourse.name)&&
				course.location.equals(delCourse.location)){
			return true;
		}
		return false;
	}
	/**
	 * �ж��Ƿ�ɸ���
	 */
	private boolean isCourseEqualsInTime(Course course, Course delCourse) {
		String s1 = (course.day).toString();
		String s2 = (delCourse.day).toString();
		//�ж����γ��Ƿ���ȫһ��
		if(				s1.equals(s2)&&
				course.time.equals(delCourse.time)){
			return true;
		}
		return false;
	}
	/**
	 * ���¿γ�
	 * ����Ӧʱ���пγ̣����޸�
	 * ��û�У������
	 */
	public void update(Course course){
		//Update
		System.out.println("Update...");
		boolean isOK = false;
		//�ж��Ƿ�ɸ���
		isOK = isOKtoAdd(course);
		//����ɸ������ڿγ̱�����ӿγ�
		if (isOK) {
			courseList.add(course);
			// ���ļ��и��¿γ�
			file.appendToFile(course.toString() + "\n");
			System.out.println("�Ѹ����ļ�");
		}else{
			for (int i=0;i<this.courseList.size();i++) {
				if(isCourseEqualsInTime(courseList.get(i),course)){
					this.courseList.remove(i);
					file.rewriteToFile(this.courseList);
					break;
				}
			}
			this.add(course);
		}
	}
	public void find(Course c){
		//Find
		System.out.println("Finding...");
		
		for (int i=0;i<this.courseList.size();i++) {
			if(isCourseEqualsInTime(courseList.get(i),c)){
				Course course = courseList.get(i);
				System.out.println(course.name+"��"+course.location);
			}
		}
	}
	public void show(){
		//Show
		System.out.println("Showing...");
	}

}
