/**
 *
 * @version Date: 27.02.2006
 * @author  Danijel Jelenic
 * @since   jdk 1.5
 * @version	1.1
 */

import java.util.*;

public class DateTime {
    
    private Calendar calendar = Calendar.getInstance();
    
    /** Inicira klasu sa trenutnim datumom i vremenom
     */
    public DateTime() {
        this.calendar.setTime(new java.util.Date());
    }
    
    /**
     * @param date long konstruktor koji kreira novi DateTime iz milisekundi
     */
    public DateTime(long date) {
        this.calendar.setTimeInMillis(date);
    }
    
    /**
     * @param date java.util.Date konstruktor koji kreira novi DateTime preko java.util.Date objekta
     */
    public DateTime(java.util.Date date) {
        this.calendar.setTime(date);
    }
    
    /**
     * @param calendar Calendar konstruktor koji kreira novi DateTime iz nekog drugog DateTime objekta
     */
    public DateTime(Calendar calendar) {
        this.calendar.setTime(calendar.getTime());
    }
    
    /**Konstruktor s kojim kreiramo novi DateTime preko godine, mjeseca, i dana
     * @param year - godina
     * @param month - mjesec
     * @param day - dan
     */
    public DateTime(int year, int month, int day) {
        this.calendar.set(year,month-1,day,0,0,0);
        this.calendar.set(java.util.Calendar.MILLISECOND, 0);
    }
    
    /**Konstruktor s kojim kreiramo novi DateTime preko godine, mjeseca, dana, sata, minute i sekunde
     * @param year - godina
     * @param month - mjesec
     * @param day -dan
     * @param hour - sat
     * @param minute - minuta
     * @param second - sekunda
     */
    public DateTime(int year, int month, int day, int hour, int minute, int second) {
        this.calendar.set(year,month-1,day,hour,minute,second);
        this.calendar.set(java.util.Calendar.MILLISECOND, 0);
    }
    
    /**Konstruktor s kojim kreiramo novi DateTime preko godine, mjeseca, dana, sata, minute, sekunde i milisekunde
     * @param year - godina
     * @param month - mjesec
     * @param day -dan
     * @param hour - sat
     * @param minute - minuta
     * @param second - sekunda
     * @param millisecond - milisekunda
     */
    public DateTime(int year, int month, int day, int hour, int minute, int second, int millisecond) {
        this.calendar.set(year,month-1,day,hour,minute,second);
        this.calendar.set(java.util.Calendar.MILLISECOND, millisecond);
    }
    
    /**
     * @return String vraèa trenutno vrijeme
     */
    public String toString() {
        return this.calendar.getTime().toString();
    }
    
