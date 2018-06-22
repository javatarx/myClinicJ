package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaEnAtencion implements EstadoCita {
	BNCita cita;

	public BNCita getCita() {
		return cita;
	}

	public void setCita(BNCita cita) {
		this.cita = cita;
		this.cita.setStCita(3);
	}

	public CitaEnAtencion() {
	}

	public CitaEnAtencion(BNCita cita) {
		this.cita = cita;
		this.cita.setStCita(3);
	}

	public String getEstado() {
		return "EN ATENCION";
	}

	public boolean puedeCancelar() {
		return false;
	}

	public boolean puedeActualizar() {
		return true;
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
