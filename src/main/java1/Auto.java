package java1;

public class Auto {
    private int id;
    private int Zeit;
    private boolean paid1 = false;
    private static int counter = 0;

    public Auto(int id, int zeit) {
        this.id = id;
        counter++;
    }
    public int getId() {return this.id;}
    public void paid(){
        this.paid1 = true;
    }
    public static int getCounter() {return counter;}
    public boolean getStatus(){return this.paid1;}

}

