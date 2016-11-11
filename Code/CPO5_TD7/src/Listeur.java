
import java.io.File;

abstract class ParcoursFichiers {
    
    public abstract void process(File f);
    
    public void parcours(File f){
        process(f);
        
        if(!f.isDirectory())
            return;
       
        File[] sousFichiers = f.listFiles();
        for(File sf : sousFichiers){
            parcours(sf);
        }
    }
}

public class Listeur extends ParcoursFichiers{

    @Override
    public void process(File f) {
        String name = f.getName();
        if(name.substring(name.length()-4).equals(".exe") && f.isFile())
            f.setExecutable(true);
    }
}