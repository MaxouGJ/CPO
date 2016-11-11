
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class StringMultilangues {
    
    static private class ItemSML{
        public String valeur;
        public Locale langue;

        public ItemSML(String valeur, Locale langue) {
            this.valeur = valeur;
            this.langue = langue;
        }
        
    }
    
    Locale defaut = Locale.ENGLISH;

    public StringMultilangues(String str) {
        ajouteLangue(str, defaut);
    }
    
    
    List<ItemSML> strings =  new LinkedList<ItemSML>();
    
    public void ajouteLangue(String str, Locale lang){
        strings.add(new ItemSML(str, lang));
    }
    
    public String toString(){
        Locale langue = Locale.getDefault();
        for (ItemSML item : strings){
            if (item.langue.equals(langue))
                return item.valeur;
        }
        for (ItemSML item : strings){
            if(item.langue.getLanguage().equals(langue.getLanguage()))
                return item.valeur;
        }
        for (ItemSML item : strings){
            if(item.langue.getLanguage().equals(defaut))
                return item.valeur;
        }
        return "";//Cas pour compiler
    }
}
