public class slip_28_2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadName());
        Thread thread2 = new Thread(new ThreadName());
        thread1.start();
        thread2.start();
    }
}

class ThreadName implements Runnable
{
    public void run()
    {
        for(;;)
        {
            String name = Thread.currentThread().getName();
            System.out.println(name);
        }
    }
}