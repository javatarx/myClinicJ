package org.joedayz.acweb.service;

import java.util.ArrayList;

import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.UsuarioDAO;
import org.joedayz.acweb.dao.factory.FactoryDAO;
import org.joedayz.acweb.domain.BNUsuario;

public class UsuarioService {

	FactoryDAO fabrica = FactoryDAO.getFactoryDAO(FactoryDAO.JDBC);
	UsuarioDAO usuarioDao = fabrica.getUsuarioDAO();
	EspecialidadDAO e = fabrica.getEspecialidadDAO();

	public BNUsuario validarUsuario(String usuario, String password) throws Exception {
		return usuarioDao.validarUsuario(usuario, password);
	}

	public ArrayList<BNUsuario> listadoUsuarios() throws Exception {
		return usuarioDao.listadoUsuarios();
	}

	public int registrarUsuario(BNUsuario usuario) throws Exception {
		return usuarioDao.registrarUsuario(usuario);
	}

}
