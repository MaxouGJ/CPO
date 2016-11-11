
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class Option {
    
    public final String nom;
    
    public static String motif= "%s#%s=%s";
    
    public Option(String nom){
        this.nom = nom;
    }
    
    abstract public String toConfigurationLine();
    
    public String toConfigurationLine(String sousType, Object valeur){
        String motif2 = String.format(motif.getClass().getName(), nom, sousType);
        return String.format(motif2, valeur);
    }
    
    static Option depuisUneLigne(String line) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        String[] args = line.split("#", 2);
        Class cl = Class.forName(args[0]);
        Constructor co = cl.getConstructor(String.class);
        Object o = co.newInstance(args[1]);
        return (Option) o;
    }
}
