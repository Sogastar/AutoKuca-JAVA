/*
 * Djelatnik.java
 *
 * Created on 2007. svibanj 16, 22:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author DGaso
 */
public class Djelatnik extends Kupac {
    
    /** Creates a new instance of Djelatnik */
    public Djelatnik () {
        
    }
    private String uzer;
    private String pass;
    private String poslovnica;

    public String getUzer() {
        return uzer;
    }

    public void setUzer(String uzer) {
        this.uzer = uzer;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPoslovnica() {
        return poslovnica;
    }

    public void setPoslovnica(String poslovnica) {
        this.poslovnica = poslovnica;
    }
    
    
}
