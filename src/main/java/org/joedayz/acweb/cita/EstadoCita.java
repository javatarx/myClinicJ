package org.joedayz.acweb.cita;

import org.joedayz.acweb.domain.BNCita;

public interface EstadoCita {
	public String getEstado();
	public void eliminarCita(BNCita cita);
	public void actualizarCita(BNCita cita);
}
