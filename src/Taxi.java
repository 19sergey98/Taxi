import java.io.*;

public class Taxi implements Serializable {
    int number;
    String sourceVertex;
    boolean isFree;

    public Taxi(int number, String sourceVertex) {
        this.number = number;
        this.sourceVertex = sourceVertex;
        this.isFree = true;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "number='" + number + '\'' +
                ", sourceVertex='" + sourceVertex + '\'' +
                ", isFree=" + isFree +
                '}';
    }

    public static void SaveToFile(Taxi taxi, String adress) throws IOException {
        FileOutputStream fos = new FileOutputStream(adress);
        ObjectOutputStream asd = new ObjectOutputStream(fos);
        asd.writeObject(taxi);
        asd.close();
    }

    public static Taxi LoadFromFile(String adress) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(adress);
        ObjectInputStream asd = new ObjectInputStream(fis);
        Taxi obj = (Taxi) asd.readObject();
        asd.close();
        return obj;
    }
}