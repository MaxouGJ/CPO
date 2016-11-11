package cpo5_td3;

public class ListeTriee {

    public static abstract class Chainable implements Evaluable{
        private Chainable suivant;
        private int value;
        private String nom;
        
        public Chainable getSuivant(){
            return suivant;
        }
        public void setSuivant(Chainable c){
            suivant = c;
        }
        public abstract void execute();
        
        public abstract int toInt();
        
        public Chainable add(Chainable c){
            if(c.toInt() <= this.toInt()){
                c.setSuivant(this);
                return c;
            }
            if(this.getSuivant() == null)
                setSuivant(c);
            else 
                suivant.add(c);
            return this;
        }
    }
    
    Chainable tete;
    
    public void execute(){
        Chainable tmp = tete;
        while(tmp != null){
            tmp.execute();
            tmp = tmp.getSuivant();
        }
    }
    
    public void add(Chainable c){
        if(tete == null)
            tete = c;
        tete = tete.add(c);
    }
    
    void add(Evaluable evArg){
        final Evaluable ev2 = evArg; 
        class ChainableDeux extends Chainable{
            Evaluable ev = ev2;
                        
            public int toInt() {
                return ev.toInt();
            }
            
            public String toString(){
                return ev.toString();
            }

            @Override
            public void execute() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }
        
        add(new ChainableDeux());
    }
}
