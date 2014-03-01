/**
 * @Author: Bruno Alessio Bibbó | Cristo González Rodríguez | Jorge Gómez Weyler
 * Fecha: 27/02/2014
 * Descripción: Función de apertura cerrar
 *         
 */
public class AperturaCerrar implements IFuncion {
  
  public double funcion(double x){
    if((-25<=x) && (x<=0))
      return ((25.0+x)/25.0);
    else if((0<=x) && (x<=25))
      return((25.0-x)/25.0);
    else 
      return 0.0;
  }
}
