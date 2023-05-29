package java1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zeit implements Comparable<Zeit> {
    private int tag;
    private int monat;
    private int jahr;
    private int stunde;
    private int minute;

    /**
     * initiiert Zeit mit "1.6.2023, 0:0"
     */
    public Zeit() {
        this.tag = 1;
        this.monat = 6;
        this.jahr = 2023;
        this.stunde = 0;
        this.minute = 0;

    }


    /**
     * setTime u.a. im Format "DD.MM.YYYY, ss:mm"
     *
     * @param input
     */
    public void setTime(String input) throws NumberFormatException, IllegalArgumentException {
        String reg = "^([0-2]?[0-9]|3[0-1])[.]([0]?[0-9]|1[0-2])[.]([0-9][0-9][0-9][1-9]), ([0-1]?[0-9]|2[0-3])[:]([0-5]?[0-9])$";
        Zeit tmp = new Zeit();
        if (input.matches(reg)) {
            Matcher m = Pattern.compile(reg).matcher(input);
            if (m.find()) {
                tmp.setTag(Integer.parseInt(m.group(1)));
                tmp.setMonat(Integer.parseInt(m.group(2)));
                tmp.setJahr(Integer.parseInt(m.group(3)));
                tmp.setStunde(Integer.parseInt(m.group(4)));
                tmp.setMinute(Integer.parseInt(m.group(5)));
            }
            if(this.compareTo(tmp) > 0){
                throw new IllegalArgumentException("Raum-Zeit-Kontiuum verletzt");
            } else {
                this.tag = tmp.getTag();
                this.monat = tmp.getMonat();
                this.jahr = tmp.getJahr();
                this.stunde = tmp.getStunde();
                this.minute = tmp.getMinute();
            }
        } else {
            throw new NumberFormatException();
        }
    }

    public void addTime(int stunde, int minute) {
        this.stunde = (this.stunde + stunde + (this.minute + minute) / 60) % 24;
        this.minute = (this.minute + minute) % 60;
        tag += (this.stunde + stunde) / 24;
        if (tag > tageInMonat(jahr, monat)) {
            tag = tag - tageInMonat(jahr, monat);
            monat++;
        }
        if (monat > 12) {
            monat = monat - 12;
            jahr++;
        }
    }

    private static int tageInMonat(int jahr, int monat) {
        if (istSchaltjahr(jahr) == true && monat == 2) { //bei einem Schaltjahr hat der Februar 29 statt 28 tage
            return 29;
        }
        if (monat < 1 || monat > 12) {
            throw new IllegalArgumentException("ungueltiger Wert fuer Monat:" + monat);
        }
        int tage = 30; //bei monat 4 6 und 9 blibt es bei 30 tagen
        switch (monat) {
            case 2:
                tage = 28;
                break;
            case 4:
                break;
            case 6:
                break;
            case 9:
                break;
            case 11:
                tage = 30;
                break;
            default:
                tage = 31;
                break; // alle nicht angegebenen Monate haben 31 Tage
        }
        return tage;
    }

    private static boolean istSchaltjahr(int jahr) throws IllegalArgumentException {
        if (jahr < 0) {
            throw new IllegalArgumentException("ungueltiger Wert fuer Jahr:" + jahr);
        }
        if (jahr < 1583 && jahr % 4 == 0) {
            return true;
        } else if (jahr % 4 == 0 && (jahr % 100 != 0 || jahr % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }


    public int getStunde() {
        return this.stunde;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getTag() {
        return this.tag;
    }

    public int getMonat() {
        return this.monat;
    }

    public int getJahr() {
        return this.jahr;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
    public void setMonat(int monat) {
        this.monat = monat;
    }
    public void setJahr(int jahr) {
        this.jahr = jahr;
    }
    public void setStunde(int stunde) {
        this.stunde = stunde;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }


    /**
     * toString im Format "DD.MM.YYYY, ss:mm"
     *
     * @return
     */
    public String toString() {
        String t = Integer.toString(this.tag);
        String m = Integer.toString(this.monat);
        String std = Integer.toString(this.stunde);
        String min = Integer.toString(this.minute);
        if ((this.tag - 10) < 0) {
            t = "0" + Integer.toString(this.tag);
        }
        if ((this.monat - 10) < 0) {
            m = "0" + this.monat;
        }
        if ((this.stunde - 10) < 0) {
            std = "0" + this.stunde;
        }
        if ((this.minute - 10) < 0) {
            min = "0" + this.minute;
        }
        return t + "." + m + "." + this.jahr + ", " + std + ":" + min;
    }

    @Override
    public int compareTo(Zeit o) {
        if (Integer.compare(this.jahr, o.getJahr()) == 0) {
            if (Integer.compare(this.monat, o.getMonat()) == 0) {
                if (Integer.compare(this.tag, o.getTag()) == 0) {
                    if (Integer.compare(this.stunde, o.getStunde()) == 0) {
                        return Integer.compare(this.minute, o.getMinute());
                    } else {
                        return Integer.compare(this.stunde, o.getStunde());
                    }
                } else {
                    return Integer.compare(this.tag, o.getTag());
                }
            } else {
                return Integer.compare(this.monat, o.getMonat());
            }
        } else {
            return Integer.compare(this.jahr, o.getJahr());
        }
    }
}