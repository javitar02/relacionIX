package repasoAñoPasado;
public abstract class Profesor {

	private String nombre;
	private String centroAdjudicado;
	private String DNI;
	private int antiguedad;
	private enum curso{PRIMARIA,SECUNDARIA};
	
	public Profesor(String nombre, String centroAdjudicado,String DNI) throws ProfesoresException {
		this.nombre = nombre;
		
		setDNI(DNI);
		setCentroAdjudicado(centroAdjudicado);
	
	}
	

	public String getDNI() {
		return DNI;
	}
	
	public void setDNI(String dNI) throws ProfesoresException{
		if(dNI.length()>9) {
			throw new ProfesoresException("Error, el DNI no debe contener mas de 9 caracteres "+dNI);
		}
		this.DNI = dNI;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCentroAdjudicado() {
		return centroAdjudicado;
	}
	public void setCentroAdjudicado(String centroAdjudicado) throws ProfesoresException {
		if(!(this.centroAdjudicado.contains(centroAdjudicado))) {
			throw new ProfesoresException("Error, centro adjudicado incorrecto "+centroAdjudicado);
		}
		if(antiguedad<0) {
			throw new ProfesoresException("Error, la antiguedad no puede ser negativa "+antiguedad);
		}
			
		this.centroAdjudicado = centroAdjudicado;
		this.antiguedad=0;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	
	

	@Override
	public String toString() {
		return "Nombre=" + nombre + " centroAdjudicado=" + centroAdjudicado + ", antiguedad=" + antiguedad;
	}	
}
