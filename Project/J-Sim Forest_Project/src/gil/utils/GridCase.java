
package gil.utils;

import java.awt.LayoutManager;
import javax.swing.JPanel;

public class GridCase extends JPanel{
    private int positionX;
    private int positionY;

    public GridCase() {
    }

    public GridCase(LayoutManager layout) {
        super(layout);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
