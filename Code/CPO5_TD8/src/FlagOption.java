public class FlagOption extends Option{

    private boolean activated=false;

    public FlagOption(String nom) {
        super(nom.split("=", 2)[0]);
        String[] args = nom.split(nom, 2);
        if(args.length == 2){
            if(args[1].equals("true"))
                activated = true;
        }
    }
    
    /*
    Ancienne méthode moins rapide mais avec moins de risque d'erreur
    */
//    @Override
//    public String toCofigurationLine() {
//        String motif = "%s#%s=%b";
//        return String.format(motif, "FlagOption", nom, activated);
//    }
    
       public String toConfigurationLine() {
           return toConfigurationLine("%b", activated);
       }
       
    boolean isActived(){
        return activated;
    }
    
}
