package ej2;
public class Empleado {
		public static final int SUELDO_MINIMO=800;
		
		private String dni;
		private String nombre;
		protected int sueldo;
		
		
		public Empleado(String dni, String nombre, int sueldo) throws EmpleadoException {
			super();
			this.dni = dni;
			this.nombre = nombre;
			setSueldo(sueldo);
		}
		public void setSueldo(int sueldo) {
			if(sueldo<SUELDO_MINIMO) {
				System.out.println("Saldo incorrecto "+sueldo);
			}
			this.sueldo=sueldo;
		}
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getSueldo() {
			return sueldo;
		}
		
		
		@Override
		public String toString() {
			return "Empleado [dni=" + dni + ", nombre=" + nombre + ", sueldo=" + sueldo + "]";
		}
		
		
		
		
	

}
