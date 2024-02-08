import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
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
import java.net.URI;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	 private JPanel contentPane;

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    MenuPrincipal frame = new MenuPrincipal();
	                    frame.setVisible(true);

	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    public MenuPrincipal() {
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
	        Color colorOriginalBtn3 = btnNewButton_3.getBackground();
	        btnNewButton_3.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseEntered(java.awt.event.MouseEvent evt) {
	                // Cambiar el color de fondo cuando el mouse entra
	                btnNewButton_3.setBackground(new Color(192, 192, 192)); // Por ejemplo, gris claro
	            }

	            public void mouseExited(java.awt.event.MouseEvent evt) {
	                // Volver al color original cuando el mouse sale
	                btnNewButton_3.setBackground(colorOriginalBtn3); // Verde claro
	            }
	        });
	        btnNewButton_3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                DialogMenu objetoDialog = new DialogMenu();
	                objetoDialog.setVisible(rootPaneCheckingEnabled);
	            }
	        });
	        btnNewButton_3.setBounds(175, 50, 155, 55);
	        contentPane.add(btnNewButton_3);

	        JButton btnNewButton_4 = new JButton("Login");
	        Color colorOriginalBtn4 = btnNewButton_4.getBackground();
	        btnNewButton_4.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseEntered(java.awt.event.MouseEvent evt) {
	                // Cambiar el color de fondo cuando el mouse entra
	                btnNewButton_4.setBackground(new Color(192, 192, 192)); // Por ejemplo, gris claro
	            }

	            public void mouseExited(java.awt.event.MouseEvent evt) {
	                // Volver al color original cuando el mouse sale
	                btnNewButton_4.setBackground(colorOriginalBtn4); // Verde claro
	            }
	        });
	        btnNewButton_4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                DialogLogin objetoDialog = new DialogLogin();
	                objetoDialog.setVisible(rootPaneCheckingEnabled);
	            }
	        });
	        btnNewButton_4.setBounds(10, 50, 155, 55);
	        contentPane.add(btnNewButton_4);
	     // Agregar un botón para abrir Google Maps con una ubicación específica
	        JButton abrirMapsButton = new JButton("Ubicación del restaurante");
	        Color colorOriginalBtn5 = abrirMapsButton.getBackground();
	        abrirMapsButton.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseEntered(java.awt.event.MouseEvent evt) {
	                // Cambiar el color de fondo cuando el mouse entra
	            	abrirMapsButton.setBackground(new Color(192, 192, 192)); // Por ejemplo, gris claro
	            }

	            public void mouseExited(java.awt.event.MouseEvent evt) {
	                // Volver al color original cuando el mouse sale
	            	abrirMapsButton.setBackground(colorOriginalBtn5); // Verde claro
	            }
	        });
	        abrirMapsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                abrirMapasConUbicacion("40.4200122,-3.7059001"); // Puedes cambiar las coordenadas por las de tu restaurante
	            }
	        });
	        abrirMapsButton.setBounds(350, 50, 190, 55);
	        contentPane.add(abrirMapsButton);
	    }
	    // Método para abrir Google Maps con una ubicación específica
	    private void abrirMapasConUbicacion(String coordenadas) {
	        try {
	            // Crear la URL de Google Maps con las coordenadas
	            String url = "https://www.google.com/maps?q=" + coordenadas;

	            // Abrir la URL en el navegador web predeterminado
	            Desktop.getDesktop().browse(new URI(url));
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
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
