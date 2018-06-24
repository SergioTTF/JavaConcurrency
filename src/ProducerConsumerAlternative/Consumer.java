package ProducerConsumerAlternative;


import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

    private int id;
    private final BlockingQueue<Integer> numList;

    public Consumer(int idNum, BlockingQueue<Integer> list)  {
        this.id = idNum;
        this.numList = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer " + this.id + " removed " + this.numList.take() + " from the list.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
