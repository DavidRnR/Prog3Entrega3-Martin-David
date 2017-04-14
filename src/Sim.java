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
		grafo.addArco(400, 401);
		grafo.addArco(401, 400);
		
		//Volvemos a chequear
		
		System.out.println("DFS Recursivo: "+AlgoritmosSobreGrafo.DFSForestRecursivo(grafo));
		
		
		System.out.println("DFS Stack: "+AlgoritmosSobreGrafo.DFSForestStack(grafo));
		
		// DFS: Recursivo ocupa mucho más memoria (Se colgó la computadora con una cantidad de Vertices significativa, con el grafo sin ciclo)
		// DFS: ultilanzando una pila no se cuelga, parece mucho mas efectivo.
		
	}
}
