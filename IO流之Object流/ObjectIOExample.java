import java.io.*;

/**
 * Created by 25375 on 2017/10/28.
 */
public class ObjectIOExample {
    public static void main(String[] args) {
        T t = new T();
        t.k = 8;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\Programming\\JetBrains\\idea files\\IO\\src\\eee.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(t);
            objectOutputStream.flush();
            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("D:\\Programming\\JetBrains\\idea files\\IO\\src\\eee.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            T tRead = (T) objectInputStream.readObject();
            System.out.println(tRead.i + " " + tRead.j + " " + tRead.d + " " + tRead.k);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class T implements Serializable{
    int i = 10;
    int j = 9;
    double d = 2.3;
    transient int k = 15;
}