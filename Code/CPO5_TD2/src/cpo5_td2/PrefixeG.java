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
public class PrefixeG implements OrdreG<PrefixeG> {
        String val;
        public PrefixeG(String v) { val = v;}
        
        public boolean plusGrandQue(PrefixeG other){
	return val.startsWith(other.val);
        }

}
