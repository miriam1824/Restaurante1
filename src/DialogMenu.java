import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Clases.CMenu;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class DialogMenu extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCodigoCompra;
    private JTextField txtDescripcionArticulo;
    private JTextField txtPrecioArticulo;
    private JTable tbListaCompras;
    private JTextField txtNombreArticulo;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DialogMenu dialog = new DialogMenu();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public DialogMenu() {
        setBounds(60, 60, 600, 500);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.LIGHT_GRAY);
        JLabel titleLabel = new JLabel("CARTA DEL RESTAURANTE");
        titleLabel.setBounds(10, 10, 600, 20);
        Font titleFont = new Font("Arial", Font.BOLD, 24); // Puedes ajustar la fuente y el tamaño según tus preferencias
        titleLabel.setFont(titleFont);

        // Ajustar la posición y el tamaño del título
        int titleWidth = 600;
        int titleHeight = 40; // Puedes ajustar la altura según tus preferencias
        titleLabel.setBounds(10, 10, titleWidth, titleHeight);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel);

        // Crear etiquetas para las imágenes
        JLabel label = crearLabelConImagen("./Imagenes/1.jpg");
        JLabel label2 = crearLabelConImagen("./Imagenes/2.jpg");
        JLabel label3 = crearLabelConImagen("./Imagenes/3.jpg");
        JLabel label4 = crearLabelConImagen("./Imagenes/4.jpg");
        JLabel label5 = crearLabelConImagen("./Imagenes/5.jpg");
        JLabel label6 = crearLabelConImagen("./Imagenes/6.jpg");

        // Establecer la posición y el tamaño de las etiquetas
        int xPosition = 80;
        int yPositionTop = 80;
        int yPositionBottom = 200;
        int labelWidth = 180;
        int labelHeight = 180;
        
        label.setBounds(xPosition, yPositionTop, labelWidth, labelHeight);
        label2.setBounds(xPosition + 150, yPositionTop, labelWidth, labelHeight);
        label3.setBounds(xPosition + 300, yPositionTop, labelWidth, labelHeight);

        label4.setBounds(xPosition, yPositionBottom, labelWidth, labelHeight);
        label5.setBounds(xPosition + 150, yPositionBottom, labelWidth, labelHeight);
        label6.setBounds(xPosition + 300, yPositionBottom, labelWidth, labelHeight);

        // Agregar las etiquetas al panel de contenido
        contentPanel.add(label);
        contentPanel.add(label2);
        contentPanel.add(label3);
        contentPanel.add(label4);
        contentPanel.add(label5);
        contentPanel.add(label6);

        // Hacer visible el panel de contenido
        contentPanel.setVisible(true);
    }

    private JLabel crearLabelConImagen(String rutaImagen) {
        ImageIcon icon = new ImageIcon(rutaImagen);
        icon.setImage(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

        JLabel label = new JLabel(icon);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirNuevaVentanaConImagen(icon);
            }
        });

        return label;
    }

    private void abrirNuevaVentanaConImagen(ImageIcon imagen) {
    	JFrame nuevaVentana = new JFrame("Alimento seleccionado");
    	nuevaVentana.setLayout(new BorderLayout());
    	nuevaVentana.setBackground(Color.LIGHT_GRAY);
    	// Ajustar el tamaño de la JLabel (imagen) para hacerla más grande
        int nuevoAnchoImagen = imagen.getIconWidth() * 1;  // Puedes ajustar el factor de escala según tus necesidades
        int nuevoAltoImagen = imagen.getIconHeight() * 1;  // Puedes ajustar el factor de escala según tus necesidades
        JLabel nuevaLabel = new JLabel(imagen);
        nuevaLabel.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(nuevoAnchoImagen, nuevoAltoImagen, Image.SCALE_SMOOTH)));
   
        nuevaVentana.add(nuevaLabel, BorderLayout.NORTH);
       
        String detalles = obtenerDetallesDeImagen(imagen);
     // Configurar contenido específico para los detalles
        JLabel labelDetalles = new JLabel("<html><body><div style='text-align: center;'>" + detalles + "</div></body></html>");
        labelDetalles.setHorizontalAlignment(JLabel.CENTER);
        nuevaVentana.add(labelDetalles, BorderLayout.CENTER);
        // Obtener el ancho y alto de la imagen
        int anchoImagen = imagen.getIconWidth();
        int altoImagen = imagen.getIconHeight();

        // Ajustar el tamaño de la nueva ventana según el tamaño de la imagen
        nuevaVentana.setSize(anchoImagen + 300, altoImagen + 300);

        nuevaVentana.setLocationRelativeTo(null);
        nuevaVentana.setVisible(true);
    
    }
    
    private String obtenerDetallesDeImagen(ImageIcon imagen) {
        // Lógica para obtener detalles basados en la imagen seleccionada
        String nombreImagen = imagen.getDescription();

         if ("./Imagenes/1.jpg".equals(nombreImagen)) {
                return "<h1>Ingredientes</h1><li>½ lechuga</li><li>1 paquete de tomates cherry</li><li>½ cebolla morada</li><li>1 pepino</li><li>1 lata de olivas negras</li><li>1 trozo de pimiento</li>";
            } else if ("./Imagenes/2.jpg".equals(nombreImagen)) {
            	return "<h1>Ingredientes</h1><li>1Kg Carne picada</li><li>1 Cebolla</li><li>1 Huevo</li><li>3 Dientes de ajo</li><li>Perejil</li><li>Sal</li><li>Pimienta</li><li>Salsa de mostaza</li><li>1 Pieza de pan duro </li><li>Aceite de oliva</li>";
            }else if("./Imagenes/3.jpg".equals(nombreImagen)){
            	return "<h1>Ingredientes</h1><li>500 g de Carne picada de ternera</li><li>1 Cebolla pequeña</li><li>1 Chile verde fresco</li><li>2 Dientes de ajo</li><li>1 Cucharada de orégano</li>";
            }

            return "<li>Elemento de lista predeterminado</li>";
    }
   
}