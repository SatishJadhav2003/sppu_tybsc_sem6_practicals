import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class slip_24_1 extends JFrame {
     JLabel textLabel;
     Timer timer;
     int position;
    public slip_24_1() {
        setTitle("Scrolling Text");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);

        // Create the text label
        textLabel = new JLabel("This is a scrolling text demo.");
        add(textLabel, BorderLayout.CENTER);

        // Initialize the timer
        position = 0;
        timer = new Timer(1, new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                position++;
                textLabel.setLocation(position, 0);
                if (position >= getWidth())
                    position = -textLabel.getWidth();
            }
        });
    }

    public void startScrolling() {
        timer.start();
    }

    public static void main(String[] args) {
            slip_24_1 frame = new slip_24_1();
            frame.setVisible(true);
            frame.startScrolling();
    }
}
