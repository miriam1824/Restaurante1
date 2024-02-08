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

public class CAsegurados {
String codigoAsegurados;
String nombres;
String apellidos;
String sexo;
String edad;

public String getCodigoAsegurados() {
	return codigoAsegurados;
}
public void setCodigoAsegurados(String codigoAsegurados) {
	this.codigoAsegurados = codigoAsegurados;
}
public String getNombres() {
	return nombres;
}
public void setNombres(String nombres) {
	this.nombres = nombres;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public String getEdad() {
	return edad;
}
public void setEdad(String edad) {
	this.edad = edad;
}

public void leerComboSexo(JComboBox comboSexo) {
	
	try {
		BufferedReader br = new BufferedReader(new FileReader("Sexo.txt"));
		String linea;
		
		while((linea = br.readLine()) != null) {
			StringTokenizer tonkens = new StringTokenizer(linea,",");
			 
			while(tonkens.hasMoreTokens()) {
				comboSexo.addItem(tonkens.nextToken());
			}
		}
		br.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un problema");
	}
}


public void agregarRegistrosAsegurados() {
	try {
		FileWriter fw = new FileWriter("Asegurados.txt",true);
		
		
		fw.write(getCodigoAsegurados());
		fw.write(",");
		fw.write(getNombres());
		fw.write(",");
		fw.write(getApellidos());
		fw.write(",");
		fw.write(getSexo());
		fw.write(",");
		fw.write(getEdad());
		fw.write("\n");
		fw.close();
		
		JOptionPane.showMessageDialog(null,"Se registro correctamente");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error al registrar" + e.toString());
	}
}

public void MostrarTotalAsegurados(JTable tablaTotalAsegurados) {
	
	String nombreArchivo = "Asegurados.txt";
	
	File file = new File(nombreArchivo);
	
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String primeraLinea = br.readLine().trim();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("DNI");
		model.addColumn("Nombres");
		model.addColumn("Apellidos");
		model.addColumn("Sexo");
		model.addColumn("Edad");
		
		tablaTotalAsegurados.setModel(model);
		
		Object[] tableLines = br.lines().toArray();
		
		for (int i = 0; i < tableLines.length; i++) {
			
			String line = tableLines[i].toString().trim();
			String[] datarow= line.split(",");
			model.addRow(datarow);
			tablaTotalAsegurados.setModel(model);
		}
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
		
	}
}

public void seleccionarAsegurados(JTable tablaAsegurados) {
	
	try {
		
		int  fila = tablaAsegurados.getSelectedRow();
		
		if (fila>=0) {
			
			setCodigoAsegurados(tablaAsegurados.getValueAt(fila, 0).toString());
			setNombres(tablaAsegurados.getValueAt(fila, 1).toString());
			setApellidos(tablaAsegurados.getValueAt(fila, 2).toString());
			setSexo(tablaAsegurados.getValueAt(fila, 3).toString());
			setEdad(tablaAsegurados.getValueAt(fila, 4).toString());
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
	}
	
}

public void EliminarAsegurados (JTable tablaAsegurados, JTextField codigoAsegurado) {
	
	//Eliminaci�n visual de la tabla
	DefaultTableModel model = (DefaultTableModel)tablaAsegurados.getModel();
	
	for (int i = 0; i < model.getRowCount(); i++) {
		
		if(((String)model.getValueAt(i, 0)).equals(codigoAsegurado.getText())) {	
			model.removeRow(i);
			break;
			
		}
	}
	//Limpieza del archivo .txt
	
	try {
		PrintWriter writer = new PrintWriter("Asegurados.txt");
		writer.print("");
		writer.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un problema"+ e.toString());
	}
	
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Asegurados.txt")))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tablaAsegurados.getColumnCount(); col++) {
			joiner.add(tablaAsegurados.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tablaAsegurados.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tablaAsegurados.getColumnCount(); col++) {
				
				Object obj = tablaAsegurados.getValueAt(row, col);
				String value = obj == null ? "null" :obj.toString();
				joiner.add(value);
				
			}
			
			
			bw.write(joiner.toString());
			bw.newLine();
			JOptionPane.showMessageDialog(null, "Se elimino correctamente");
		}

		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ocurrio un error");
	}
	
	
	
}

}
