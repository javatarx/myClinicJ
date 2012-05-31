package org.joedayz.acweb.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joedayz.acweb.domain.BNCita;
import org.joedayz.acweb.domain.BNUsuario;
import org.joedayz.acweb.service.CitaService;
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
		
		if(lista!=null&&usuarioSession.getDeRol().equalsIgnoreCase(Constantes.ADMIN)){
			List<BNCita> citas = null;
			
			try {
				citas = servicio.getListaCitas();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error en listado");
			}
			request.setAttribute("citas", citas);
			request.getRequestDispatcher(VIEWCITAS).forward(request, response);
		}else if ("I".equals(tipo)) {
			request.getRequestDispatcher(VIEWCITASREGISTRAR).forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
