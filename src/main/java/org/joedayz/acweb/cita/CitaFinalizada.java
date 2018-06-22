package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaFinalizada implements EstadoCita {
	BNCita cita;

	public CitaFinalizada(BNCita cita) {
		this.cita = cita;
		this.cita.setStCita('4');
	}

	public String getEstado() {
		return "FINALIZADA";
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
