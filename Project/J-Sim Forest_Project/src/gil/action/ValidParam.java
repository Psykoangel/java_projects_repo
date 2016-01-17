
package gil.action;

import bol.BOLObject;
import gil.MainFrame;
import gil.units.PanPara;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidParam implements ActionListener {
    
    BOLObject obj;
    MainFrame frame;
    
    public ValidParam(BOLObject obj, MainFrame frame) {
        this.obj = obj;
        this.frame = frame;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        PanPara panelParam = (PanPara) ((Component)e.getSource()).getParent();
        int abscisse = 100;
        int ordonnee = 100;
        try {
            abscisse = Integer.valueOf(panelParam.getTailleX().getText());
        } catch (Exception exp) {
        }
        try {
            ordonnee = Integer.valueOf(panelParam.getTailleY().getText());
        } catch (Exception ex) {
        }
        this.frame.setTabToShow(obj.emptyTabGen(abscisse, ordonnee).getTab(), abscisse, ordonnee);
        
        
        panelParam.getTailleX().setEnabled(false);
        panelParam.getTailleY().setEnabled(false);
        panelParam.getTfTailleX().setEnabled(false);
        panelParam.getTfTailleY().setEnabled(false);
        panelParam.getButValid().setVisible(false);
        
        panelParam.getTfStep().setVisible(true);
        panelParam.getTfStepNumber().setVisible(true);
        panelParam.getSlStepSpeed().setVisible(true);
        panelParam.getSliderNumber().setVisible(true);
        panelParam.getButStepValid().setVisible(true);
        
        frame.getPanMenu().getExportItem().setEnabled(true);
        frame.getPanMenu().getCsvItem().setEnabled(true);
    }
    
}
