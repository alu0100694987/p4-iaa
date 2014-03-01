/**
 * @Author: Bruno Alessio Bibbó | Cristo González Rodríguez | Jorge Gómez Weyler
 * Fecha: 27/02/2014
 * Descripción: Clase ControlEmbalse - Representa al sistema de control del
 *              embalse y calcula la altura del agua.
 * 
 */

import java.io.*;

public class ControlEmbalse {
  
  private double altura;
  private Regla reglas[];
  
  ControlEmbalse(double h){
    
    altura = h;
    
    reglas = new Regla[3];
    reglas[0] = new Regla(new ErrorNegativo(), new AperturaCerrar());
    reglas[1] = new Regla(new ErrorCero(), new AperturaCerrar());
    reglas[2] = new Regla(new ErrorPositivo(), new AperturaAbrir());
  }
  
  void controlarAltura(int tiempo, String fichero) {
    
    FileWriter fw = null;
    double M_en, M_ec, M_ep;
    double intervalo = (Deposito.FINAL_APERTURA - Deposito.INICIO_APERTURA) / Deposito.N_PUNTOS; // Tamaño del intervalo entre puntos para el cálculo del centroide
    double x, vx, sum_x_vx, sum_vx;
    double error, apertura, agua;
    
    try{
      
      fw = new FileWriter(fichero);
      fw.write("0\t" + Deposito.H_INICIAL + "\n"); // Se escribe la altura inicial
      
      for (int s = 1; s <= tiempo; s++) {

        sum_x_vx = sum_vx = 0.0;
      
        // Calcular error:
      
        error = Deposito.H_DESEADA - altura;
      
        // Calcular funciones (nivel de error):
      
        M_en = reglas[0].getAntecedente().funcion(error);
        M_ec = reglas[1].getAntecedente().funcion(error);
        M_ep = reglas[2].getAntecedente().funcion(error);
      
        // Calcular apertura:
        
        for(int i = 0; i <= Deposito.N_PUNTOS; i++) {
          
          x = (i * intervalo) + Deposito.INICIO_APERTURA;
          vx = Math.max(Math.max(Math.min(reglas[0].getConsecuente().funcion(x), M_en), Math.min(reglas[1].getConsecuente().funcion(x), M_ec)), Math.min(reglas[2].getConsecuente().funcion(x), M_ep));
          sum_x_vx += x*vx;
          sum_vx += vx;
        }

        apertura = sum_x_vx / sum_vx;
        
        // Calcular nueva altura del agua:
        
        agua = (Deposito.W_INPUT * (apertura/100.0)) - Deposito.W_OUTPUT;
        altura += agua/100.0;
        
        // Escribir la altura en el fichero:
        
        fw.write(s + "\t" + altura + "\n");
      
      }
      
    } catch(IOException ex1){
      
      System.out.println("Error: Inicialización de fichero.");
      
    } finally {

      try {
        
        fw.close();
   
      } catch (IOException ex2) {
        
        System.out.println("Error: Cierre de fichero.");
      }
    }
  }
  
}
