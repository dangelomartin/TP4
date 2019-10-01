package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dominio.Pet;
import dominio.Petdao;
import dominio.Tabla;

public class VeterinariaF extends JFrame {

	private JPanel contentPane;
	//

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeterinariaF frame = new VeterinariaF();
					Tabla.Lista(Petdao.obtenerTodos());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public VeterinariaF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 430, 118);
		getContentPane().add(panel);
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
				txtNombre.setText("");
				txtEdad.setText("");
				rdbtnHembra.setSelected(true);
				
				
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
		getContentPane().add(table);
		table.getModel();
		table.setModel(Tabla.tabla);

	}

}
