import java.util.LinkedList;

public class slip_21_2 {

    public static void main(String[] args) {
        producerConsumer pc = new producerConsumer();
        producer p =new producer(pc);
        p.start();
        consumer c = new consumer(pc);
        c.start();
      
    }

}

class producer extends Thread {
    producerConsumer pc;
    producer(producerConsumer pc)
    {
        this.pc = pc;
    }
    public void run()
    {
        try{
            pc.producer();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

class consumer extends Thread {
    producerConsumer pc;
    consumer(producerConsumer pc)
    {
        this.pc = pc;
    }
    public void run()
    {
        try{
            pc.consumer();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

class producerConsumer {
    int capacity = 2, data = 0;
    LinkedList<Integer> ll = new LinkedList<Integer>();

    public void producer() throws InterruptedException
    {
        while (true) {
            synchronized(this)
            {
                while (ll.size() == capacity) {
                    wait();
                }
                ll.add(++data);
                System.out.println("producer = "+data);
                Thread.sleep(1000);
                notifyAll();
            }
        }
    }

    public void consumer() throws InterruptedException
    {
        while (true) {
            synchronized(this)
            {
                while (ll.size() == 0) {
                    wait();
                }
                data = ll.removeFirst();
                System.out.println("Consume = "+data);
                Thread.sleep(1000);
                notifyAll();
            }
        }
    }

}