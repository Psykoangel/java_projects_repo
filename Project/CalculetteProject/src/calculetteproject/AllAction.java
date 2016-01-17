package calculetteproject;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Psyko
 */
public class AllAction extends AbstractAction {
    
    private EasyFrame frame;

    public AllAction(String name, EasyFrame frame) {
        super(name);
        this.frame = frame;
    }

    public AllAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EasyFrame.count += 2;
        frame.getLabalCount().setText("Click number : " + EasyFrame.count);
    }
    
}
