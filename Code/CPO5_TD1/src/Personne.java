public class Personne {

    private String nom, prenom;
    public int age;
    
   public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void anniversaire(){
        age++;
    }
    
    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", prenom=" + prenom + ", age=" + age + '}';
    }
}