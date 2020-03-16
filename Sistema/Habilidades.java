package Sistema;

import java.util.*;

public class Habilidades {
	private Persona p;
	private String habilidad;
	private int tiempo;
	
	public Habilidades(Persona p, String habilidad, int tiempo) {
		this.p = p;
		this.habilidad = habilidad;
		this.tiempo = tiempo;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	
	public void agregarTiempo(int tiempo) {
		this.tiempo += tiempo;
	}
	
	public void quitarTiempo(int tiempo) {
		if(this.tiempo == 0) {
			System.out.println("La persona "+p.getNombre()+" no cuenta con tiempo en la cuenta.");
			return;
		}
		if(this.tiempo < tiempo) {
			this.tiempo = 0;
		}
		this.tiempo -= tiempo;
	}
	
	public boolean tieneTiempo() {
		return !(tiempo == 0);
	}
	
	public boolean habilidadIgual(Habilidades h) {
		return habilidad.equals(h.habilidad);
	}
	
	public String toString() {
		return p + " "+ habilidad + " "+ tiempo+"hrs.";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((habilidad == null) ? 0 : habilidad.hashCode());
		result = prime * result + ((p == null) ? 0 : p.hashCode());
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
		Habilidades other = (Habilidades) obj;
		if (habilidad == null) {
			if (other.habilidad != null)
				return false;
		} else if (!habilidad.equals(other.habilidad))
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		return true;
	}

	
	
}
