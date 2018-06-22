package org.joedayz.acweb.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.dao.jdbc.impl.JdbcMedicoDaoImpl;
import org.joedayz.acweb.domain.BNMedico;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MedicoDAOTest {

	@Test
	public void getListaMedicosTest(){
		MedicoDAO dao = new JdbcMedicoDaoImpl();
		System.out.println("MedicoDAOTest.getListaMedicosTest()");
		try {
			List<BNMedico> medicos = dao.getListaMedicos();
			for (BNMedico medico : medicos) {
				System.out.println(medico.getDeMedico()+" - "+medico.getEspecialidad().getDeEspecialidad());
			}
			assertEquals(medicos.size(),10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getMedicosPorIdEspecialidad(){
		MedicoDAO dao = new JdbcMedicoDaoImpl();
		System.out.println("MedicoDAOTest.getMedicosPorIdEspecialidad()");
		try {
			List<BNMedico> medicos = dao.getMedicosPorEspecialidad("1");
			for (BNMedico medico : medicos) {
				System.out.println(medico.getDeMedico()+" - "+medico.getEspecialidad().getDeEspecialidad());
			}
			assertEquals(medicos.size(), 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
