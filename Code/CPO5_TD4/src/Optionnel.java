public class Optionnel<T> {
    
    T val;
    boolean aUneValeur;

    public Optionnel() {
        val = null;
        aUneValeur = false;
    }

    public Optionnel(T val) {
        this.val = val;
        aUneValeur = true;
    }
    
   public T get() throws Exception{
        if(aUneValeur)
            return val;
        else
            throw new Exception("Aucune valeur");
    }
}
