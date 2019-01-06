import java.sql.*;
import java.io.*;
import java.util.Properties;

public class Konekcija{
    
    private Connection conn                   = null;
    private PreparedStatement prepStatement   = null;
    private ResultSet rs                      = null;
    
    private String serverName                 = "localhost";
    private String port                       = "5432";
    private String databaseName               = "imeBaze";
    private String user                       = "imeKorisnika";
    private String password                   = "password";
    
    private String connectionString           = "";
    private String connectionParameters       = "&useUnicode=true&character_set_server=latin2&collation_server=latin2_croatian_ci&character_set_database=latin2&collation_database=latin2_croatian_ci&character_set_results=latin2&character_set_client=latin2&character_set_connection=latin2&collation_connection=latin2_croatian_ci";
    
    
    
    /**
     * Kontruktor konekcija objekta. Služi za otvaranje konekije prema bazi</br>
     * @param imeServera ime stroja na kojem se nalazi baza (localhost ako je na lokalnoj mašini)
     * @param port je port ja koji se treba spojiti - za postgresql bazu to je obièno 5432
     * @param imeBaze ime baze na koju se treba spojiti
     * @param imeUsera username
     * @param password password 
     */
    public Konekcija(String imeServera, String port, String imeBaze, String imeUsera, String password) {
        this.serverName         = imeServera;
        this.port               = port;
        this.databaseName       = imeBaze;
        this.user               = imeUsera;
        this.password           = password;
        this.connectionString   = "jdbc:postgresql://"+serverName+":"+port+"/"+databaseName+"?user="+user+"&password="+password;
        openConnection();
    }
    
    
    /**
     * Privatna metoda koja otvara konekciju.</br>
     * Poziva ju konstruktor automatski
     */
    private void openConnection() {
        
        try {
            //prvi korak - uèitavanje klase drajvera u Java Virtualnu Mašinu (vadi ga iz .jar fajla)
            // isto bi postigli i sa new org.postgresql.Driver();
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            //drugi korak pozvati statièku metodu getConection() DriverManager klase
            //DriverManager klasi je automatski dostupan driver uèitan u JVM sa Class.forName("org.postgresql.Driver")
            //nakon toga konekcija sa bazom je uspostavljena
            conn = DriverManager.getConnection(connectionString);
            
        } catch (SQLException ex) {
            System.out.println("Greska prilikom otvaranja baze konekcija.openConnection():");
        }
    }
    
    
    /**
     * Metoda koja provjerava dali je veza na bazu otvorena ili ne</br>
     * @return true ako je veza otvorena
     */
    public boolean isClosed(){
        try {
            if(conn==null) return true;
            return conn.isClosed();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }
    
    
    /**
     * Metoda koja zatvara konekciju prema bazi
     */
    public void closeConnection() {
        try {
            rs.close();
            prepStatement.close();
            conn.close();
        } catch (SQLException ex5) {
            System.out.println("Greska prilikom zatvaranja baze Konekcija.closeConnection():");
        }
    }
    
    
    /**
     * Izvršava SQL operacije nad bazom</br>
     * @param statement SQL naredba koju treba izvršiti
     * @param scrollable ako je postavljen na true onda æe otvoriti ResultSet po kojem æe se moèi šetati 
     * @return true ako je SQL naredba uspješno izvršena
     */
    public boolean executeUpdate(String statement, boolean scrollable) {
        try {
            setStatement(statement, scrollable);
            prepStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja Querya Konekcija.executeQuery(String str)");
            return false;
        }
    }
    
    
    
    /**
     * Izvršava SQL upit nad bazom i vraèa ResultSet</br>
     * @param statement SQL upit
     * @param scrollable ako je postavljen na true onda æe otvoriti ResultSet po kojem æe se moèi šetati 
     * @return true ako je SQL upit uspješno izvršen
     */
    public ResultSet getResultSet(String statement, boolean scrollable) {
        try {
            setStatement(statement,scrollable);
            return prepStatement.executeQuery();
            //rs.setFetchDirection(ResultSet.FETCH_UNKNOWN);
            //rs.setFetchSize(1);
        } catch (SQLException ex) {
            System.out.println("Greška prilikom vraèanja recordseta Konekcija.getResultset(String sql):");
            return null;
        }
    }
    
    
    
    /**
     * Postavlja SQL upit koji treba izvršiti
     * @param statement SQL upit 
     * @param scrollable ako je postavljen na true onda æe otvoriti ResultSet po kojem æe se moèi šetati 
     */
    private void setStatement(String statement, boolean scrollable) {
        try {
            prepStatement = scrollable ? conn.prepareStatement(statement,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) : conn.prepareStatement(statement);
        } catch (SQLException ex) {
            System.out.println("Greška prilikom postavljanja prepared statementa setStatement(String stm)");
        }
    }
    
    
    /**
     * Zatvara vezu prema bazi kad se objekat briše iz memorije.
     */
    public void finalize(){
        if(!isClosed()) closeConnection();
    }
}
