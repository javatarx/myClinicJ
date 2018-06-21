package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaDisponible implements EstadoCita {
	BNCita cita;

	public CitaDisponible(BNCita cita) {
		this.cita = cita;
	}

	public String getEstado() {
		return "DISPONIBLE";
	}

}
