package com.abc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> attributes = new ArrayList<String>(Arrays.asList("id_Cliente","Nombre","Apellido","CURP","RFC","Direccion"));
		List<String> values = new ArrayList<String>(Arrays.asList("1","6","'Agua Estancada'"));
		List<String> conditions = new ArrayList<String>(Arrays.asList("id_categoria=1","id_problema=1"));
		MYABC abc = new MYABC("problemas",
				"jdbc:mysql://localhost:3306/repso?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root",
				"1234",
				new ArrayList<String>(Arrays.asList("id_categoria","id_problema","descripcion")));
		List<List<String>> view = abc.select(conditions);
		boolean status = abc.insert(values);
		System.out.println(view);
		System.out.println(status);
		}
	}


