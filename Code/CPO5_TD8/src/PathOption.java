
import java.io.File;
import java.util.*;

public class PathOption extends Option{

    List<File> chemins = new ArrayList<File>();
    
    public PathOption(String nom) {
        super(nom.split("=", 2)[0]);
        String[] args = nom.split("=", 2);
        if(args.length == 2){
            for(String s : args[1].split(":"))
                chemins.add(new File(s));
        }
    }
    
    public String toConfigurationLine() {
        String motif = "%s#%s=%s";
        String valeur = "";
        for(File f : chemins){
            if(!valeur.equals(""))
                valeur += ':';
            valeur += f.getPath();
        }
        
        return (String.format(motif,"PathOption", nom, valeur));
    }
    
    
}
