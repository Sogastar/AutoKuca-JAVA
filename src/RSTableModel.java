import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;


//klasa koja æe hraniti našu tablicu
//klasa æe biti TableModel tipa
//AbstractTableModel implements javax.swing.table.TableModel
public class RSTableModel extends AbstractTableModel {
    
    private String[] imenaStupaca=new String[0];
    
    private Vector<String[]> redovi=new Vector<String[]>();//vektor koji u sebi ima polje stringova
                                                            //služi da možemo imati promjenjivi broj 
                                                           //redova u tablici
    private ResultSet rs;
     public RSTableModel() {
       
    }
    public RSTableModel(ResultSet rs) {
        setResultSet(rs);//postavljanje metode
        
    }
     public void setResultSet(ResultSet rs) {
         if(rs==null){      //ako neko postavi rs na null briše se sve u tablici
             this.rs=null;
             imenaStupaca=new String[0];
             redovi.clear();
             fireTableChanged(null);//ova linija obavještava da se tablica promjenila
             return;
         }
       this.rs=rs;
       try {
          
           ResultSetMetaData rsmd=rs.getMetaData();//ova metoda vraca podatke iz resultset-a
           int brojStupaca=rsmd.getColumnCount();//daje nam broj stupaca
           imenaStupaca=new String[brojStupaca];
           for(int i=0;i<imenaStupaca.length;i++){
               imenaStupaca[i]=rsmd.getColumnLabel(i+1);//i+1 zato jer ne ide od nule,nema nultog stupca,daje nam imena stupaca
           }
           //dobijanje redova..
           //prvo praznimo Vector
           redovi.clear();
           //definiramo polje stringova
           String[] red;
           
           //formiranje petlje vertikalno(prolazimo kroz bazu vertikalno)
           while(rs.next()){
               red=new String[brojStupaca];//kod svakog prolaza kroz red formira se string ovaj
               //formiranje petlje horizontalno(prolazimo kroz bazu horizontalno)
               for(int i=0;i<brojStupaca;i++){
                   red[i]=rs.getString(i+1);
                   
               }
               //sada dodajemo red u vektor
               redovi.addElement(red);
           }
           //sada obavjestimo bazu o promjeni podataka i onda ona refresha tablicu
           fireTableChanged(null);
           
       } catch (SQLException e) {
           
       }
    }

    public int getRowCount() {
//        if(redovi!=null){
//        return redovi.size();
//        }else{
//            return 0;
//        }
        //ovo gore mozemo pisati i sa ternari operatorom:
        return redovi==null ? 0 : redovi.size();
    }

    public int getColumnCount() {
        return imenaStupaca==null ? 0:imenaStupaca.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) { 
        String[] red = redovi.elementAt(rowIndex);
        String str=red[columnIndex];
        return str;
        //skraceno se moze ovo gore napisati i ovako:
        //return redovi.elementAt(rowIndex)[columnIndex];
    }
    public String getColumnName(int kolona){
        if(kolona<0 | kolona>=imenaStupaca.length){
            return null;
        }else{
            return imenaStupaca[kolona];
            
        }
    }

   
    
}
