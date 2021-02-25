package ej4;

import java.util.Arrays;

public class ListaPersonajes  {

	private Personaje listaPersonajes[];
	private int cantidadPersonajes;
	
	
	/**
	 * Se encarga de inicializar el array con la cantidad del array que se le pasa
	 * por parametro
	 * 
	 * @param capacidad de personajes que se pueden almacenar en el array
	 * @throws PersonajeException se lanzara si la capacidad es 0 o negativa
	 */
	public ListaPersonajes(int capacidad) throws PersonajeException {

		if (capacidad <= 0) {
			throw new PersonajeException("Error, la cantidad de la lista tiene que ser mayor que 0");
		}

		listaPersonajes = new Personaje[capacidad];
		cantidadPersonajes = 0;
	}

	/**
	 * Se encarga de annadir en el array el personaje pasado por parametro
	 * 
	 * @param personajeAnnadir Objeto personaje que se va annadir
	 * @throws PersonajeException Al comprobar que el personaje ya existe y tambien
	 *                            si no hay mas espacio en el array
	 */
	public void incorporarPersonaje(Personaje personajeIncorporado) throws PersonajeException {

		if (cantidadPersonajes == listaPersonajes.length) {
			throw new PersonajeException("Error, lista de personajes llena");
		}

		for (int i = 0; i <= cantidadPersonajes; i++) {
			if (listaPersonajes[i].getNombre().equals(personajeIncorporado.getNombre())) {
				throw new PersonajeException("Error, este personaje ya existe");
			}
		}

		listaPersonajes[cantidadPersonajes] = personajeIncorporado;

		cantidadPersonajes++;

	}

	/**
	 * Se encarga de añadir el hechizo al objeto personaje
	 * 
	 * @param nombreMago    String nombre del mago que aprende el hechizo
	 * @param nombreHechizo String nombre del hechizo que va a aprender el mago
	 * @throws PersonajeException En el metodo comprobarPersonajeExiste, cuando se
	 *                            comprueba que si el objeto de array es un mago
	 */
	public void aprenderHechizoMago(String nombreMago, String hechizo) throws PersonajeException {

		Personaje personaje;

		personaje = encontrarPersonaje(nombreMago);

		if (personaje == null) {
			throw new PersonajeException("No existe el mago " + nombreMago);
		}

		if (personaje instanceof Mago) {
//			Mago mago = (Mago)personaje;
//			mago.aprenderHechizo(hechizo);
			((Mago) personaje).aprenderHechizos(hechizo); // Es lo mismo que las dos lineas anteriores
		} else {
			throw new PersonajeException("El personaje no puede aprender el hechizo porque no es un mago");
		}

	}

	private Personaje encontrarPersonaje(String nombre) {

		Personaje personaje = null;
		boolean encontrado = false;

		for (int i = 0; i <= cantidadPersonajes && !encontrado; i++) {

			if (nombre.equals(listaPersonajes[i].getNombre())) {
				personaje = listaPersonajes[i];
				encontrado = true;
			}

		}

		return personaje;
	}

	/**
	 * Se encarga de buscar el nombre del mago, su hechizo y nombre del personaje
	 * 
	 * @param nombreMagoAtaca         String nombre del mago que ataca
	 * @param nombrePersonajeDefiende String nombre del personaje que es atacado
	 * @param nombreHechizo           String del hechizo del mago que ataca
	 * @throws PersonajeException Se utiliza en el metodo comprobarPersonajeExiste,
	 *                            si nombreMagoAtaca es un mago y que si
	 *                            nombreMagoAtaca esta en la misma posicion
	 *                            nombrePersonajeDefiende no se ataca asi mismo
	 *                            comprobando la posicion en el array
	 * @throws MuerteException
	 */
	public void lanzarHechizoPersonaje(String nombreMagoAtacante, String nombrePersonajeAtacado, String hechizo)
			throws PersonajeException {

		Personaje personajeAtacado = null;
		Personaje personajeAtacante = null;

		personajeAtacante = encontrarPersonaje(nombreMagoAtacante);
		personajeAtacado = encontrarPersonaje(nombrePersonajeAtacado);

		if (personajeAtacante == null || !(personajeAtacante instanceof Mago)) {
			throw new PersonajeException("No se ha encontrado ningun mago con el nombre" + nombreMagoAtacante);
		}

		if (personajeAtacado == null) {
			throw new PersonajeException("No se ha encontrado ningun mago con el nombre" + nombrePersonajeAtacado);
		}

		if (personajeAtacante.equals(personajeAtacado)) {
			throw new PersonajeException(
					"El personaje esta tan confuso que intento atacarse a si mismo, pero no se puede");
		}
		((Mago) personajeAtacante).lanzarHechizo(hechizo, personajeAtacado);

//			if (personajeAtacado.getVidaActual() == Personaje.VALOR_MINIMO) {
//			throw new PersonajeException("El personaje " + nombrePersonajeAtacado + " esta muerto");
//			}
	}

	/**
	 * Se encarga de buscar un clerigo y buscar un personaje, y el clerigo cura al
	 * personaje.
	 * 
	 * @param nombreClerigo   String que contiene el nombre del clerigo que va a
	 *                        curar
	 * @param nombrePersonaje String que contiene el nombre del personaje que se va
	 *                        a curar
	 * @throws PersonajeException En el metodo comprobarPersonajeExiste, si es un
	 *                            clerigo en la posClerigo del array y si la
	 *                            posClerigo y posPersonaje no son iguales para
	 *                            comprobar que no se cura asi mismo
	 */
	public void curarPersonaje(String nombreClerigo, String nombrePersonaje) throws PersonajeException {

		Personaje clerigo;
		Personaje personajeCurado = null;

		clerigo = encontrarPersonaje(nombreClerigo);
		personajeCurado = encontrarPersonaje(nombrePersonaje);

		if (clerigo == null || !(clerigo instanceof Clerigo)) {
			throw new PersonajeException("Error, no se ha encontrado un clerigo con nombre " + nombreClerigo);
		}

		if (personajeCurado == null) {
			throw new PersonajeException("Error, no se ha encontrado un personaje con nombre " + personajeCurado);
		}

		if (clerigo instanceof Clerigo) {
			((Clerigo) clerigo).curar(personajeCurado);
		}

	}

	/**
	 * Ordena el array de personajes por el numero de vida actual de mayor a menor y
	 * luego lo muesta en forma de String
	 * 
	 * @param numeroPersonajes
	 * @param listaPersonajes
	 * @return
	 * @return String del array ya ordenado
	 */
	public String mostrarListadoPuntosActuales() {
		int i;

		StringBuilder sb = new StringBuilder();
		Personaje[] arrayDeOrdenacion = new Personaje[cantidadPersonajes];

		for (i = 0; i < cantidadPersonajes; i++) {
			arrayDeOrdenacion[i] = listaPersonajes[i];
		}
		Arrays.sort(arrayDeOrdenacion);

		for (i = 0; i < cantidadPersonajes; i++) {
			sb.append((i + 1) + ". " + listaPersonajes[i] + "\n");

		}

		return sb.toString();
	}

	/**
	 * Almacena en un String todos los personajes almacenados en el array
	 * 
	 * @return String de todos los personajes creados
	 */
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cantidadPersonajes; i++) {
			sb.append((i + 1) + ". " + listaPersonajes[i] + "\n");

		}

		return sb.toString();
	}

	
}
