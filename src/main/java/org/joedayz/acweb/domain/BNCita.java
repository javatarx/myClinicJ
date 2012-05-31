package org.joedayz.acweb.domain;

import java.io.Serializable;
import java.util.Date;

public class BNCita implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long coCita;
	private BNMedico medico;
	private BNUsuario usuario;
	private BNEspecialidad especialidad;
	private Date fecha;
	private String horario;
	private String comentario;
	private char stCita;
	
	public Long getCoCita() {
		return coCita;
	}
	public void setCoCita(Long coCita) {
		this.coCita = coCita;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public char getStCita() {
		return stCita;
	}
	public void setStCita(char stCita) {
		this.stCita = stCita;
	}
	public BNMedico getMedico() {
		return medico;
	}
	public void setMedico(BNMedico medico) {
		this.medico = medico;
	}
	public BNUsuario getUsuario() {
		return usuario;
	}
	public void setUsuario(BNUsuario usuario) {
		this.usuario = usuario;
	}
	public BNEspecialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(BNEspecialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	
}
