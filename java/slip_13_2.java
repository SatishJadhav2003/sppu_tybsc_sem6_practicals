import java.util.*;

public class slip_13_2 {
    public static void main(String[] args) {
        lifecycle lc = new lifecycle("Satish");
        lc.start();
    }
}
 
class lifecycle extends Thread {
    String name;
    Random random;

    lifecycle(String name) {
        this.name = name;
        this.random = new Random();
    }

    public void run() {
        System.out.println("Process " + name + " is created ......");
        int sleeptime = random.nextInt(5000);
        try {
            Thread.sleep(sleeptime);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Process " + name + " was sleep for " + sleeptime + " time");
        System.out.println("Process " + name + " is dead");
    }

}