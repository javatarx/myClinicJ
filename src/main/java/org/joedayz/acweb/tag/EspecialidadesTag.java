package org.joedayz.acweb.tag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.joedayz.acweb.domain.BNEspecialidad;
import org.joedayz.acweb.service.EspecialidadService;

public class EspecialidadesTag extends TagSupport{
	private static final long serialVersionUID = 1L;

	private EspecialidadService servicio = new EspecialidadService();
	
	@Override
	public int doEndTag() throws JspException {
		
		try {
			JspWriter salida = pageContext.getOut();
			List<BNEspecialidad> especialidades = servicio.getListaEspecialidades();
			
			salida.print("<select id=\"idEspecialidad\" name=\"idEspecialidad\" >");
			for (BNEspecialidad especialidad : especialidades) {
				
					salida.print("<option value=");
					salida.print(especialidad.getCoEspecialidad());
					salida.print(">");
					salida.print(especialidad.getDeEspecialidad());
					salida.println("</option>");
			}
			salida.print("</select>");
			System.out.println("bien :)");
		} catch (Exception e) {
			System.out.println("EspecialidadesTag.doEndTag()");
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}
}
