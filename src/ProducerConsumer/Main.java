package ProducerConsumer;

import java.util.ArrayList;

public class Main {

    public static void main (String[] Args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i=0; i < 2; i++) {
            (new Thread(new Producer(i, numberList, 10))).start();
        }
        for (int i=0; i < 2; i++) {
            (new Thread(new Consumer(i, numberList))).start();
        }
    }
}