    /**
     * @return String vraèa trenutni datum u kraèem obliku
     */
    public String toShortDateString() {
        return java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT).format(this.calendar.getTime());
    }
    
    /**
     * @return String vraèa trenutni datum u dužem obliku
     */
    public String toLongDateString() {
        return java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG).format(this.calendar.getTime());
    }
    
    /**
     * @return String vraèa trenutno vrijeme u kraèem obliku
     */
    public String toShortTimeString() {
        return java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT).format(this.calendar.getTime());
    }
    
    /**
     * @return String vraèa trenutni datum u dužem obliku
     */
    public String toLongTimeString() {
        return java.text.DateFormat.getTimeInstance(java.text.DateFormat.LONG).format(this.calendar.getTime());
    }
  
    /**
     * @return java.util.Date objekt
     */
    public java.util.Date toDate() {
        return this.calendar.getTime();
    }
    
    /**
     * @param days broj dana za dodati
     * @return novi DateTime objekt
     */
    public DateTime addDays(int days) {
        java.util.Calendar newCal = java.util.Calendar.getInstance();
        newCal.setTime(this.calendar.getTime());
        newCal.add(java.util.Calendar.DAY_OF_YEAR, days);
        return new DateTime(newCal);
    }
    
    /**
     * @param hours broj sati za dodati
     * @return novi DateTime objekt
     */
    public DateTime addHours(int hours) {
        java.util.Calendar newCal = java.util.Calendar.getInstance();
        newCal.setTime(this.calendar.getTime());
        newCal.add(java.util.Calendar.HOUR, hours);
        return new DateTime(newCal);
    }
    
    /**
     * @param milliseconds broj millisekundi za dodati
     * @return novi DateTime objekt
     */
    public DateTime addMilliseconds(int milliseconds) {
        java.util.Calendar newCal = java.util.Calendar.getInstance();
        newCal.setTime(this.calendar.getTime());
        newCal.add(java.util.Calendar.MILLISECOND, milliseconds);
        return new DateTime(newCal);
    }
    
    /**
     * @param minutes broj minuta za dodati
     * @return novi DateTime objekt
     */
    public DateTime addMinutes(int minutes) {
        java.util.Calendar newCal = java.util.Calendar.getInstance();
        newCal.setTime(this.calendar.getTime());
        newCal.add(java.util.Calendar.MINUTE, minutes);
        return new DateTime(newCal);
    }
    
    /**
     * @param months broj mjeseci za dodati
     * @return novi DateTime objekt
     */
    public DateTime addMonths(int months) {
        java.util.Calendar newCal = java.util.Calendar.getInstance();
        newCal.setTime(this.calendar.getTime());
        newCal.add(java.util.Calendar.MONTH, months);
        return new DateTime(newCal);
    }
    
    /**
     * @param seconds broj sekundi za dodati
     * @return novi DateTime objekt
     */
    public DateTime addSeconds(int seconds) {
        java.util.Calendar newCal = java.util.Calendar.getInstance();
        newCal.setTime(this.calendar.getTime());
        newCal.add(java.util.Calendar.SECOND, seconds);
        return new DateTime(newCal);
    }
    
    /**
     * @param years broj godina za dodati
     * @return novi DateTime objekt
     */
    public DateTime addYears(int years) {
        java.util.Calendar newCal = java.util.Calendar.getInstance();
        newCal.setTime(this.calendar.getTime());
        newCal.add(java.util.Calendar.YEAR, years);
        return new DateTime(newCal);
    }
    
    /**
     * @return dan
     */
    public int getDay() {
        return this.calendar.get(java.util.Calendar.DAY_OF_MONTH);
    }
    
    /**
     * @return dan u tjednu
     */
    public int getDayOfWeek() {
        return this.calendar.get(java.util.Calendar.DAY_OF_WEEK);
    }
    
    /**
     * @return dan u godini
     */
    public int getDayOfYear() {
        return this.calendar.get(java.util.Calendar.DAY_OF_YEAR);
    }
    
    /**
     * @return sat u formatu 0-12
     */
    public int getHourAs12() {
        return this.calendar.get(java.util.Calendar.HOUR);
    }
    
    /**
     * @return sat u formatu 0-24
     */
    public int getHourAs24() {
        return this.calendar.get(java.util.Calendar.HOUR_OF_DAY);
    }
    
    /**
     * @return minute
     */
    public int getMinute() {
        return this.calendar.get(java.util.Calendar.MINUTE);
    }
    
    /**
     * @return millisekunde
     */
    public int getMillisecond() {
        return this.calendar.get(java.util.Calendar.MILLISECOND);
    }
    
    /**
     * @return mjesec (1-12)
     */
    public int getMonth() {
        return this.calendar.get(java.util.Calendar.MONTH)+1;
    }
    
    /**
     * @return sekunde
     */
    public int getSecond() {
        return this.calendar.get(java.util.Calendar.SECOND);
    }
    
    /**
     * @return godinu
     */
    public int getYear() {
        return this.calendar.get(java.util.Calendar.YEAR);
    }
    
    /** Static funkcija koja vraèa novi objekt DateTime iz trenutnog vremena
     * @return novi DateTime objekt od sada
     */
    public static DateTime getNow() {
        return (new DateTime(new java.util.Date()));
    }
    
   
    
    /** Static funkction koja vraèa novi objekt DateTime iz trenutnog vremena ali postavlja sat minute i sekunde na nula
     * @return novi DateTime objekt
     */
    public static DateTime getToday() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(new java.util.Date());
        cal.set(java.util.Calendar.HOUR, 0);
        cal.set(java.util.Calendar.MINUTE, 0);
        cal.set(java.util.Calendar.SECOND, 0);
        cal.set(java.util.Calendar.MILLISECOND, 0);
        return new DateTime(cal);
    }
    
    /**
     * @return broj dana u trenutnom mjesecu
     */
    public int getDaysInMonth() {
        java.util.Calendar cal = (java.util.Calendar)this.calendar.clone();
        cal.add(java.util.Calendar.MONTH,1);
        cal.set(java.util.Calendar.DAY_OF_MONTH,1);
        cal.add(java.util.Calendar.DAY_OF_YEAR,-1);
        return cal.get(java.util.Calendar.DAY_OF_MONTH);
    }
    
    /** Static funkcija koja vrèa broj dana u željenom mjesecu i željenoj godini
     * @return broj dana
     */
    public static int getDaysInMonth(int year, int month) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year,month-1,1,0,0,0);
        cal.add(java.util.Calendar.MONTH,1);
        cal.set(java.util.Calendar.DAY_OF_MONTH,1);
        cal.add(java.util.Calendar.DAY_OF_YEAR,-1);
        return cal.get(java.util.Calendar.DAY_OF_MONTH);
    }
    
    /**
     * @return dali je prestupna godina ili ne
     */
    public boolean isLeapYear() {
        java.util.Calendar cal = (java.util.Calendar)this.calendar.clone();
        cal.set(java.util.Calendar.MONTH,11);
        cal.set(java.util.Calendar.DAY_OF_MONTH,31);
        if (cal.get(java.util.Calendar.DAY_OF_YEAR)==366) {
            return true;
        } else {
            return false;
        }
    }
    
    /** Static funkcija koja vraèa dali je prestupna godina za željenu godinu
     * @return dali je prestupna godina ili ne
     */
    public static boolean isLeapYear(int year) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year,0,1,0,0,0);
        cal.set(java.util.Calendar.MONTH,11);
        cal.set(java.util.Calendar.DAY_OF_MONTH,31);
        if (cal.get(java.util.Calendar.DAY_OF_YEAR)==366) {
            return true;
        } else {
            return false;
        }
    }
    
    /** Vraèa broj milisekundi poèevši od 1971 godine
     * @return long vrijeme u milisekundama (timestamp)
     */
    public long getTimeInMillis(){
        return this.calendar.getTimeInMillis();
    }
    
    /** 
     * @return String datum u obliku dan:mjesec:godina
     */
    public String getDate(){
        return this.getDay()+"."+this.getMonth()+"."+this.getYear();
    }
    
    public String getAmericanDate(){
        return this.getYear()+"-"+this.getMonth()+"-"+this.getDay();
    }
    
    /** 
     * @return String vrijeme u obliku sat:minuta
     */
    public String getTime(){
        String hour         = getHourAs24()<10? ("0"+getHourAs24()):(""+getHourAs24());
        String minute       = getMinute()<10? ("0"+getMinute()):(""+getMinute());
        return hour+":"+minute;
    }

    /** 
     * @return String vrijeme u obliku sat:minuta:sekundi
     */
    public String getLongTime(){
        String hour         = getHourAs24()<10? ("0"+getHourAs24()):(""+getHourAs24());
        String minute       = getMinute()<10? ("0"+getMinute()):(""+getMinute());
        String sekunde      = getSecond()<10? ("0"+getSecond()):(""+getSecond());
        return hour+":"+minute+":"+sekunde;
    }
    
    
}
