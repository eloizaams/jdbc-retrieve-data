package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
			
		Connection conn = null; // conecta ao banco de dados
		Statement st = null; // realiza a consulta  
		ResultSet rs = null; // retorna uma tabela com o resultado da consulta feita ao banco de dados
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			rs = st.executeQuery("select * from department");
			
			while(rs.next()) {
				System.out.println(rs.getInt("Id") + "- " + rs.getString("Name"));
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatment(st);
			DB.closeConnection();
		}
	}

}
