public class Auto {
    private int id;
    private int Zeit;
    private static int counter = 0;

    public Auto(int id, int zeit) {
        this.id = id;
        counter++;
    }
    public int getId() {return this.id;}
    public static int getCounter() {return counter;}
}

