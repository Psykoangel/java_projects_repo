
package gil.action;

import bol.BOLObject;
import dal.DALObject;
import gil.MainFrame;
import gil.utils.DialogBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ExportCsv implements ActionListener {
    
    private BOLObject obj;
    private MainFrame frame;
    private DALObject DBAccess;

    public ExportCsv(BOLObject obj, MainFrame frame) {
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
        try {
            DBAccess.createCSVExport(name, obj.getCountStateGridCase());
        } catch (IOException ex) {
            Logger.getLogger(ExportCsv.class.getName()).log(Level.SEVERE, null, ex);
            String message = "Une erreur est survenue lors de l'export CSV !\nRéesssayez plus tard";
            if (!"".equals(ex.getMessage())) {
                message = ex.getMessage();
            }
            JOptionPane.showMessageDialog(frame, message,
                                                "Erreur d'export", JOptionPane.ERROR_MESSAGE);
        }
    }
}
