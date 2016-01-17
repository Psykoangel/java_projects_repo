
package gil.action;

import bol.BOLObject;
import gil.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButNextStep implements ActionListener {
    
    private BOLObject obj;
    private MainFrame frame;

    public ButNextStep(BOLObject obj, MainFrame frame) {
        this.obj = obj;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (obj.getStep().getRemainingTime() != 0) {
            this.obj.getStep().nextStep(obj, frame);
        }
    }
}
