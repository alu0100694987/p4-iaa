/**
 * @Author: Bruno Alessio Bibb� | Cristo Gonz�lez Rodr�guez | Jorge G�mez Weyler
 * Fecha: 27/02/2014
 * Descripci�n: Clase Regla - Representa a cada una de las reglas del embalse,
 *              dada por un antecedente y un consecuente.
 *         
 */
public class Regla {
  
  private IFuncion antecedente;
  private IFuncion consecuente;
  
  Regla (IFuncion ant, IFuncion cons) {
    
    antecedente = ant;
    consecuente = cons;
  }
  
  IFuncion getAntecedente() {
    
    return antecedente;
  }
  
  IFuncion getConsecuente() {
    
    return consecuente;
  }
  
  /*
  

  

  

  
*/
  
}
