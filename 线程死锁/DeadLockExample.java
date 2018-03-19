/**
 * Created by 25375 on 2017/10/30.
 */
public class DeadLockExample implements Runnable{
    public int flag = 1;
    public static Object object1 = new Object();
    public static Object object2 = new Object();

    @Override
    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (object1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    System.out.println("1");
                }
            }
        }

        if (flag == 0) {
            synchronized (object2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLockExample deadLockExample1 = new DeadLockExample();
        DeadLockExample deadLockExample2 = new DeadLockExample();
        deadLockExample1.flag = 1;
        deadLockExample2.flag = 0;
        Thread thread1 = new Thread(deadLockExample1);
        Thread thread2 = new Thread(deadLockExample2);
        thread1.start();
        thread2.start();
    }
}
