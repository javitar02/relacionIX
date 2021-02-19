package ej4;

public class Clerigo extends Personaje {

	private static final int FUERZA_MIN = 18;
	private static final int INTELIGENCIA_MIN = 12;
	private static final int INTELIGENCIA_MAX = 16;
	private static final int DAÑO_CURADO= 10;
	
	private String dios;
	
	public Clerigo(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMaxima) throws PersonajeException {
		super(nombre, raza, fuerza, inteligencia, vidaMaxima);
		
		if(fuerza<FUERZA_MIN) {
			throw new PersonajeException("Error, un Clerigo no puede tener menos de " +FUERZA_MIN+ " de fuerza");
		}
		
		if(inteligencia<=INTELIGENCIA_MIN||inteligencia>=INTELIGENCIA_MAX) {
			throw new PersonajeException("Error, un Clerigo no puede tener menos de " +INTELIGENCIA_MIN+ 
					" de inteligencia y mas de "+INTELIGENCIA_MAX+" de inteligencia");
		}
		setDios(dios);
	}

	public String getDios() {
		return dios;
	}

	public void setDios(String dios) {
		this.dios = dios;
	}
	
	public void curarAliado(Personaje otro) throws PersonajeException {
		
		otro.setVidaActual(DAÑO_CURADO);
		
	}

	@Override
	public String toString() {
		return super.toString()+" clerigo que reza al dios/diosa " + dios;
	}
	
	
}
