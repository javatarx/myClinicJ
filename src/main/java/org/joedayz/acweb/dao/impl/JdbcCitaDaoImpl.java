package org.joedayz.acweb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.dao.daoFactory.BaseDaoSupport;
import org.joedayz.acweb.domain.BNCita;
import org.joedayz.acweb.domain.BNEspecialidad;
import org.joedayz.acweb.domain.BNMedico;
import org.joedayz.acweb.domain.BNUsuario;
import org.joedayz.acweb.util.GeneradorId;

public class JdbcCitaDaoImpl implements CitaDAO{

	private BaseDaoSupport daoSupport = new BaseDaoSupport();
	
	public List<BNCita> getListaCitas() throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<BNCita> citas = new ArrayList<BNCita>();
		
		try {
			con =  daoSupport.getConnexion();
			
			String sql = "select a.co_cita, a.fecha, a.horario, a.comentario, "+
							" b.co_medico, b.de_medico, c.co_especialidad, c.de_especialidad, "+
							" d.co_user, d.nombres, d.apellidos "+
							"from cita a, medico b, especialidad c, usuario d "+
							" where a.co_medico = b.co_medico and b.co_especialidad = c.co_especialidad "+
							" and a.co_especialidad = c.co_especialidad and a.co_usuario=d.co_user";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				BNCita cita = new BNCita();
				BNUsuario usuario = new BNUsuario();
				BNMedico medico = new BNMedico();
				BNEspecialidad especialidad = new BNEspecialidad();
				
				cita.setCoCita(rs.getLong(1));
				cita.setFecha(rs.getDate(2));
				cita.setHorario(rs.getString(3));
				cita.setComentario(rs.getString(4));
				
				especialidad.setCoEspecialidad(rs.getLong(7));
				especialidad.setDeEspecialidad(rs.getString(8));
				
				medico.setCoMedico(rs.getLong(5));
				medico.setDeMedico(rs.getString(6));
				medico.setEspecialidad(especialidad);
				
				usuario.setCoUser(rs.getLong(9));
				usuario.setNombres(rs.getString(10));
				usuario.setApellidos(rs.getString(11));
				
				cita.setUsuario(usuario);
				cita.setMedico(medico);
				cita.setEspecialidad(especialidad);
				
				citas.add(cita);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			rs.close();
			pstm.close();
			con.close();
		}
		return citas;
	}

	public List<BNCita> getCitasPorMedico() throws Exception {
		return null;
	}

	public int registrarCita(BNCita cita) throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "";
		int cont = 0;
		
		try {
			con =  daoSupport.getConnexion();
			
			sql = "insert into cita (co_cita,fecha,horario,co_medico,co_usuario,st_cita,co_especialidad,comentario) "+
					" values(?,?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			
			pstm.setLong(1, GeneradorId.getId("cita", "co_cita"));
			pstm.setDate(2, new java.sql.Date(cita.getFecha().getTime()));
			pstm.setString(3, cita.getHorario());
			pstm.setLong(4, cita.getMedico().getCoMedico());
			pstm.setLong(5, cita.getUsuario().getCoUser());
			pstm.setBoolean(6, true);
			pstm.setLong(7, cita.getEspecialidad().getCoEspecialidad());
			pstm.setString(8, cita.getComentario());
			
			cont = pstm.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			pstm.close();
			con.close();
		}
		return cont;
	}

	public int eliminarCita(String idCita) throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		int cont = 0;
		
		try {
			con =  daoSupport.getConnexion();
			
			String sql = "delete cita where co_cita = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idCita);
			
			cont = pstm.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			pstm.close();
			con.close();
		}
		return cont;
	}

	public List<String> getListaHorariosOcupados(java.util.Date fecha) throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<String> horariosOcupados = null;
		
		try {
			horariosOcupados = new ArrayList<String>();
			con =  daoSupport.getConnexion();
			
			String sql = "select a.horario "+
							"from cita a "+
							" where a.fecha = ?";
			pstm = con.prepareStatement(sql);
			pstm.setDate(1, new Date(fecha.getTime()));
			rs = pstm.executeQuery();
			while (rs.next()) {
				horariosOcupados.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			rs.close();
			pstm.close();
			con.close();
		}
		return horariosOcupados;
	}

	public List<BNCita> getListaCitasPorUsuario(String idUsuario)
			throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<BNCita> citas = new ArrayList<BNCita>();
		
		try {
			con =  daoSupport.getConnexion();
			
			String sql = "select a.co_cita, a.fecha, a.horario, a.comentario, "+
							" b.co_medico, b.de_medico, c.co_especialidad, c.de_especialidad, "+
							" d.co_user, d.nombres, d.apellidos "+
							"from cita a, medico b, especialidad c, usuario d "+
							" where a.co_medico = b.co_medico and b.co_especialidad = c.co_especialidad "+
							" and a.co_especialidad = c.co_especialidad and a.co_usuario=d.co_user"+
							" and a.co_usuario=?";
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, Long.parseLong(idUsuario));
			rs = pstm.executeQuery();
			while (rs.next()) {
				BNCita cita = new BNCita();
				BNUsuario usuario = new BNUsuario();
				BNMedico medico = new BNMedico();
				BNEspecialidad especialidad = new BNEspecialidad();
				
				cita.setCoCita(rs.getLong(1));
				cita.setFecha(rs.getDate(2));
				cita.setHorario(rs.getString(3));
				cita.setComentario(rs.getString(4));
				
				especialidad.setCoEspecialidad(rs.getLong(7));
				especialidad.setDeEspecialidad(rs.getString(8));
				
				medico.setCoMedico(rs.getLong(5));
				medico.setDeMedico(rs.getString(6));
				medico.setEspecialidad(especialidad);
				
				usuario.setCoUser(rs.getLong(9));
				usuario.setNombres(rs.getString(10));
				usuario.setApellidos(rs.getString(11));
				
				cita.setUsuario(usuario);
				cita.setMedico(medico);
				cita.setEspecialidad(especialidad);
				
				citas.add(cita);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			rs.close();
			pstm.close();
			con.close();
		}
		return citas;
	}

}
