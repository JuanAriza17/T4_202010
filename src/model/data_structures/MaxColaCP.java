package model.data_structures;

import model.logic.Ordenamientos;

public class MaxColaCP<T extends Comparable<T>> implements IMaxColaCP {

	/**
	 * Arreglo din�mico que maneja la cola de prioridad.
	 */
	public IQueue cola;
	
	/**
	 * N�mero de elementos presentes en la cola de prioridad.
	 */
	public int numPresentes; 
	
	/**
	 * M�todo constructor de la clase MaxHeapCP.
	 * @post:-Inicializa el arreglo din�mico que manejar� la cola de prioridad.
	 * 		 -Inicializa en cero el n�mero de elementos presentes en la cola de prioridad.
	 */
	public MaxColaCP()
	{
		numPresentes=0;
		cola=new Queue();
	}
	/**
	 * M�todo que retorna el n�mero de elementos presentes en la cola de prioridad.
	 * @return N�mero de elementos presentes.
	 */
	public int darNumElementos()
	{
		return numPresentes;
	}

	/**
	 * M�todo que agrega un elemento a la cola de prioridad. Utiliza el comparador natural de la clase T.
	 * @param elemento Elemento que ser� agregado a la cola de prioridad.
	 */
	public void agregar(Comparable elemento)
	{
		cola.enqueue(elemento);
	}

	/**
	 * M�todo que ordena la cola de prioridad seg�n el comparador.
	 */
	public void ordenarCola()
	{
		Comparable[] a=cola.darElementos().darArreglo();
		Ordenamientos.mergeSort(a);
	}
	
	/**
	 * Saca/atiende el elemento m�ximo en la cola y lo retorna.
	 * @return Elemento m�ximo de la cola. Si la cola est� vac�a retorna null.
	 */
	public T sacarMax()
	{
		return (T) cola.dequeue();
	}
	
	/**
	 * Obtiene el elemento m�ximo (sin sacarlo de la cola).
	 * @return  Elemento m�ximo de la cola. Si la cola esta vac�a retorna null.
	 */
	public T darMax()
	{
		return (T) cola.peek();
	}
	
	/**
	 * Retorna si la cola est� vac�a o no.
	 * @return True en caso de que este vac�a. False en caso contrario.
	 */
	public boolean esVacia()
	{
		return cola.isEmpty();
	}
	
	/**
	 * Retorna la cola.
	 * @return cola.
	 */
	public Queue darListaCola()
	{
		ordenarCola();
		return (Queue) cola;
	}
}
