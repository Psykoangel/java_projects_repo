
package gil.action;

import bol.BOLObject;
import bol.utils.Case;
import dal.DALObject;
import gil.MainFrame;
import gil.utils.ListDialogBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ImportFromDataBase implements ActionListener {
    
    private BOLObject obj;
    private MainFrame frame;
    private DALObject DBAccess;
    
    private String selectedSave;

    public ImportFromDataBase(BOLObject obj, MainFrame frame) {
        this.obj = obj;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DBAccess = new DALObject();
        ArrayList list = null;
        ArrayList results = null;
        try {
            list = DBAccess.showSave();
        } catch (SQLException ex) {
            Logger.getLogger(ImportFromDataBase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frame, "Une erreur est survenue lors du chargement !\nRéesssayez plus tard",
                                                "Erreur de chargement", JOptionPane.ERROR_MESSAGE);
        }
        if (list.size() > 0) {
            ListDialogBox ldb = new ListDialogBox(list, this);
            ldb.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(frame, "Aucune sauvegarde n'a été trouvée !",
                                                "Erreur de chargement", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            results = DBAccess.selectSave(this.selectedSave);
        } catch (SQLException ex) {
            Logger.getLogger(ImportFromDataBase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frame, "Une erreur est survenue lors du chargement !\nRéesssayez plus tard",
                                                "Erreur de chargement", JOptionPane.ERROR_MESSAGE);
        }
        int tailleX = 0;
        int tailleY = 0;
        int stepTot = 0;
        int stepAct = 0;
        String saveString = "";
        
        tailleX = (int)results.get(0);
        tailleY = (int)results.get(1);
        stepTot =(int)results.get(2);
        stepAct =(int)results.get(3);
        saveString = (String)results.get(4);
        Case[][] temp = this.obj.TransformToTab(saveString, tailleX, tailleY);

        this.obj.emptyTabGen(tailleX, tailleY);
        this.obj.setUpdatedTab(temp, tailleX, tailleY);
        this.frame.setTabToShow(obj.getUpdatedTab().getTab(), tailleX, tailleY);
        this.obj.getStep().setRemainingTime(stepTot - stepAct);
        this.obj.getStep().setActualStepNumber(stepAct);
        
        this.frame.getPanPara().getTailleX().setText(String.valueOf(tailleX));
        this.frame.getPanPara().getTailleY().setText(String.valueOf(tailleY));
        this.frame.getPanPara().getTfStepNumber().setText(String.valueOf(stepTot));
        
        this.frame.getPanPara().getTailleX().setEnabled(false);
        this.frame.getPanPara().getTailleY().setEnabled(false);
        this.frame.getPanPara().getTfTailleX().setEnabled(false);
        this.frame.getPanPara().getTfTailleY().setEnabled(false);
        this.frame.getPanPara().getButValid().setVisible(false);
        
        this.frame.getPanPara().getTfStep().setVisible(true);
        this.frame.getPanPara().getTfStepNumber().setVisible(true);
        this.frame.getPanPara().getSlStepSpeed().setVisible(true);
        this.frame.getPanPara().getSliderNumber().setVisible(true);
        this.frame.getPanPara().getButStepValid().setVisible(true);
        
        frame.getPanMenu().getExportItem().setEnabled(true);
        frame.getPanMenu().getCsvItem().setEnabled(true);
    }

    public String getSelectedSave() {
        return selectedSave;
    }

    public void setSelectedSave(String selectedSave) {
        this.selectedSave = selectedSave;
    }
}
