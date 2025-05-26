// Concurrent Problems Solution
class Counter {

    // Shared resource
    private int count = 0;

    // Synchronized method to ensure
    // thread-safe increment
    public synchronized void increment()
    {

        // Increment the counter
        count++;
    }

    // Method to get the current count
    public int getCount() { return count; }
}

class CounterThread extends Thread {
    private Counter counter;

    // Constructor to initialize the
    // counter
    public CounterThread(Counter counter)
    {
        this.counter = counter;
    }

    // Override the run method to
    // increment the counter
    @Override public void run()
    {
      	System.out.println("Running the Thread");
        
      	// Increment the counter
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Geeks
{
    public static void main(String[] args)
    {

        // Create a shared Counter object
        Counter counter = new Counter();

        // Create multiple threads that will
        // increment the counter
        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);
        Thread t3 = new CounterThread(counter);

        // Start the threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final count
        System.out.println("Final count: "
                           + counter.getCount());
    }
}
