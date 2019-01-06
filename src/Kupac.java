/*
 * Kupac.java
 *
 * Created on 2007. svibanj 16, 22:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author DGaso
 */
public class Kupac {
    
    /** Creates a new instance of Kupac */
    public Kupac() {
    }
    private int id;
    private String ime;
    private String prezime;
    private String adresa;
    private String grad;
    private String zupanija;
    private String telefon;
    private String mobitel;
    private String email;
    private java.sql.Timestamp vrijeme;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getZupanija() {
        return zupanija;
    }

    public void setZupanija(String zupanija) {
        this.zupanija = zupanija;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Timestamp getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(java.sql.Timestamp vrijeme) {
        this.vrijeme = vrijeme;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     public boolean valjaniPodaci(){
       if(this.getIme().length()>1&this.getPrezime().length()>1){
           return true;
           
       }else{
           return false;
       }
   }             

    public String getMobitel() {
        return mobitel;
    }

    public void setMobitel(String mobitel) {
        this.mobitel = mobitel;
    }
}
