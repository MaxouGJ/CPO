public class Tube {
    private byte[] contenu;
    private Byte[] contenu2;
    private int iLecture;
    private int iEcriture;
    
    public Tube(int capacite){
        contenu = new byte[capacite];
        contenu2 = new Byte[capacite];
//        iLecture = 0;
//        iEcriture = 0;
    }
    
    synchronized byte lit(){
        while(iLecture == iEcriture){
            try{ wait(); }
            catch(InterruptedException e){ }
        }
            iLecture = (iLecture + 1)%contenu.length;
            notifyAll();
            return contenu[iLecture];
    }
    
    Byte lit2(){
        synchronized (contenu2[(iLecture + 1)%contenu2.length]){
            while(iLecture == iEcriture){
                try{ wait(); }
                catch(InterruptedException e){ }
            }
            iLecture = (iLecture + 1)%contenu2.length;
            notifyAll();
            return contenu2[iLecture];
        }
    }
    
    synchronized void ecrit(byte b){
        while((iLecture+1)%contenu.length == iEcriture){
            try{wait();}
            catch(InterruptedException e){ }
        }
        iEcriture = (iEcriture +1)%contenu.length;
        contenu[iEcriture] = b;
        notifyAll();
    }
    
    void ecrit2(Byte b){
        synchronized(contenu2[(iEcriture+1)%contenu2.length]){
            try{wait();}
            catch(InterruptedException e){ }
        }
        iEcriture = (iEcriture +1)%contenu2.length;
        contenu2[iEcriture] = b;
        notifyAll();
    }
    
    public static void main(String[]args){
        Tube t = new Tube(2);
        (new Thread(){
            public void run(){
                for(int i=0; i<10; i++){
                    System.out.println("Lu : "+t.lit2());
                }
            }
        }).start();
        
        (new Thread(){
            public void run(){
                for(int i=0; i<10; i++){
                    t.ecrit2((byte)i);
                    System.out.println("Ecrit : "+i);
                }
            }
        }).start();
    }
}
