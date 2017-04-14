import java.util.*;

public class Sim {
	public static void main(String[] args) {
		
		int grafoSize = 4000;
		
		GrafoDirigido grafo = new GrafoDirigido();
		
		for (int i = 0; i < grafoSize; i++) {
			grafo.addVertice();
		}

		System.out.println(grafo.getSize());
		for (int i = 0; i < grafoSize-2; i++) {
			grafo.addArco(i, i+2);
			grafo.addArco(i, i+1);
		}

		//System.out.println("DFS Recursivo: "+AlgoritmosSobreGrafo.DFSForestRecursivo(grafo));
		
		
		System.out.println("DFS Stack: "+AlgoritmosSobreGrafo.DFSForestStack(grafo));
		
		//******************Hacemos un ciclo***************************
		grafo.addArco(1, 0);
		
		//Volvemos a chequear
		
		System.out.println("DFS Recursivo: "+AlgoritmosSobreGrafo.DFSForestRecursivo(grafo));
		
		
		System.out.println("DFS Stack: "+AlgoritmosSobreGrafo.DFSForestStack(grafo));
		
	}
}
