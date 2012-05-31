package org.joedayz.acweb.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joedayz.acweb.domain.BNUsuario;
import org.joedayz.acweb.service.UsuarioService;
import org.joedayz.acweb.util.Constantes;

public class ServletUsuario extends HttpServlet{
	
	public static final String VIEWUSUARIOS="/pages/usuario/listadoUsuario.jsp";
	public static final String VIEWUSUARIOSREGISTRAR="/pages/usuario/registrarUsuario.jsp";
	
	BNUsuario usuario= new BNUsuario();
	UsuarioService servicio= new UsuarioService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	String id=request.getParameter("id");
	String lista=request.getParameter("list");
		
	BNUsuario usuariosession=(BNUsuario)request.getSession().getAttribute("usuario");
	
	if(usuariosession.getDeRol().equalsIgnoreCase(Constantes.ADMIN) && lista!=null){
		ArrayList<BNUsuario> usuarios=null;
		try {
			usuarios=servicio.listadoUsuarios();
		} catch (Exception e) {
		
			System.out.println("Error en listado "+e);
		}
		request.setAttribute("usuarios",usuarios);
		request.getRequestDispatcher(VIEWUSUARIOS).forward(request, response);

	}else if(id!=null){
		/*Formulario de Usuario lleno*/
		
		getServletContext().getRequestDispatcher(VIEWUSUARIOSREGISTRAR).forward(request, response);

	}else if(id==null){
		/*Formulario de Registro*/
		
		getServletContext().getRequestDispatcher(VIEWUSUARIOSREGISTRAR).forward(request, response);
		
	}
	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*Registrar y Actualizar*/
		
		String username=request.getParameter("username");
		String nombres=request.getParameter("nombres");
		String apellidos=request.getParameter("apellidos");
		String sexo=request.getParameter("sexo");
		String password=request.getParameter("password");
		String direccion=request.getParameter("direccion");
		String telefono=request.getParameter("telefono");
		String tipodocumento=request.getParameter("tipodocumento");
		String nrodocumento=request.getParameter("nrodocumento");
		String email=request.getParameter("email");
		
		usuario.setUserName(username);
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setSexo(sexo.charAt(0));
		usuario.setPassword(password);
		usuario.setDireccion(direccion);
		usuario.setTelefono(telefono);
		usuario.setTipoDocumento(tipodocumento.charAt(0));
		usuario.setDocumento(new Long(nrodocumento));
		usuario.setEmail(email);
		int resultado=0;
		
		try {
			resultado=servicio.registrarUsuario(usuario);
			
		} catch (Exception e) {
			System.out.println("Error en el SERVICIO al registrar Usuario " +e);
			e.printStackTrace();
		}
		
		if(resultado==0){
			request.setAttribute("mensaje","Problemas al registar");
			getServletContext().getRequestDispatcher(VIEWUSUARIOSREGISTRAR).forward(request, response);
		}else{
			request.setAttribute("mensaje","Registro Satisfcatorio");
			getServletContext().getRequestDispatcher(VIEWUSUARIOSREGISTRAR).forward(request, response);
		}

	}
	
	
	

}
