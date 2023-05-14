import java.util.concurrent.TimeUnit;

public class slip_6_2 {
    public static void main(String[] args) {
        TrafficSignal redSignal = new TrafficSignal("Red");
        TrafficSignal yellowSignal = new TrafficSignal("Yellow");
        TrafficSignal greenSignal = new TrafficSignal("Green");

        Thread redSignalThread = new Thread(redSignal);
        Thread yellowSignalThread = new Thread(yellowSignal);
        Thread greenSignalThread = new Thread(greenSignal);

        redSignalThread.start();
        yellowSignalThread.start();
        greenSignalThread.start();
    }
}

class TrafficSignal implements Runnable {
    private String signalColor;

    public TrafficSignal(String signalColor) {
        this.signalColor = signalColor;
    }

    public void run() {
        while (true) {
            System.out.println("Signal: " + signalColor);
            try {
                TimeUnit.SECONDS.sleep(getSignalDuration());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            changeSignalColor();
        }
    }

    private long getSignalDuration() {
        if (signalColor.equals("Red")) {
            return 5;
        } else if (signalColor.equals("Yellow")) {
            return 2;
        } else {
            return 3;
        }
    }

    private void changeSignalColor() {
        if (signalColor.equals("Red")) {
            signalColor = "Green";
        } else if (signalColor.equals("Green")) {
            signalColor = "Yellow";
        } else {
            signalColor = "Red";
        }
    }
}
