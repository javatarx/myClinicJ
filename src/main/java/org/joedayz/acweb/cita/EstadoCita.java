package org.joedayz.acweb.cita;

public interface EstadoCita {
	public String getEstado();

	public void eliminarCita();

	public void actualizarCita();

	public boolean puedeCancelar();

	public boolean puedeActualizar();

	public boolean puedeAtender();
}
