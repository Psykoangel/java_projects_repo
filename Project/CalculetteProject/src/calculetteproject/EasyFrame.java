package calculetteproject;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Psyko
 */
public class EasyFrame extends JFrame implements ActionListener {

    public static int count = 0;
    
    private JLabel labalCount;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    
    public EasyFrame() throws HeadlessException {
        super();
        build();
    }

    public JButton getButton1() {
        return button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public void setButton2(JButton button2) {
        this.button2 = button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public void setButton3(JButton button3) {
        this.button3 = button3;
    }

    public JLabel getLabalCount() {
        return labalCount;
    }

    public void setLabalCount(JLabel labalCount) {
        this.labalCount = labalCount;
    }

    private void build() {
        setTitle("MainFrame of the Applicaion");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPanel());
    }
    
    private JPanel buildContentPanel(){
        
        JPanel panelText = new JPanel();
        Color color = new Color(164, 255, 255);
        JLabel label = new JLabel("Welcome on my first JAVA Application");
        JTextField tb = new JTextField();
        
        labalCount = new JLabel("Click number : " + count);
        button1 = new JButton("Action 1");
        button2 = new JButton("Action 2");
        
        panelText.setLayout(new FlowLayout());
        panelText.setBackground(color);
        
        tb.setColumns(10);
        
        panelText.add(label);
        panelText.add(labalCount);
        panelText.add(button1);
        
        button1.addActionListener(this);
        panelText.add(button2);
        button2.addActionListener(this);
        button3 = new JButton(new AllAction("Arg", this));
        panelText.add(button3);
        
        panelText.add(tb);
        
        return panelText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == button1) {
            count++;
            this.labalCount.setText("Click number : " + count);
        }
        else{
            EasyFrame newFrame = new EasyFrame();
            newFrame.setVisible(true);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(EasyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            newFrame.setVisible(false);
            newFrame.dispose();
        }
    }
    
}
