import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;


public class myWindow extends JFrame {
    private JLabel heading;
    private JLabel clockLable;

    private Font f = new Font("", Font.BOLD, 35);

    myWindow() {
        super.setTitle("My Clock"); //calling setTitle class of Jframe
        super.setSize(400, 400);
        super.setLocation(300, 50);
        this.gui();

        setVisible(true);
    }

    public void gui() {
        //gui

        heading = new JLabel("My Clock");
        clockLable = new JLabel("Clock");

        heading.setFont(f);
        clockLable.setFont(f);

        this.setLayout(new GridLayout(3, 2));
        this.add(heading);
        this.add(clockLable);

        this.startClock();
    }

    public void startClock() {

        Thread t = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Date d = new Date();

                        SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");
                        String dateTime = sdf.format(d);

                        clockLable.setText(dateTime);

                        Thread.currentThread().sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}


