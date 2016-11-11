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
public interface Chainable {
    
    Chainable suivant();
    
    default int longueur(){
        Chainable s = suivant();
        return 1 + ((s == null) ? 0 : s.longueur());
    }
}
