package org.joedayz.acweb.cita;

public class FactoryEstadoCita {

	public static final int CANCELADO = 0;
	public static final int REGISTRADO = 1;
	public static final int EN_ESPERA = 2;
	public static final int EN_ATENCION = 3;
	public static final int FINALIZADA = 4;

	public static EstadoCita getEstadoCita(int estado) {

		switch (estado) {
		case CANCELADO:
			return new CitaCancelada();
		case REGISTRADO:
			return new CitaRegistrada();
		case EN_ESPERA:
			return new CitaEnEspera();
		case EN_ATENCION:
			return new CitaEnAtencion();
		case FINALIZADA:
			return new CitaFinalizada();

		default:
			return new CitaRegistrada();
		}
	}
}
