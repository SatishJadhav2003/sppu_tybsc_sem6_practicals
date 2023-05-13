
import javax.swing.*;
import java.awt.*;

public class slip_20_2 extends JFrame implements Runnable {

    JLabel label;
    ImageIcon img;

    slip_20_2() {
        setTitle("Blinking image");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        img = new ImageIcon("satishjadhav.jpeg");
        label = new JLabel(img);
        add(label);

        setVisible(true);
    }

    public void run() {
        try {
            while (true) {
                label.setVisible(!label.isVisible());
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        slip_20_2 s = new slip_20_2();
        Thread thread = new Thread(s);
        thread.start();
    }

}