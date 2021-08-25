// register the driver class
Class.forName() 

// com.mysql.jbc.Driver
// jdbc:mysql://localhost:3306/shweta

//create database sonu;
// use sonu;

// create table employee(id int(5), name varchar(40));


import java.sql.*;

class A{
	public static void main(String args[]){
		try{
			// register
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection();
			

		}
	}
}
