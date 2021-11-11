package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FileHandler {

	public static LinkedList<String[]> read(String fileName) throws IOException{
		LinkedList<String[]> list = new LinkedList<String[]>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
		    String line = br.readLine();
	    	String[] data = line.split(",");
		    while (line != null) {
		        data = line.split(",");
		    	list.add(data);
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}
		return list;
	}
}
