package src.main.java;

public class Parkhaus implements ParkhausIF {

    private int aktuellezeit = 0;

    public Parkhaus(){}
    /**
     * pull()
     * erstellt ein auto(id,zeit)
     * @return src.main.java.Auto: gibt src.main.java.Auto zurück, dass reingefahren ist
     */
   @Override
    public Auto pull() {
        return new Auto(Auto.getCounter()+1, aktuellezeit);
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
