
/**
 * @Author: Bruno Alessio Bibbó | Cristo González Rodríguez | Jorge Gómez Weyler
 * Fecha: 27/02/2014
 * Descripción: Main - Sistema de control de un depósito de agua.
 * 
 */
public class Deposito {

  final static double H_DESEADA = 20.0; // Altura deseada (m)
  final static double H_INICIAL = 19.0; // Altura inicial (i)
  final static double W_INPUT = 0.4; // Entrada de agua (m3) con la válvula abierta
  final static double W_OUTPUT = 0.1; // Salida de agua (m3) por la turbina
  final static int TIEMPO = 18000; // Tiempo (s) de control del depósito
  final static int N_PUNTOS = 10000; // Cantidad de puntos para el cálculo del centroide
  final static double INICIO_APERTURA = -25.0; // Inicio del rango de valores que puede tomar la apertura
  final static double FINAL_APERTURA = 100.0; // Final del rango de valores que puede tomar la apertura
  final static String FICHERO = "resultados.txt";
  
  public static void main(String[] args) {
    
    /* Sistema de control del depósito */
    ControlEmbalse CE = new ControlEmbalse(H_INICIAL);
    
    /* Activar el sistema de control durante 'TIEMPO' segundos */
    CE.controlarAltura(TIEMPO, FICHERO);
  }

}
