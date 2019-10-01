package Principal;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.ButtonGroup;


import javax.swing.JLabel;
import javax.swing.JTextField;

import dominio.Petdao;
import dominio.Pet;

import javax.swing.JRadioButton;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Veterinaria extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Veterinaria() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 430, 118);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 11, 94, 14);
		panel.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(49, 36, 38, 14);
		panel.add(lblEdad);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(49, 86, 48, 14);
		panel.add(lblSexo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(113, 8, 96, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(113, 33, 96, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);
		
		JRadioButton rdbtnHembra = new JRadioButton("Hembra");
		rdbtnHembra.setSelected(true);
		rdbtnHembra.setBounds(113, 82, 109, 23);
		panel.add(rdbtnHembra);
		
		JRadioButton rdbtnMacho = new JRadioButton("Macho");
		rdbtnMacho.setBounds(224, 82, 109, 23);
		panel.add(rdbtnMacho);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnHembra);
		grupo.add(rdbtnMacho);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pet x = new Pet();
				x.setNombre(txtNombre.getText());
				x.setEdad(txtEdad.getText());
				if(rdbtnHembra.isSelected())
				{
					x.setSexo("Hembra");
				}else
				{
					x.setSexo("Macho");
				}
				
				
				Petdao.addPet(x);
			}
		});
		btnAgregar.setBounds(307, 32, 89, 23);
		panel.add(btnAgregar);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		table.setBounds(20, 140, 420, 149);
		add(table);
		

	}
}
