package Sistema;

import java.util.*;

public class AsociacionVoluntarios {
	
	private String codigoPostal;
	private Voluntarios voluntarios;
	private Necesitados necesitados;
	private ArrayList<Combinacion> combinaciones;
	
	public AsociacionVoluntarios(String codigoPostal) {
		voluntarios = new Voluntarios();
		necesitados = new Necesitados();
		combinaciones = new ArrayList<Combinacion>();
		this.codigoPostal = codigoPostal;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	public boolean esZona(String codigoPostalPersona) {
		return codigoPostal.equals(codigoPostalPersona);
	}
	
	public void agregarVoluntario(Persona p) {
		voluntarios.registraVoluntario(p);
	}
	
	public void agregarNecesitado(Persona p) {
		necesitados.registraNecesitado(p);
	}
	
	public void registraAyuda(Persona necesitado, String habilidad, int tiempo) {
		necesitados.agregarDemanda(necesitado, habilidad, tiempo);
	}
	private Scanner scan = new Scanner(System.in);
	public void realizarCombinaciones() {
		System.out.println("¿Quiere hacer las combinaciones de la zona con código postal?(S/N)"+codigoPostal);
		String res = scan.next();
		if(!res.equals("S")) {
			System.out.println("No se generaron las combinaciones para la zona.");
			return;
		}
		ArrayList<Habilidades> hNecesitados = necesitados.getDemandas(), hVoluntarios = voluntarios.getHabilidades();
		for(Habilidades auxN: hNecesitados) {
			for(Habilidades auxV: hVoluntarios) {
				if(auxN.habilidadIgual(auxV) && auxV.tieneTiempo()) {
					combinaciones.add(new Combinacion(auxV, auxN));
				}
			}
		}
		System.out.println("Se crearon las combinaciones:");
		for(Combinacion c: combinaciones) {
			System.out.println(c);
		}
		for(Combinacion c: combinaciones) {
			System.out.println("El voluntario "+c.getVoluntario()+" acepta la demanda del necesitado "+c.getNecesitado()+" (S/N)");
			res = scan.next();
			if(!res.equals("S")) {
				System.out.println("No se acepto la demanda");
				continue;
			}
			System.out.println("El necesitado "+c.getNecesitado()+" acepta la ayuda del voluntario "+c.getNecesitado()+" (S/N)");
			res = scan.next();
			if(!res.equals("S")) {
				System.out.println("No se acepto la demanda");
				continue;
			}
			System.out.println("Se ha realizado la "+c+" correctamente");
			actualizarTiempos(c);
			System.out.println("Se actualizaron los tiempos del voluntario "+c.getVoluntario()+" y el necesitado "+c.getNecesitado()+" correctamente");
		}
	}
	
	private void actualizarTiempos(Combinacion c) {
		int tiempoN = c.getNecesitado().getTiempo(),tiempoV = c.getVoluntario().getTiempo();
		if(tiempoV < tiempoN) {
			c.getNecesitado().quitarTiempo(tiempoV);
			c.getVoluntario().quitarTiempo(tiempoN);
		}else {
			c.getNecesitado().quitarTiempo(tiempoN);
			c.getVoluntario().quitarTiempo(tiempoN);
		}
	}

	public void agregarHabilidad(Persona voluntario, String habilidad) {
		voluntarios.agregarHabilidad(voluntario, habilidad);
	}

	public void agregarTiempo(Persona voluntario, String habilidad, int tiempo) {
		voluntarios.agregarTiempo(voluntario, habilidad, tiempo);
	}
}
