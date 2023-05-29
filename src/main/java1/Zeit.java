package java1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zeit {
    private int tag;
    private int monat;
    private int jahr;
    private int stunde;
    private int minute;

    /**
     * initiiert Zeit mit "1.6.2023, 0:0"
     */
    public Zeit(){
        this.tag = 1;
        this.monat = 6;
        this.jahr = 2023;
        this.stunde = 0;
        this.minute = 0;

    }


    /**
     *setTime u.a. im Format "DD.MM.YYYY, ss:mm"
     * @param input
     */
    public void setTime(String input) throws NumberFormatException{
        String reg = "^([0-2]?[0-9]|3[0-1])[.]([0]?[0-9]|1[0-2])[.]([0-9][0-9][0-9][1-9]), ([0-1]?[0-9]|2[0-3])[:]([0-5]?[0-9])$";
        if(input.matches(reg)) {
            Matcher m = Pattern.compile(reg).matcher(input);
            if(m.find()){
                this.tag = Integer.parseInt(m.group(1));
                this.monat = Integer.parseInt(m.group(2));
                this.jahr = Integer.parseInt(m.group(3));
                this.stunde = Integer.parseInt(m.group(4));
                this.minute = Integer.parseInt(m.group(5));
            }
        } else {
            throw new NumberFormatException("Raum-Zeit-Kontinuum verletzt");
        }
    }
    public String addTime(int stunde, int minute){
        this.stunde = (this.stunde + stunde + (this.minute+minute)/60) % 24;
        this.minute = (this.minute+minute)%60;
        return this.stunde +":"+this.minute;
    }

    public int getStunde(){return this.stunde;}
    public int getMinute(){return this.minute;}
    public int getTag(){return this.tag;}
    public int getMonat(){return this.monat;}
    public int getJahr(){return this.jahr;}


    public String toString(){
        String t = Integer.toString(this.tag);
        String m = Integer.toString(this.monat);
        String std = Integer.toString(this.stunde);
        String min = Integer.toString(this.minute);
        if((this.tag-10) <0) {
            t = "0" + Integer.toString(this.tag);
        }
        if((this.monat - 10) < 0 ) {
            m = "0" + this.monat;
        }
        if((this.stunde - 10) < 0 ) {
            std = "0" + this.stunde;
        }
        if((this.minute - 10) < 0 ) {
            min = "0" + this.minute;
        }
        return t + "." + m + "." + this.jahr + ", " + std + ":" + min;
    }
}