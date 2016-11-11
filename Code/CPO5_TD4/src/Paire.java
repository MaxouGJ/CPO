
public class Paire<X,Y> {

    public X premier;
    public Y deuxieme;

    public Paire(X un, Y deux) {
        premier = un;
        deuxieme = deux;
    }
    
    public Paire<X,Y> get(){
        return this;
    }
}
