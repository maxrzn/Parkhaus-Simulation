package java1;
import java.util.ArrayList;
import java1.Auto;

public class Parkhaus implements ParkhausIF {

    private Zeit aktuellezeit = new Zeit();
    private double tarif;
    private ArrayList<Auto> autoList = new ArrayList<Auto>();

    public Parkhaus(int size, double tarif){
        autoList = new ArrayList<Auto>(size);
        this.tarif = tarif;
    }
    /**
     * erstellt ein auto(id,zeit), fügt es zu autoList hinzu
     * @return java1.Auto
     */
   @Override
    public Auto pull() {
       Auto tmp = new Auto(Auto.getCounter()+1, aktuellezeit);
       autoList.add(tmp);
       return tmp;
    }

    @Override
    public String push(int a1){
       double preis = autoList.get(a1).getParkdauer() * this.tarif;
       String log = "Auto: " + autoList.get(a1).getId() + " Dauer: " + autoList.get(a1).getParkdauer() + "Preis: " + preis;
       autoList.remove(a1);
       return log;
    }
    public void timewarp(){
     //TODO aktuellezeit.setTime()
     checkparktime();
    }
    public void timeskip(){
       //TODO aktuelleZeit.addTime()
       checkparktime();
    }
    /**
    * prüft ob die Parkzeit eines Autos abgelaufen ist und ruft push(i) auf
    */
    public void checkparktime() {
        for(int i=0; i<autoList.size(); i++) {
            if (autoList.get(i) != null) {
                if(autoList.get(i).getParkende().compareTo(this.aktuellezeit) <= 0){
                    push(i);
                }
            }
        }
    }
}
