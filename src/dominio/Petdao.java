package dominio;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;

public class Petdao {

	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass = "root";
	private static String dbName = "Veterinaria";
	
	
	
	public Petdao()
	{
		
	}
	
	public int agregarUsuario(Pet pet)
	{
		String query = "Insert into usuario(Nombre,Edad,Sexo) values ('"+pet.getNombre()+"','"+pet.getEdad()+"','"+pet.getSexo()+"')";
		Connection cn = null;
		int filas=0;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
		
	}
	
	
	public static ArrayList<Pet> obtenerTodos()
	{
		ArrayList<Pet> lPet = new ArrayList<Pet>();
		 
		Connection cn = null;
		  try
		  {
			 cn = DriverManager.getConnection(host+dbName,user,pass);
			 String query = "Select * from mascotas";
			 Statement st = cn.createStatement();
			 ResultSet rs = st.executeQuery(query);
			 while(rs.next())
			 {	
				 Pet x = new Pet();
				 x.setId(rs.getInt("id"));
				 x.setNombre(rs.getString("nombre"));
				 x.setEdad(rs.getString("Edad"));
				 x.setSexo(rs.getString("Sexo"));
				 lPet.add(x); 
			 }
			 
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
		  return lPet;
	}
	


	
	public static void addPet(Pet pet)
	{
		Connection cn = null;
		  try
		  {
			 cn = DriverManager.getConnection(host+dbName,user,pass);
			 CallableStatement cst = cn.prepareCall("CALL addPet(?,?,?)");
			 cst.setString(1, pet.getNombre());
			 cst.setString(2, pet.getEdad());
			 cst.setString(3, pet.getSexo());
			 cst.execute();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
			
	}
  
	 
}
