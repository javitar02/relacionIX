package repasoAñoPasado;

public class ProfesorPrimaria extends Profesor{
	 EspecialidadesPrimaria especialidad;
	
	public ProfesorPrimaria(String nombre, String centroAdjudicado,String DNI,EspecialidadesPrimaria especialidad) throws ProfesoresException {
		super(nombre, centroAdjudicado, DNI);
	}
	
	public EspecialidadesPrimaria getEspecialidad() {
		return especialidad;
	}

	@Override
	public String toString() {
		return super.toString()+" profesor de primaria especializado en" + especialidad;
	}

	
	
}
