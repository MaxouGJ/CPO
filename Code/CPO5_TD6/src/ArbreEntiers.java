
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ArbreEntiers {

    public int contenu;
    public ArbreEntiers gauche;
    public ArbreEntiers droite;

    class ZeroAction extends RecursiveAction {

        ArbreEntiers a;

        @Override
        protected void compute() {
            if (a == null) {
                return;
            }
            contenu = 0;
            ZeroAction t1 = new ZeroAction(gauche);
            ZeroAction t2 = new ZeroAction(droite);
            t1.fork();
            t2.compute();
        }
        
        public ZeroAction(ArbreEntiers a){
            this.a = a;
        }
        
    }
    
    void maz(ArbreEntiers a){
       (new ForkJoinPool()).invoke(new ZeroAction(a));
    }
    
    class ProfondeurTask extends RecursiveTask<Integer>{
        
        ArbreEntiers a;
        
        public ProfondeurTask(ArbreEntiers a){
            this.a = a;
        }
        
        protected Integer compute(){
            if(a == null)
                return 0;
            ProfondeurTask t1 = new ProfondeurTask(gauche);
            ProfondeurTask t2 = new ProfondeurTask(droite);
            t1.fork();
            int vd = t2.compute();
            int vg = 0;
            try { vg = t1.get();} catch(Exception e){}
            return 1 + Math.max(vg, vd);
        }
    }
    
    Integer profondeur(ArbreEntiers a){
        return (new ForkJoinPool().invoke(new ProfondeurTask(a)));
    }
    
}
