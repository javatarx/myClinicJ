package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaEnAtencion implements EstadoCita {
	BNCita cita;

	public CitaEnAtencion(BNCita cita) {
		this.cita = cita;
		this.cita.setStCita('3');
	}

	public String getEstado() {
		return "EN ATENCION";
	}

	public void eliminarCita(BNCita cita) {
		// TODO Auto-generated method stub
		
	}

	public void actualizarCita(BNCita cita) {
		// TODO Auto-generated method stub
		
	}

}