package org.joedayz.acweb.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCita extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VIEWCITAS="/pages/cita/listadoCita.jsp";
	public static final String VIEWCITASREGISTRAR="/pages/cita/registrarCita.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String lista =  request.getParameter("list");
		String tipo = request.getParameter("tipo");
		
		if(lista!=null){
			 request.getRequestDispatcher(VIEWCITAS).forward(request, response);
		}else if ("I".equals(tipo)) {
			request.getRequestDispatcher(VIEWCITASREGISTRAR).forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
