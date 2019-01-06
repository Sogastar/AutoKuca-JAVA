/*
 * Auto.java
 *
 * Created on 2007. svibanj 16, 22:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author DGaso
 */
public class Auto {
    
   
    public Auto() {
    }
    
    private int id;
    private String markaVozila;
    private String tipVozila;
    private String vrstaVozila;
    private String boja;
    private String godinaProizvodnje;
    private String vrstaMotora;
    private String prijedjeniKilometri;
    private String vrstaGoriva;
    private String snagaUKilovatima;
    private String zapreminaMotora;
    private String cijenaVozila;
    private String status;
    private String dodatnaOprema;
    private String slika;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarkaVozila() {
        return markaVozila;
    }

    public void setMarkaVozila(String markaVozila) {
        this.markaVozila = markaVozila;
    }

    public String getTipVozila() {
        return tipVozila;
    }

    public void setTipVozila(String tipVozila) {
        this.tipVozila = tipVozila;
    }

    public String getVrstaVozila() {
        return vrstaVozila;
    }

    public void setVrstaVozila(String vrstaVozila) {
        this.vrstaVozila = vrstaVozila;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public String getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(String godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public String getVrstaMotora() {
        return vrstaMotora;
    }

    public void setVrstaMotora(String vrstaMotora) {
        this.vrstaMotora = vrstaMotora;
    }

    public String getPrijedjeniKilometri() {
        return prijedjeniKilometri;
    }

    public void setPrijedjeniKilometri(String prijedjeniKilometri) {
        this.prijedjeniKilometri = prijedjeniKilometri;
    }

    public String getVrstaGoriva() {
        return vrstaGoriva;
    }

    public void setVrstaGoriva(String vrstaGoriva) {
        this.vrstaGoriva = vrstaGoriva;
    }

    public String getSnagaUKilovatima() {
        return snagaUKilovatima;
    }

    public void setSnagaUKilovatima(String snagaUKilovatima) {
        this.snagaUKilovatima = snagaUKilovatima;
    }

    public String getZapreminaMotora() {
        return zapreminaMotora;
    }

    public void setZapreminaMotora(String zapreminaMotora) {
        this.zapreminaMotora = zapreminaMotora;
    }

    public String getCijenaVozila() {
        return cijenaVozila;
    }

    public void setCijenaVozila(String cijenaVozila) {
        this.cijenaVozila = cijenaVozila;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDodatnaOprema() {
        return dodatnaOprema;
    }

    public void setDodatnaOprema(String dodatnaOprema) {
        this.dodatnaOprema = dodatnaOprema;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }
     public boolean valjaniPodaci(){
       if(this.getMarkaVozila().length()>1&this.getTipVozila().length()>1){
           return true;
           
       }else{
           return false;
       }
   }             
    
    
    
              
}
