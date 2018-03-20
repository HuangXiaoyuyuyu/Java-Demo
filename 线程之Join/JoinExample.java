/**
 * Created by 25375 on 2017/10/30.
 */
public class JoinExample {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2("abcde");
        myThread2.start();
        try {
            myThread2.join();
        } catch (InterruptedException e) {
        //    e.printStackTrace();
        }
        for (int i=0; i<=10; i++) {
            System.out.println("I'm Main Thread");
        }
    }
}

class MyThread2 extends Thread {
    MyThread2(String s) {
        super(s);
    }

    @Override
    public void run() {
        for (int i=0; i<=10; i++) {
            System.out.println("I'm " + getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            //    e.printStackTrace();
                return;
            }
        }
    }
}