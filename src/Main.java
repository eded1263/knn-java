

import java.io.IOException;
import java.util.LinkedList;

import utils.FileHandler;

public class Main {

	public static void main(String[] args) {
		try {
			LinkedList<String[]> dataset = FileHandler.read("C:\\Users\\edils\\eclipse-workspace\\KNN\\src\\dataset.txt");
			System.out.println(ar.size());
			for(int i = 0; i<ar.size(); i++) {
				for(String s : ar.get(i)) {
					System.out.print(s+",");
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}