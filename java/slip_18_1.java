public class slip_18_1 {
    public static void main(String[] args) {
        Thread thread1 =  new Thread(new ThreadInfo());
        Thread thread2 =  new Thread(new ThreadInfo());
        thread1.start();
        thread2.start();

    }
}


class ThreadInfo implements Runnable
{
    public void run()
    {
            String name = Thread.currentThread().getName();
            int priority = Thread.currentThread().getPriority();
            System.out.println(name +" = "+priority);
       
    }
}