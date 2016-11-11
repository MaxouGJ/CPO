
import java.util.Iterator;

public class Pile<E> {

    Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static class Cellule<F>{
        private F val;
        private Cellule<F> suivant;
        
        Cellule(F el, Cellule<F> c){ 
            val = el;
            suivant = c;
        }
        
        public F getVal() {
            return val;
        }
        
        public Cellule<F> getSuivant(){
            return suivant;
        }
    }
    
    Cellule<E> hautDePile;
    public void add(E elem){
        hautDePile = new Cellule<E>(elem, hautDePile);
    }
    
    public E depiler(){
        if(hautDePile == null)
            return null;
        E el = hautDePile.getVal();
        hautDePile = hautDePile.getSuivant();
        return el;
    }
}
