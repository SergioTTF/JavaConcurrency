package ProducerConsumerAlternative;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

    private int id;
    private final BlockingQueue<Integer> numList;
    private int maxSize;
    private Random rnd;

    public Producer(int idNum, BlockingQueue<Integer> list, int size)  {
        this.id = idNum;
        this.numList = list;
        this.maxSize = size;
        this.rnd = new Random();
    }

    @Override
    public void run() {
        while (true) {
            if (this.maxSize > this.numList.size()) {
                int number = rnd.nextInt(101);
                try {
                    this.numList.put(number);
                    System.out.println("Producer " + this.id + " inserted " + number + " in the list.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
