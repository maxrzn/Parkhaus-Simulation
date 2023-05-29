package java1;

public class Auto {
    private int id;
    private Zeit timestamp;
    private static int counter = 0;

    public Auto(int id, Zeit timestamp) {
        this.id = id;
        this.timestamp = timestamp;
        counter++;
    }
    private int random(){

    }
    public int getId() {return this.id;}
    public static int getCounter() {return counter;}
}

