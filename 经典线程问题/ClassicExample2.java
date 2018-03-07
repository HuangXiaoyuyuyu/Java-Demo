/**
 * Created by 25375 on 2017/10/31.
 */
public class ClassicExample2 implements Runnable{
    int b = 100;

    public synchronized void m1() {
        b = 1000;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b=" +b);
    }

    public synchronized void m2() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b = 2000;
        //System.out.println(b);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClassicExample2 classicExample2 = new ClassicExample2();
        Thread thread = new Thread(classicExample2);
        thread.start();

//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        classicExample2.m2();
        System.out.println(classicExample2.b);
    }
}
