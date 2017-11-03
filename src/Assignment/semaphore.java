package Assignment;

import java.util.LinkedList;
import java.util.Queue;


public class semaphore {
    private int counter;
    private Queue<Customer> queue;
    semaphore()
    {
        counter = 0;
        queue = null;
    }
    semaphore(int c)
    {
        counter = c;
        queue = new LinkedList<Customer>();
    }

    public int availablePermits()
    {
        return counter;
    }

    public  void acquire(Customer c)
    {
        synchronized (this)
        {
            counter--;
            if (counter >= 0)
            {
                c.r.Enter(c);
                return;
            }
        }

        if (counter<0)
        {
            queue.add(c);
            try
            {
                c.join();
            } catch (InterruptedException e)
            {
                c.r.Enter(c);
            }
        }

    }
    public synchronized void release()
    {
        counter++;
        if (!queue.isEmpty()) {
            Customer c = queue.remove();
            c.interrupt();
        }

    }

}
