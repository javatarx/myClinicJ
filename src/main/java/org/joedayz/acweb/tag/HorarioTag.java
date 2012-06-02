package org.joedayz.acweb.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.joedayz.acweb.service.HorarioService;

public class HorarioTag extends TagSupport{
	private static final long serialVersionUID = 1L;
	
	private String idMedico;
	private String fecha;
	private String horario;
	
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public int doEndTag() throws JspException {
		HorarioService horarioService = new HorarioService();
		List<String> horarios = new ArrayList<String>();
		
		if ("x".equalsIgnoreCase(getHorario())) {
			horarios = horarioService.getListaHorariosDisponibles(getFecha(),getIdMedico());
		} else{
			horarios = horarioService.getListaHorarios(getFecha());
		}
		
		JspWriter salida =  pageContext.getOut();
		
		try {
			salida.print("<select id=\"idHorario\" name=\"idHorario\" >");
			for (String hora : horarios) {
				salida.print("<option value='");
				salida.print(hora);
			if(getHorario().equalsIgnoreCase(hora)){
				salida.print("' selected='selected");
			}
				salida.print("' >");
				salida.print(hora);
				salida.println("</option>");
			}
			salida.print("</select>");
		} catch (IOException e) {
			System.out.println("HorarioTag.doEndTag()");
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}
	
}
