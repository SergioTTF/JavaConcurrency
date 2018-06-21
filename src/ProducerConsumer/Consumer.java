package ProducerConsumer;

import java.util.ArrayList;

public class Consumer extends Thread {

    private int id;
    private ArrayList<Integer> numList;

    public Consumer(int idNum, ArrayList<Integer> list)  {
        this.id = idNum;
        this.numList = list;
    }

    @Override
    public void run() {
        while (true) {
            // If the list is empty the Consumer Thread will sleep for 1 second
            if (!numList.isEmpty()){
                this.remove();
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private synchronized void remove() {
        // Store number that's being removed
        int ghostNum = numList.get(numList.size() - 1);
        numList.remove(numList.size() - 1);
        System.out.println("Consumer " + this.id + " removed " + ghostNum + " from the list.");
    }
}
