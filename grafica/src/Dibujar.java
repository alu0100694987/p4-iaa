import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @Author: Bruno Alessio Bibb� | Cristo Gonz�lez Rodr�guez | Jorge G�mez Weyler
 * Fecha: 27/02/2014
 * Descripci�n: Clase encargada de dibujar la gr�fica.
 *         
 */

public class Dibujar extends JFrame {
	
	
	private static final long serialVersionUID = -1542283333352975962L;
	private swing Grafica;
	private JPanel panel;
	
	Dibujar() throws IOException{
	 Grafica = new swing(3, "Gr�fico Resultante");
	 Grafica.agregarGrafica("Altura del agua");
	 panel = Grafica.getPanel();
	 this.setSize(800,600);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.add(panel);
	 this.setVisible(true);
	 
	}
}
