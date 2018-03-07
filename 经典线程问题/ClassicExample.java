/**
 * Created by 25375 on 2017/10/30.
 */
public class ClassicExample implements Runnable{
    public int b = 100;

    public synchronized void m1() {
        b = 1000;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b = " + b);
    }

    public void m2() {
        System.out.println(b);
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
        ClassicExample classicExample = new ClassicExample();
        Thread thread = new Thread(classicExample);
        thread.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        classicExample.m2();
    }
}
