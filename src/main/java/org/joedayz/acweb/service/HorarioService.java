package org.joedayz.acweb.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.dao.daoFactory.DAOFactory;
import org.joedayz.acweb.util.Constantes;

public class HorarioService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.H2);
	CitaDAO citaDAO = fabrica.getCitaDAO();
	
	public List<String> getListaHorarios(String fecha){
		SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formato2 = new SimpleDateFormat("HH:mm a");
		
		List<String> horarios = new ArrayList<String>();
		
		try {
			Date dia = formato1.parse(fecha);
			
			Calendar inicioMannana = Calendar.getInstance();
			inicioMannana.set(dia.getYear(),dia.getMonth(),dia.getDay(),Constantes.horaInicioT1,0,0);
			
			Calendar finMannana = Calendar.getInstance();
			finMannana.set(dia.getYear(),dia.getMonth(),dia.getDay(),Constantes.horaFinT1,0,0);
			
			Calendar inicioTarde = Calendar.getInstance();
			inicioTarde.set(dia.getYear(),dia.getMonth(),dia.getDay(),Constantes.horaInicioT2,0,0);
			
			Calendar finTarde = Calendar.getInstance();
			finTarde.set(dia.getYear(),dia.getMonth(),dia.getDay(),Constantes.horaFinT2,0,0);
			
			
			List<String> horariosOcupados = citaDAO.getListaHorariosOcupados(formato1.parse(fecha));
			
			while (inicioMannana.before(finMannana)) {
				horarios.add(formato2.format(inicioMannana.getTime()));
				inicioMannana.add(Calendar.MINUTE, Constantes.duracionCita);
			}

			while (inicioTarde.before(finTarde)) {
				horarios.add(formato2.format(inicioTarde.getTime()));
				inicioTarde.add(Calendar.MINUTE, Constantes.duracionCita);
			}
			
			horarios.removeAll(horariosOcupados);
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return horarios;
	}
	
}
