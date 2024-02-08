import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Clases.CAsegurados;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogGestionAsegurados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoAsegurado;
	private JTextField txtNombresAsegurados;
	private JTextField txtApellidosAsegurados;
	private JTextField txtEdad;
	private JTable tbListaAsegurados;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogGestionAsegurados dialog = new DialogGestionAsegurados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogGestionAsegurados() {
		setBounds(100, 100, 648, 351);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 45, 239, 263);
			contentPanel.setBackground(Color.LIGHT_GRAY);

			contentPanel.add(panel);
			{
				txtCodigoAsegurado = new JTextField();
				txtCodigoAsegurado.setColumns(10);
				txtCodigoAsegurado.setBounds(132, 24, 86, 20);
				panel.add(txtCodigoAsegurado);
			}
			
			{
				JLabel lblNewLabel_3 = new JLabel("DNI");
				lblNewLabel_3.setBounds(10, 27, 46, 14);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Sexo");
				lblNewLabel_4.setBounds(10, 121, 112, 14);
				panel.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Nombre");
				lblNewLabel_5.setBounds(10, 58, 112, 14);
				panel.add(lblNewLabel_5);
				Clases.CAsegurados objetoAsegurados = new Clases.CAsegurados();
			}
			{
				txtNombresAsegurados = new JTextField();
				txtNombresAsegurados.setColumns(10);
				txtNombresAsegurados.setBounds(132, 55, 86, 20);
				panel.add(txtNombresAsegurados);
				
			}
			
				JComboBox cbSexo = new JComboBox();
				cbSexo.setBounds(132, 117, 86, 22);
				panel.add(cbSexo);
				
				Clases.CAsegurados objetoAsegurados = new Clases.CAsegurados();
				objetoAsegurados.leerComboSexo(cbSexo);
		
			
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Clases.CAsegurados objetoAsegurados = new Clases.CAsegurados();
						objetoAsegurados.setCodigoAsegurados(txtCodigoAsegurado.getText());
						objetoAsegurados.setNombres(txtNombresAsegurados.getText());
						objetoAsegurados.setApellidos(txtApellidosAsegurados.getText());
						objetoAsegurados.setSexo(cbSexo.getSelectedItem().toString());
						objetoAsegurados.setEdad(txtEdad.getText());
						objetoAsegurados.agregarRegistrosAsegurados();
						
					}
				});
				btnGuardar.setBounds(7, 195, 99, 23);
				panel.add(btnGuardar);
			}
			
			{
				JButton btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Clases.CAsegurados objetoAsegurados = new Clases.CAsegurados();
						objetoAsegurados.EliminarAsegurados(tbListaAsegurados, txtCodigoAsegurado);
					}
				});
				btnEliminar.setBounds(7, 223, 208, 29);
				panel.add(btnEliminar);
			}
			{
				JLabel lblApellidos = new JLabel("Apellido");
				lblApellidos.setBounds(10, 83, 86, 14);
				panel.add(lblApellidos);
			}
			{
				txtApellidosAsegurados = new JTextField();
				txtApellidosAsegurados.setColumns(10);
				txtApellidosAsegurados.setBounds(132, 86, 86, 20);
				panel.add(txtApellidosAsegurados);
			}
			{
				JLabel lblContraseña = new JLabel("Contraseña");
				lblContraseña.setBounds(10, 179, 112, 14);
		        panel.add(lblContraseña);
			}
	        

	        {
	        	JPasswordField passwordField = new JPasswordField();
	        	  passwordField.setBounds(132, 176, 86, 20);
	  	        panel.add(passwordField);
	        }
	      
		
			{
				JLabel lblNewLabel = new JLabel("Edad");
				lblNewLabel.setBounds(10, 153, 46, 14);
				panel.add(lblNewLabel);
			}
			{
				txtEdad = new JTextField();
				txtEdad.setBounds(132, 150, 86, 20);
				panel.add(txtEdad);
				txtEdad.setColumns(10);
			}
			
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lista de Registros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(259, 45, 365, 263);
			contentPanel.add(panel_1);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 21, 345, 231);
				panel_1.add(scrollPane);
				{
					tbListaAsegurados = new JTable();
					scrollPane.setViewportView(tbListaAsegurados);
				}
			}
		}
		{
			JButton btnMostrarAsegurados = new JButton("Mostrar Registrados");
			btnMostrarAsegurados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Clases.CAsegurados objetoAsegurados = new Clases.CAsegurados();
					objetoAsegurados.MostrarTotalAsegurados(tbListaAsegurados);
				}
			});
			btnMostrarAsegurados.setBounds(259, 11, 136, 23);
			contentPanel.add(btnMostrarAsegurados);
		}
		{
		
			
		}
		{
			JButton btnSeleccionarAsegurados = new JButton("Seleccionar");
			btnSeleccionarAsegurados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Clases.CAsegurados objetoAsegurados = new Clases.CAsegurados();
					objetoAsegurados.seleccionarAsegurados(tbListaAsegurados);
					txtCodigoAsegurado.setText(objetoAsegurados.getCodigoAsegurados());
					txtNombresAsegurados.setText(objetoAsegurados.getNombres());
					txtApellidosAsegurados.setText(objetoAsegurados.getApellidos());
					txtEdad.setText(objetoAsegurados.getEdad());
				}
			});
			btnSeleccionarAsegurados.setBounds(535, 11, 89, 23);
			contentPanel.add(btnSeleccionarAsegurados);
		}
	}

}
