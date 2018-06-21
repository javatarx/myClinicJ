package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaCancelada implements EstadoCita {

	BNCita cita;

	public CitaCancelada(BNCita cita) {
		this.cita = cita;
		this.cita.setStCita('0');
	}

	public String getEstado() {
		return "CANCELADA";
	}

	public void eliminarCita(BNCita cita) {
		// TODO Auto-generated method stub
		
	}

	public void actualizarCita(BNCita cita) {
		// TODO Auto-generated method stub
		
	}

}
