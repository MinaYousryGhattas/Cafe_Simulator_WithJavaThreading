package Assignment;

import java.util.Random;

public class Customer extends Thread {
    String name;
    Restaurant r;
    Random rand;

    Customer() {
        name = "";
        r = null;
        rand = new Random();
    }

    Customer(String n, Restaurant rest) {
        name = n;
        r = rest;
        rand = new Random();
    }


    public void run() {
        r.arrive(this);
        r.Semaphore.acquire(this);
        r.order(this);
        r.eat(this);
        r.leave(this);
        r.Semaphore.release();
    }

}
