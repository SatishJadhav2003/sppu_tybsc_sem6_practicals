import java.util.Random;

public class slip_7_1 {
    public static void main(String[] args) {
        createNumber cn = new createNumber();
        cn.start();
    }
}

class createNumber extends Thread {
    int n;
    Random random = new Random();

    public void run() {
        for (;;) {
            try {
                n = random.nextInt(100);
                if (n % 2 == 0) {
                    evenNum en = new evenNum(n);
                    en.start();
                } else {
                    oddNum od = new oddNum(n);
                    od.start();
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}

class evenNum extends Thread {
    int num;

    evenNum(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("Square of " + num + " : " + num * num);
    }
}

class oddNum extends Thread {
    int num;

    oddNum(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("Cube of " + num + " : " + num * num * num);
    }
}
