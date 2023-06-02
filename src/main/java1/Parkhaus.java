package java1;
import java.util.ArrayList;
import java.util.List;

import java1.Auto;
public class Parkhaus implements ParkhausIF {

    private Zeit aktuelleZeit;
    private double tarif;
    private ArrayList<Auto> autoList = new ArrayList<Auto>();

    /**
     * konstruktor
     * @param size Parkhaus
     * @param tarif in Euro pro min
     */
    public Parkhaus(int size, double tarif){
        autoList = new ArrayList<Auto>(size);
        aktuelleZeit = new Zeit();
        this.tarif = tarif;
    }
    public Parkhaus(int size, double tarif, Zeit z1){
        autoList = new ArrayList<Auto>(size);
        this.tarif = tarif;
        aktuelleZeit = z1;
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
       String log = "Auto: " + a1.getId() + ", Dauer: " + a1.getParkende().subtract(a1.getTimestamp()) + "min, Preis: " + preis+"€";
       autoList.remove(a1);
       System.out.print(log+"\n");
       return log;
    }
    public String push(List<Auto> list){
       //TODO bisschen getested
        String log = "";
        for(int i=0; i<list.size();i++){
            double preis = list.get(i).getParkende().subtract(list.get(i).getTimestamp()) * this.tarif;
            log += "Auto: " + list.get(i).getId() + ", Dauer: " + list.get(i).getParkende().subtract(list.get(i).getTimestamp()) + "min, Preis: " + preis+"€\n";
            autoList.remove(list.get(i));
        }
        System.out.print(log+"\n");
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
}
