package Sistema;

import java.util.*;

public class Necesitados {
	
	private ArrayList<Persona> necesitados;
	private ArrayList<Habilidades> demandas;

	public Necesitados() {
		necesitados = new ArrayList<Persona>();
		demandas = new ArrayList<Habilidades>();
	}
	
	public ArrayList<Habilidades> getDemandas(){
		return demandas;
	}
	
	public void registraNecesitado(Persona p) {
		if(contiene(p)) {
			System.out.println("Usuario ya registrado.");
			return;
		}
		necesitados.add(p);
	}
	
	public boolean agregarDemanda(Persona p, String habilidad, int tiempo) {
		if(!contiene(p)) {
			System.out.println("Usuario no registrado");
			return false;
		}
		Habilidades demanda = new Habilidades(p, habilidad, tiempo);
		if(demandas.contains(demanda)) {
			System.out.println("Demanda registrada, se le agregará el tiempo");
			for(Habilidades aux: demandas) {
				if(aux.equals(demanda)) {
					aux.agregarTiempo(tiempo);
				}
			}
			return true;
		}
		demandas.add(demanda);
		return true;
	}
	
	private boolean contiene(Persona p) {
		return necesitados.contains(p);
	}
	
}
