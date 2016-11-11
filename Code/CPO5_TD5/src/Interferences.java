public class Interferences {
    static int x=0;

    static Object verrou = new Object();
    
    static class ThreadIncr extends Thread{
        public void run(){
            for(int i=0; i<5; i++){
                synchronized(verrou){//Empêche juste que le dernier résultat soit différent de 0 
                    System.out.println(++x);
                }
                try{sleep(1);}
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    static class ThreadDecr extends Thread {
        public void run(){
            for(int i=0; i<5; i++){
                System.out.println(--x);
                try{sleep(1);}
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    } 
    
    public static void main(String[] args){
        /*Consigne de base*/
        (new ThreadIncr()).start();
        (new ThreadDecr()).start();
        /*Le résultat de base peut afficher des nombre de -5 à 5.*/
        
        /*Correction1*/
//        Thread Incr = new ThreadIncr();
//        Incr.start();
//        try{ Incr.join();} catch(InterruptedException e){ }
//        (new ThreadDecr()).start();
        /*Pas terrible tant qu'à faire lancer les deux run() l'un après l'autre*/
    }
}
