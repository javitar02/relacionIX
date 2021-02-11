package banco;
public class CuentaCredito extends Cuenta {
	
	//Atributos
	private int credito;
	
	//Constructor
	public CuentaCredito (double saldo, String titular, int credito) throws CuentaException {
		
		super(saldo,titular);
		
		if(credito <= 0) {
			throw new CuentaException("Credito incorrecto " + credito);	
		}
		this.credito = credito;
		
	}

	public int getCredito() {

		return credito;
	}

	@Override
	public String toString() {	 
		return "CuentaCredito " + super.getSaldo()+ " y Cliente " + getTitular() + ", tiene un credito " + credito;
	}
	public void realizarReintegro(double reintegro) throws CuentaException{
		double maxDineroASacar;
		maxDineroASacar=super.getSaldo()+credito;
		
		if(reintegro<=0) {
			throw new CuentaException("Error, reintegro incorrecto "+reintegro);
		}
		
		if(reintegro>maxDineroASacar) {
			throw new CuentaException("No puede sacar "+reintegro+", sobrepasas el credito");
		}
		
		saldo=saldo-reintegro;
		
		
	}
}

