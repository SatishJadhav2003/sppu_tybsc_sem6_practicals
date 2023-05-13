public class slip_8_1 {
    public static void main(String[] args) {
        printmessage first = new printmessage(10,"COVID19");
        printmessage second = new printmessage(20,"LOCKDOWN2020");
        printmessage third = new printmessage(30,"VACCINATED2021");

        first.start();
        second.start();
        third.start();
    }
}

class printmessage extends Thread {
    int n;
    String msg;

    printmessage(int n, String msg) {
        this.n = n;
        this.msg = msg;
    }

    public void run()
    {
        for(int i=0;i<n;i++)
        {
            System.out.println(msg);
        }
    }
}