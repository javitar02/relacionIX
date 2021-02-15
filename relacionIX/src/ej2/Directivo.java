package ej2;

public class Directivo extends Empleado {
	public static final int SUELDO_MAXIMO=3500;
	
	private String nombreDep;
	
	public Directivo(String dni, String nombre, int sueldo,String nombreDep) throws EmpleadoException {
		super(dni, nombre, sueldo);
		setSueldo(sueldo);
		
		
	}

	public String getNombreDep() {
		return nombreDep;
	}
	public void setSueldo(int sueldo) throws EmpleadoException {
		if (sueldo < SUELDO_MINIMO)
			throw new EmpleadoException(" Sueldo incorrecto");
		super.s
	}
	
	@Override
	public String toString() {
		return super.toString()+" directivo que dirige el departamento de " + nombreDep;
	}

}
