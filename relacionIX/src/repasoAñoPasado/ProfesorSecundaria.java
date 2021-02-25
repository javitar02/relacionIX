package repasoAñoPasado;

public class ProfesorSecundaria extends Profesor{
	EspecialidadesSecundaria especialidad;

	public ProfesorSecundaria(String nombre, String centroAdjudicado,String DNI,EspecialidadesSecundaria especialidad) throws ProfesoresException {
		super(nombre, centroAdjudicado,DNI);
	}
	
	public EspecialidadesSecundaria getEspecialidad() {
		return especialidad;
	}
	
	@Override
	public String toString() {
		return super.toString()+ " profesor de secundaria especializado en " + especialidad;
	}

}
