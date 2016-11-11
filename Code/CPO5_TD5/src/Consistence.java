public class Consistence {
    static String s = "";
    static int x = 0;
    
    static class ThreadPrint extends Thread{
        public void run(){
//            synchronized(s){
                System.out.println(x+" et "+s);
//            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        (new ThreadPrint()).start();
        (new ThreadPrint()).start();
        for(int i=0; i<10; i++){
//            synchronized(s){
                s = ""+(x+1);
                x++;
//            }
        }
    }
}
