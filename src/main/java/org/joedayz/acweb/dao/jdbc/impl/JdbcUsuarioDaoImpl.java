package org.joedayz.acweb.dao.jdbc.impl;



import org.joedayz.acweb.dao.UsuarioDAO;
import org.joedayz.acweb.dao.daoFactory.BaseDaoSupport;
import org.joedayz.acweb.domain.BNUsuario;
import org.joedayz.acweb.util.GeneradorId;

import java.sql.*;
import java.util.ArrayList;


public class JdbcUsuarioDaoImpl implements UsuarioDAO {
	

	private BaseDaoSupport daoSupport= new BaseDaoSupport();
	public int contador=3;

	public BNUsuario validarUsuario(String usuario,String password)throws Exception{
            
            System.out.println("ESTOY VALIDANDO EL USUARIO");
		
		PreparedStatement pstm= null;
		Connection 		   con= null;
		ResultSet 			rs= null;
		BNUsuario validado	  = null;
		
		try {
			con = daoSupport.getConnexion();
			String sql ="	select usu.CO_USER as CO_USER,usu.USERNAME as USERNAME,usu.NOMBRES as NOMBRES,usu.APELLIDOS as APELLIDOS,rol.de_role as DE_ROLE" +
						"	from USUARIO usu " +
						"	inner join USUARIO_ROLE usurol on usu.co_user = usurol.co_user " +
						"	inner join ROLE rol on rol.co_role=usurol.co_role   " +
						"	where usu.username=? and usu.password=?  ";
			
			
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, password);
			
			rs = pstm.executeQuery();

			while (rs.next()) 
			{
				validado = new BNUsuario();
				validado.setCoUser(rs.getLong("CO_USER"));
				validado.setUserName(rs.getString("USERNAME"));
				validado.setNombres(rs.getString("NOMBRES"));
				validado.setApellidos(rs.getString("APELLIDOS"));
				validado.setDeRol(rs.getString("DE_ROLE"));
			}
		
		} catch (Exception e) {
			System.out.println("Error al Validar "+e);
		} finally{
			rs.close();
			pstm.close();
			con.close();
		}
	
		return validado;
	}
	
	public ArrayList<BNUsuario> listadoUsuarios() throws Exception{

		Statement 			st= null;
		Connection 		   con= null;
		ResultSet 			rs= null;
		BNUsuario usuario	  = null;
		ArrayList<BNUsuario> usuarios=new ArrayList<BNUsuario>();
		
		try {
			con = daoSupport.getConnexion();
			
			String sql="Select  usu.CO_USER as CO_USER, usu.USERNAME as USERNAME, usu.NOMBRES as NOMBRES," +
						"usu.APELLIDOS as APELLIDOS, usu.EMAIL as EMAIL" +
						" From usuario usu";
			
			
			 st = con.createStatement();
			 rs = st.executeQuery(sql);
			
			while (rs.next()) {

				usuario = new BNUsuario();
				usuario.setCoUser(rs.getLong(1));
				usuario.setUserName(rs.getString(2));
				usuario.setNombres(rs.getString(3));
				usuario.setApellidos(rs.getString(4));
				usuario.setEmail(rs.getString(5));
				usuarios.add(usuario);
				}
			
		} catch (Exception e) {
			System.out.println("Error en el select de usuario "+e);
		} finally{
			rs.close();
			st.close();
			con.close();
		}
		
		
		return usuarios;
		}
	
	
	public int registrarUsuario(BNUsuario usuario) throws Exception{
		
		int resultado 	= 0;
		Connection 	con	= null;
		String sql 		= null;
		PreparedStatement pstm = null;
		
		try {
		Long id = GeneradorId.getId("usuario", "co_user");
		con = daoSupport.getConnexion();
		
		sql = "insert into USUARIO(CO_USER ,USERNAME  ,NOMBRES ,APELLIDOS ,ST_USUARIO," +
				"	SEXO ,DIRECCION ,TELEFONO ,TIPO_DOCUMENTO , DOCUMENTO ,PASSWORD ,EMAIL) values(?,?,?,?,?,?,?,?,?,?,?,?)";

		pstm = con.prepareStatement(sql);
		
		pstm.setLong(1, id);
		pstm.setString(2, usuario.getUserName());	
		pstm.setString(3, usuario.getNombres());
		pstm.setString(4, usuario.getApellidos());
		pstm.setBoolean(5, true);
		pstm.setString(6, usuario.getSexo()+"");
		pstm.setString(7, usuario.getDireccion());
		pstm.setString(8, usuario.getTelefono());
		pstm.setString(9, usuario.getTipoDocumento()+"");
		pstm.setLong(10, usuario.getDocumento());
		pstm.setString(11, usuario.getPassword());
		pstm.setString(12, usuario.getEmail());

		resultado = pstm.executeUpdate();
		
		//a�adiendo el rol
		sql = "insert into usuario_role (co_role_user,co_role,co_user,st_role_user) "+
				" values(?,?,?,?)";
		pstm = con.prepareStatement(sql);
		pstm.setLong(1, GeneradorId.getId("usuario_role", "co_role_user"));
		pstm.setLong(2, usuario.getCoRol());
		pstm.setLong(3, id);
		pstm.setBoolean(4, true);
		resultado = pstm.executeUpdate();
		
		
		} catch (Exception e) {
			System.out.println("Error en el select de usuario "+e);
		} finally{
			pstm.close();
			con.close();
			con.close();
		}
	
		return resultado;
		
	}

	public BNUsuario getUsuarioPorId(String idUsuario) throws Exception {
		PreparedStatement	pstm= null;
		Connection 		   con= null;
		ResultSet 			rs= null;
		BNUsuario usuario	  = null;
		
		try {
			con = daoSupport.getConnexion();
			
			String sql="Select  usu.CO_USER as CO_USER, usu.USERNAME as USERNAME, usu.NOMBRES as NOMBRES," +
						"usu.APELLIDOS as APELLIDOS, usu.EMAIL as EMAIL" +
						" From usuario usu where usu.co_user = ? ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idUsuario);
			rs = pstm.executeQuery();
			
			if(rs.next()) {

				usuario = new BNUsuario();
				usuario.setCoUser(rs.getLong(1));
				usuario.setUserName(rs.getString(2));
				usuario.setNombres(rs.getString(3));
				usuario.setApellidos(rs.getString(4));
				usuario.setEmail(rs.getString(5));
			}
		} catch (Exception e) {
			System.out.println("Error en el select de usuario "+e);
		} finally{
			pstm.close();
			rs.close();
			con.close();
		}
		
		return usuario;
	}

}
