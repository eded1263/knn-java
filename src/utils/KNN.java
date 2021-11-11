package utils;

import java.util.LinkedList;

public class KNN {
	private String[] atributos;
	private LinkedList<String[]> dataset;
	
	public KNN(LinkedList<String[]> file) {
		String[] atributos = file.get(0);
		LinkedList<String[]> dataset = file;
		dataset.removeFirst();
		this.dataset = dataset;
		this.atributos = atributos;
	}
	
	public void classify(String[] entrada) {
		
	}

	public String[] getAtributos() {
		return atributos;
	}

	public void setAtributos(String[] atributos) {
		this.atributos = atributos;
	}

	public LinkedList<String[]> getDataset() {
		return dataset;
	}

	public void setDataset(LinkedList<String[]> dataset) {
		this.dataset = dataset;
	}
}
