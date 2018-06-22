package org.joedayz.acweb.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.joedayz.acweb.dao.factory.FactoryDaoJDBC;

public class GeneradorId {

	
	public static Long getId(String table,String columna){
		Long id=(long)0;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con =  FactoryDaoJDBC.getConnexion();
			
			String sql = "select max("+columna+")+1 from "+table;
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				id=rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
}
