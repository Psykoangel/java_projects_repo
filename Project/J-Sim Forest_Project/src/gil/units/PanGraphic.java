package gil.units;

import gil.utils.GridCase;
import bol.utils.Case;
import bol.utils.Etat;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanGraphic extends JPanel{
    
    //private JPanel[][] grid;
    
    private Case[][] tabToShow;
    
    private GridCase[][] grid;
    
    private Border blackline;
    
    private int gridWidth;
    private int gridLength;

    public PanGraphic(){
        this.setPreferredSize(new Dimension(600, 500));
        this.blackline = BorderFactory.createLineBorder(Color.black, 1);
        //this.CreateGrid();
    }
    
    private void CreateGrid() {
        //this.removeAll();
    }
    
    private void updateGrid() {
        //this.CreateGrid();
        for(int y = 0; y < this.gridLength; y++)
        {
            for(int x = 0; x < this.gridWidth; x++)
            {
                //this.grid[x][y] = new JPanel();
                this.grid[x][y].setBorder(blackline);
                //this.add(this.grid[x][y]);
                this.ConvertToGrid(x, y);
                this.ConvertToCell(x, y);
            }
        }
    }
    
    private void ConvertToGrid(int x, int y) 
    {
        switch (this.tabToShow[x][y].getEtat()) 
        {
            case vide:        //vide -- blanc -- 255,255,255 -- 0
                this.grid[x][y].setBackground(new Color(255,255,255));
                this.grid[x][y].setPositionX(x);
                this.grid[x][y].setPositionY(y);
                break;
            case jeunePousse:  //jeune pousse -- vert clair -- 147,208,81 -- 1
                this.grid[x][y].setBackground(new Color(147,208,81));
                this.grid[x][y].setPositionX(x);
                this.grid[x][y].setPositionY(y);
                break;
            case arbuste:       //arbuste -- vert -- 52,153,51 -- 2
                this.grid[x][y].setBackground(new Color(52,153,51));
                this.grid[x][y].setPositionX(x);
                this.grid[x][y].setPositionY(y);
                break;
            case arbre:         //arbre -- vert foncée  -- 1,73,0 -- 3
                this.grid[x][y].setBackground(new Color(1,73,0));
                this.grid[x][y].setPositionX(x);
                this.grid[x][y].setPositionY(y);
                break;
            case feu:           //feu -- rouge -- 231,31,27 -- 4
                this.grid[x][y].setBackground(new Color(231,31,27));
                this.grid[x][y].setPositionX(x);
                this.grid[x][y].setPositionY(y);
                break;
            case cendre:        //cendre -- gris -- 129,130,129 -- 5
                this.grid[x][y].setBackground(new Color(129,130,129));
                this.grid[x][y].setPositionX(x);
                this.grid[x][y].setPositionY(y);
                break;
            case infecte:       //infecte -- violet -- 109,58,150 -- 6
                this.grid[x][y].setBackground(new Color(109,58,150));
                this.grid[x][y].setPositionX(x);
                this.grid[x][y].setPositionY(y);
                break;
            default:
                this.grid[x][y].setBackground(new Color(255, 255, 255));
                this.grid[x][y].setPositionX(x);
                this.grid[x][y].setPositionY(y);
                break;
        }
    }
    private void ConvertToCell(int x, int y) 
    {
        Color basic = this.grid[x][y].getBackground();
        Color a = new Color(255, 255, 255);
        Color b = new Color(147, 208, 81);
        Color c = new Color(52, 153, 51);
        Color d = new Color(1, 73, 0);
        Color e = new Color(231, 31, 27);
        Color f = new Color(129, 130, 129);
        Color g = new Color(109, 58, 150);
        
        if (basic.equals(a)) {
            this.tabToShow[x][y].setEtat(Etat.vide);//vide -- blanc -- 255,255,255 -- 0
        } else if(basic.equals(b)){
            this.tabToShow[x][y].setEtat(Etat.jeunePousse);//jeune pousse -- vert clair -- 147,208,81 -- 1
        } else if(basic.equals(c)) {
            this.tabToShow[x][y].setEtat(Etat.arbuste);//arbuste -- vert -- 52,153,51 -- 2
        } else if(basic.equals(d)) {
            this.tabToShow[x][y].setEtat(Etat.arbre);//arbre -- vert foncée  -- 1,73,0 -- 3
        } else if(basic.equals(e)) {
            this.tabToShow[x][y].setEtat(Etat.feu);//feu -- rouge -- 231,31,27 -- 4
        } else if(basic.equals(f)) {
            this.tabToShow[x][y].setEtat(Etat.cendre);//cendre -- gris -- 129,130,129 -- 5
        } else if(basic.equals(g)) {
            this.tabToShow[x][y].setEtat(Etat.infecte);//infecte -- violet -- 109,58,150 -- 6
        }
    }
    
    public Case[][] getTabToShow() {
        return this.tabToShow;
    }

    public int getGridLength() {
        return gridLength;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public GridCase[][] getGrid() {
        return grid;
    }

    public void setTabToShow(Case[][] tabToShow) {
        this.tabToShow = tabToShow;
        this.updateGrid();
    }

    public void setGrid(GridCase[][] grid) {
        this.grid = grid;
    }

    public void setGridLength(int gridLength) {
        this.gridLength = gridLength;
    }

    public void setGridWidth(int gridWidth) {
        if(this.gridWidth != gridWidth)
        {
            this.gridWidth = gridWidth;
            this.removeAll();
            //this.grid = new JPanel[this.gridWidth][this.gridLength];
            this.grid = new GridCase[this.gridWidth][this.gridLength];
            this.setLayout(new GridLayout(this.gridWidth, this.gridLength));

            for(int y = 0; y < this.gridLength; y++)
            {
                for(int x = 0; x < this.gridWidth; x++)
                {   
                    //this.grid[x][y] = new JPanel();
                    this.grid[x][y] = new GridCase();
                    this.grid[x][y].setPositionX(x);
                    this.grid[x][y].setPositionY(y);
                    this.add(this.grid[x][y]);
                }
            }
        }
    }
    
    public void setPosition(int positionX, int positionY, Color c){
        this.grid[positionX][positionY].setBackground(c);
    }
}
