import java.util.Arrays;
import java.util.Scanner;

public class Exercice1 {
  
    public static String[] lireChaines(){
        String[] chaines = new String[10];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<10; i++){
            System.out.println("Entrez une chaîne de caractère");
            chaines[i] = sc.nextLine();
        }
        return chaines;
    }
    
    public static void enMajuscules(String[] tab){
        for (int i = 0; i < tab.length; i++) {
                tab[i] = tab[i].toUpperCase();
        }
    }
    
    public static void afficher(String[] tab){
        for(String tab1 : tab){
            System.out.println(tab1);
        }        
    }
    
    public static void main(String[] args){
        String[] chaines = lireChaines();
        enMajuscules(chaines);
        Arrays.sort(chaines);//trie par ordre alphabétique
        afficher(chaines);
    }
}
