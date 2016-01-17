package gil;

import bol.BOLObject;

public class GILObject {
    
    private MainFrame mainFrame;
    BOLObject BOLObj;
    

    public GILObject(BOLObject calculate) {
        this.BOLObj = calculate;
        this.mainFrame = new MainFrame(this.BOLObj);
        this.mainFrame.setVisible(true);
    }
}