
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireDOptions {
    
    List<Option> options = new ArrayList<Option>();
    
    void treatFile(File f) throws IOException, ClassNotFoundException, InstantiationException, IllegalArgumentException, InvocationTargetException{
        BufferedReader r = new BufferedReader(new FileReader(f));
        while(r.ready()){
            String line = r.readLine();
            try{
                options.add(Option.depuisUneLigne(line));
            }catch(NoSuchMethodException| SecurityException | IllegalAccessException e){
                System.err.println(e.getMessage());
                System.err.println(line);
            }
        }
    }
}
