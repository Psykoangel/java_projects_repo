package calculetteproject;

import javax.swing.SwingUtilities;


/**
 *
 * @author Psyko
 */
public class CalculetteProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    SwingUtilities.invokeLater(new Runnable() {
            @Override
        public void run() {
            /*
            JDialog window = new JDialog();
            window.setTitle("Dialog Box");
            window.setSize(500, 200);
            window.setType(Window.Type.NORMAL);
            window.setVisible(true);
            
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            */
            EasyFrame window = new EasyFrame();
            window.setVisible(true);
        }
    });
    /*
    try {
        Thread.sleep(5000);
    } catch (Exception e) {}
    
    System.exit(0);
        */
    }
}
