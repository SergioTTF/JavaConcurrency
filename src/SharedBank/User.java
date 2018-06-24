package SharedBank;

import java.util.Random;

public class User extends Thread {
    private double balance;
    private int id;
    private Random random;

    public User (int identifier, double initBalance){
        this.id = identifier;
        this.balance = initBalance;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            // select random 0 or 1
            int rnd = random.nextInt(2);
            double amount = random.nextInt(500) * 1.00;
            if (rnd==0) {
                this.deposit(amount);
            } else {
                this.withdraw(amount);
            }
        }
    }
    public synchronized void deposit(double num) {
        this.balance += num;
        System.out.println("User " + this.id + " deposited " + num);
        notifyAll();
    }
    public synchronized void withdraw(double num) {
        if (this.balance < num) {
            this.balance -= num;
            System.out.println("User " + this.id + " withdrew " + num);
        } else {
            System.out.println("User " + this.id + " failed to withdrew " + num);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] Args) {
        //Simulating a shared bank account with 3 users
        double initBalance = 0.00;
        for(int i=0; i<3; i++) {
            (new Thread(new User(i, initBalance))).start();
        }
    }
}
