package java1;

import java.util.Random;
import java.util.ArrayList;
//TODO parkdauer setter/variable löschen wenn implementation in Parkhaus/Zeit fertig
public class Auto {
    private int id;
    private Zeit timestamp;
    private Zeit parkende;
    private static int counter = 0;

    /**
     * konstruktor: setzt id,timestamp und parkende
     * @param id
     * @param timestamp
     */
    public Auto(int id, Zeit timestamp) {
        this.id = id;
        this.timestamp = timestamp;
        counter++;
        Zeit tmp = new Zeit(timestamp);
        tmp.addTime(0, random());
        this.parkende = tmp;
    }

    /**
     * berechnet "zufällig" eine Parkdauer von 1 - 2880 min
     * @return rnd Parkdauer (int)
     */
    private int random(){
        int rnd = myRandom(1,101);
        if (rnd < 50){                           //50% 30 - 120 min
            return myRandom(30,121);
        } else if(rnd >= 50 && rnd < 60) {       //10%  1 - 30 min
            return myRandom(1,31);
        } else if(rnd >= 60 && rnd < 80) {       //20% 2h - 4h
            return myRandom(121,241);
        } else if(rnd >= 80 && rnd < 90) {       //10% 4h - 8h
            return myRandom(241, 481);
        } else{                                  //10% 8h - 2d
            return myRandom(481, 2881);
        }
    }
    private static int myRandom(int a, int b) {
        Random r = new Random();
        return a + (int)(Math.random() * (b - a));
    }

    public String toString(){return "Auto: " + this.id;}
    public int getId() {return this.id;}
    public Zeit getParkende(){return this.parkende;}
    public Zeit getTimestamp(){return this.timestamp;}
    public static int getCounter() {return counter;}

    public void setParkende(Zeit parkende) {this.parkende = parkende;}
}

