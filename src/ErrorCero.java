/**
 * @Author: Bruno Alessio Bibb� | Cristo Gonz�lez Rodr�guez | Jorge G�mez Weyler
 * Fecha: 27/02/2014
 * Descripci�n: Funci�n de error cero
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
