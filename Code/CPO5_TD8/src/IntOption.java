public class IntOption extends Option{

    int valeur = 0;
    
    public IntOption(String nom){
        super(nom.split("=", 2)[0]);
        String args[] = nom.split("=", 2);
        if(args.length == 2)
            valeur = Integer.parseInt(args[1]);
    }
    
    @Override
    public String toConfigurationLine() {
        String motif = "%d#%s=%d";
        return String.format(motif, "IntOption", nom, valeur);
    }
    
}
