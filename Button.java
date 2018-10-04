import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

/**
 * This is the class that contains the code for the java machine
 * to run. It makes and displays a kFrame of type KeyFrame
 * @see KeyFrame
 * @author Preston Piercey
 */
public class Button{
    public static void main(String[] args){
        KeyFrame kframe = new KeyFrame();
        kframe.show();
    }
}

/**
 * Sets up a frame to display a KeyPanel on. Uses an anonymous internal Class
 * to set up a listener and processor for keystrokes
 * @see JFrame
 * @see KeyPanel
 */
class KeyFrame extends JFrame{
    private int s = 500;
    private KeyPanel kpanel = new KeyPanel();

    /**Constructor for KeyFrame, sets window behavior and adds a KeyPanel kpanel
    */
    public KeyFrame(){
        setSize(s, s);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(kpanel);
        addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                kpanel.addtok(e.getKeyText(e.getKeyCode()));
            }
        });
    }
}

/**
 * Sets up a panel to paint the keystrokes on. Uses an anonymous internal Class
 * to set up a listener and action associated with a mouse click
 * @see JPanel
 */
class KeyPanel extends JPanel{
    private ArrayList<String> keyArray = new ArrayList<String>();
    private ArrayList<Point> keyPointArray = new ArrayList<Point>();
    private int i = 0;

    /**
    * Constructs a new Keypanel object with a mouselistener to register
    * mouse clicks
    */
    public KeyPanel(){
        addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                reset(e.getButton());
            }
        });
    }

    /**
    * Adds "in" to an Arraylist of strings that needs to be drawn.
    * @param in
    */
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

    /** Used to paint in the panel
    */
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
