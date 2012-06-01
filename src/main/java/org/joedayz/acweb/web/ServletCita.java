package org.joedayz.acweb.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joedayz.acweb.domain.BNCita;
import org.joedayz.acweb.domain.BNEspecialidad;
import org.joedayz.acweb.domain.BNMedico;
import org.joedayz.acweb.domain.BNUsuario;
import org.joedayz.acweb.service.CitaService;
import org.joedayz.acweb.service.EspecialidadService;
import org.joedayz.acweb.service.MedicoService;
import org.joedayz.acweb.util.Constantes;

public class ServletCita extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VIEWCITAS="/pages/cita/listadoCita.jsp";
	public static final String VIEWCITASREGISTRAR="/pages/cita/registrarCita.jsp";
	
	BNUsuario usuario = new BNUsuario();
	CitaService servicio = new CitaService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BNUsuario usuarioSession=(BNUsuario)request.getSession().getAttribute("usuario");
		String lista =  request.getParameter("list");
		String tipo = request.getParameter("tipo");
		
		if(lista!=null){
			List<BNCita> citas = null;
			
			try {
				if (usuarioSession.getDeRol().equalsIgnoreCase(Constantes.ADMIN)) {
					citas = servicio.getListaCitas();
				}else{
					citas = servicio.getListaCitasPorUsuario(usuarioSession.getCoUser().toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error en listado");
			}
			request.setAttribute("citas", citas);
			request.getRequestDispatcher(VIEWCITAS).forward(request, response);
		}else if ("I".equals(tipo)) {
			request.getRequestDispatcher(VIEWCITASREGISTRAR).forward(request, response);
		}else if ("E".equals(tipo)) {
			String idCita = request.getParameter("idCita");
			try {
				servicio.eliminarCita(idCita);
				List<BNCita> citas = null;
				
				try {
					citas = servicio.getListaCitas();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error en listado");
				}
				request.setAttribute("citas", citas);
				request.getRequestDispatcher(VIEWCITAS).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BNCita cita = new BNCita();
		
		EspecialidadService especialidadService = new EspecialidadService();
		MedicoService medicoService =  new MedicoService();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		BNUsuario usuarioSession=(BNUsuario)request.getSession().getAttribute("usuario");
		
		String idMedico = request.getParameter("idMedico");
		String idEspecialidad =  request.getParameter("idEspecialidad");
		String fecha =  request.getParameter("fecha");
		String comentario = request.getParameter("comentario");
		String horario = request.getParameter("idHorario");
		
		try {
			BNMedico medico = medicoService.getMedicoPorId(idMedico);
			BNEspecialidad especialidad = especialidadService.getEspecialidadPorId(idEspecialidad);
			
			cita.setUsuario(usuarioSession);
			cita.setMedico(medico);
			cita.setEspecialidad(especialidad);
			cita.setFecha(dateFormat.parse(fecha));
			cita.setHorario(horario);
			cita.setComentario(comentario);
			 
			int x = servicio.registrarCita(cita);
			
			if(x>0){
				List<BNCita> citas = null;
				
				try {
					if (usuarioSession.getDeRol().equalsIgnoreCase(Constantes.ADMIN)) {
						citas = servicio.getListaCitas();
					}else{
						citas = servicio.getListaCitasPorUsuario(usuarioSession.getCoUser().toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error en listado");
				}
				request.setAttribute("citas", citas);
				request.getRequestDispatcher(VIEWCITAS).forward(request, response);
			}else{
				System.out.println("ServletCita.doPost()");
				System.out.println("erro al guardar");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
