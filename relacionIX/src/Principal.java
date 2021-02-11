import banco.CuentaCredito;
import banco.CuentaException;

public class Principal {

	public static void main(String[] args) {
		try {
			CuentaCredito cc=new CuentaCredito(4000, "JAVI", 150);
			System.out.println(cc.getSaldo());
			System.out.println(cc);
			
		} catch (CuentaException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
