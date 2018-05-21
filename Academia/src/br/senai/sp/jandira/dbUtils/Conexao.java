package br.senai.sp.jandira.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static Connection con;
	
	public static Connection abrirConexao(){
		con = null;
		
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String dbURL = "jdbc:ucanaccess://C:/academia.accdb";
			con = DriverManager.getConnection(dbURL);
		} catch (Exception erro){
			System.out.println(erro.getMessage());
		}
		
		return con;
	}
}
