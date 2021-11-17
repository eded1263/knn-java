package main;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

import utils.FileHandler;
import utils.KNN;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get(System.getProperty("user.dir")); 
		LinkedList<String[]> file = FileHandler.read(path.resolve("src/iris.data").toString());
		KNN knn = new KNN(file);
		Scanner leitor = new Scanner(System.in);
		String[] dados = null;
		System.out.println("--------------KNN--------------");
		while(dados == null) {
			int dadosEsperados = knn.getDataset().get(0).length - 1;
			System.out.println("Digite " + dadosEsperados + " registros, separados por virgula: ");
			String entrada = leitor.nextLine();
			String[] entradaList = entrada.split(",");
			if(entradaList.length != dadosEsperados) {
				System.out.println("Quantia de dados inválida, digite novamente");
			}else {
				try {
					for(String parametro : entradaList) {
						Float.parseFloat(parametro);
					}
					dados = entradaList;
				} catch(Exception e) {
					System.out.println("Dados inválidos, digite novamente");
				}
			}
		}
		leitor.close();
		System.out.println("Classe recomendada: " + knn.classify(knn.getDataset(), 5, dados));
	}

}
