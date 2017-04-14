//******** DEPH-FIRST SEACH ************************
import java.util.*;

public class AlgoritmosSobreGrafo {

	private enum Estado { VISITADO, NO_VISITADO, VISITANDOSE };



	public static boolean DFSForestRecursivo (GrafoDirigido grafo) {

		Estado [] estados;

		estados = new Estado[grafo.getSize()];

		for (int i = 0; i < estados.length; i++) {
			estados[i] = Estado.NO_VISITADO;
		}

		for (int i = 0; i < grafo.getSize(); i++) {
			if (tieneCicloRecursivo(grafo, grafo.getVertice(i), estados))
				return true;	
		}

		return false;

	}


	private static boolean tieneCicloRecursivo (GrafoDirigido grafo, int vertice, Estado[] estados) {

		if( estados[vertice] == Estado.VISITANDOSE) {
			return true;
		}

		estados[vertice] = Estado.VISITANDOSE;

		List<Integer> adyacentes = grafo.getAdyacentes(vertice);

		for (int i = 0; i < adyacentes.size(); i++) {
			if (tieneCicloRecursivo(grafo,adyacentes.get(i),estados)) {
				return true;
			}
		}

		estados[vertice] = Estado.VISITADO;

		return false;
	}

	public static boolean DFSForestStack (GrafoDirigido grafo) {

		Estado [] estados;

		estados = new Estado[grafo.getSize()];

		for (int i = 0; i < estados.length; i++) {
			estados[i] = Estado.NO_VISITADO;
		}

		return tieneCicloPila(grafo, estados);

	}

	private static boolean tieneCicloPila(GrafoDirigido grafo, Estado[] estados) {

		Stack<Integer> pila = new Stack<Integer>();
		int vertice = grafo.getVertice(0);

		while(vertice < estados.length){//este while es por si hay un vertice sin estar en el grafo que tiene ciclo
			pila.push(vertice);

			while(!pila.isEmpty()) {

				if(estados[pila.peek()] == Estado.NO_VISITADO) {
					estados[pila.peek()] = Estado.VISITANDOSE;

					List<Integer> adyacentes = grafo.getAdyacentes(pila.peek());
					
					if(adyacentes.size() > 0 ) {		
						
						
						for (int i = 0; i < adyacentes.size(); i++) {
							if(estados[adyacentes.get(i)] == Estado.NO_VISITADO){
								pila.push(adyacentes.get(i));
							}else if(estados[adyacentes.get(i)] == Estado.VISITANDOSE){
								return true;
							}

						}

					}
					else{//no tiene adyacentes
						estados[pila.peek()] = Estado.VISITADO;
						pila.pop();
					}
				}

				else if(estados[pila.peek()] == Estado.VISITADO){//negro
					pila.pop();
				}
				else{
					estados[pila.peek()] = Estado.VISITADO ;//amarillo
					pila.pop();
				}


			}
			vertice++;
		}

		return false;
	}

}
