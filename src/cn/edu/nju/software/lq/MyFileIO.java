package cn.edu.nju.software.lq;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MyFileIO implements IFileIO{
	String fileName;
	
	public MyFileIO(String fileName){
		this.fileName = fileName;
	}
	
	public ArrayList<String> readFromFile(){

		ArrayList<String> list = new ArrayList<String>();
		
		try{
			//创建新文件
			File f = new File("CurriculumSchedule.txt");
			BufferedReader br1=new BufferedReader(new FileReader(f));
			String line;
			//向list中添加数据行
			while((line=br1.readLine())!=null){
				list.add(line);
			}
			br1.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		return list;
	}
	
	
	public void appendToFile(String output){

		try{			
			FileWriter writer = new FileWriter(fileName,true);
			writer.write(output);
			writer.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public void rewriteToFile(ArrayList<Course> courselist){
		
		try {
			FileWriter fWriter = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fWriter);
			for (Course course : courselist) {
				bw.write(course.toString()+"\n");
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
