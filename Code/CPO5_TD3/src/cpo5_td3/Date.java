/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpo5_td3;

/**
 *
 * @author Maxime
 */
public class Date extends ListeTriee.Chainable /*implements Evaluable*/ { //car chainable implemente deja evaluable

    static Jour jdls;
    
    public enum Jour {

        Lundi(0, "Lundi"),
        Mardi(1, "Mardi"),
        Mercredi(2, "Mercredi"),
        Jeudi(3, "Jeudi"),
        Vendredi(4, "Vendredi"),
        Samedi(5, "Samedi"),
        Dimanche(6, "Dimanche");

        public final int id;
        public final String nom;

        Jour(int i, String nom) {
            id = i;
            this.nom = nom;
        }

        public static Jour ofInt(int i) {
            for (Jour j : Jour.values()) {
                if (j.id == i) {
                    return j;
                }
        }
        return null; //return ofInt(i%7)        
        }
    }

    public enum Mois {

        Janvier(0, "Janvier", 31),
        Fevrier(1, "Février", 28),
        Mars(2, "Mars", 31),
        Avril(3, "Avril", 30),
        Mai(4, "Mai", 31),
        Juin(5, "Juin", 30),
        Juillet(6, "Juillet", 31),
        Aout(7, "Août", 31),
        Septembre(8, "Septembre", 30),
        Octobre(9, "Octobre", 31),
        Novembre(10, "Novembre", 30),
        Decembre(11, "Décembre", 31);

        final public int id;
        final public String nom;
        final int nbJours;

        Mois(int i, String nom, int nbJours) {
            id = i;
            this.nom = nom;
            this.nbJours = nbJours;
        }

        public static Mois ofInt(int i) {
            for (Mois m : Mois.values()) {
                if (m.id == i) {
                    return m;
                }
            }
            return null; //return ofInt(i%12)        
        }

        public Mois next() {
            return Mois.ofInt(id + 1);
        }

        Jour jour;
        Mois mois;
        int annee;
        int jdm;

        public int toInt() {
            int resultat = 365 * (annee - 1); //nb jours ecoules depuis le debut de l'annee
            for (Mois m2 : Mois.values()) {//nb jours ecoules du 1er javier de l'annee courante au debut du moois courant
                if (m2.id < mois.id) {
                    resultat += m2.nbJours;
                }
            }
            return (resultat + jdm);
        }

        public boolean estCoherenteAvec(Date d) {
            int diff = Math.abs(d.toInt() - toInt());
            return d.jdls == Jour.ofInt(jdls.id + (diff % 7));
        }
    }

    @Override
    public int toInt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
