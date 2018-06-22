package org.joedayz.acweb.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.dao.factory.FactoryDaoJDBC;
import org.joedayz.acweb.domain.BNCita;
import org.joedayz.acweb.domain.BNEspecialidad;
import org.joedayz.acweb.domain.BNMedico;
import org.joedayz.acweb.domain.BNUsuario;
import org.joedayz.acweb.util.GeneradorId;

public class JdbcCitaDaoImpl implements CitaDAO {

	public List<BNCita> getListaCitas() throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<BNCita> citas = new ArrayList<BNCita>();

		try {
			con = FactoryDaoJDBC.getConnexion();

			String sql = "select a.co_cita, a.fecha, a.horario, a.comentario, "
					+ " b.co_medico, b.de_medico, c.co_especialidad, c.de_especialidad, "
					+ " d.co_user, d.nombres, d.apellidos, a.st_cita "
					+ "from cita a, medico b, especialidad c, usuario d "
					+ " where a.co_medico = b.co_medico and b.co_especialidad = c.co_especialidad "
					+ " and a.co_especialidad = c.co_especialidad and a.co_usuario=d.co_user and a.st_cita=? "
					+ " order by a.fecha,a.horario ASC ";
			pstm = con.prepareStatement(sql);
			pstm.setBoolean(1, true);
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

				cita.setStCita(rs.getInt(12));

				cita.setUsuario(usuario);
				cita.setMedico(medico);
				cita.setEspecialidad(especialidad);

				citas.add(cita);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			con = FactoryDaoJDBC.getConnexion();

			sql = "insert into cita (co_cita,fecha,horario,co_medico,co_usuario,st_cita,co_especialidad,comentario) "
					+ " values(?,?,?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);

			pstm.setLong(1, GeneradorId.getId("cita", "co_cita"));
			pstm.setDate(2, new java.sql.Date(cita.getFecha().getTime()));
			pstm.setString(3, cita.getHorario());
			pstm.setLong(4, cita.getMedico().getCoMedico());
			pstm.setLong(5, cita.getUsuario().getCoUser());
			pstm.setInt(6, 1);
			pstm.setLong(7, cita.getEspecialidad().getCoEspecialidad());
			pstm.setString(8, cita.getComentario());

			cont = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			con = FactoryDaoJDBC.getConnexion();

			// String sql = "delete cita where co_cita = ?";
			String sql = "update cita set st_cita=? where co_cita = ?";
			pstm = con.prepareStatement(sql);
			pstm.setBoolean(1, false);
			pstm.setString(2, idCita);

			cont = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstm.close();
			con.close();
		}
		return cont;
	}

	public List<String> getListaHorariosDisponibles(java.util.Date fecha, String idMedico) throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<String> horariosDisponibles = null;

		try {
			horariosDisponibles = new ArrayList<String>();
			con = FactoryDaoJDBC.getConnexion();

			String sql = "select a.horario " + "from cita a " + " where a.fecha = ? and a.st_cita =? and a.co_medico=?";
			pstm = con.prepareStatement(sql);
			pstm.setDate(1, new Date(fecha.getTime()));
			pstm.setBoolean(2, true);
			pstm.setLong(3, Long.parseLong(idMedico));
			rs = pstm.executeQuery();
			while (rs.next()) {
				horariosDisponibles.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstm.close();
			con.close();
		}
		return horariosDisponibles;
	}

	public List<BNCita> getListaCitasPorUsuario(String idUsuario) throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<BNCita> citas = new ArrayList<BNCita>();

		try {
			con = FactoryDaoJDBC.getConnexion();

			String sql = "select a.co_cita, a.fecha, a.horario, a.comentario, "
					+ " b.co_medico, b.de_medico, c.co_especialidad, c.de_especialidad, "
					+ " d.co_user, d.nombres, d.apellidos, a.st_cita "
					+ "from cita a, medico b, especialidad c, usuario d "
					+ " where a.co_medico = b.co_medico and b.co_especialidad = c.co_especialidad "
					+ " and a.co_especialidad = c.co_especialidad and a.co_usuario=d.co_user"
					+ " and a.co_usuario=? and a.st_cita =? order by a.fecha,a.horario ASC";
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, Long.parseLong(idUsuario));
			pstm.setBoolean(2, true);
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

				cita.setStCita(rs.getInt(12));

				cita.setUsuario(usuario);
				cita.setMedico(medico);
				cita.setEspecialidad(especialidad);

				citas.add(cita);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstm.close();
			con.close();
		}
		return citas;
	}

	public int actualizarCita(BNCita cita) throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		String sql = "";
		int cont = 0;

		try {
			con = FactoryDaoJDBC.getConnexion();

			sql = " update cita "
					+ " set fecha=?,horario=?,co_medico=?,co_usuario=?,st_cita=?,co_especialidad=?,comentario=?"
					+ " where co_cita=?";
			pstm = con.prepareStatement(sql);

			pstm.setDate(1, new java.sql.Date(cita.getFecha().getTime()));
			pstm.setString(2, cita.getHorario());
			pstm.setLong(3, cita.getMedico().getCoMedico());
			pstm.setLong(4, cita.getUsuario().getCoUser());
			pstm.setBoolean(5, true);
			pstm.setLong(6, cita.getEspecialidad().getCoEspecialidad());
			pstm.setString(7, cita.getComentario());
			pstm.setLong(8, cita.getCoCita());

			cont = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstm.close();
			con.close();
		}
		return cont;
	}

	public BNCita getCitaPorId(String idCita) throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		BNCita cita = new BNCita();

		try {
			con = FactoryDaoJDBC.getConnexion();

			String sql = "select a.co_cita, a.fecha, a.horario, a.comentario, "
					+ " b.co_medico, b.de_medico, c.co_especialidad, c.de_especialidad, "
					+ " d.co_user, d.nombres, d.apellidos " + "from cita a, medico b, especialidad c, usuario d "
					+ " where a.co_medico = b.co_medico and b.co_especialidad = c.co_especialidad "
					+ " and a.co_especialidad = c.co_especialidad and a.co_usuario=d.co_user "
					+ " and a.st_cita=? and a.co_cita=?";
			pstm = con.prepareStatement(sql);
			pstm.setBoolean(1, true);
			pstm.setLong(2, Long.parseLong(idCita));
			rs = pstm.executeQuery();
			if (rs.next()) {
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstm.close();
			con.close();
		}
		return cita;
	}

}
