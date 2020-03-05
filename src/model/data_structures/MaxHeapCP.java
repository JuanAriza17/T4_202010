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
	
	public MaxHeapCP()
	{
		numPresentes=0;
		heap=new ArregloDinamico(100);
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
		
	}

	
	/**
	 * Saca/atiende el elemento m�ximo en la cola y lo retorna.
	 * @return Elemento m�ximo de la cola. Si la cola est� vac�a retorna null.
	 */
	public T sacarMax()
	{
		return null;
	}
	
	/**
	 * Obtiene el elemento m�ximo (sin sacarlo de la cola).
	 * @return  Elemento m�ximo de la cola. Si la cola esta vac�a retorna null.
	 */
	public T darMax()
	{
		return null;
	}
	
	/**
	 * Retorna si la cola est� vac�a o no.
	 * @return True en caso de que este vac�a. False en caso contrario.
	 */
	public boolean esVacia()
	{
		return false;
	}
}
