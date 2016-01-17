package gil.action;

import bol.BOLObject;
import gil.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButGeneration implements ActionListener {
    
    private BOLObject obj;
    private MainFrame frame;

    public ButGeneration(BOLObject obj, MainFrame mainFrame) {
        this.obj = obj;
        this.frame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (obj.getStep().getRemainingTime() != 0) {
            if (obj.getStep().getActualStepNumber() != 0) {
                obj.getStep().setRemainingTime(obj.getStep().getRemainingTime() - 1);
            }
            if (!(obj.getTab().getX() > 49 && obj.getTab().getY() > 49)) {
                frame.getPanPara().getButGeneration().setVisible(false);
            }
            this.obj.getStep().start(obj, frame);
            if (!(obj.getTab().getX() > 49 && obj.getTab().getY() > 49)) {
                frame.getPanPara().getButPause().setVisible(true);
            }
        }
    }
}