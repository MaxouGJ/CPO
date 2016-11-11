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
public class ReelG implements OrdreG<Reel> {
        double val;
        public ReelG(double v) { val = v;}
        
        public boolean plusGrandQue(Reel other){
	return val > other.val;
        }

}
