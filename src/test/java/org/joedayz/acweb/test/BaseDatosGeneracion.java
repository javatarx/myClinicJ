package org.joedayz.acweb.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.joedayz.acweb.dao.factory.FactoryDaoJDBC;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BaseDatosGeneracion {

	@Test
	public void ExecuteSql() throws Exception {

		List list = new ArrayList();
		PreparedStatement Statement = null;
		Connection conection = FactoryDaoJDBC.getConnexion();

		// String sql = " SET FOREIGN_KEY_CHECKS=0;";
		// list.add(sql);

		String sql = " CREATE TABLE USUARIO( CO_USER INTEGER NOT NULL, USERNAME VARCHAR(100),"
				+ " EMAIL VARCHAR(150),NOMBRES VARCHAR(150), APELLIDOS VARCHAR(150),ST_USUARIO BIT,"
				+ " SEXO CHAR(1), DIRECCION VARCHAR(200), TELEFONO VARCHAR(12),TIPO_DOCUMENTO CHAR(1),"
				+ " DOCUMENTO INTEGER, PASSWORD VARCHAR(100),	ACCOUNT_EXPIRED BIT, ACCOUNT_LOCKED BIT,"
				+ " CREDENTIALS_EXPIRED BIT, ACCOUNT_ENABLED BIT, PASSWORD_HINT VARCHAR(100),	PRIMARY KEY (CO_USER));";
		list.add(sql);

		sql = "	INSERT INTO USUARIO ( CO_USER ,USERNAME ,EMAIL ,NOMBRES ,APELLIDOS ,ST_USUARIO,"
				+ "	SEXO ,DIRECCION ,TELEFONO ,TIPO_DOCUMENTO , DOCUMENTO ,PASSWORD ,ACCOUNT_EXPIRED ,"
				+ "   ACCOUNT_LOCKED , CREDENTIALS_EXPIRED ,ACCOUNT_ENABLED ,PASSWORD_HINT)"
				+ "   VALUES(1,'admin','joseluis_0428@hotmail.com','Jose luis', 'Mandujano Bueno'," + true + ",'1',"
				+ "  'Jr. Saenz Pe�a 203', '2358796','1',123456789,'admin'," + "  " + false + "," + false + "," + false
				+ "," + true + ",'d033e22ae348aeb5660fc2140aec35850c4da997')";
		list.add(sql);

		sql = "	INSERT INTO USUARIO ( CO_USER ,USERNAME ,EMAIL ,NOMBRES ,APELLIDOS ,ST_USUARIO,"
				+ "	SEXO ,DIRECCION ,TELEFONO ,TIPO_DOCUMENTO , DOCUMENTO ,PASSWORD ,ACCOUNT_EXPIRED ,"
				+ "   ACCOUNT_LOCKED , CREDENTIALS_EXPIRED ,ACCOUNT_ENABLED ,PASSWORD_HINT)"
				+ "   VALUES(2,'rosamedina','rosamedina@hotmail.com','Rosa', 'Medina Perez'," + true + ",'2',"
				+ "  'Av. Canada  2203', '2358796','1',123456789,'rosamedina'," + "  " + false + "," + false + ","
				+ false + "," + true + ",'d033e22ae348aeb5660fc2140aec35850c4da997')";
		list.add(sql);

		sql = "	CREATE TABLE ROLE( CO_ROLE INTEGER NOT NULL,	DE_ROLE VARCHAR(100),ST_ROLE BIT,PRIMARY KEY (CO_ROLE));";
		list.add(sql);

		sql = "	INSERT INTO ROLE(CO_ROLE,DE_ROLE ,ST_ROLE) VALUES (1,'ADMIN'," + true + ");";

		list.add(sql);

		sql = "	INSERT INTO ROLE(CO_ROLE,DE_ROLE ,ST_ROLE) VALUES (2,'CLIENTE'," + true + ");";
		list.add(sql);

		sql = "	CREATE TABLE USUARIO_ROLE(CO_ROLE_USER INTEGER NOT NULL,CO_ROLE INTEGER,CO_USER INTEGER,"
				+ "	ST_ROLE_USER BIT, PRIMARY KEY (CO_ROLE_USER)) ;";
		list.add(sql);

		sql = "	INSERT INTO USUARIO_ROLE(CO_ROLE_USER ,CO_ROLE,CO_USER ,ST_ROLE_USER ) " + "VALUES (1,1,1," + true
				+ ");";
		list.add(sql);

		sql = "	INSERT INTO USUARIO_ROLE(CO_ROLE_USER ,CO_ROLE,CO_USER ,ST_ROLE_USER ) " + "VALUES (2,2,2," + true
				+ ");";
		list.add(sql);

		sql = "CREATE TABLE ESPECIALIDAD (CO_ESPECIALIDAD INTEGER NOT NULL,DE_ESPECIALIDAD VARCHAR(200),"
				+ " ST_ESPECIALIDAD BIT, PRIMARY KEY (CO_ESPECIALIDAD) );";
		list.add(sql);

		sql = "INSERT INTO ESPECIALIDAD (CO_ESPECIALIDAD,DE_ESPECIALIDAD,ST_ESPECIALIDAD) VALUES (1,'MEDICINA GENERAL',"
				+ true + "); ";
		list.add(sql);

		sql = "INSERT INTO ESPECIALIDAD (CO_ESPECIALIDAD,DE_ESPECIALIDAD,ST_ESPECIALIDAD) VALUES (2,'TRAUMATOLOGIA',"
				+ true + "); ";
		list.add(sql);

		sql = "INSERT INTO ESPECIALIDAD (CO_ESPECIALIDAD,DE_ESPECIALIDAD,ST_ESPECIALIDAD) VALUES (3,'CARDIOLOGIA',"
				+ true + "); ";
		list.add(sql);

		sql = "INSERT INTO ESPECIALIDAD (CO_ESPECIALIDAD,DE_ESPECIALIDAD,ST_ESPECIALIDAD) VALUES (4,'DERMATOLOGIA',"
				+ true + "); ";
		list.add(sql);

		sql = "INSERT INTO ESPECIALIDAD (CO_ESPECIALIDAD,DE_ESPECIALIDAD,ST_ESPECIALIDAD) VALUES (5,'NEONATOLOGIA',"
				+ true + "); ";
		list.add(sql);

		sql = "CREATE TABLE MEDICO (CO_MEDICO INTEGER NOT NULL, DE_MEDICO VARCHAR(200), ST_MEDICO BIT, "
				+ "CO_ESPECIALIDAD INTEGER, PRIMARY KEY (CO_MEDICO));";
		list.add(sql);

		sql = "INSERT INTO MEDICO (CO_MEDICO,DE_MEDICO,ST_MEDICO,CO_ESPECIALIDAD) VALUES(1,'LUPA QUISOLACA HERNAN',"
				+ true + ",1);";
		list.add(sql);

		sql = "INSERT INTO MEDICO (CO_MEDICO,DE_MEDICO,ST_MEDICO,CO_ESPECIALIDAD) VALUES(2,'LUQUE MAMANI ELOY'," + true
				+ ",2);";
		list.add(sql);

		sql = "INSERT INTO MEDICO (CO_MEDICO,DE_MEDICO,ST_MEDICO,CO_ESPECIALIDAD) VALUES(3,'MARIN VEGA CESAR'," + true
				+ ",3);";
		list.add(sql);

		sql = "INSERT INTO MEDICO (CO_MEDICO,DE_MEDICO,ST_MEDICO,CO_ESPECIALIDAD) VALUES(4,'PASSANO DEL CARPIO AGUSTIN',"
				+ true + ",4);";
		list.add(sql);

		sql = "INSERT INTO MEDICO (CO_MEDICO,DE_MEDICO,ST_MEDICO,CO_ESPECIALIDAD) VALUES(5,'PORTUGAL GALDOS ENRIQUE',"
				+ true + ",5);";
		list.add(sql);

		sql = "INSERT INTO MEDICO (CO_MEDICO,DE_MEDICO,ST_MEDICO,CO_ESPECIALIDAD) VALUES(6,'SOTOMAYOR PERALES ENRIQUE',"
				+ true + ",1);";
		list.add(sql);

		sql = "INSERT INTO MEDICO (CO_MEDICO,DE_MEDICO,ST_MEDICO,CO_ESPECIALIDAD) VALUES(7,'ZEGARRA MACEDO ANGEL',"
				+ true + ",2);";
		list.add(sql);

		sql = "INSERT INTO MEDICO (CO_MEDICO,DE_MEDICO,ST_MEDICO,CO_ESPECIALIDAD) VALUES(8,'VEGA HINOJOSA OSCAR',"
				+ true + ",3);";
		list.add(sql);

		sql = "INSERT INTO MEDICO (CO_MEDICO,DE_MEDICO,ST_MEDICO,CO_ESPECIALIDAD) VALUES(9,'AGUILAR RIOS CHRISTIAN',"
				+ true + ",4);";
		list.add(sql);

		sql = "INSERT INTO MEDICO (CO_MEDICO,DE_MEDICO,ST_MEDICO,CO_ESPECIALIDAD) VALUES(10,'HUAMALIES BAQUERIZO NORCA',"
				+ true + ",5);";
		list.add(sql);

		sql = "CREATE TABLE CITA (CO_CITA INTEGER NOT NULL,FECHA DATE,HORARIO VARCHAR(50),CO_MEDICO INTEGER, CO_USUARIO INTEGER, "
				+ "ST_CITA BIT,CO_ESPECIALIDAD INTEGER,COMENTARIO VARCHAR(200), PRIMARY KEY (CO_CITA) );";
		list.add(sql);

		for (int i = 0; i < list.size(); i++) {
			sql = (String) list.get(i);
			System.out.println("sql" + i + "--" + sql);
			Statement = conection.prepareStatement(sql);
			Statement.execute();
		}

		conection.close();
	}
}
