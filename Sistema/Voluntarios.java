package Sistema;

import java.util.*;

public class Voluntarios{
	
	private ArrayList<Persona> voluntarios;
	private ArrayList<Habilidades> habilidades;
	
	public Voluntarios() {
		voluntarios = new ArrayList<Persona>();
		habilidades = new ArrayList<Habilidades>();
	}
	
	public ArrayList<Habilidades> getHabilidades(){
		return habilidades;
	}
	
	public void registraVoluntario(Persona p) {
		if(voluntarios.contains(p)) {
			System.out.println("Voluntario actualmente registrado");
			return;
		}
		voluntarios.add(p);
	}
	
	public boolean agregarHabilidad(Persona p, String habilidad) {
		if(!voluntarios.contains(p)) {
			System.out.println("Voluntario no registrado.");
			return false;
		}
		habilidades.add(new Habilidades(p, habilidad, 0));
		return true;
	}
	
	public boolean agregarTiempo(Persona p, String habilidad, int tiempo) {
		Habilidades nueva = new Habilidades(p, habilidad, tiempo);
		if(!habilidades.contains(nueva)) {
			System.out.println("Habilidad no registrada");
			return false;
		}
		for(Habilidades aux: habilidades) {
			if(aux.equals(nueva)) {
				aux.agregarTiempo(tiempo);
				break;
			}
		}
		return true;
	}
}
