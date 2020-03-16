package Sistema;

public class SistemaVolBank {
	
	public static void main(String [] args) {
		Persona pm = new Persona("Manuel", "Culiacan", "6671456345", "80000");
		Persona pl = new Persona("Lalo", "Culiacan", "6672456315", "80140");
		Persona pj = new Persona("Juan", "Culiacan", "6675461326", "80000");
		
		OrganizacionVoluntarios ov = new OrganizacionVoluntarios();
		ov.agregarVoluntario(pm);
		ov.agregarHabilidad(pm, "Pintor");
		ov.depositarOfertaAyuda(pm, "Pintor", 3);
		ov.agregarVoluntario(pl);
		ov.agregarHabilidad(pl, "Decoración");
		ov.depositarOfertaAyuda(pl, "Decoración", 3);
		ov.agregarNecesitado(pj);
		ov.registrarPedidoAyuda(pj, "Pintor", 2);
		ov.combinaciones();
		System.out.println("Acabo!");
		
	}

}
