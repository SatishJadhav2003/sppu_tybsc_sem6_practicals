
import javax.swing.*;
import java.awt.*;

public class slip_4_1 extends JFrame implements Runnable {
    private JLabel label;

    public slip_4_1() {
        setTitle("Blinking Text");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        label = new JLabel("Welcome!");
        label.setFont(new Font("Arial", Font.BOLD, 40));

        add(label);
        setVisible(true);
    }

    public void run() {
        try {
            while (true) {
                label.setVisible(!label.isVisible()); // Toggle label visibility
                Thread.sleep(500); // Pause for 500 milliseconds
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
                slip_4_1 slip_4_1 = new slip_4_1();
                Thread thread = new Thread(slip_4_1);
                thread.start();
            }
}
