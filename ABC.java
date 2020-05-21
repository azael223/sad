package com.abc;

import java.util.*;

class ABC {
	protected String table;
	protected String connection;
	protected String password;
	protected String user;
	public List<String> attributes;
	
	public ABC(String table, String connection, String user, String password, List<String> attributes) {
		this.table=table;
		this.connection=connection;
		this.attributes=attributes;
		this.password=password;
		this.user=user;
	}
	
	protected String appendLists (String separator, List<String> list) {
		String str="";
		for(int i=0; i<list.size()-1;i++) {
			str+=list.get(i)+separator;
		}
		str+= list.get(list.size()-1);
		return str;
	}
	 protected String appendDoubleList(String separator, String separator2, List<String> list, List<String> list2)
     {
         String str = "";
         for (int i = 0; i < list.size() - 1; i++)
             str += list.get(i) + separator + list2.get(i) + separator2;
         str += list.get(list.size()-1) + separator + list2.get(list2.size()-1);
         return str;
     }
	 public String getTable() {
		 return table;
	 }
	 public String getConnection() {
		 return connection;
	 }
	 public String getPassword() {
		 return password;
	 }
	 public String getUser() {
		 return user;
	 }
	 public List<String> getAttributes(){
		 return attributes;
	 }
}
