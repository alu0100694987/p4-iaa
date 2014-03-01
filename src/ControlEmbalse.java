/**
 * @Author:
 * Fecha: 27/02/2014
 * E-mail:
 * Descripción: Clase ControlEmbalse - Representa al sistema de control del
 *              embalse y calcula la altura del agua.
 * 
 */

import java.io.*;

public class ControlEmbalse {
  
  private double h;
  private double error;
  
  ControlEmbalse(double altura){
    
    h = altura;
  }
  
  void controlarAltura(int tiempo, String fichero){
    
    FileWriter fr;
    double M_en, M_ec, M_ep;
    double Sum_Max, x, agua;
    
    try{
      
      fr = new FileWriter(fichero);
      Sum_Max = 0.0;
      
      // Calcular error:
      
      error = Deposito.H_DESEADA - h;
      
      // Calcular funciones (nivel de error):
      
      M_en = Funcion_error_negativo(error);
      M_ec = Funcion_error_cero(error);
      M_ep = Funcion_error_positivo(error);
      
      // Calcular apertura:
      
      for(int i = 0; i < 10000; i++){
        x = (i * 0.0125) - 25;
        Sum_Max += Math.max(Math.max(Math.min(Funcion_apertura_cerrar(x), M_en), Math.min(Funcion_apertura_cerrar(x), M_ec)), Math.min(Funcion_apertura_abrir(x), M_ep));
      }
        
      // Calcular nueva altura del agua:
      
      agua = (Deposito.W_INPUT * (Sum_Max/100)) - Deposito.W_OUTPUT;
      
    } catch(IOException ex){
      
      System.out.println(" Error: Inicialización de fichero.");
      
    } finally{
      
      fr.close();
    }
  }
  
}
