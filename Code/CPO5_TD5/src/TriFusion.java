public class TriFusion {

    public static void triFusion(int tableau[], int deb, int fin){
        if(deb!=fin){
            int milieu = (deb+fin)/2;
            triFusion(tableau, deb, milieu);
            triFusion(tableau, milieu, fin);
            fusion(tableau, deb, milieu, fin);
        }
    }
    
    static class FusionThread extends Thread{
        int[] tab;
        int deb, fin;

        public FusionThread(int[] tab, int deb, int fin) {
            this.tab = tab;
            this.deb = deb;
            this.fin = fin;
        }
        
        public void run(){
            int milieu = (fin+deb)/2;
            Thread t1 = new FusionThread(tab, deb, milieu);
            Thread t2 = new FusionThread(tab, milieu+1, fin);
            t1.start();
            t2.start();
            try{t1.join();} catch(InterruptedException e){}
            try{t2.join();} catch(InterruptedException e){}
            fusion(tab, deb, milieu, fin);
        }
    }
    
    public static void threadTriFusion(int[]tab, int deb, int fin){
        Thread t = new FusionThread(tab, deb, fin);
        t.run();
    }
    
    public static void fusion(int tableau[], int deb, int milieu, int fin){
        //Contenu ininteressant
    }
}
