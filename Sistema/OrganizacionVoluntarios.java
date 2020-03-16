package Sistema;

import java.util.*;

public class OrganizacionVoluntarios {
	
	private Voluntarios voluntarios;
	private Necesitados necesitados;
	private ArrayList<AsociacionVoluntarios> asociaciones;
	
	public OrganizacionVoluntarios() {
		voluntarios = new Voluntarios();
		necesitados = new Necesitados();
		asociaciones = new ArrayList<AsociacionVoluntarios>();
	}
	
	public void agregarVoluntario(Persona p) {
		voluntarios.registraVoluntario(p);
		for(AsociacionVoluntarios aux: asociaciones) {
			if(aux.esZona(p.getCodigoPostal())) {
				aux.agregarVoluntario(p);
				return;
			}
		}
		agregarAsociacion(p.getCodigoPostal()).agregarVoluntario(p);
	}
	
	public void agregarNecesitado(Persona p) {
		necesitados.registraNecesitado(p);
		for(AsociacionVoluntarios aux: asociaciones) {
			if(aux.esZona(p.getCodigoPostal())) {
				aux.agregarNecesitado(p);
				return;
			}
		}
		agregarAsociacion(p.getCodigoPostal()).agregarNecesitado(p);
	}
	
	private AsociacionVoluntarios agregarAsociacion(String codigoPostal) {
		System.out.println("Se creo una nueva asociación con el código postal: "+ codigoPostal);
		AsociacionVoluntarios a = new AsociacionVoluntarios(codigoPostal);
		asociaciones.add(a);
		return a;
	}
	
	public void registrarPedidoAyuda(Persona necesitado, String habilidad, int tiempo) {
		if(!necesitados.agregarDemanda(necesitado, habilidad, tiempo)) {
			System.out.println("Ocurrio un error al registrar la demanda");
			return;
		}
		for(AsociacionVoluntarios aux: asociaciones) {
			if(aux.esZona(necesitado.getCodigoPostal())) {
				aux.registraAyuda(necesitado, habilidad, tiempo);
				break;
			}
		}
		System.out.println("Se registro el pedido existosamente para la habilidad "+habilidad+" de "+necesitado.getNombre()+" por un tiempo de "+tiempo+"hr.");
	}
	
	public void agregarHabilidad(Persona voluntario, String habilidad) {
		if(!voluntarios.agregarHabilidad(voluntario, habilidad)) {
			System.out.println("Ocurrio un error al registrar la habilidad");
			return;
		}
		for(AsociacionVoluntarios aux: asociaciones) {
			if(aux.esZona(voluntario.getCodigoPostal())) {
				aux.agregarHabilidad(voluntario, habilidad);
				break;
			}
		}
		System.out.println("Se agrego una nueva habilidad para "+voluntario.getNombre());
	}
	
	public void depositarOfertaAyuda(Persona voluntario, String habilidad, int tiempo) {
		if(!voluntarios.agregarTiempo(voluntario, habilidad, tiempo)) {
			System.out.println("Ocurrio un error al registrar el tiempo");
			return;
		}
		for(AsociacionVoluntarios aux: asociaciones) {
			if(aux.esZona(voluntario.getCodigoPostal())) {
				aux.agregarTiempo(voluntario, habilidad, tiempo);
				break;
			}
		}
		System.out.println("Se agrego el tiempo a la hablidad "+habilidad+" para "+voluntario.getNombre());
	}
	
	public void combinaciones() {
		for(AsociacionVoluntarios aux: asociaciones) {
			System.out.println("*****************************************************");
			System.out.println("Asociación con código postal "+aux.getCodigoPostal());
			aux.realizarCombinaciones();
		}
	}
}
