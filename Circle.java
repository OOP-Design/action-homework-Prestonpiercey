import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class Circle{
    public static void main(String[] args){
        CircleFrame cframe = new CircleFrame();
    }
}

class CircleFrame extends JFrame{
    private int s = 500;
    private CirclePanel cpanel;

    public CircleFrame(){
        setSize(s, s);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cpanel = new CirclePanel();
        add(cpanel);
    }
}

class CirclePanel extends JPanel{
    Point circlePoint = new Point((int) (Math.random() * getWidth()), (int) (Math.random() * getHeight()));
    int circleRad = 20;
    int circleColor = 0;


    public CirclePanel(){
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseMoved(MouseEvent e){
                if (e.getPoint().distance(circlePoint) <= circleRad){
                    circlePoint.setLocation(Math.random() * getWidth(), Math.random() * getHeight());
                    repaint();
                }
                circleColor = (int) (255/Math.sqrt(e.getPoint().distance(circlePoint)/circleRad));
                System.out.println(circleColor);
                repaint();
            }
        });
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(circleColor, 0, 0));
        g2.fillOval((int) circlePoint.getX() - (int) circleRad, (int) circlePoint.getY() - (int) circleRad, (int) circleRad*2, (int) circleRad*2);
    }
}
