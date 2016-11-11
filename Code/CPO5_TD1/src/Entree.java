public class Entree {

    private final Personne client;
    public String login;
    private String password;
    private static int tentative = 0;
    
    public Entree(Personne client, String login, String password) {
        this.client = client;
        this.login = login;
        this.password = password;
    }
    
    public boolean autorise(String mdp){
        tentative ++;
        if( mdp.equals(password)){
            tentative = 0;
            return true;
        }else 
            return false;
    }
    
    public boolean changerMdp(String ancien, String nouveau){
        if(ancien.equals(password)){
            password = nouveau;
            return true;
        }else 
            return false;
    }
    
    
}
