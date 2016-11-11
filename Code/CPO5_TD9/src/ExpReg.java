
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpReg {

    public static void ex1(){
        String chaine;
        try (Scanner sc = new Scanner(System.in)) {
            chaine = sc.nextLine();
        }
        String regexp = "((\\p{L})|(\\p{L}\\p{L})|(\\p{L}\\p{L}\\p{L}))"+"[sx]"+"[\\s.,;]";
        Pattern motif = Pattern.compile(regexp);
        Matcher recherche = motif.matcher(chaine);
        int nbOccurences = 0;
        while(recherche.find()){
            nbOccurences ++;
            System.out.println(recherche.group());
        }
        System.out.println(nbOccurences);
    }
    
    public static void nbOcc(String chaine, String regexp){
        Pattern motif = Pattern.compile(regexp);
        Matcher recherche = motif.matcher(chaine);
        int nbOccurences = 0;
        int i=0;
        while(i < chaine.length()){
            if(recherche.find(i)){
                nbOccurences++;
                i = recherche.start()+1;
            }else 
                break;
        }
        System.out.println(nbOccurences);        
    }
    
    public HashMap<String,String> xml(String chaine){
        HashMap<String,String> h = new HashMap<String,String>();
        String regexp = "[a-zA-Z]*=\"[a-zA-Z]*\"";
        Pattern motif = Pattern.compile(regexp);
        Matcher recherche = motif.matcher(chaine);
        while(recherche.find()){
            h.put(,)
        }
        return h;
    }
    
    public static void main(String[] args){
        String chaine;
        try (Scanner sc = new Scanner(System.in)) {
            chaine = sc.nextLine();
        }    
        /*Ex1*/
        String regexp1 = "((\\p{L})|(\\p{L}\\p{L})|(\\p{L}\\p{L}\\p{L}))"+"[sx]"+"[\\s.,;]";
        
        /*Ex2*/
//        String r = "aa";
//        nbOcc(chaine, r);
        
        /*Ex3*/
        String regexp3 = "\\p{L}+"+"[sx]"+"[\\s.,;]";
        
        /*Ex4*/
        String regexp4 = "(((foo)|(bar) |\\s)*((foo)|(bar)))?";
        
        /*Ex5*/
        String format = "(https?://)?(%s.)+%s(/%s)*/?";
        String secondaire = "[a-z-]+";
        String primaire = "(fr|org|com|com.uk)";
        String repertoire = "[a-zA-Z_]+";
        String regexp5 =  String.format(format, secondaire, primaire, repertoire);
        
        /*Ex6*/
        xml(chaine);
    }
}
