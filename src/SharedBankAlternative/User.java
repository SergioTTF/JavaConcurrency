package SharedBankAlternative;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class User extends Thread {
    private AtomicInteger balance;
    private int id;
    private Random random;

    public User (int identifier, AtomicInteger integer){
        this.id = identifier;
        this.balance = integer;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            // select random 0 or 1
            int rnd = random.nextInt(2);
            int amount = random.nextInt(500);
            if (rnd==0) {
                this.deposit(amount);
            } else {
                this.withdraw(amount);
            }
        }
    }
    public void deposit(int num) {
        this.balance.addAndGet(num);
        System.out.println("User " + this.id + " deposited " + num);
    }
    public void withdraw(int num) {
        if (this.balance.get() > num) {
            this.balance.addAndGet(num * (-1));
            System.out.println("User " + this.id + " withdrew " + num);
        } else {
            System.out.println("User " + this.id + " failed to withdrew " + num);
        }
    }

    public static void main (String[] Args) {
        //Simulating a shared bank account with 3 users
        AtomicInteger initBalance = new AtomicInteger();
        for(int i=0; i<3; i++) {
            (new Thread(new User(i, initBalance))).start();
        }
    }
}
