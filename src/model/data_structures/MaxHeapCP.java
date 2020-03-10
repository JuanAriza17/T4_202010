package model.data_structures;


public class MaxHeapCP<T extends Comparable<T>> implements IMaxHeapCP {

	/**
	 * Arreglo din�mico que maneja la cola de prioridad.
	 */
	public IArregloDinamico heap;

	/**
	 * N�mero de elementos presentes en la cola de prioridad.
	 */
	public int numPresentes; 

	/**
	 * M�todo constructor de la clase MaxHeapCP.
	 * @post:-Inicializa el arreglo din�mico que manejar� el heap.
	 * 		 -Inicializa en cero el n�mero de elementos presentes en el heap.
	 */
	public MaxHeapCP()
	{
		heap=new ArregloDinamico(550000);
		numPresentes=heap.darTamano();

	}

	/**
	 * M�todo que retorna el n�mero de elementos presentes en el heap de prioridad.
	 * @return N�mero de elementos presentes.
	 */
	public int darNumElementos()
	{
		return numPresentes;
	}

	/**
	 * M�todo que agrega un elemento en el heap de prioridad. Utiliza el comparador natural de la clase T.
	 * @param elemento Elemento que ser� agregado a la cola de prioridad.
	 */
	public void agregar(Comparable elemento)
	{
		heap.agregar(elemento);
		int posicionUltimo=heap.darTamano()-1;
		numPresentes++;
		swim(posicionUltimo);
		
	}


	/**
	 * Saca/atiende el elemento m�ximo en el heap y lo retorna.
	 * @return Elemento m�ximo de la cola. Si la cola est� vac�a retorna null.
	 */
	public T sacarMax()
	{
		T mayor = (T) heap.darElemento(1); 
		heap.intercambiarPosiciones(0, heap.darTamano()-1);; 
		heap.ultimoNull(); 
		sink(0); 
		--numPresentes;
		return mayor;
	}

	/**
	 * Obtiene el elemento m�ximo (sin sacarlo del heap).
	 * @return  Elemento m�ximo de la cola. Si la cola esta vac�a retorna null.
	 */
	public T darMax()
	{
		return (T) heap.darElemento(0);
	}

	/**
	 * Retorna si el heap est� vac�o o no.
	 * @return True en caso de que este vac�a. False en caso contrario.
	 */
	public boolean esVacia()
	{
		return numPresentes==0?true:false;
	}

	/**
	 * M�todo que env�a un elemento de la parte superior a la inferior del heap para preservar el orden.
	 */
	public void sink(int pPosicion) 
	{
		pPosicion++;
		while (2*pPosicion <= heap.darTamano()-1)
		{
			int j = 2*pPosicion;
			if (j < heap.darTamano()-1 && less(j, j+1)) j++;
			if (!less(pPosicion, j)) break;
			heap.intercambiarPosiciones(pPosicion, j);
			pPosicion = j;
		} 
	}

	/**
	 * M�todo que env�a un elemento de la parte inferior a la superior del heap para preservar el orden.
	 */
	public void swim(int pPosicion) 
	{
		while (pPosicion > 0 && less(pPosicion/2, pPosicion))
		{
			heap.intercambiarPosiciones(pPosicion/2, pPosicion);
			pPosicion = pPosicion/2;
		}
	}

	/**
	 * M�todo que retorna el arreglo din�mico que guarda el heap.
	 * @return Arreglo din�mico del Heap.
	 */
	public IArregloDinamico darArreglo() 
	{
		return heap;
	}

	/**
	 * M�todo que compara por una caracter�stica natural de la clase del elemento comparable.
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean less(int i, int j)
	{ 
		boolean comparador=false;
		if(heap.darElemento(j)!=null)
		{
			comparador= heap.darElemento(i).compareTo(heap.darElemento(j)) < 0; 
		}
		return comparador;
	}
	
	




}
