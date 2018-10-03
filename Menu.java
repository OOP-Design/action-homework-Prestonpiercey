import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu{
    public static void main(String[] args){
        MenuFrame mframe = new MenuFrame();
    }
}

class MenuPanel extends JPanel{
    MenuPanel(){
        super();
    }
}

class MenuFrame extends JFrame {
    private MenuPanel mpanel = new MenuPanel();

    public MenuFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new BGCMenu());
        menuBar.add(new LeaveMenu());
        setJMenuBar(menuBar);
        add(mpanel);
        setSize(250, 250);
        setVisible(true);
    }

    private class LeaveMenu extends JMenu{
        public LeaveMenu(){
            super("Leave");
            JMenuItem ExitItem = new JMenuItem("Exit");
            ExitItem.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
            add(ExitItem);
        }
    }
    private class BGCMenu extends JMenu{
        public BGCMenu(){
            super("Color");
            JMenuItem RedOption = new JMenuItem("Red");
            JMenuItem GreenOption = new JMenuItem("Green");
            JMenuItem BlueOption = new JMenuItem("Blue");

            RedOption.addActionListener(new BGCListener(Color.RED));
            GreenOption.addActionListener(new BGCListener(Color.GREEN));
            BlueOption.addActionListener(new BGCListener(Color.BLUE));

            add(RedOption);
            add(GreenOption);
            add(BlueOption);
        }
    }
    private class BGCListener implements ActionListener{
        private Color color;
        public void actionPerformed(ActionEvent e){
            mpanel.setBackground(color);
        }
        public BGCListener(Color color){
            this.color = color;
        }
    }
}
