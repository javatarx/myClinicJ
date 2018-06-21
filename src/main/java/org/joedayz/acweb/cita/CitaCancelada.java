package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaCancelada implements EstadoCita {

	BNCita cita;

	public CitaCancelada(BNCita cita) {
		this.cita = cita;
	}

	public String getEstado() {
		return "CANCELADA";
	}

}
