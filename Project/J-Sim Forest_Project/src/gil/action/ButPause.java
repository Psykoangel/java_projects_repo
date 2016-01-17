
package gil.action;

import bol.BOLObject;
import gil.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButPause implements ActionListener {
    
    private BOLObject obj;
    private MainFrame frame;

    public ButPause(BOLObject obj, MainFrame frame) {
        this.obj = obj;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getPanPara().getButPause().setVisible(false);
        this.obj.getStep().stop();
        frame.getPanPara().getButGeneration().setVisible(true);
    }
    
}
