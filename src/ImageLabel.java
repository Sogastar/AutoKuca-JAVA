

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/*
 * ImageLabel.java
 *
 * Created on 2007. svibanj 16, 23:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Danijel Jeleniæ
 */
public class ImageLabel extends JLabel {
    
    
    private ImageIcon imgIcon;
    private Image image;
    
    public ImageLabel() {
    }
    
    
    private void parsirajSliku(final int sirina,final int visina){
        this.image=imgIcon.getImage().getScaledInstance(sirina,visina,Image.SCALE_DEFAULT);
        this.setIcon(new ImageIcon(image));
        this.repaint();
    }
    
    public void obrisiSliku(){
        this.image=null;
        this.setIcon(null);
        this.repaint();
    }
    
    
    public void prikaziSliku(ImageIcon imgIcon){
        this.imgIcon=imgIcon;
        parsirajSliku(this.getWidth(),this.getHeight());
    }
    
    public void prikaziSliku(File f){
        if(f.exists()){
            ImageIcon tmp=imgIcon;
            Image tmpImage=image;
            try{
                imgIcon=new ImageIcon(f.getAbsolutePath());
                parsirajSliku(this.getWidth(),this.getHeight());
            }catch(Exception e){
                imgIcon=tmp;
                image=tmpImage;
                System.out.println("Greška prilikom postavljanja slike ");
            }
        }else{
            System.out.println("File "+f.getAbsolutePath()+" ne postoji !");
        }
    }
    
    public void prikaziSliku(String slika){
        this.prikaziSliku(new File(slika));
    }
    
    public void postaviVelicinu(int sirina, int visina){
        this.setSize(sirina,visina);
        this.parsirajSliku(sirina,visina);
    }
    
    public void postaviSirinu(int sirina){
        double scale=(imgIcon.getIconHeight()*1.0)/imgIcon.getIconWidth();
        int visina=(int)(scale*sirina);
        this.postaviVelicinu(sirina,visina);
    }
    
    public void postaviVisinu(int visina){
        double scale=(imgIcon.getIconWidth()*1.0)/imgIcon.getIconHeight();
        int sirina=(int)(scale*visina);
        this.postaviVelicinu(sirina,visina);
    }
    
}
