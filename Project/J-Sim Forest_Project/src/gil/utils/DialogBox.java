
package gil.utils;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DialogBox {
    JDialog d;
    JLabel label1 = new JLabel("Entrer un nom de sauvegarde : ");
    JTextField text1 = new JTextField(50);
    JPanel panel = new JPanel(new GridLayout(3,2));
    
    public DialogBox(JFrame parent)
    {
        JButton button = new JButton("OK");
        d = new JDialog(parent);
        panel.add(label1);
        panel.add(text1);
        panel.add(button);
        d.getContentPane().add(panel,BorderLayout.CENTER);
        d.setTitle("Enregistrer en base de données");
        d.setModal(true);
        d.pack();
        d.setSize(300,100);

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                d.dispose();
            }
        });
        d.setVisible(true);
    }

    public String getText() {
        return this.text1.getText();
    }
    
}