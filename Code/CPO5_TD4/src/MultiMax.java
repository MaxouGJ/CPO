import java.util.ArrayList;
import java.util.Collection;

public class MultiMax extends ArrayList<Integer>{

    private int nb;
    
    public MultiMax(int n){
        this.nb = n;
    }
    
    public void processAll(Collection<Integer> c){
        for(Integer i : c){
            process(i);
        }
    }
    
    public void process(int i){
        if(size() < nb){
            add(i);
            return;
        }
        
        int minIndice = 0;
        for(int indice=0; indice < nb; indice++){
            if(get(minIndice) > get(indice))
                minIndice = indice;
        }
        if(i > get(minIndice))
            set(minIndice, i);
    }
    
    ArrayList<Integer> getValues(){
        return this;
    }

}
