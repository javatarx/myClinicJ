package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaFinalizada implements EstadoCita {
	BNCita cita;

	public CitaFinalizada(BNCita cita) {
		this.cita = cita;
	}

	public String getEstado() {
		return null;
	}

}
