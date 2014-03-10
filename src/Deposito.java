
/**
 * @Author: Bruno Alessio Bibb� | Cristo Gonz�lez Rodr�guez | Jorge G�mez Weyler
 * Fecha: 27/02/2014
 * Descripci�n: Main - Sistema de control de un dep�sito de agua.
 * 
 */
public class Deposito {

  final static double H_DESEADA = 20.0; // Altura deseada (m)
  final static double H_INICIAL = 19.0; // Altura inicial (i)
  final static double W_INPUT = 0.4; // Entrada de agua (m3) con la v�lvula abierta
  final static double W_OUTPUT = 0.1; // Salida de agua (m3) por la turbina
  final static int TIEMPO = 18000; // Tiempo (s) de control del dep�sito
  final static int N_PUNTOS = 10000; // Cantidad de puntos para el c�lculo del centroide
  final static double INICIO_APERTURA = -25.0; // Inicio del rango de valores que puede tomar la apertura
  final static double FINAL_APERTURA = 100.0; // Final del rango de valores que puede tomar la apertura
  final static String FICHERO = "resultados.txt";
  
  public static void main(String[] args) {
    
    /* Sistema de control del dep�sito */
    ControlEmbalse CE = new ControlEmbalse(H_INICIAL);
    
    /* Activar el sistema de control durante 'TIEMPO' segundos */
    CE.controlarAltura(TIEMPO, FICHERO);
  }

}
