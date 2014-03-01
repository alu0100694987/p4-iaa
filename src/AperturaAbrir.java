/**
 * @Author: Bruno Alessio Bibb� | Cristo Gonz�lez Rodr�guez | Jorge G�mez Weyler
 * Fecha: 27/02/2014
 * Descripci�n: Funci�n de apertura abrir
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
