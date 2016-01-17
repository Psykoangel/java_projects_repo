
package gil.action;

import bol.BOLObject;
import gil.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;

public class AddMode implements ActionListener {
    
    BOLObject obj;
    MainFrame frame;

    public AddMode(BOLObject obj, MainFrame frame) {
        this.obj = obj;
        this.frame = frame;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        Object chkBox = e.getSource();
        
        if (chkBox == frame.getPanPara().getCbFireMode()) {
            JCheckBox cb = (JCheckBox)chkBox;
            if (cb.isSelected()) {
                this.obj.setFireMode(true);
                frame.getPanMenu().getFireItem().setSelected(true);
                frame.getPanPara().getFeuCaserButton().setEnabled(true);
                frame.getPanPara().getCendreCaserButton().setEnabled(true);
                
                frame.getPanText().getNbFeu().setVisible(true);
                frame.getPanText().getNbInfecte().setVisible(false);
                
                this.obj.setInvasionMode(false);
                frame.getPanMenu().getInfectItem().setSelected(false);
                frame.getPanPara().getCbInvasionMode().setSelected(false);
                frame.getPanPara().getInsecteCaserButton().setEnabled(false);
                
            } else {
                this.obj.setFireMode(false);
                frame.getPanMenu().getFireItem().setSelected(false);
                frame.getPanPara().getFeuCaserButton().setEnabled(false);
                frame.getPanPara().getCendreCaserButton().setEnabled(false);
            }
        }
        
        if(chkBox == frame.getPanPara().getCbInvasionMode()){
            JCheckBox cb = (JCheckBox)chkBox;
            if (cb.isSelected()) {
                this.obj.setInvasionMode(true);
                frame.getPanMenu().getInfectItem().setSelected(true);
                frame.getPanPara().getInsecteCaserButton().setEnabled(true);
                
                frame.getPanText().getNbFeu().setVisible(false);
                frame.getPanText().getNbInfecte().setVisible(true);
                
                this.obj.setFireMode(false);
                frame.getPanMenu().getFireItem().setSelected(false);
                frame.getPanPara().getCbFireMode().setSelected(false);
                frame.getPanPara().getFeuCaserButton().setEnabled(false);
                frame.getPanPara().getCendreCaserButton().setEnabled(false);
            } else {
                this.obj.setInvasionMode(false);
                frame.getPanMenu().getInfectItem().setSelected(false);
                frame.getPanPara().getInsecteCaserButton().setEnabled(false);
            }
        }
        
        if (chkBox == frame.getPanMenu().getFireItem()) {
            JCheckBoxMenuItem cb = (JCheckBoxMenuItem)chkBox;
            if (cb.isSelected()) {
                this.obj.setFireMode(true);
                frame.getPanPara().getCbFireMode().setSelected(true);
                frame.getPanPara().getFeuCaserButton().setEnabled(true);
                frame.getPanPara().getCendreCaserButton().setEnabled(true);
                
                frame.getPanText().getNbFeu().setVisible(true);
                frame.getPanText().getNbInfecte().setVisible(false);
                
                this.obj.setInvasionMode(false);
                frame.getPanMenu().getInfectItem().setSelected(false);
                frame.getPanPara().getCbInvasionMode().setSelected(false);
                frame.getPanPara().getInsecteCaserButton().setEnabled(false);
            } else {
                this.obj.setFireMode(false);
                frame.getPanPara().getCbFireMode().setSelected(false);
                frame.getPanPara().getFeuCaserButton().setEnabled(false);
                frame.getPanPara().getCendreCaserButton().setEnabled(false);
            }
        }
        
        if (chkBox == frame.getPanMenu().getInfectItem()) {
            JCheckBoxMenuItem cb = (JCheckBoxMenuItem)chkBox;
            if (cb.isSelected()) {
                this.obj.setInvasionMode(true);
                frame.getPanPara().getCbInvasionMode().setSelected(true);
                frame.getPanPara().getInsecteCaserButton().setEnabled(true);
                this.obj.setFireMode(false);
                
                frame.getPanText().getNbFeu().setVisible(false);
                frame.getPanText().getNbInfecte().setVisible(true);
                
                frame.getPanMenu().getFireItem().setSelected(false);
                frame.getPanPara().getCbFireMode().setSelected(false);
                frame.getPanPara().getFeuCaserButton().setEnabled(false);
                frame.getPanPara().getCendreCaserButton().setEnabled(false);
            } else {
                this.obj.setInvasionMode(false);
                frame.getPanPara().getCbInvasionMode().setSelected(false);
                frame.getPanPara().getInsecteCaserButton().setEnabled(false);
            } 
        }
    }
    
}
