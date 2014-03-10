import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @Author: Bruno Alessio Bibbó | Cristo González Rodríguez | Jorge Gómez Weyler
 * Fecha: 27/02/2014
 * Descripción: Clase encargada de dibujar la gráfica.
 *         
 */

public class Dibujar extends JFrame {
	
	
	private static final long serialVersionUID = -1542283333352975962L;
	private swing Grafica;
	private JPanel panel;
	
	Dibujar() throws IOException{
	 Grafica = new swing(3, "Gráfico Resultante");
	 Grafica.agregarGrafica("Altura del agua");
	 panel = Grafica.getPanel();
	 this.setSize(800,600);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.add(panel);
	 this.setVisible(true);
	 
	}
}
