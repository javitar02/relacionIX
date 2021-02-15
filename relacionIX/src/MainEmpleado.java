import java.util.Arrays;
import java.util.Scanner;

import ej2.EmpleadoException;
import ej2.Informatico;
import ej2.Operario;
import ej2.tipoEspecialidad;

public class MainEmpleado {
	private static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
	
		System.out.println("Introduce la especialidad "+Arrays.toString(tipoEspecialidad.values()));
		String especialidad=teclado.nextLine();

	try {
		Operario op1=new Operario("423423434D", "JAVI", 1200, 4);
		
	} catch (EmpleadoException e) {
		System.out.println(e.getMessage());;
	}
		
		
		
		
		
		

	}

}
