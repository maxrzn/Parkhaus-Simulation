package java1;
import java.util.ArrayList;
import java.util.List;

import java1.Auto;
public class Parkhaus implements ParkhausIF {

    private Zeit aktuelleZeit;
    private double tarif;
    private ArrayList<Auto> autoList = new ArrayList<Auto>();
    private String log;

    /**
     * konstruktor
     * @param size Parkhaus
     * @param tarif in Euro pro min
     */
    public Parkhaus(int size, double tarif){
        autoList = new ArrayList<Auto>(size);
        aktuelleZeit = new Zeit();
        this.tarif = tarif;
        this.log = "";
    }
    public Parkhaus(int size, double tarif, Zeit z1){
        autoList = new ArrayList<Auto>(size);
        this.tarif = tarif;
        aktuelleZeit = z1;
        this.log = "";
    }
    /**
     * erstellt ein auto(id,zeit), fügt es zu autoList hinzu
     * @return java1.Auto
     */
   @Override
    public Auto pull() {
       Auto tmp = new Auto(Auto.getCounter()+1, aktuelleZeit);
       autoList.add(tmp);
       return tmp;
    }

    @Override
    public String push(Auto a1){
       double preis = a1.getParkende().subtract(a1.getTimestamp()) * this.tarif;
       String log = "<p class=\"color\"><red>"+this.aktuelleZeit+": </red>Auto: " + a1.getId() + ", Dauer: " + a1.getParkende().subtract(a1.getTimestamp()) + "min, Preis: " + preis+"€</p>\n";
       autoList.remove(a1);
       this.log += log;
       return log;
    }
    public String push(List<Auto> list){
       //TODO bisschen getested
        String log = "";
        for(int i=0; i<list.size();i++){
            double preis = list.get(i).getParkende().subtract(list.get(i).getTimestamp()) * this.tarif;
            preis = Math.round(preis*100.0)/100.0;
            log += "<tr>\n" +
                    "   <td>\n" +
                    "<p class=\"color\"><red>"+list.get(i).getParkende()+" </red>\n" +
                    "   </td>\n" +
                    "   <td>" + list.get(i).getId() + "</td>\n" +
                    "   <td>" + list.get(i).getParkende().subtract(list.get(i).getTimestamp()) + " min</td>\n" +
                    "   <td>" + preis+"&#8364 </p></td>\n" +
                    "</tr>\n";
            autoList.remove(list.get(i));
        }
        this.log += log;
        return log;
    }
    public void timewarp(String timestamp){
     aktuelleZeit.setTime(timestamp);
     checkparktime();
    }
    public void timeskip(int stunde, int minute){
       this.aktuelleZeit.addTime(stunde, minute);
       checkparktime();
    }
    /**
    * prüft ob die Parkzeit eines Autos abgelaufen ist und ruft push(i) auf
    */
    public void checkparktime() {
        //TODO funktioniert auf den ersten Blick und tests aber nochmal prüfen bevor alten code löschen
        //ArrayList<Auto> tmp = new ArrayList<Auto>(this.autoList);
        List<Auto> ltmp = this.autoList
                .stream()
                .filter(auto -> auto.getParkende().compareTo(this.aktuelleZeit) <= 0)
                .toList();
        push(ltmp);
        /*
        for(int i=0; i<tmp.size(); i++) {
            if (tmp.get(i) != null) {
                if(tmp.get(i).getParkende().compareTo(this.aktuelleZeit) <= 0){
                    push(tmp.get(i));
                }
            }
        }*/
    }

    public ArrayList<Auto> getAutoList(){return this.autoList;}
    public Zeit getAktuelleZeit(){return this.aktuelleZeit;}
    public String getLog(){return this.log;}
}
