import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class is for
 */
public class Window extends JFrame {

    public JPanel panel;
    private JLabel label;
    private String path;
    private JTextField textField;

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
       startTextField();
    }

    private void startTextField() {
       textField = new JTextField();
       textField.setBounds(20,20,50,10);
       panel.add(textField);
    }

    private void startButtons() {
        JButton btn1 = new JButton("Cargar Path");
        btn1.setBounds(10, 20, 30, 20);
        panel.add(btn1);
        ActionListener actionList = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().length() > 0){
                path = textField.getText();
            }
            else{
                JOptionPane.showMessageDialog(panel , "Ingrese una direccion!");
                }
            }
        };

        btn1.addActionListener(actionList);
    }

    private void starLabels(){
        label = new JLabel("Ingrese el path del archivo de texto : ");
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

