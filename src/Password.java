
/**
 * @version Date: 27.02.2006
 * @author  Danijel Jelenic
 * @since   jdk 1.5
 * @version	1.0
 */

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;
import sun.misc.CharacterEncoder;


/**
 * This Class is used for storing passwords.
 * Before insertation in the database password nead to be encrypted.
 * This Class uses hashing algorithm to store passwords.
 * Supported hashing algorithms are : MD5,SHA-1, SHA-256, SHA-384, SHA-512
 */
public class Password {
    
    private String cipher="MD5";
    private String plainText;
    private String hashCode;
    
    /** static field that sets MD5 algorithm
     */
    public static final int algorithmMD5=1;
    
    /** static field that sets SHA-1 algorithm
     */
    public static final int algorithmSHA1=2;
    
    /** static field that sets SHA-256 algorithm
     */
    public static final int algorithmSHA256=3;
    
    /** static field that sets SHA-384 algorithm
     */
    public static final int algorithmSHA384=4;
    
    /** static field that sets SHA-512 algorithm
     */
    public static final int algorithmSHA512=5;
    
    /**
     * Use this constructor to create new password.
     * If hashing algorithm is not set default is MD5
     * <br><b>Example:</b><br>
     * Password pass=new Password("mypass");
     * @param plainText is the password you nead to hash
     */
    public Password(String plainText){
        this(plainText,1);
    }
    
    /**
     * Use this constructor when you nead differen hashing algorihm.
     * You nead to set algorithm with class static attribute
     * <br><b>Example:</b><br>
     * Password pass=new Password("mypass",Password.algorithmSHA1);
     * @param plainText is the password you nead to hash
     * @param cipherAlgorithm is the hash algorithm
     */
    public Password(String plainText, int cipherAlgorithm){
        this.plainText=plainText;
        setCipherAlgorithm(cipherAlgorithm);
    }
    
    /**
     * Use this method to compare some password with actual keept in Password class.
     * Method converts your password to hash code and compares it with actual hash of password.
     * <br><b>Example:</b><br>
     * boolean b=pass.isPassword("mypass");
     * @return <b>true</b> if two hashes match
     * @param passwordToCheck password to check
     */
    public boolean isPassword(String passwordToCheck){
        try {
            return encrypt(passwordToCheck).equals(hashCode);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    /**
     * Use this method to compare some hash code with actual keept in Password class.
     * Method compares your hash with actual hash of password.
     * <br><b>Example:</b><br>
     * boolean b=pass.issHashCode("EDr654/HG5$#"f$#9876&%==");
     * @return <b>true</b> if two hashes match
     * @param hash hash to check
     */
    public boolean isHashCode(String hash){
        return hashCode.equals(hash);
    }
    
    /**
     * Sets the Cipher Algorithm and automaticly makes hash code.
     * After this method hash code is changed
     * <br><b>Example:</b><br>
     * pass.setCipherAlgorithm(Password.algorithmSHA1);
     * @param hashingAlgorithm algorithm to hash
     */
    public void setCipherAlgorithm(int hashingAlgorithm){
        switch(hashingAlgorithm){
            case 1:
                cipher="MD5";
                break;
            case 2:
                cipher="SHA-1";
                break;
            case 3:
                cipher="SHA-256";
                break;
            case 4:
                cipher="SHA-384";
                break;
            case 5:
                cipher="SHA-512";
                break;
            default:
                System.out.println("Cipher algorithm not supported ...");
        }
        try {
            hashCode=encrypt(plainText);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Use this method if you nead to know algorithm name.
     * <br><b>Example:</b><br>
     * String str=pass.getAlgorithmName();
     * @return String algorithm name
     */
    public String getAlgorithmName(){
        return cipher;
    }
    
    /**
     * Use this method if you nead hash code.
     * <br><b>Example:</b><br>
     * String str=pass.getHashCode();
     * @return String string representation of hash
     */
    public String getHashCode(){
        return (hashCode != null) ? hashCode : "";
    }
    
    /**
     * Use this method if you nead to know password.
     * <br><b>Example:</b><br>
     * String str=pass.getPassword();
     * @return String string representation of password
     */
    public String getPassword(){
        return (plainText != null) ? plainText : "";
    }
    
    /**
     * Use this method if you nead to know password length.
     * <br><b>Example:</b><br>
     * int i=pass.getPasswordLength();
     * @return int password length
     */
    public int getPasswordLength(){
        return plainText.length();
    }
    
    /**
     * Use this method if you nead to know hash length.
     * <br><b>Example:</b><br>
     * int i=pass.getHashLength();
     * @return int length of hash
     */
    public int getHashLength(){
        return hashCode.length();
    }
    
    private String encrypt(String plaintext) throws UnsupportedEncodingException {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(cipher);
        } catch(NoSuchAlgorithmException e) {
            throw new UnsupportedEncodingException(e.getMessage());
        }
        try {
            md.update(plaintext.getBytes("ISO-8859-1"));
        } catch(UnsupportedEncodingException e) {
            throw new UnsupportedEncodingException(e.getMessage());
        }
        
        byte raw[] = md.digest();
        String hash = (new BASE64Encoder()).encode(raw);
        return hash;
    }
    
}




