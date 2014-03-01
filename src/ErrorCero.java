/**
 * @Author: Bruno Alessio Bibbó | Cristo González Rodríguez | Jorge Gómez Weyler
 * Fecha: 27/02/2014
 * Descripción: Función de error cero
 *         
 */
public class ErrorCero implements IFuncion {
  
  public double funcion (double x){
    if((-5<=x) && (x<=0))
      return ((5.0+x)/5.0);
    else if((0<=x)&&(x<=5.0))
      return ((5.0-x)/5.0);
    else 
      return 0;
  }
}
