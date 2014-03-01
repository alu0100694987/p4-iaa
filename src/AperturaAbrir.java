/**
 * @Author: Bruno Alessio Bibbó | Cristo González Rodríguez | Jorge Gómez Weyler
 * Fecha: 27/02/2014
 * Descripción: Función de apertura abrir
 *         
 */
public class AperturaAbrir implements IFuncion {
  
  public double funcion(double x){
    if((0<=x) && (x<=50))
      return (x/50.0);
    else if(50<=x)
      return 1.0;
    else 
      return 0.0;
  }
}
