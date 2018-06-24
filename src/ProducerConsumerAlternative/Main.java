package ProducerConsumerAlternative;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main (String[] Args) {
        BlockingQueue<Integer> numberList = new ArrayBlockingQueue<Integer>(10);
        for (int i=0; i < 2; i++) {
            (new Thread(new Producer(i, numberList, 10))).start();
        }
        for (int i=0; i < 2; i++) {
            (new Thread(new Consumer(i, numberList))).start();
        }
    }
}
