package cn.edu.nju.software.lq;

import java.util.ArrayList;

public class CourseSchedule {
	
	ArrayList<Course> courseList = new ArrayList<Course>();
	IFileIO file;

	
	public CourseSchedule(String fileName){
		//获得文件
		file = new MyFileIO(fileName);
		//打印文件名
		System.out.println("File : "+file);
		//获得单条课程数据的数组
		ArrayList<String> list = file.readFromFile();
		//循环向课程表中添加课程
		for(String s:list)
			courseList.add(new Course(s));
	}

	
	/**
	 * 命令判断器
	 * @param cmd 命令
	 * @param course 课程
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
	 * 添加课程操作
	 */
	public void add(Course c){
		System.out.println("Adding...");
		boolean isOK = false;
		//判断是否可加
		isOK = isOKtoAdd(c);
		//如果可加则在课程表中添加课程
		if (isOK) {
			courseList.add(c);
			// 在文件中添加课程
			file.appendToFile(c.toString() + "\n");
			
			System.out.println("已添加到文件中");
		}else
		System.out.println("对应时间已有课程，添加失败");
		
	}
	/**
	 * 判断是否可加
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
	 * 删除课程操作
	 */
	public void remove(Course delCourse){
		//Remove
		System.out.println("Removing...");
		
		for (int i=0;i<this.courseList.size();i++) {
			if(isCourseEquals(courseList.get(i),delCourse)){
				this.courseList.remove(i);
				file.rewriteToFile(this.courseList);
				System.out.println("已从文件删除");
				return;
			}
		}
		System.out.println("删除失败");
	}
	/**
	 * 判断是否有相应课程
	 */
	private boolean isCourseEquals(Course course, Course delCourse) {
		String s1 = (course.day).toString();
		String s2 = (delCourse.day).toString();
		//判断两课程是否完全一样
		if(				s1.equals(s2)&&
				course.time.equals(delCourse.time)&&
				course.name.equals(delCourse.name)&&
				course.location.equals(delCourse.location)){
			return true;
		}
		return false;
	}
	/**
	 * 判断是否可更新
	 */
	private boolean isCourseEqualsInTime(Course course, Course delCourse) {
		String s1 = (course.day).toString();
		String s2 = (delCourse.day).toString();
		//判断两课程是否完全一样
		if(				s1.equals(s2)&&
				course.time.equals(delCourse.time)){
			return true;
		}
		return false;
	}
	/**
	 * 更新课程
	 * 若相应时间有课程，则修改
	 * 若没有，则添加
	 */
	public void update(Course course){
		//Update
		System.out.println("Update...");
		boolean isOK = false;
		//判断是否可更新
		isOK = isOKtoAdd(course);
		//如果可更新则在课程表中添加课程
		if (isOK) {
			courseList.add(course);
			// 在文件中更新课程
			file.appendToFile(course.toString() + "\n");
			System.out.println("已更新文件");
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
				System.out.println(course.name+"；"+course.location);
			}
		}
	}
	public void show(){
		//Show
		System.out.println("Showing...");
	}

}
