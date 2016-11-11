/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpo5_td2;

/**
 *
 * @author Maxime
 */
public class EntierChainable implements Chainable {

    int entier;
    Chainable suivant;

    public EntierChainable(int entier, Chainable suivant) {
        this.entier = entier;
        this.suivant = suivant;
    }
    
    @Override
    public Chainable suivant() {
        return suivant;
    }
    
    public String toString(){
        Chainable s = suivant;
        return ""+entier + ((s == null) ?  "" : ", "+s); //On ne met pas toString car Java le sait implicitement 
    }
    
}
