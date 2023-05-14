/**
 * test
 */
public class test {

    public static void main(String[] args) {
        signal yellow = new signal("Yellow");
        signal green = new signal("Green");
        signal red = new signal("Red");
        yellow.start();
        green.start();
        red.start();
    }
}

class signal extends Thread {
    String signalName;

    signal(String name) {
        this.signalName = name;
    }

    public void run() {
        while (true) {
            System.out.println("Signal : "+signalName);
            try
            {
                Thread.sleep(signalTime());
            }catch(Exception e)
            {
                System.out.println(e);
            }
            changeSignalColor();
            
        }
    }

    int signalTime()
    {
        if (signalName.equals("Red")) {
            return 5000;
        }
        else if (signalName.equals("Yellow")) {
            return 3000;
        } else {
            return 2000;
        }
    }

    void changeSignalColor()
    {
        if (signalName.equals("Red")) {
            this.signalName = "Yellow";
        }
        else if (signalName.equals("Yellow")) {
            this.signalName = "Green";
        } else {
            this.signalName = "Red";
        }
    }
}