package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class FileHandler {

	public static LinkedList<String[]> read(String fileName) {
		LinkedList<String[]> list = new LinkedList<String[]>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
		    String line = br.readLine();
	    	String[] data = line.split(",");
		    while (line != null) {
		        data = line.split(",");
		    	list.add(data);
		        line = br.readLine();
		    }
		    br.close();
		} catch(Exception e) {
			System.out.println("Arquivo não encontrado ou mal formatado");
			return null;
		}
		return list;
	}
}
