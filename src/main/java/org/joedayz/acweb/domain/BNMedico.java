package org.joedayz.acweb.domain;

import java.io.Serializable;

public class BNMedico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long coMedico;
	private String deMedico;
	private char stMedico;
	private BNEspecialidad especialidad;
	
	public BNMedico() {
	}
	
	public BNMedico(Long coMedico, String deMedico, BNEspecialidad especialidad) {
		super();
		this.coMedico = coMedico;
		this.deMedico = deMedico;
		this.especialidad = especialidad;
	}
	public Long getCoMedico() {
		return coMedico;
	}
	public void setCoMedico(Long coMedico) {
		this.coMedico = coMedico;
	}
	public String getDeMedico() {
		return deMedico;
	}
	public void setDeMedico(String deMedico) {
		this.deMedico = deMedico;
	}
	public char getStMedico() {
		return stMedico;
	}
	public void setStMedico(char stMedico) {
		this.stMedico = stMedico;
	}
	public BNEspecialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(BNEspecialidad especialidad) {
		this.especialidad = especialidad;
	}

	
}
