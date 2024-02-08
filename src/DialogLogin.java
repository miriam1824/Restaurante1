import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogLogin extends JFrame {


	private JTextField textFieldUsuario;
    private JPasswordField passwordField;
    private JButton btnLogin;
    
    public static void main(String[] args) {
        try {
        	DialogLogin dialog = new DialogLogin();
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public DialogLogin() {

    	setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setResizable(true);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Puedes cambiar la ruta de la imagen según la ubicación de tu imagen
                ImageIcon background = new ImageIcon("./Imagenes/login.jpg");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblTitulo = new JLabel("Bienvenido al Restaurante");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitulo, gbc);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setForeground(Color.WHITE);  // Color del texto
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(lblUsuario, gbc);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setPreferredSize(new Dimension(150, 25));
        textFieldUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));  // Borde del campo de texto
        gbc.gridx = 1;
        panel.add(textFieldUsuario, gbc);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblContrasena, gbc);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 25));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        btnLogin.setBackground(new Color(50, 150, 50));  // Color de fondo del botón
        btnLogin.setForeground(Color.WHITE);  // Color del texto del botón
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(btnLogin, gbc);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogGestionAsegurados objetoDialog = new DialogGestionAsegurados();
                objetoDialog.setVisible(rootPaneCheckingEnabled);
            }
        });
        btnRegistrar.setBackground(new Color(30, 144, 255));
        btnRegistrar.setForeground(Color.WHITE);
        gbc.gridx = 1;
        panel.add(btnRegistrar, gbc);

        getContentPane().add(panel, BorderLayout.CENTER);
    }
    
    

    private void login() {
    	   // Obtener los datos ingresados por el usuario
        String enteredUsername = textFieldUsuario.getText();
        char[] enteredPasswordChars = passwordField.getPassword();
        String enteredPassword = new String(enteredPasswordChars);

        // Verificar si los campos están vacíos
        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa ambos campos.");
            return;  // No continúes con la autenticación si hay campos vacíos
        }

        // Verificar si el nombre de usuario contiene caracteres especiales
        if (!enteredUsername.matches("^[a-zA-Z0-9]+$")) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario no puede contener caracteres especiales.");
            return;  // No continúes con la autenticación si hay caracteres especiales en el nombre de usuario
        }

     // Verificar la longitud de la contraseña
        if (enteredPassword.length() < 8) {
            JOptionPane.showMessageDialog(this, "La contraseña tiene que exceder los 8 caracteres.");
            return;  // No continúes con la autenticación si la contraseña no excede la longitud permitida
        }
        
        // Verificar las credenciales (puedes cambiar estas credenciales)
        String validUsername = "pepito";
        String validPassword = "12345678";

        // Realizar la autenticación
        if (enteredUsername.equals(validUsername) && enteredPassword.equals(validPassword)) {
        	openMenuPrincipal();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas. Inténtalo de nuevo.");
            // Puedes agregar más lógica aquí, como contar intentos fallidos, etc.
        }
    }
    private void openMenuPrincipal() {
        
        MenuPrincipal2 menuPrincipal2 = new MenuPrincipal2();
        menuPrincipal2.setVisible(true);

        // Close the current login window if necessary
        this.dispose();
    }
    
	
}
