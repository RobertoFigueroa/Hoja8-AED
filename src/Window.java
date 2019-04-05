import javax.swing.*;
import java.awt.*;


/**
 * This class is for
 */
public class Window extends JFrame {

    public JPanel panel;

    public Window(){
       setSize(500,500);
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setTitle("Hoja de trabajo 8");
       starComponents();
    }

    private void starComponents(){
       startPanel();
       starLabels();
       startButtons();
    }

    private void startButtons() {
       JButton btn1 = new JButton("Cargar Path");
       btn1.setBounds(10,20,30,20);
       panel.add(btn1);
    }

    private void starLabels(){
        JLabel label = new JLabel("Ingrese el path del archivo de texto : ");
        label.setBounds(10,10,100,50);
        panel.add(label);
    }

    private void startPanel(){
        panel = new JPanel();
        panel.setLayout(null); //disable the sample design
        panel.setBackground(Color.DARK_GRAY);
        this.getContentPane().add(panel); //add a panel to the window
    }
}

