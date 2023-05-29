package java1;
import java.util.ArrayList;

public class Parkhaus implements ParkhausIF {

    private Zeit aktuellezeit = new Zeit();
    private ArrayList autoList = new ArrayList<Auto>();

    public Parkhaus(){}
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
    public String push(Auto a1){
       if(a1.getStatus()){
           return "Gute Fahrt";
       } else {
           return "Bitte Ticket bezahlen!";
       }

    }

    public void pay(Auto a1) {
       a1.paid();
    }




}
