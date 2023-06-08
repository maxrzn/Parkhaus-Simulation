package java1;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java1.Auto;
public class Parkhaus implements ParkhausIF {

    private Zeit aktuelleZeit;
    private double tarif;
    private ArrayList<Auto> autoList = new ArrayList<Auto>();
    private String inlog;
    private String outlog;

    /**
     * konstruktor
     * @param size Parkhaus
     * @param tarif in Euro pro min
     */
    public Parkhaus(int size, double tarif){
        autoList = new ArrayList<Auto>(size);
        aktuelleZeit = new Zeit();
        this.tarif = tarif;
        this.outlog = "";
        this.inlog ="";
    }
    public Parkhaus(int size, double tarif, Zeit z1){
        autoList = new ArrayList<Auto>(size);
        this.tarif = tarif;
        aktuelleZeit = z1;
        this.outlog = "";
        this.inlog ="";
    }
    /**
     * erstellt ein auto(id,zeit), fügt es zu autoList hinzu
     * @return java1.Auto
     */
   @Override
    public Auto pull() {
       Auto tmp = new Auto(Auto.getCounter()+1, aktuelleZeit);

       this.inlog +="<tr>\n" +
               "   <td>\n" +
               "       <p class=\"color\"> <red>" + this.aktuelleZeit + " </red></p>\n" +
               "   </td>\n" +
               "   <td>\n" +
               "       <p>" + tmp.getId() + "</p>\n" +
               "   </td>\n" +
               "</tr>\n";

       autoList.add(tmp);
       return tmp;
    }

    @Override
    public String push(Auto a1){
       double preis = a1.getParkende().subtract(a1.getTimestamp()) * this.tarif;
       String outlogtmp = "<tr>\n" +
               "   <td>\n" +
               "<p class=\"color\"><red>"+a1.getParkende()+" </red></p>\n" +
               "   </td>\n" +
               "   <td>" + a1.getId() + "</td>\n" +
               "   <td>" + a1.getParkende().subtract(a1.getTimestamp()) + " min</td>\n" +
               "   <td>" + preis+"&#8364;</td>\n" +
               "</tr>\n";
       autoList.remove(a1);
       this.outlog += outlogtmp;
       return outlogtmp;
    }
    public String push(List<Auto> list){
        String outlogtmp = "";
        for(int i=0; i<list.size();i++){
            double preis = list.get(i).getParkende().subtract(list.get(i).getTimestamp()) * this.tarif;
            preis = Math.round(preis*100.0)/100.0;
            outlogtmp += "<tr>\n" +
                    "   <td>\n" +
                    "<p class=\"color\"><red>"+list.get(i).getParkende()+" </red></p>\n" +
                    "   </td>\n" +
                    "   <td>" + list.get(i).getId() + "</td>\n" +
                    "   <td>" + list.get(i).getParkende().subtract(list.get(i).getTimestamp()) + " min</td>\n" +
                    "   <td>" + preis+"&#8364;</td>\n" +
                    "</tr>\n";
            autoList.remove(list.get(i));
        }
        this.outlog += outlogtmp;
        return outlogtmp;
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
        List<Auto> ltmp = this.autoList
                .stream()
                .filter(auto -> auto.getParkende().compareTo(this.aktuelleZeit) <= 0)
                .collect(Collectors.toList());
        push(ltmp);
    }

    public ArrayList<Auto> getAutoList(){return this.autoList;}
    public Zeit getAktuelleZeit(){return this.aktuelleZeit;}
    public String getOutlog(){return this.outlog;}
    public String getInlog(){return this.inlog;}
}
