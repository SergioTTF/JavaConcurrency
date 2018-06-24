public class Semaphore extends Object {
    private int count ;
    public Semaphore ( int startingCount ){
        this.count = startingCount;
    }
    public static void main (String[] args) {
        // Testing semaphore
        Semaphore semaphore = new Semaphore(10);
        new Thread(() -> {
            while (true) {
                semaphore.up();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) { }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                semaphore.down();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) { }
            }
        }).start();
    }
    public void down ( ) {
        synchronized ( this ) {
            while ( this.count <= 0 ) {
                // Aguarda
                try {
                    wait();
                } catch (InterruptedException ex) {
                }
            }
            System.out.println("DOWN " + this.count);
            this.count--;
        }
    }
    public void up ( ) {
        synchronized ( this ) {
            System.out.println("UP");
            count++;
            if ( count == 1 ) {
                notify();
            }
        }
    }
}
