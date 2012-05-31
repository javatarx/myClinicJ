package org.joedayz.acweb.test;

import java.util.List;

import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.impl.JdbcEspecialidadDaoImpl;
import org.joedayz.acweb.domain.BNEspecialidad;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EspecialidadDAOTest {

	@Test
	public void getListaEspecialidades(){
		EspecialidadDAO dao = new JdbcEspecialidadDaoImpl();
		
		try {
			List<BNEspecialidad> especialidades = dao.getEspecialidades();
			for (BNEspecialidad especialidad : especialidades) {
				System.out.println(especialidad.getDeEspecialidad());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getEspecialidadPorMedico(){
		EspecialidadDAO dao = new JdbcEspecialidadDaoImpl();
		String idMedico = "1";
		
		try {
			List<BNEspecialidad> especialidades = dao.getEspecialidadPorMedico(idMedico);
			System.out.println("Este medico tiene las siguientes especialidades: ");
			for (BNEspecialidad especialidad : especialidades) {
				System.out.println(especialidad.getDeEspecialidad());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
