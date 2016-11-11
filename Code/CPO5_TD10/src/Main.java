
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
 
    
    public static HashMap<String,String> xml(String chaine){
        HashMap<String, String> h = new HashMap<String,String>();
        String exp = "([a-z]+)=\"([^\"]+)\"";
        String verif = String.format("[<][a-z]*( *%s)*[>]", exp);
        if(!Pattern.matches(verif, chaine))
            return null;
        Pattern motif = Pattern.compile (exp);
        Matcher m = motif.matcher(chaine);
        while(m.find()){
            h.put(m.group(1), m.group(2));
        }
        return h;
    } 
    
    public static String remplaceGroupe(String chaine, int groupeNb, Pattern p, String remplacement){
        Matcher m = p.matcher(chaine);
        String debut = chaine.substring(0, m.start(groupeNb));
        String fin = chaine.substring(m.end(groupeNb), chaine.length()-1);
        return debut+remplacement+fin;
    } 
    
    public static String racinePrimitive(String chaine){
        String exp = "(.*?)*(\\1)*";
        Pattern motif = Pattern.compile(exp);
        Matcher m = motif.matcher(chaine);
        return m.group(1);
    } 
    
    public static String remplaceBlancs(String chaine){
        return chaine.replaceAll("\\s+", " ");
    }
    
    public static List<String> etoile(String chaine, Pattern motif){
        Matcher m = motif.matcher(chaine);
        List<String> res = new ArrayList<String>();
        while(m.lookingAt()){
            res.add(m.group());
            m.region(m.end(), m.regionEnd());
        }
        return res;
    }
    
    public static String[] smartSplit(char separateur, String chaine){
        String[] res = chaine.split(String.format("(<=[^\\\\])%c", separateur));
        for(int i=0; i<res.length;i++)
            res[i].replaceAll("\\\\:", ":");
        return res;
    }
    
    public static void main(String[] args){
        /*Ex1*/
//        String chaine;
//        try (Scanner sc = new Scanner(System.in)) {
//            chaine = sc.nextLine();
//        }
//        System.out.println(xml(chaine));
        /*Ex2*/
//        String chaine = "victor.marsault@marsault.fr";
//        int groupeNb = 1;
//        Pattern p = Pattern.compile("[^@]*@([a-z.]*).fr");
//        String remplacement = "@liafa.univ-paris-diderot";
//        System.out.println(remplaceGroupe(chaine, groupeNb, p, remplacement));
        /*Ex3*/
//        String chaine;
//        try (Scanner sc = new Scanner(System.in)) {
//            chaine = sc.nextLine();
//        }
//        System.out.println(racinePrimitive(chaine));
        /*Ex4*/
//        String chaine;
//        try (Scanner sc = new Scanner(System.in)) {
//            chaine = sc.nextLine();
//        }
//        System.out.println(remplaceBlancs(chaine));
        /*Ex5*/
//        String chaine = "foobarbar pasfoo";
//        Pattern p = Pattern.compile("((foo)|(bar))");
//        List<String>l = etoile(chaine, p);
//        for(int i=0; i<l.size(); i++)
//            System.out.println(l.get(i));        
        /*Ex6*/
//        String chaine = "liste:avec:des:deux points\\::\\:\\";
//        char separateur = ':';
//        String[] s = smartSplit(separateur, chaine);
//        for(int i=0; i<s.length; i++)
//            System.out.println(s[i]);
    }
}
