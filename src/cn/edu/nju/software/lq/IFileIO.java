package cn.edu.nju.software.lq;

import java.util.ArrayList;

public interface IFileIO {
	public ArrayList<String> readFromFile();
	public void appendToFile(String output);
	public void rewriteToFile(ArrayList<Course> courselist);
}
