package org.joedayz.acweb.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.dao.UsuarioDAO;
import org.joedayz.acweb.dao.factory.FactoryDAO;
import org.joedayz.acweb.domain.BNCita;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CitaDAOTest {

	FactoryDAO fabrica = FactoryDAO.getFactoryDAO(FactoryDAO.JDBC);
	CitaDAO citaDAO = fabrica.getCitaDAO();
	MedicoDAO medicoDAO = fabrica.getMedicoDAO();
	UsuarioDAO usuarioDAO = fabrica.getUsuarioDAO();
	EspecialidadDAO especialidadDAO = fabrica.getEspecialidadDAO();
	
//	@Test
//	public void registrarCitaTest(){
//		BNCita cita = new BNCita();
//		
//		try {
//			cita.setComentario("esto es un comentario");
//			cita.setEspecialidad(especialidadDAO.getEspecialidadPorId("1"));
//			cita.setMedico(medicoDAO.getMedicoPorId("1"));
//			cita.setHorario("08:00 am");
//			cita.setUsuario(usuarioDAO.getUsuarioPorId("1"));
//			cita.setFecha(new Date(new java.util.Date().getTime()));
//			
//			int x = citaDAO.registrarCita(cita);
//			
//			assertEquals(x,4);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void listarCitasTest() throws Exception{
		List<BNCita> citas = citaDAO.getListaCitas();
		for (BNCita cita : citas) {
			System.out.println(cita.getFecha()+" - "+cita.getComentario()+" - "+cita.getHorario()+" - "+cita.getMedico().getDeMedico()+" - "+cita.getEspecialidad().getDeEspecialidad());
		}
	}
	
	@Test
	public void listarHorariosOcupadosTest() throws Exception{
		Calendar fecha =  Calendar.getInstance();
		fecha.set(2012,4,31);
		List<String> horarios = citaDAO.getListaHorariosDisponibles(fecha.getTime(),"1");
		for (String hora : horarios) {
			System.out.println(hora);
		}
	}
	
	@Test
	public void getListaHorariosTest(){
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm a");
		
		int horaInicioMannana = 8 ;
		int horaFinMannana = 13;
		int horaInicioTarde = 15 ;
		int horaFinTarde = 18;
		int intervalo = 25;
		
		Calendar inicioMannana = Calendar.getInstance();
		inicioMannana.set(2012,4,31,horaInicioMannana,0,0);
		
		Calendar finMannana = Calendar.getInstance();
		finMannana.set(2012,4,31,horaFinMannana,0,0);
		
		Calendar inicioTarde = Calendar.getInstance();
		inicioTarde.set(2012,4,31,horaInicioTarde,0,0);
		
		Calendar finTarde = Calendar.getInstance();
		finTarde.set(2012,4,31,horaFinTarde,0,0);
		
		List<String> horarios = new ArrayList<String>();
		
		List<String> horariosOcupados = new ArrayList<String>();
		horariosOcupados.add("08:25 AM");
		horariosOcupados.add("10:30 AM");
		
		while (inicioMannana.before(finMannana)) {
			horarios.add(format2.format(inicioMannana.getTime()));
			inicioMannana.add(Calendar.MINUTE, intervalo);
		}

		while (inicioTarde.before(finTarde)) {
			horarios.add(format2.format(inicioTarde.getTime()));
			inicioTarde.add(Calendar.MINUTE, intervalo);
		}
		
		horarios.removeAll(horariosOcupados);
		
		for (String hora : horarios) {
			System.out.println(hora);
		}
		
	}
	
}
