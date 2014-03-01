import java.util.Scanner;

/**
 * @Author:
 * Fecha: 27/02/2014
 * E-mail:
 * Descripción: Main - Sistema de control de un depósito de agua.
 * 
 */
public class Deposito {

  final static double H_DESEADA = 20.0; // Altura deseada (m)
  final static double H_INICIAL = 19.0; // Altura inicial (i)
  final static double W_INPUT = 0.4; // Entrada de agua (m3) con la válvula abierta
  final static double W_OUTPUT = 0.1; // Salida de agua (m3) por la turbina
  final static int TIEMPO = 18000; // Tiempo (s) de control del depósito
  
  public static void main(String[] args) {
    
    /* Sistema de control del depósito */
    ControlEmbalse CE = new ControlEmbalse(H_INICIAL);
    
    /* Introducción por teclado del nombre del fichero */
    System.out.print(" Fichero a analizar: ");
    
    Scanner sc = new Scanner(System.in);
    String fichero = sc.nextLine();
    
    /* Activar el sistema de control durante 'TIEMPO' segundos */
    CE.controlarAltura(TIEMPO, fichero);
    
    sc.close();

  }

}
