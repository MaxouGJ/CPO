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
public class Reel implements Ordre {
        double val;
        public Reel(double v) { val = v;}
	
        public boolean plusGrandQue(Object other){
	if(other instanceof Double)
                        return val > (Double)other;
	else if(other instanceof Reel) 
                        return val > ((Reel)other).val;
	else 
                        return false;//throw Exception(); //ou return false ;
	}
    
}
