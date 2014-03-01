/**
 * @Author: Bruno Alessio Bibb� | Cristo Gonz�lez Rodr�guez | Jorge G�mez Weyler
 * Fecha: 27/02/2014
 * Descripci�n: Funci�n de error positivo
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
