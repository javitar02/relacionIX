package ej2;

public class Operario extends Empleado{
	public static final int SUELDO_MAXIMO=1200;

	private int numNave;
	
	public Operario(String dni, String nombre, int sueldo,int numNave) throws EmpleadoException {
		super(dni, nombre, sueldo);
		setSaldo(sueldo);
		setNumNave(numNave);
		
		
		
	}

	private void setNumNave(int numNave) throws EmpleadoException {
		if(numNave<1||numNave>5) {
			throw new EmpleadoException("Error, la naves solo van del 1 al 5 "+numNave);
		}
		this.numNave=numNave;
	}

	private void setSaldo(int sueldo) throws EmpleadoException {
		if(sueldo>SUELDO_MAXIMO){
			throw new EmpleadoException("Error, el sueldo no puede sobrepasar los 1200 euros "+sueldo);
		}
		this.sueldo=sueldo;
	}

	@Override
	public String toString() {
		return super.toString()+" operario que trabaja en la nave " + numNave;
	}

	public int getNumNave() {
		return numNave;
	}

	

}