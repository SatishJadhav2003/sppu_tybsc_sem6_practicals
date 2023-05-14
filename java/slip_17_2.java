import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class slip_17_2 extends JFrame {
    JTextField textField;
    JButton startButton;
    JButton stopButton;
    Thread numberDisplayThread;
    boolean running;

    public slip_17_2() {
        setTitle("Number Display");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(10);
        textField.setEditable(false);
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!running) {
                    running = true; 
                    numberDisplayThread = new Thread(new NumberDisplayRunnable());
                    numberDisplayThread.start();
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running = false;
            }
        });

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(startButton);
        panel.add(stopButton);

        add(panel);
    }

    int number = 1;

    private class NumberDisplayRunnable implements Runnable {
        public void run() {

            while (running && number <= 100) {
                textField.setText(Integer.toString(number));
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            number++;

        }
    }

    public static void main(String[] args) {
        slip_17_2 app = new slip_17_2();
        app.setVisible(true);
    }
}
