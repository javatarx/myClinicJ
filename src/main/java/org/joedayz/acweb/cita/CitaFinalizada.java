package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public class CitaFinalizada implements EstadoCita {
	BNCita cita;

	public CitaFinalizada(BNCita cita) {
		this.cita = cita;
		this.cita.setStCita('4');
	}

	public String getEstado() {
		return "FINALIZADA";
	}

	public void eliminarCita(BNCita cita) {
		// TODO Auto-generated method stub
		
	}

	public void actualizarCita(BNCita cita) {
		// TODO Auto-generated method stub
		
	}

}
