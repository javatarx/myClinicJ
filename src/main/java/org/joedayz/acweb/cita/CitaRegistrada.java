package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaRegistrada implements EstadoCita {
	BNCita cita;

	public CitaRegistrada() {
	}

	public CitaRegistrada(BNCita cita) {
		this.cita = cita;
		this.cita.setStCita(1);
	}

	public BNCita getCita() {
		return cita;
	}

	public void setCita(BNCita cita) {
		this.cita = cita;
		this.cita.setStCita(1);
	}

	public String getEstado() {
		return "REGISTRADA";
	}

	public boolean puedeCancelar() {
		return false;
	}

	public boolean puedeActualizar() {
		return false;
	}

	public boolean puedeAtender() {
		return false;
	}

	public void eliminarCita() {
		// TODO Auto-generated method stub

	}

	public void actualizarCita() {
		// TODO Auto-generated method stub

	}

}
