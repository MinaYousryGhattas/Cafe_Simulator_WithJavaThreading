package Assignment;

import java.util.Random;
//import java.util.concurrent.Semaphore;

public class Restaurant {
    int numberoftables;
    Customer[] tables;
    Random rand;
    semaphore Semaphore;

    Restaurant() {
        numberoftables = 0;
        tables = null;
        Semaphore = null;
        rand = null;
    }

    Restaurant(int n) {
        numberoftables = n;
        tables = new Customer[n];
        Semaphore = new semaphore(n);
        rand = new Random();
    }

    public synchronized void Enter(Customer c) {
        for (int i = 0; i < numberoftables; i++) {
            if (tables[i] == null) {
                tables[i] = c;
                System.out.println(c.name + " enters and sits on table " + (int) (i + 1) + ".");
                return;
            }
        }
        System.out.println(" didn't find seat");

    }

    public synchronized void Leave(Customer c) {
        for (int i = 0; i < numberoftables; i++)
            if (tables[i] != null && tables[i].name == c.name) {
                tables[i] = null;
                return;
            }
    }

    public  void order(Customer c) {

        System.out.println(c.name + " orders the food.");
        try {
            Thread.sleep(rand.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void arrive(Customer c) {

        System.out.println(c.name + " arrives at the restaurant.");// + c.r.semaphore.availablePermits());
        if (Semaphore.availablePermits() <= 0) {
            System.out.println(c.name + " is waiting");
        }
    }

    public  void eat(Customer c) {
        System.out.println(c.name + " eats the food.");
        try {
            Thread.sleep(rand.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void leave(Customer c) {
        System.out.println(c.name + " leaves the restaurant.");
        Leave(c);
    }
}