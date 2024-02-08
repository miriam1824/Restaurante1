import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Clases.CHorarios;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogGestionHorarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtHoras;
	private JTextField txtFecha;
	private JTable tbListaHorarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogGestionHorarios dialog = new DialogGestionHorarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogGestionHorarios() {
		setBounds(100, 100, 628, 333);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Horarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 45, 239, 239);
			contentPanel.add(panel);
			{
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(132, 24, 86, 20);
				panel.add(txtNombre);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Nombre");
				lblNewLabel_3.setBounds(10, 27, 46, 14);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Restaurantes");
				lblNewLabel_4.setBounds(10, 68, 112, 14);
				panel.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Horas");
				lblNewLabel_5.setBounds(10, 106, 112, 14);
				panel.add(lblNewLabel_5);
			}
			{
				txtHoras = new JTextField();
				txtHoras.setColumns(10);
				txtHoras.setBounds(132, 103, 86, 20);
				panel.add(txtHoras);
			}
			
			JComboBox cbRestaurantes = new JComboBox();
			cbRestaurantes.setBounds(132, 64, 86, 22);
			panel.add(cbRestaurantes);
			Clases.CHorarios objetoHorarios = new Clases.CHorarios();
			objetoHorarios.leerComboRestaurante(cbRestaurantes);
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Clases.CHorarios objetoHorarios = new Clases.CHorarios();
						objetoHorarios.setNombre(txtNombre.getText());
						objetoHorarios.setRestaurante(cbRestaurantes.getSelectedItem().toString());
						objetoHorarios.setHoras(txtHoras.getText());
						objetoHorarios.setFecha(txtFecha.getText());
						objetoHorarios.agregarRegistrosHorarios();
						
					}
				});
				btnGuardar.setBounds(10, 171, 99, 23);
				panel.add(btnGuardar);
			}
			{
				JButton btnEditar = new JButton("Editar");
				btnEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Clases.CHorarios objetoHorarios = new Clases.CHorarios();
						objetoHorarios.EditarHorarios(tbListaHorarios);
					}
				});
				btnEditar.setBounds(109, 171, 112, 23);
				panel.add(btnEditar);
			}
			{
				JButton btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Clases.CHorarios objetoHorarios = new Clases.CHorarios();
						objetoHorarios.EliminarHorarios(tbListaHorarios, txtNombre);
					}
				});
				btnEliminar.setBounds(10, 199, 208, 29);
				panel.add(btnEliminar);
			}
			{
				JLabel lblFecha = new JLabel("Fecha");
				lblFecha.setBounds(10, 146, 86, 14);
				panel.add(lblFecha);
			}
			{
				txtFecha = new JTextField();
				txtFecha.setColumns(10);
				txtFecha.setBounds(132, 140, 86, 20);
				panel.add(txtFecha);
			}
			{
				
			}
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lista de Horarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(248, 45, 354, 239);
			contentPanel.add(panel_1);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 21, 334, 207);
				panel_1.add(scrollPane);
				{
					tbListaHorarios = new JTable();
					scrollPane.setViewportView(tbListaHorarios);
				}
			}
		}
		{
			JButton btnMostrarHorarios = new JButton("Mostrar Horarios");
			btnMostrarHorarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Clases.CHorarios objetoHorarios = new Clases.CHorarios();
					objetoHorarios.MostrarTotalHorarios(tbListaHorarios);
				}
			});
			btnMostrarHorarios.setBounds(259, 11, 134, 23);
			contentPanel.add(btnMostrarHorarios);
		}
		{
			JButton btnSeleccionarHorarios = new JButton("Seleccionar");
			btnSeleccionarHorarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Clases.CHorarios objetoHorarios = new Clases.CHorarios();
					objetoHorarios.seleccionarHorarios(tbListaHorarios);
					txtNombre.setText(objetoHorarios.getNombre());
					txtHoras.setText(objetoHorarios.getHoras());
					txtFecha.setText(objetoHorarios.getHoras());
				}
			});
			btnSeleccionarHorarios.setBounds(450, 11, 135, 23);
			contentPanel.add(btnSeleccionarHorarios);
		}
	}

}