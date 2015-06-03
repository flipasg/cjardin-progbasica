package informacion;

public class ResultadoMatricula {
	private boolean exito;
	private String motivo;

	public ResultadoMatricula(boolean exito, String motivo) {
		this.exito = exito;
		this.motivo = motivo;
	}
	
	
	@Override
	public String toString() {
		return motivo;
	}


	public boolean isExito() {
		return exito;
	}

}
