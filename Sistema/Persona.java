package Sistema;

public class Persona {
	private String codigoPostal, direccion, nombre, telefono;
	
	public Persona(String nombre, String direccion, String telefono, String codigoPostal) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.codigoPostal = codigoPostal;
	}
	
	public boolean zonasIguales(Persona p) {
		return codigoPostal.equals(p.codigoPostal);
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}
	
	public String toString() {
		return nombre + " " + direccion + " " + telefono + " " + codigoPostal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoPostal == null) ? 0 : codigoPostal.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (codigoPostal == null) {
			if (other.codigoPostal != null)
				return false;
		} else if (!codigoPostal.equals(other.codigoPostal))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	
	
	
}
