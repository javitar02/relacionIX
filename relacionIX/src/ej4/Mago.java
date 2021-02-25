package ej4;

import java.util.Arrays;

public class Mago extends Personaje{

	private static final int LIMITE_HECHIZOS = 4;
	private static final int INTELIGENCIA_MIN = 17;
	private static final int FUERZA_MAX= 15;
	private static final int DAÑO_PROVOCADO= 10;
	
	private String []almacenHechizos;
	
	public Mago(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima) throws PersonajeException {
		super(nombre, raza, fuerza, inteligencia, vidaMaxima);
		
		if(inteligencia<INTELIGENCIA_MIN) {
			throw new PersonajeException("Error, un mago no puede tener menos de 17 de inteligencia");
		}
		
		if(fuerza>FUERZA_MAX) {
			throw new PersonajeException("Error, un mago no puede tener mas de 15 de fuerza");
		}
		
		almacenHechizos=new String[LIMITE_HECHIZOS];
	}
	
	public int aprenderHechizos(String hechizo) {
		int i;
		int numRealHechizos=0;
		
		for(i=0;i<almacenHechizos.length;i++) {
			if(almacenHechizos[i]==null) {
				hechizo=almacenHechizos[i];
				numRealHechizos++;
			}
		}
		return numRealHechizos;
	}
	
	public void lanzarHechizo(String hechizos,Personaje otro) throws PersonajeException {
		int i;
		int vida;
		
		for(i=0;i<almacenHechizos.length;i++) {
			if(almacenHechizos[i].equals(hechizos)) {
				almacenHechizos[i]=null;
			}
		}
		otro.setVidaActual(DAÑO_PROVOCADO);
	
	}
	
	public void mostrarHechizos() {
		int i;
		
		for(i=0;i<almacenHechizos.length;i++) {
			System.out.println(almacenHechizos[i]);
			}
		}
	

	@Override
	public String toString() {
		return super.toString() + " Mago cuya lista de hechizos es "+almacenHechizos;
	}
	
	
}
