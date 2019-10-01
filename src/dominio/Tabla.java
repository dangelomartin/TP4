package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class Tabla {

	private static Object[] columnas = {"id","Nombre", "Edad", "Sexo"};
	public static DefaultTableModel tabla;
	
	public static final ArrayList<Pet> Lista (ArrayList<Pet> Pets)
	{
		tabla = new DefaultTableModel (new Object [0][0], columnas);
		
		for (Pet pet : Pets)	
		{
			Object[] x = new Object [4];
			x[0]=pet.getId();
			x[1]=pet.getNombre();
			x[2]=pet.getEdad();
			x[3]=pet.getSexo();
			tabla.addRow(x);
		}
		
		return tabla;
	}
	
	
}

