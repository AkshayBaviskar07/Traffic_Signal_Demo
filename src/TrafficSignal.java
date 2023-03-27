import javax.swing.*;
import java.awt.*;

class SignalTimer extends JFrame implements Runnable{
    Thread t = null;
    int time, color;

    SignalTimer(){
        t = new Thread(this);
        time = 10;
        color = 0;
        t.start();
        setSize(200, 250);
        setVisible(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // show();
    }

    @Override
    public void run() {
        try{
            while(true){
                while(time >= 0){
                    Thread.sleep(1000);    //sleep for 1 second
                    time--;
                    repaint();
                }
                color = (color+1)%3; //change the color
                time = 10;
                if(color == 1)     //Orange
                    time = 5;
            }
        }catch(InterruptedException e){}
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, 200, 250);
        g.setColor(Color.black);
        g.drawOval(30, 35, 50, 50);
        g.drawOval(30, 85, 50, 50);
        g.drawOval(30, 135, 50, 50);

        String message = "Time: " + time;
        g.drawString(message, 35, 205);

        if(color == 0){    //Green
            g.setColor(Color.green);
            g.fillOval(30, 135, 50, 50);
            g.setColor(Color.black);
            g.fillOval(30, 85, 50, 50);
            g.setColor(Color.BLACK);                        //red
            g.fillOval(30, 35, 50, 50);
        }
        else if(color == 1){ // Orange
            g.setColor(Color.black);                        //green
            g.fillOval(30, 135, 50, 50);
            g.setColor(Color.orange);                       //orange
            g.fillOval(30, 85, 50, 50);
            g.setColor(Color.BLACK);                        //red
            g.fillOval(30, 35, 50, 50);
        }
        else{
            g.setColor(Color.black);                        //green
            g.fillOval(30, 135, 50, 50);
            g.setColor(Color.black);                        //orange
            g.fillOval(30, 85, 50, 50);
            g.setColor(Color.red);                          //red
            g.fillOval(30, 35, 50, 50);
        }
    }
}
public class TrafficSignal {
    private JPanel PanelMain;
    public static void main(String[] args) {


        new SignalTimer();
    }
}
