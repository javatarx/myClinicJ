package org.joedayz.acweb.test;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class TestGeneraDB {

	@Test
	public void getDirectorioTest(){
		File folder = new File("myclinic");
		if(!folder.exists()){
			folder.mkdirs();
		}else{
			System.out.println("existe");
		}
		
	}
	
}
