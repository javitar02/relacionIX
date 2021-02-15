package ej3;

public abstract class Vehiculo {
	
	public static final int PRECIO_GAMA_BAJA = 30;
	public static final int PRECIO_GAMA_MEDIA = 40;
	public static final int PRECIO_GAMA_ALTA = 50;

	private String matricula;
	private TipoGama gama;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public TipoGama getGama() {
		return gama;
	}

	public void setGama(TipoGama gama) {
		this.gama = gama;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", gama=" + gama + "]";
	}

	public double calcularPrecioAlquiler(int dias) {
		double alquiler = PRECIO_GAMA_BAJA;

		return alquiler;
	}
}
