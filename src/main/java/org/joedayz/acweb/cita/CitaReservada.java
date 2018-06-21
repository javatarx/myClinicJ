package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaReservada implements EstadoCita {
	BNCita cita;

	public CitaReservada(BNCita cita) {
		this.cita = cita;
	}

	public String getEstado() {
		return "RESERVADA";
	}

}
