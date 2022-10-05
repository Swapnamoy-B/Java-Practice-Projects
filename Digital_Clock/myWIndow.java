import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;


public class myWIndow extends JFrame {
    private JLabel heading;
    private JLabel clockLable;

    private Font f=new Font("",Font.BOLD,35);

    myWIndow(){
        super.setTitle("My Clock"); //calling setTitle class of Jframe
        super.setSize(400,400);
        super.setLocation(300,50);
        this.gui();

        setVisible(true);
    }

    public void gui(){
        //gui

        heading =  new JLabel("My Clock");
        clockLable = new JLabel("Clock");

        heading.setFont(f);
        clockLable.setFont(f);

        this.setLayout(new GridLayout(3,2));
        this.add(heading);
        this.add(clockLable);

        this.startClock();
    }

    public void startClock()
    {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String dateTime=new Date().toString();

                //String dateTime=new Date().toLocaleString();

                Date d = new Date();

                SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss");
                String dateTime=sdf.format(d);

                clockLable.setText(dateTime);
            }
        });
        timer.start();
    }
    
}
