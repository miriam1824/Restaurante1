import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal2 extends JFrame {

	 private JPanel contentPane;

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    MenuPrincipal2 frame = new MenuPrincipal2();
	                    frame.setVisible(true);

	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    public MenuPrincipal2() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 800, 505);

	        // Cargar la imagen de fondo (ajusta la ruta según la ubicación de tu imagen)
	        Image imagenFondo = new ImageIcon("restaurante.jpg").getImage();

	        // Crear un panel de fondo personalizado con la imagen
	        contentPane = new FondoPanel(imagenFondo);
	        contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel titleLabel = new JLabel("RESTAURANTE");
	        titleLabel.setBounds(10, 10, 800, 20);
	        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        titleLabel.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
	        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
	        contentPane.add(titleLabel);

	        JButton btnNewButton_3 = new JButton("Carta");
	        btnNewButton_3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                DialogMenu objetoDialog = new DialogMenu();
	                objetoDialog.setVisible(rootPaneCheckingEnabled);
	            }
	        });
	        btnNewButton_3.setBounds(340, 50, 155, 55);
	        contentPane.add(btnNewButton_3);
	        JButton btnNewButton_5 = new JButton("Gestion Reservas");
	        btnNewButton_5.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                DialogGestionHorarios objetoDialog = new DialogGestionHorarios();
	                objetoDialog.setVisible(rootPaneCheckingEnabled);
	            }
	        });
	        btnNewButton_5.setBounds(175, 50, 155, 55);
	        contentPane.add(btnNewButton_5);
	        
	        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
	        btnCerrarSesion.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	MenuPrincipal menuPrincipal = new MenuPrincipal();
	            	menuPrincipal.setVisible(rootPaneCheckingEnabled);
	            }
	        });
	        btnCerrarSesion.setBounds(505, 50, 155, 55);
	        contentPane.add(btnCerrarSesion);
	    }

	    private static class FondoPanel extends JPanel {

	        private Image imagenFondo;

	        public FondoPanel(Image imagenFondo) {
	            this.imagenFondo = imagenFondo;
	        }

	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            // Dibujar la imagen de fondo
	            if (imagenFondo != null) {
	                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
	            }
	        }
	    }

}
