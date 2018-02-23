package ProducerConsumer;

/**
 * Created by 25375 on 2017/11/1.
 */
public class asdf {
    public static void main(String[] args) {
        SyncStack syncStack = new SyncStack();
        Producer producer = new Producer(syncStack);
        Consumer consumer = new Consumer(syncStack);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Mantou {
    int id;

    public Mantou(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mantou{" +
                "id=" + id +
                '}';
    }
}

class SyncStack {
    int index = 0;
    Mantou[] arrMT = new Mantou[6];

    public synchronized void push(Mantou mt) {
        while (index == arrMT.length - 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        arrMT[index] = mt;
        index ++;
    }

    public synchronized Mantou pop() {
        while (index == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        index --;
        return arrMT[index];
    }
}

class Producer implements Runnable {
    SyncStack syncStack = null;

    public Producer(SyncStack syncStack) {
        this.syncStack = syncStack;
    }

    @Override
    public void run() {
        for (int i=1; i<=20; i++) {
            Mantou mt = new Mantou(i);
            syncStack.push(mt);
            System.out.println("生产生产生产生产了:"+mt);
        }
    }
}

class Consumer implements Runnable {
    SyncStack syncStack = null;

    public Consumer(SyncStack syncStack) {
        this.syncStack = syncStack;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=1; i<=20; i++) {
            Mantou mt = syncStack.pop();
            System.out.println("消费了：" + mt);
        }
    }
}