
package gil.action;

import bol.BOLObject;
import bol.utils.Case;
import dal.DALObject;
import gil.MainFrame;
import gil.utils.DialogBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ExportToDataBase implements ActionListener {
    
    private BOLObject obj;
    private MainFrame frame;
    private DALObject DBAccess;

    public ExportToDataBase(BOLObject obj, MainFrame frame) {
        this.obj = obj;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DBAccess = new DALObject();
        String name = "";
        do {
            name = new DialogBox(frame).getText();
        } while (!(name != null && !name.isEmpty() && !name.trim().isEmpty()));
        
        int TabTailleX = obj.getUpdatedTab().getX();
        int TabTailleY = obj.getUpdatedTab().getY();
        int actualStep = obj.getStep().getActualStepNumber();
        int StepTotal = obj.getStep().getStepNumber();
        String SaveString = "";
        Case[][] temp = obj.getUpdatedTab().getTab();
        for (int j = 0; j < temp[0].length; j++) {
            for (int i = 0; i < temp.length; i++) {
                SaveString += i + "," + j + "," + temp[i][j].toString() + ";";
            }
        }
        JOptionPane.showMessageDialog(frame, "Le programme va faire un sauvegarde de la grille actuelle !", "Information", JOptionPane.INFORMATION_MESSAGE);
        try {
            DBAccess.insertSave(name, TabTailleX, TabTailleY, StepTotal, actualStep, SaveString);
        } catch (SQLException ex) {
            Logger.getLogger(ExportToDataBase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frame, "Une erreur est survenue lors de l'enregistrement !\nRéesssayez plus tard",
                                                "Erreur d'enregistrement", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBAccess.closeConnection();
        }
        DBAccess.closeConnection();
    }
}
