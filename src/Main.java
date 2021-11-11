

import java.io.IOException;
import java.util.LinkedList;

import utils.FileHandler;

public class Main {

	public static void main(String[] args) {
		try {
			LinkedList<String[]> file = FileHandler.read("C:\\Users\\edils\\eclipse-workspace\\KNN\\src\\dataset.txt");
			String[] atributos = file.get(0);
			LinkedList<String[]> dataset = file;
			dataset.removeFirst();
			System.out.println(atributos);
			System.out.println(dataset.size());
			for(int i = 0; i<dataset.size(); i++) {
				for(String s : dataset.get(i)) {
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
