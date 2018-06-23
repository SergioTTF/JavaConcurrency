package ProducerConsumer;

import java.util.ArrayList;

public class Consumer extends Thread {

    private int id;
    private final ArrayList<Integer> numList;

    public Consumer(int idNum, ArrayList<Integer> list)  {
        this.id = idNum;
        this.numList = list;
    }

    @Override
    public void run() {
        while (true) {
            this.remove();
        }
    }
    private void remove() {
        // If the list is empty the Consumer Thread will sleep for 0.2 seconds
        synchronized(this.numList) {
            if (numList.size() > 0){
                System.out.println("Consumer " + this.id + " removed " + numList.get(numList.size() - 1) + " from the list.");
                numList.remove(numList.size() - 1);
            } else {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
