/*
 * Metode.java
 *
 * Created on 2007. svibanj 16, 22:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author DGaso
 */
import java.sql.*;
import java.io.*;
import java.util.Properties;
import java.util.*;


public class Metode {
    
    public static Konekcija kon= new Konekcija("localhost","5432","autokuca","danijel","danijel");
    
    
    
    //osnovni konstruktor proglasimo privatnim da nitko ne dira ovu klasu!
    private Metode() {
    }
    
    public static ResultSet DajZupanije(){
        
        String sql="select * from zupanije where id>1 order by nazivzupanije asc";
        ResultSet rs=kon.getResultSet(sql,true);
        return rs;
        
    }
    public static ResultSet DajGradoveOdZupanija(String zupanija){
        
        String sql="select * from gradovi where zupanija=(select id from zupanije where nazivzupanije='"+zupanija+"')order by nazivgrada asc;";
        ResultSet rs=kon.getResultSet(sql,true);
        return rs;
        
    }
    
    //metode potrebne za rad sa tablicom automobila
    
    
    public static boolean spremiAuto(Auto a){
        
       String sql="insert into auto(markaVozila,tipVozila,vrstaVozila,boja,godinaProizvodnje,vrstaMotora,prijedjeniKilometri,vrstaGoriva,snagaUKilovatima,zapreminaMotora,cijenaVozila,status,dodatnaOprema,slika)values('"+a.getMarkaVozila()+"','"+a.getTipVozila()+"','"+a.getVrstaVozila()+"','"+a.getBoja()+"','"+a.getGodinaProizvodnje()+"','"+a.getVrstaMotora()+"','"+a.getPrijedjeniKilometri()+"','"+a.getVrstaGoriva()+"','"+a.getSnagaUKilovatima()+"','"+a.getZapreminaMotora()+"','"+a.getCijenaVozila()+"','"+a.getStatus()+"','"+a.getDodatnaOprema()+"','"+a.getSlika()+"')";
       return kon.executeUpdate(sql,true);
        
    }
    public static boolean modificirajAuto( Auto a){
        
        String sql="update auto set markavozila='"+a.getMarkaVozila()+"',tipvozila='"+a.getTipVozila()+"',vrstavozila='"+a.getVrstaVozila()+"',boja='"+a.getBoja()+"',godinaproizvodnje='"+a.getGodinaProizvodnje()+"',vrstaMotora='"+a.getVrstaMotora()+"',prijedjeniKilometri='"+a.getPrijedjeniKilometri()+"',vrstaGoriva='"+a.getVrstaGoriva()+"',snagaUKilovatima='"+a.getSnagaUKilovatima()+"',zapreminaMotora='"+a.getZapreminaMotora()+"',cijenaVozila='"+a.getCijenaVozila()+"',status='"+a.getStatus()+"',dodatnaOprema='"+a.getDodatnaOprema()+"' where id="+a.getId()+"";
        return kon.executeUpdate(sql,true);
        
    }
    public static boolean obrisiAuto(int id){
        
        String sql="delete from auto where id='"+id;//overloadana metoda
        return kon.executeUpdate(sql,true);
        
    }
    public static boolean obrisiAutoPoKriteriju(String kolona,String uvjet){
        
        String sql="delete from auto where "+kolona+"='"+uvjet+"%'";
        return kon.executeUpdate(sql,true);
        
    }
    public static Vector <Auto>dajSveAute(){
        Vector<Auto> v= new Vector();
        String sql="select * from auto";
        ResultSet rs= kon.getResultSet(sql,true);
        if (rs != null) {
        try {
        Auto a= null;
            while (rs.next()){
                a= new Auto();
                System.out.println("row id=" + rs.getRow()); 
        a.setId(rs.getInt("id"));
        a.setBoja(rs.getString("boja"));
        a.setCijenaVozila(rs.getString("cijenavozila"));
        a.setDodatnaOprema(rs.getString("dodatnaoprema"));
        a.setGodinaProizvodnje(rs.getString("godinaproizvodnje"));
        a.setMarkaVozila(rs.getString("markavozila"));
        a.setPrijedjeniKilometri(rs.getString("prijedjenikilometri"));
        a.setSlika(rs.getString("slika"));
        a.setSnagaUKilovatima(rs.getString("snagaukilovatima"));
        a.setStatus(rs.getString("status"));
        a.setTipVozila(rs.getString("tipvozila"));
        a.setVrstaGoriva(rs.getString("vrstagoriva"));
        a.setVrstaMotora(rs.getString("vrstamotora"));
        a.setVrstaVozila(rs.getString("vrstavozila"));
        a.setZapreminaMotora(rs.getString("zapreminamotora"));
        
        v.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        
        }
        }
        return v;
          
    }
     public static ResultSet dajSveAutomobile(){
        String sql="select * from auto";
        ResultSet rs= kon.getResultSet(sql,true);
        return rs;
        
    }
    public static ResultSet dajSveAutePoKriteriju(String kolona,String uvjet){
        
        String sql="select from auto where "+kolona+"='"+uvjet+"'";
        ResultSet rs= kon.getResultSet(sql,true);
        return rs;
        
    }
    public static ResultSet dajSveAutePoId(String id){
        
        String sql="select * from auto where id='"+id;
        ResultSet rs= kon.getResultSet(sql,true);
        return rs;
    }
   
    //metode potrebne za rad sa tablicom djelatnik
    
    
    public static boolean spremiDjelatnika(Djelatnik d){
        
        String sql="insert into djelatnik(ime,prezime,adresa,grad,zupanija,telefon,mobitel,email,vrijeme,status,uzer,pass,poslovnica) values('"+d.getIme()+"','"+d.getPrezime()+"','"+d.getAdresa()+"',(select id from gradovi where nazivgrada='"+d.getGrad()+"' and zupanija=(select id from zupanije where nazivzupanije='"+d.getZupanija()+"')),(select id from zupanije where nazivzupanije='"+d.getZupanija()+"'),'"+d.getTelefon()+"','"+d.getMobitel()+"','"+d.getEmail()+"',now(),'"+d.getStatus()+"','"+d.getUzer()+"','"+d.getPass()+"',(select id from poslovnica where nazivposlovnice='"+d.getPoslovnica()+"'))";
        return kon.executeUpdate(sql,true);
        
    }
    public static boolean modificirajDjelatnika( Djelatnik d){
        
        String sql="update djelatnik set(ime='"+d.getIme()+"',prezime='"+d.getPrezime()+"',adresa='"+d.getAdresa()+"',grad=(select id from gradovi where nazivgrada='"+d.getGrad()+"' and zupanija=(select id from zupanije where nazivzupanije='"+d.getZupanija()+"')),zupanija=(select id from zupanije where nazivzupanije='"+d.getZupanija()+"'),telefon='"+d.getTelefon()+"',mobitel='"+d.getMobitel()+"',email='"+d.getEmail()+"',now(),status='"+d.getStatus()+"',user=''"+d.getUzer()+",pass='"+d.getPass()+"',poslovnica=(select id from poslovnica where nazivposlovnice='"+d.getPoslovnica()+"'))";
        return kon.executeUpdate(sql,true);
        
    }
    public static boolean obrisiDjelatnika(int id){
        
        String sql="delete from djelatnik where id='"+id;
        return kon.executeUpdate(sql,true);
        
    }
    public static boolean obrisiDjelatnikaPoKriteriju(String kolona,String uvjet){
        
        String sql="delete * from djelatnik where "+kolona+"='"+uvjet+"'";
        return kon.executeUpdate(sql,true);
        
    }
    public static ResultSet dajSveDjelatnike(){
        String sql="select * from djelatnik";
        ResultSet rs= kon.getResultSet(sql,true);
        return rs;
        
    }
    public static ResultSet dajDjelatnika(int id){
        String sql="select from djelatnik where id='"+id;
        ResultSet rs= kon.getResultSet(sql,true);
        return rs; 
        
    }
    public static ResultSet dajSveDjelatnikePoKriteriju(String kolona,String uvjet){
        
        String sql="select * from djelatnik where "+kolona+"='"+uvjet+"'";
        ResultSet rs= kon.getResultSet(sql,true);
        return rs;
    }
   
    
    // metode za rad sa tablicom kupac
    
    
    public static boolean spremiKupca(Kupac k){
        
        String sql="insert into kupac(ime,prezime,adresa,grad,zupanija,telefon,mobitel,email,vrijeme,status) values('"+k.getIme()+"','"+k.getPrezime()+"','"+k.getAdresa()+"',(select id from gradovi where nazivgrada='"+k.getGrad()+"' and zupanija=(select id from zupanije where nazivzupanije='"+k.getZupanija()+"')),(select id from zupanije where nazivzupanije='"+k.getZupanija()+"'),'"+k.getTelefon()+"','"+k.getMobitel()+"','"+k.getEmail()+"',now(),'"+k.getStatus()+"')";
        return kon.executeUpdate(sql,true);
          
    }
    public static boolean modificirajKupca( Kupac k){
        
        String sql="update kupac set(ime='"+k.getIme()+"',prezime='"+k.getPrezime()+"',adresa='"+k.getAdresa()+"',grad=(select id from gradovi where nazivgrada='"+k.getGrad()+"' and zupanija=(select id from zupanije where nazivzupanije='"+k.getZupanija()+"')),zupanija=(select id from zupanije where nazivzupanije='"+k.getZupanija()+"'),telefon='"+k.getTelefon()+"',mobitel='"+k.getMobitel()+"',email='"+k.getEmail()+"',now(),status='"+k.getStatus()+"')";
        return kon.executeUpdate(sql,true);
        
    }
    public static boolean obrisiKupca(int id){
    
        String sql="delete from kupac where id='"+id;
        return kon.executeUpdate(sql,true);
    
    } 
    public static boolean obrisiKupcaPoKriteriju(String kolona,String uvjet){
        
        String sql="delete * from kupac where "+kolona+"='"+uvjet+"'";
        return kon.executeUpdate(sql,true);
        
    }
    public static ResultSet dajSveKupce(){
        
        String sql="select * from kupac";
        ResultSet rs= kon.getResultSet(sql,true);
        return rs;
        
    }
    public static ResultSet dajKupca(int id){
        
        String sql="select from kupac where id='"+id;
        ResultSet rs= kon.getResultSet(sql,true);
        return rs; 
        
    }
    public static ResultSet dajSveKupcePoKriteriju(String kolona,String uvjet){
        
        String sql="select * from kupac where "+kolona+"='"+uvjet+"'";
        ResultSet rs= kon.getResultSet(sql,true);
        return rs;
        
    }
     public static Djelatnik dajDjelatnikaPoUserPass(String uzer,String pass){
        String sql="select * from djelatnik_detaljno where uzer='"+uzer+"' AND pass='"+pass+"';";
        ResultSet rs=kon.getResultSet(sql,true);
        Djelatnik d=new Djelatnik();
                 try {
                      while(rs.next()){
                d.setPass(rs.getString("pass"));
                d.setId(rs.getInt("id"));
                d.setIme(rs.getString("ime"));
                d.setPrezime(rs.getString("prezime"));
                d.setAdresa(rs.getString("adresa"));
                d.setTelefon(rs.getString("telefon"));
                d.setMobitel(rs.getString("mobitel"));
                d.setEmail(rs.getString("email"));
                d.setGrad(rs.getString("nazivgrada"));
                d.setZupanija(rs.getString("nazivzupanije"));
                d.setUzer(rs.getString("uzer"));     
                d.setPoslovnica(rs.getString("nazivposlovnice"));
                d.setVrijeme(rs.getTimestamp("vrijeme"));
                d.setStatus(rs.getString("status"));  
                d.setAdresa(rs.getString("adresa"));
               
                      }                               
                         } catch (SQLException ex) {
            ex.printStackTrace();
        }
                return d;
    }
    
    
    
     
    //metode za rad sa tablicom poslovnica
    
    
    public static boolean spremiPoslovnicu(Poslovnica p){
        
        String sql="insert into poslovnica(naziv,adresa,grad,zupanija,telefon,email,status) values('"+p.getNaziv()+"','"+p.getAdresa()+"',(select id from gradovi where nazivgrada='"+p.getGrad()+"' and zupanija=(select id from zupanije where nazivzupanije='"+p.getZupanija()+"')),zupanija=(select id from zupanije where nazivzupanije='"+p.getZupanija()+"'),telefon'"+p.getTelefon()+"',email='"+p.getEmail()+"',status='"+p.isStatus()+"')";
        return kon.executeUpdate(sql,true);
        
    }
    public static boolean modificirajPoslovnicu( Poslovnica p){
        
        String sql="update poslovnica set(naziv='"+p.getNaziv()+"',adresa='"+p.getAdresa()+"',grad=(select id from gradovi where nazivgrada='"+p.getGrad()+"' and zupanija=(select id from zupanije where nazivzupanije='"+p.getZupanija()+"')),zupanija=(select id from zupanije where nazivzupanije='"+p.getZupanija()+"'),telefon='"+p.getTelefon()+"',email='"+p.getEmail()+"',status='"+p.isStatus()+"'";
        return kon.executeUpdate(sql,true);
        
    }
    public static boolean obrisiPoslovnicu(int id){
        
        String sql="delete from poslovnica where id='"+id;
        return kon.executeUpdate(sql,true);
        
    }
    public static boolean obrisiPoslovnicuPoKriteriju(String kolona,String uvjet){
        
        String sql="delete * from poslovnica where "+kolona+"='"+uvjet+"'";
        return kon.executeUpdate(sql,true);
        
    }
    public static ResultSet dajSvePoslovnice(){
        
        String sql="select * from poslovnica";
        ResultSet rs= kon.getResultSet(sql,true);
        return rs;
    }
    public static ResultSet dajSvePoslovnicePoKriteriju(String kolona,String uvjet){
        
        String sql="select * from poslovnica where "+kolona+"='"+uvjet+"'";
        ResultSet rs= kon.getResultSet(sql,true);
        return rs;
        
    }
    public static ResultSet dajAutePoSqlUpitu(String sql){
        System.out.println("metoda daj aute");
         ResultSet rs=kon.getResultSet(sql,true);
          System.out.println("metoda daj aute poslje rs-a");
         return rs;
         
     }
    public static String vratiPassUStringu(char[] c){
        String s="";
        char[]polje= c;
        for(int i=0;i<c.length;i++){
            s+=c[i];
            
        }
        System.out.println(s);
        return s;
        
    }
    
    
    
    
    
    
    
    
    
}
