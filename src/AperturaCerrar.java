/**
 * @Author: Bruno Alessio Bibb� | Cristo Gonz�lez Rodr�guez | Jorge G�mez Weyler
 * Fecha: 27/02/2014
 * Descripci�n: Funci�n de apertura cerrar
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
