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
public class DiviseurG implements OrdreG<DiviseurG> {
        int val;
        public DiviseurG(int v) { val = v;}
        
        public boolean plusGrandQue(DiviseurG other){
	return val % other.val == 0;
        }

}
