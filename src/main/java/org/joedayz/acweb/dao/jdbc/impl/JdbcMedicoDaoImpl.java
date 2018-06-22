package org.joedayz.acweb.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.dao.factory.FactoryDaoJDBC;
import org.joedayz.acweb.domain.BNEspecialidad;
import org.joedayz.acweb.domain.BNMedico;

public class JdbcMedicoDaoImpl implements MedicoDAO {
	public int contador = 3;

	public List<BNMedico> getListaMedicos() throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<BNMedico> medicos = new ArrayList<BNMedico>();

		try {
			con = FactoryDaoJDBC.getConnexion();

			String sql = "select a.co_medico,a.de_medico,b.co_especialidad,b.de_especialidad "
					+ " from medico a, especialidad b where a.co_especialidad = b.co_especialidad "
					+ " order by a.de_medico ASC ";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				BNEspecialidad especialidad = new BNEspecialidad();
				especialidad.setCoEspecialidad(rs.getLong(3));
				especialidad.setDeEspecialidad(rs.getString(4));

				BNMedico medico = new BNMedico();
				medico.setCoMedico(rs.getLong(1));
				medico.setDeMedico(rs.getString(2));
				medico.setEspecialidad(especialidad);

				medicos.add(medico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstm.close();
			rs.close();
			con.close();
		}
		return medicos;
	}

	public List<BNMedico> getMedicosPorEspecialidad(String idEspecialidad) throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<BNMedico> medicos = new ArrayList<BNMedico>();

		try {
			con = FactoryDaoJDBC.getConnexion();

			String sql = "select a.co_medico,a.de_medico,b.co_especialidad,b.de_especialidad "
					+ " from medico a, especialidad b " + " where a.co_especialidad = b.co_especialidad"
					+ " and b.co_especialidad=? order by a.de_medico ASC ";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idEspecialidad);
			rs = pstm.executeQuery();

			while (rs.next()) {

				BNEspecialidad especialidad = new BNEspecialidad();
				especialidad.setCoEspecialidad(rs.getLong(3));
				especialidad.setDeEspecialidad(rs.getString(4));

				BNMedico medico = new BNMedico();
				medico.setCoMedico(rs.getLong(1));
				medico.setDeMedico(rs.getString(2));
				medico.setEspecialidad(especialidad);

				medicos.add(medico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstm.close();
			rs.close();
			con.close();
		}
		return medicos;
	}

	public BNMedico getMedicoPorId(String idMedico) throws Exception {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		BNMedico medico = new BNMedico();

		try {
			con = FactoryDaoJDBC.getConnexion();

			String sql = "select a.co_medico,a.de_medico,b.co_especialidad,b.de_especialidad "
					+ " from medico a, especialidad b " + " where a.co_especialidad = b.co_especialidad"
					+ " and a.co_medico=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idMedico);
			rs = pstm.executeQuery();

			if (rs.next()) {

				BNEspecialidad especialidad = new BNEspecialidad();
				especialidad.setCoEspecialidad(rs.getLong(3));
				especialidad.setDeEspecialidad(rs.getString(4));

				medico = new BNMedico();
				medico.setCoMedico(rs.getLong(1));
				medico.setDeMedico(rs.getString(2));
				medico.setEspecialidad(especialidad);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstm.close();
			rs.close();
			con.close();
		}
		return medico;
	}

	public int guardar(BNMedico medico) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
