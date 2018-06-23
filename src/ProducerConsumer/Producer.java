package ProducerConsumer;

import java.util.ArrayList;
import java.util.Random;

public class Producer extends Thread {

    private int id;
    private final ArrayList<Integer> numList;
    private int maxSize;
    private Random rnd;

    public Producer(int idNum, ArrayList<Integer> list, int size)  {
        this.id = idNum;
        this.numList = list;
        this.maxSize = size;
        this.rnd = new Random();
    }

    @Override
    public void run() {
        while (true) {
            //If the list is full the Producer Thread will sleep for 0.2 seconds
            if (this.maxSize > this.numList.size()) {
                int number = rnd.nextInt(101);
                this.insert(number);
            } else {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void insert(int n) {
        numList.add(n);
        System.out.println("Producer " + this.id + " inserted " + n + " in the list.");
    }
}
