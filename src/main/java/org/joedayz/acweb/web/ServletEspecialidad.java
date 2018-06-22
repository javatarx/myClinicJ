package org.joedayz.acweb.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joedayz.acweb.service.EspecialidadService;

/**
 * Servlet implementation class Especialidad
 */
public class ServletEspecialidad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VIEW_LIST = "/pages/especialidad/listado.jsp";
	public static final String VIEW_FORM = "/pages/especialidad/form.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEspecialidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EspecialidadService es = new EspecialidadService();
		try {
			request.setAttribute("especialidades", es.getListaEspecialidades());
			getServletContext().getRequestDispatcher(VIEW_LIST).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
