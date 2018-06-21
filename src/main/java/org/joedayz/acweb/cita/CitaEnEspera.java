package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaEnEspera implements EstadoCita {
	BNCita cita;

	public CitaEnEspera(BNCita cita) {
		this.cita = cita;
	}

	public String getEstado() {
		return null;
	}

}
