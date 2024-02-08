package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CHorarios {
String nombre;
String horas;
String fecha;
String restaurante;

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getHoras() {
	return horas;
}
public void setHoras(String horas) {
	this.horas = horas;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getRestaurante() {
	return restaurante;
}
public void setRestaurante(String restaurante) {
	this.restaurante = restaurante;
}
public void leerComboRestaurante(JComboBox comboRestaurantes) {
	
	try {
		BufferedReader br = new BufferedReader(new FileReader("restaurantes.txt"));
		String linea;
		
		while((linea = br.readLine()) != null) {
			StringTokenizer tonkens = new StringTokenizer(linea,",");
			 
			while(tonkens.hasMoreTokens()) {
				comboRestaurantes.addItem(tonkens.nextToken());
			}
		}
		br.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio  un problema");
	}
}


public void EditarHorarios(JTable tablaHorarios) {
	//Limpieza del archivo .txt
	
		try {
			PrintWriter writer = new PrintWriter("Horarios.txt");
			writer.print("");
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ocurrio un problema"+ e.toString());
		}
		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Horarios.txt")))) {
			StringJoiner joiner = new StringJoiner(",");
			for (int col = 0; col < tablaHorarios.getColumnCount(); col++) {
				joiner.add(tablaHorarios.getColumnName(col));
			}
			
			System.out.println(joiner.toString());
			bw.write(joiner.toString());
			bw.newLine();
			
			for (int row = 0; row < tablaHorarios.getRowCount(); row++) {
				joiner = new StringJoiner(",");
				for (int col = 0; col < tablaHorarios.getColumnCount(); col++) {
					
					Object obj = tablaHorarios.getValueAt(row, col);
					String value = obj == null ? "null" :obj.toString();
					joiner.add(value);
					
				}
				
				System.out.println(joiner.toString());
				bw.write(joiner.toString());
				bw.newLine();
			}

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error");
		}
		
}

public void agregarRegistrosHorarios() {
	try {
		FileWriter fw = new FileWriter("Horarios.txt",true);
		
		
		fw.write(getNombre());
		fw.write(",");
		fw.write(getRestaurante());
		fw.write(",");
		fw.write(getHoras());
		fw.write(",");
		fw.write(getFecha());
		fw.write("\n");
		fw.close();
		
		JOptionPane.showMessageDialog(null,"Se registro  correctamente");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio  un error al registrar" + e.toString());
	}
}

public void MostrarTotalHorarios(JTable tablaTotalHorarios) {
	
	String nombreArchivo = "Horarios.txt";
	
	File file = new File(nombreArchivo);
	
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String primeraLinea = br.readLine().trim();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Nombre");
		model.addColumn("Restaurante");
		model.addColumn("Horas");
		model.addColumn("Fecha");
		
		tablaTotalHorarios.setModel(model);
		
		Object[] tableLines = br.lines().toArray();
		
		for (int i = 0; i < tableLines.length; i++) {
			
			String line = tableLines[i].toString().trim();
			String[] datarow= line.split(",");
			model.addRow(datarow);
			tablaTotalHorarios.setModel(model);
		}
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
		
	}
}

public void seleccionarHorarios(JTable tablaHorarios) {
	
	try {
		
		int  fila = tablaHorarios.getSelectedRow();
		
		if (fila>=0) {
			
			setNombre(tablaHorarios.getValueAt(fila, 0).toString());
			setRestaurante(tablaHorarios.getValueAt(fila, 1).toString());
			setHoras(tablaHorarios.getValueAt(fila, 2).toString());
			setFecha(tablaHorarios.getValueAt(fila, 3).toString());
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
	}
	
}

public void EliminarHorarios (JTable tablaHorarios, JTextField nombre) {
	
	//Eliminación visual de la tabla
	DefaultTableModel model = (DefaultTableModel)tablaHorarios.getModel();
	
	for (int i = 0; i < model.getRowCount(); i++) {
		
		if(((String)model.getValueAt(i, 0)).equals(nombre.getText())) {	
			model.removeRow(i);
			break;
			
		}
	}
	//Limpieza del archivo .txt
	
	try {
		PrintWriter writer = new PrintWriter("Horarios.txt");
		writer.print("");
		writer.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio  un problema"+ e.toString());
	}
	
	//Creación de los nuevos registros luego de la eliminaciÓn
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Horarios.txt")))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tablaHorarios.getColumnCount(); col++) {
			joiner.add(tablaHorarios.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tablaHorarios.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tablaHorarios.getColumnCount(); col++) {
				
				Object obj = tablaHorarios.getValueAt(row, col);
				String value = obj == null ? "null" :obj.toString();
				joiner.add(value);
				
			}
			
			
			bw.write(joiner.toString());
			bw.newLine();
			JOptionPane.showMessageDialog(null, "Se elimino  correctamente");
		}

		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ocurrio un error");
	}
	
	
	
}

}
