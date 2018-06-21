package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaEnEspera implements EstadoCita {
	BNCita cita;

	public CitaEnEspera(BNCita cita) {
		this.cita = cita;
		this.cita.setStCita('2');
	}

	public String getEstado() {
		return "EN ESPERA";
	}

	public void eliminarCita(BNCita cita) {
		// TODO Auto-generated method stub
		
	}

	public void actualizarCita(BNCita cita) {
		// TODO Auto-generated method stub
		
	}

}
