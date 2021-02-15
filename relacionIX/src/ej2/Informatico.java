package ej2;

public class Informatico extends Empleado{
	public static final int SUELDO_MAXIMO=3000;
	
	private tipoEspecialidad especialidad;
	
	public Informatico(String dni, String nombre, int sueldo,tipoEspecialidad especialidad) throws EmpleadoException {
		super(dni, nombre, sueldo);
		this.especialidad=especialidad;
		
		if(sueldo>SUELDO_MAXIMO){
			throw new EmpleadoException("Error, el sueldo no puede sobrepasar los 3000 euros "+sueldo);
		}
		super.setSueldo(sueldo);
	}

	public tipoEspecialidad getEspecialidad() {
		return especialidad;
	}

	
	@Override
	public String toString() {
		return super.toString()+" informatico cuya especialidad es " + especialidad;
	}

}
