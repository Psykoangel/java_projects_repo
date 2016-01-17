
package gil.utils;

import gil.action.ImportFromDataBase;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListDialogBox extends JDialog {
    ImportFromDataBase event;
    
    JList liste = new JList();
    ArrayList<String> listData;

    public ListDialogBox(ArrayList dtList, ImportFromDataBase aThis) {
        
        this.setTitle("Liste des sauvegardes");
        this.setSize(300, 300);
        this.setModal(true);
        
        this.event = aThis;
        this.listData = dtList;
        
	liste = new JList(this.listData.toArray());
        liste.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black), BorderFactory.createEmptyBorder(10,10,10,10)));
	liste.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) { 
                event.setSelectedSave((String)liste.getSelectedValue());
            }
        });
        liste.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    dispose();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        JPanel basement = new JPanel(new BorderLayout());
        basement.setPreferredSize(new Dimension(50, 90));
        basement.add(liste, BorderLayout.CENTER);
        
        this.add(basement);
    }
} 
