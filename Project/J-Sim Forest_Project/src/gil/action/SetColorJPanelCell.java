
package gil.action;

import bol.BOLObject;
import bol.utils.Etat;
import gil.utils.GridCase;
import gil.MainFrame;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class SetColorJPanelCell implements MouseListener {
    
    BOLObject obj;
    MainFrame frame;

    public SetColorJPanelCell(BOLObject obj, MainFrame frame) {
        this.obj = obj;
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        GridCase sgc = (GridCase) e.getSource();
        String selectedButton = frame.getPanPara().getCaseGroup().getSelection().getActionCommand();
        
        switch(selectedButton){
            case "Vide" :
                sgc.setBackground(new Color(-1));
                obj.setUpdatedTabColorPosition(sgc.getPositionX(), sgc.getPositionY(), Etat.vide);
            break;
            case "Jeune pousse" :
                sgc.setBackground(new Color(-7090095));
                obj.setUpdatedTabColorPosition(sgc.getPositionX(), sgc.getPositionY(), Etat.jeunePousse);
            break;
            case "Arbustre" :
                sgc.setBackground(new Color(-13330125));
                obj.setUpdatedTabColorPosition(sgc.getPositionX(), sgc.getPositionY(), Etat.arbuste);
            break;
            case "Arbre" :
                sgc.setBackground(new Color(-16692992));
                obj.setUpdatedTabColorPosition(sgc.getPositionX(), sgc.getPositionY(), Etat.arbre);
            break;
            case "Feu" :
                sgc.setBackground(new Color(-1630437));
                obj.setUpdatedTabColorPosition(sgc.getPositionX(), sgc.getPositionY(), Etat.feu);
            break;
            case "Cendre" :
                sgc.setBackground(new Color(-8289663));
                obj.setUpdatedTabColorPosition(sgc.getPositionX(), sgc.getPositionY(), Etat.cendre);
            break;
            case "Insectes" :
                sgc.setBackground(new Color(-9618794));
                obj.setUpdatedTabColorPosition(sgc.getPositionX(), sgc.getPositionY(), Etat.infecte);
            break;
        }        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JPanel selectedPanel = (JPanel) e.getSource();
        
        Color x = selectedPanel.getBackground();
        if (x.equals(Color.WHITE)) {
            selectedPanel.setBackground(new Color(50, 50, 50)); 
        } else {
            selectedPanel.setBackground(x); 
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JPanel selectedPanel = (JPanel) e.getSource();
        
        Color x = selectedPanel.getBackground();
        if (x.equals(new Color(50,50,50))) {
            selectedPanel.setBackground(Color.WHITE);
        } else {
            selectedPanel.setBackground(x);
        }
    }
} 
