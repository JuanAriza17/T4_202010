package model.data_structures;


public interface IArregloDinamico<T extends Comparable<T>>
{
	/**
	 * Retornar el numero de elementos maximo en el arreglo.
	 * @return Capacidad del arreglo.
	 */
	int darCapacidad( );

	/**
	 * Retornar el numero de elementos presentes en el arreglo.
	 * @return Tama�o del arreglo.
	 */
	int darTamano( );

	/**
	 * Retornar el elemento en la posicion i
	 * @param i posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 */
	T darElemento( int i );

	/**
	 * Agregar un dato de forma compacta (en la primera casilla disponible) 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param dato nuevo elemento
	 */
	public void agregar( T dato );

	/**
	 * Buscar un dato en el arreglo.
	 * @param dato Objeto de busqueda en el arreglo
	 * @return elemento encontrado en el arreglo (si existe). null si no se encontro el dato.
	 */
	T buscar(T dato);

	/**
	 * Eliminar un dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param dato Objeto de eliminacion en el arreglo
	 * @return dato eliminado
	 */
	T eliminar( T dato );

	/**
	 * Intercambia la posici�n entre dos elementos del arreglo.
	 * @param i Posici�n i.
	 * @param j Posici�n j.
	 */
	public void intercambiarPosiciones(int i, int j);
	
	/**
	 * M�todo que vuelve el �ltimo elemento del tama�o del arreglo m�s uno en null.
	 */
	public void ultimoNull();
}
