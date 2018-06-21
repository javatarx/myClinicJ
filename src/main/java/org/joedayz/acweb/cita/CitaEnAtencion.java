package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaEnAtencion implements EstadoCita {
	BNCita cita;

	public CitaEnAtencion(BNCita cita) {
		this.cita = cita;
	}

	public String getEstado() {
		return null;
	}

}
