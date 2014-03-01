/**
 * @Author: Bruno Alessio Bibbó | Cristo González Rodríguez | Jorge Gómez Weyler
 * Fecha: 27/02/2014
 * Descripción: Función de error positivo
 *         
 */
public class ErrorPositivo implements IFuncion {
  
  public double funcion(double x){
    if((0<=x) && (x<=10))
      return (x/10.0);
    else if((10<=x)&&(x<=15))
      return 1.0;
    else 
      return 0.0;
  }
}
