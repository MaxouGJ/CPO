package cpo5_td3;

import java.util.ArrayList;

public class FonctionMap extends ArrayList<Fonction> {
    public int appliquer(int x){
        int y = x;
        for(Fonction f : this)
            y = f.appliquer(y);
        return y;
    }
    
    public static void main(String[]args){
        FonctionMap f = new FonctionMap();
        f.add(new PlusTrois());
        System.out.println(f.appliquer(1));//Affiche 4
        f.add(new Carre());
        System.out.println(f.appliquer(1));//Affiche 16
        
        class MultDeux implements Fonction{
            public int appliquer(int x){
                return x+2;
            }
        }
        f.add(new MultDeux());
        System.out.println(f.appliquer(1));//Affiche 18
        
        f.add(new Fonction(){
            public int appliquer(int x){
                return x/2;
            }
        });
        System.out.println(f.appliquer(1));//Affiche 9
    }
}
