package main;


import java.util.LinkedList;
import java.util.Scanner;

import utils.FileHandler;
import utils.KNN;

public class Main {

	public static void main(String[] args) {
		LinkedList<String[]> file = FileHandler.read("C:\\Users\\edils\\eclipse-workspace\\KNN\\src\\dataset.txt");
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
		knn.classify(dados);
	}

}
