
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JPanel;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @Author: Bruno Alessio Bibbó | Cristo González Rodríguez | Jorge Gómez Weyler
 * Fecha: 27/02/2014
 * Descripción: Clase encargada de crear el gráfico.
 *         
 */


public class swing {

		private JFreeChart grafica;
		private XYSeriesCollection datos;
		private String Titulo;				// Título de la gráfica.
		private String tx; 					// Nombre del atributo de las X.
		private String ty; 					// Nombre del atributo de las Y.
		
		final static int LINEAL = 1;
		final static int POLAR = 2;
		final static int DISPERSION = 3;
		final static int AREA = 4;
		final static int LOGARITMICA = 5;
		final static int SERIETIEMPO = 6;
		final static int PASO = 7;
		final static int PASOAREA = 8;
		
	
		swing(int Tipo, String titulo){  
			
			datos = new XYSeriesCollection();
			Titulo = titulo;
			tx = "Segundos";
			ty = "Altura";
			tipoGrafica(Tipo);
			
		}
		
		void tipoGrafica (int tipo){
			
			switch (tipo){
			case LINEAL:
				grafica= ChartFactory.createXYLineChart(Titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
				break;
			case POLAR: ChartFactory.createPolarChart(Titulo, datos, true, true, true);
				break;
			case DISPERSION:
				grafica = ChartFactory.createScatterPlot(Titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
				break;
			case AREA: 
				grafica = ChartFactory.createXYAreaChart(Titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
				break;
			case LOGARITMICA:
				grafica = ChartFactory.createXYLineChart(Titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
				XYPlot ejes = grafica.getXYPlot();
				NumberAxis rango = new LogarithmicAxis(ty);
				ejes.setRangeAxis(rango);
				break;
			case SERIETIEMPO:
				grafica = ChartFactory.createTimeSeriesChart(Titulo, tx, ty, datos, true, true, true);
				break;
			case PASO:
				grafica = ChartFactory.createXYStepChart(Titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
				break;
			case PASOAREA:
				grafica = ChartFactory.createXYStepAreaChart(Titulo, tx, tx, datos, PlotOrientation.VERTICAL, true, true, true);
				break;
			}
		}
		
		void agregarGrafica(String id) throws IOException{
			
			XYSeries s = new XYSeries(id);
			
			File archivo = new File("resultados.txt");
			FileReader lector = new FileReader(archivo);
			BufferedReader buffer = new BufferedReader(lector);
			
			String linea;
			while ((linea = buffer.readLine()) != null) {
				
				StringTokenizer st = new StringTokenizer(linea, "\n\t");
				
				int contadorTokens = 0;
				int x = 0;
				double y = 0.0;
				
				while (st.hasMoreTokens()) {
					
					String aux = st.nextToken();
					if (contadorTokens == 0){  // Si es el primer token hablamos del segundo correspondiente en el que se mide el agua.
						x = Integer.parseInt(aux);
						contadorTokens ++;
					}
					else                       // Si no, es la altura del agua.
						y = Double.parseDouble(aux);
				}
				s.add(x ,y);
			}
			
			lector.close();
			datos.addSeries(s); 
			
		}
		
		JPanel getPanel(){
			return new ChartPanel(grafica);
		}
}
		

