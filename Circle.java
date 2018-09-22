import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
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
    private Point cPoint = new Point();
    private int cRad = 20;

    public CirclePanel(){
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseMoved(MouseEvent e){
                if (e.getPoint().distance(cPoint) <= cRad){
                    repaint();
                }
            }
        });
    }

    private void randCirclePoint(){
        cPoint.setLocation(Math.random() * getWidth(), Math.random() * getHeight());
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        randCirclePoint();
        g2.fillOval((int) cPoint.getX() - cRad, (int) cPoint.getY() - cRad, cRad*2, cRad*2);
    }
}
