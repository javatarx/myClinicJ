package org.joedayz.acweb.test;

import java.util.List;

import org.joedayz.acweb.service.HorarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HorarioTest {

	@Test
	public void getHorarios(){
		String fecha = "2012-05-03";
		HorarioService horarioService = new HorarioService();
		List<String> horarios = horarioService.getListaHorarios(fecha);
		
		for (String hora : horarios) {
			System.out.println(hora);
		}
		
	}
	
}
