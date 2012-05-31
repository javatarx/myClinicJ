package org.joedayz.acweb.test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.dao.UsuarioDAO;
import org.joedayz.acweb.dao.daoFactory.DAOFactory;
import org.joedayz.acweb.domain.BNCita;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CitaDAOTest {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.H2);
	CitaDAO citaDAO = fabrica.getCitaDAO();
	MedicoDAO medicoDAO = fabrica.getMedicoDAO();
	UsuarioDAO usuarioDAO = fabrica.getUsuarioDAO();
	EspecialidadDAO especialidadDAO = fabrica.getEspecialidadDAO();
	
	@Test
	public void registrarCitaTest(){
		BNCita cita = new BNCita();
		
		try {
			cita.setComentario("esto es un comentario");
			cita.setEspecialidad(especialidadDAO.getEspecialidadPorId("1"));
			cita.setMedico(medicoDAO.getMedicoPorId("1"));
			cita.setHorario("08:00 am");
			cita.setUsuario(usuarioDAO.getUsuarioPorId("1"));
			cita.setFecha(new Date(new java.util.Date().getTime()));
			
			int x = citaDAO.registrarCita(cita);
			
			assertEquals(x,2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void listarCitasTest() throws Exception{
		List<BNCita> citas = citaDAO.getListaCitas();
		for (BNCita cita : citas) {
			System.out.println(cita.getFecha()+" - "+cita.getComentario()+" - "+cita.getHorario()+" - "+cita.getMedico().getDeMedico()+" - "+cita.getEspecialidad().getDeEspecialidad());
		}
	}
	
}
