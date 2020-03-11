package model.data_structures;

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
		NodoLista<T> agregado= new NodoLista(elemento);
		NodoLista<T> actual=cola.darElementos().darPrimero();
		NodoLista<T> temporal=null;
		if(actual==null)
		{
			cola.darElementos().agregar(elemento);
			++numPresentes;
			return;
		}
		while(actual!=null)
		{
			if((actual!=null && actual.darSiguiente()!=null) && (elemento.compareTo(actual.darElemento())>0) && (elemento.compareTo(actual.darSiguiente().darElemento())<0) )
			{
				temporal=actual.darSiguiente();
				actual.cambiarSiguiente(agregado);
				agregado.cambiarAnterior(actual);
				agregado.cambiarSiguiente(temporal);
				temporal.cambiarAnterior(agregado);
				++numPresentes;
				return;
			}
			else if(actual.darSiguiente()==null)
			{
				cola.darElementos().agregarFinal(elemento);
				++numPresentes;
				return;
			}
		}
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
}
