public class Lista {
	Nodo primero;
	int cantidad = 0;

	public Lista () {
		primero = null;
	}

	/**
	 * Agrega un Nodo al principio de la lista
	 * @param n
	 */
	public void addNodo (int n) {
		Nodo tmp =  new Nodo(n);
		tmp.setSig(primero);
		primero = tmp;
		cantidad++;
	}

	/**
	 * Agrega un Nodo al final de la lista
	 * @param n
	 */
	public void addNodoEnd (int n) {
		Nodo nodoActual = primero;

		if(nodoActual == null) {
			primero = new Nodo(n);
		}
		else {
			while(nodoActual.getSig() != null) {
				nodoActual = nodoActual.getSig();
			}		
			nodoActual.setSig(new Nodo(n));	
		}
		cantidad++;	
	}

	/**
	 * Retorna el tamano de la lista vinculada	
	 * @return
	 */
	public int getSize() {
		return cantidad;
	}

	/**
	 * Cuando primero es igual a null la lista esta vacia
	 * @return
	 */
	public boolean isEmpty () {
		return primero == null;
	}

	@Override
	/**
	 * Recorre la lista vinculada y guarda en 's' cada valor de cada Nodo
	 */
	public String toString(){
		Nodo nodoActual = primero;
		String s = "";
		while (nodoActual != null) {
			s += nodoActual.getValor();
			s += " ";
			nodoActual = nodoActual.getSig();
		}
		return s;
	}

	/**
	 * Recorre la lista vinculada y retorna el valor de un Nodo en una determinada posicion
	 * @param pos
	 * @return
	 */
	public int getValueNodo(int pos){
		//Retorna -1 sino encuentra
		int resp = -1;  
		
		Nodo nodoActual = primero;
		while (nodoActual != null) {
			if (pos == 0) {
				resp = nodoActual.getValor();
				return resp;
			}
			nodoActual = nodoActual.getSig();
			pos --;
		}
		return resp;
	}

	/**
	 * Elimina un Nodo es una determianda pos de la lista vinculada
	 * @param pos
	 * @return
	 */
	public boolean delete(int pos){		
		
		//Cuando solo tiene un elemento
		if(pos == 0) {
			primero = primero.getSig();
			cantidad--;
		}		

		Nodo nodoActual = primero;
		
		while(nodoActual != null && pos > 0){
			if (pos == 1) {
				Nodo temp = nodoActual.getSig();
				nodoActual.setSig(temp.getSig());
				cantidad--;
				return true;
			}
			pos --;
			nodoActual = nodoActual.getSig();
		}	
		return false;
	}


	public boolean containsValue (int s) {
		Nodo nodoActual = primero;

		while(nodoActual != null) {
			if (nodoActual.getValor() == s) {
				return true;
			}
			else {
				nodoActual = nodoActual.getSig();
			}
		}

		return false;
	}

	//***************Private Class - Nodo********************************************************************************
	private class Nodo {
		private int valor;	
		private Nodo sig;

		public Nodo (int v) {
			valor = v;
		}


		/**
		 * Get valor
		 * @return
		 */
		public int getValor() {
			return valor;
		}

		/**
		 * Set valor
		 * @param v
		 */
		public void setValor (int v) {
			valor = v;
		}

		public void setSig(Nodo n) {
			sig = n;
		}

		public Nodo getSig() {
			return sig;
		}
	}

}