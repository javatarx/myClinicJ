package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaRegistrada implements EstadoCita {
	BNCita cita;

	public CitaRegistrada(BNCita cita) {
		this.cita = cita;
		this.cita.setStCita('1');
	}

	public String getEstado() {
		return "REGISTRADA";
	}

	public void eliminarCita(BNCita cita) {
		// TODO Auto-generated method stub

	}

	public void actualizarCita(BNCita cita) {
		// TODO Auto-generated method stub

	}

}
