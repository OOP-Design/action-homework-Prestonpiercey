import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class Button{
    public static void main(String[] args){
        KeyFrame kframe = new KeyFrame();
    }
}

class KeyFrame extends JFrame{
    private int s = 500;
    private KeyPanel kpanel = new KeyPanel();

    public KeyFrame(){
        setSize(s, s);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(kpanel);
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                kpanel.addtok(e.getKeyText(e.getKeyCode()));
            }
        });
    }
}

class KeyPanel extends JPanel{
    private ArrayList<String> keyArray = new ArrayList<String>();
    private ArrayList<Point> keyPointArray = new ArrayList<Point>();
    private int i = 0;

    public KeyPanel(){
        addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                reset(e.getButton());
            }
        });
    }

    public void addtok(String in){
        keyArray.add(i, in);
        keyPointArray.add(i, getRandomPoint());
        i++;
        repaint();
    }

    private Point getRandomPoint(){
        return new Point((int) (Math.random() * getWidth()), (int) (Math.random() * getHeight()));
    }

    private void reset(int button){
        if (button == 3){
            keyArray.clear();
            keyPointArray.clear();
            i = 0;
            repaint();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int iter = 0;
        Point dPoint;
        while(iter<keyArray.size()){
            dPoint = keyPointArray.get(iter);
            g2.drawString(keyArray.get(iter), (int) dPoint.getX(), (int) dPoint.getY());
            iter++;
        }
    }
}
