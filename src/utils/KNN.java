package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
	
	public double euclidianDistance(String[] currentReg, String[] target) {
		float total = 0;
		for(int i = 0;i < currentReg.length - 1; i++) {
			float value = Float.parseFloat(currentReg[i]) - Float.parseFloat(target[i]);
			total += Math.pow(value, 2);
		}
		
		return Math.sqrt(total);
	}
	
	public String classify(LinkedList<String[]> dataset, int k, String[] entrada) {
		if(dataset == null) return null;
		Map<Double, String[]> resultados = new HashMap<Double, String[]>();
		for(int i = 0; i<dataset.size(); i++) {
			String[] currentReg = dataset.get(i);
			resultados.put(this.euclidianDistance(currentReg, entrada),currentReg);
		}
		List<String[]> sortedResults = sortResultados(resultados);
		List<String[]> kResultados = new ArrayList<String[]>();
		
		for(int i =0; i<k; i++) {
			kResultados.add(sortedResults.get(i));
		}
		String classe = getClassFromResults(kResultados);
		return classe;
	}
	
	@SuppressWarnings("unchecked")
	public List<String[]> sortResultados(Map<Double, String[]> resultados){
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Set<Entry<Double, String[]>>> list = new LinkedList<Set<Entry<Double, String[]>>>((Collection<? extends Set<Entry<Double, String[]>>>) (resultados.entrySet()));
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2){  
				return ((Comparable) ((Map.Entry) (o1)).getKey()).compareTo(((Map.Entry) (o2)).getKey());  
			}
		});
		List<String[]> sortedHashMap = new ArrayList<String[]>();  
		for (Iterator<Set<Entry<Double, String[]>>> it = list.iterator(); it.hasNext();) {
			Map.Entry<Double, String[]> entry = (Entry<Double, String[]>) it.next();  
			sortedHashMap.add(entry.getValue()); 
		}
		return sortedHashMap;
	}
	
	public String getClassFromResults(List<String[]> results) {
		Map<String, Integer> classes = new HashMap<String, Integer>();
		Iterator<String[]> it = results.iterator();
		do {
			String[] linha = it.next();
			String classe = linha[linha.length - 1];
			int currentVal;
			try{
				currentVal = classes.get(classe);
			} catch(Exception e) {
				currentVal = 0;
			}
			classes.put(classe,  currentVal+1);
		}while(it.hasNext());
		int maior = 0;
		String maiorClasse = null;
		Iterator<Entry<String, Integer>> classesRankeadas = classes.entrySet().iterator(); 
		do {
			Entry<String, Integer> obj = classesRankeadas.next();
			if(maior< obj.getValue()) {
				maior = obj.getValue();
				maiorClasse = obj.getKey();
			}
		} while (classesRankeadas.hasNext());
		return maiorClasse;
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
