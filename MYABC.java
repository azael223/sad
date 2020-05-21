package com.abc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;

public class MYABC extends ABC{
	
	public MYABC(String table, String connection, String user, String password, List<String> attributes) {
		super(table, connection, user, password, attributes);
	}
	
	public List<List<String>> select (List<String> conditions){	
		String query = "SELECT * FROM " + table;
		if(conditions.size()>0) {
			query+=" WHERE " + appendLists(" AND ", conditions);
		}
		List<List<String>> queryData = new ArrayList<List<String>> ();
		try {
			Connection conexion = DriverManager.getConnection(connection, user, password); 
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {		
				//queryData.add((String) rs.getObject(i));
				List<String> rowData = new ArrayList<String> ();
				for(int j=0;j<attributes.size();j++) {
					rowData.add(""+rs.getObject(attributes.get(j)));
				}
				queryData.add(rowData);
			}
			rs.close();
			st.close();
			conexion.close();
			return queryData;
		}
		catch (SQLException e) {
			System.out.println(e.toString());
			return queryData;
		}
	}
	
	public boolean insert (List<String> values){
		String query= "INSERT INTO " + table +"("+appendLists(",",attributes)+")" + " VALUES (" + appendLists(",", values) + ")";
		System.out.println(query);
		return executeNoQuery(query);
	}
	
	public boolean update (List<String> values, List<String> conditions) {
		String query = "UPDATE " + table + " SET " + appendDoubleList("=", ",", attributes, values) + " WHERE " + appendLists(" AND ", conditions);
		return executeNoQuery(query);
	}
	
	public boolean delete (List<String> conditions) {
		String query = "DELETE FROM " + table + " WHERE " + appendLists(" AND ", conditions);
		return executeNoQuery(query);
	}
	
	private boolean executeNoQuery(String query){
		try {		
			Connection conexion = DriverManager.getConnection(connection,user,password); 
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
			st.close();
			conexion.close();
			return true;
		}	
		catch (SQLException e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
}
