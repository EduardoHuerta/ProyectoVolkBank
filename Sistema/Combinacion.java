package Sistema;

public class Combinacion {
	private Habilidades hVoluntario;
	private Habilidades hNecesitado;
	
	public Combinacion(Habilidades hVoluntario, Habilidades hNecesitado) {
		this.hVoluntario = hVoluntario;
		this.hNecesitado = hNecesitado;
	}
	
	public Habilidades getVoluntario() {
		return hVoluntario;
	}
	
	public Habilidades getNecesitado() {
		return hNecesitado;
	}
	
	public String toString() {
		return "Combinación "+hVoluntario+" con "+hNecesitado;
	}
}
