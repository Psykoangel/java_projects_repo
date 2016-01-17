
package bol.utils;

public class Tableau {
    private Case tab[][];
    private int x;
    private int y;
    
    public Tableau(){
        this.x = 100;
        this.y = 100;
        this.tab = new Case[x][y];
        for (int width = 0; width < this.y; width++) {
            for (int length = 0; length < this.x; length++) {
                this.tab[length][width] = new Case(Etat.vide);
            }
        }
    }
    
    public Tableau(int x_default, int y_default){
        this.x = x_default;
        this.y = y_default;
        this.tab = new Case[x][y];
        for (int width = 0; width < this.y; width++) {
            for (int length = 0; length < this.x; length++) {
                this.tab[length][width] = new Case(Etat.vide);
            }
        }
    }

    //Getter
    public Case[][] getTab() {
        return tab;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Setter
    public void setTab(Case[][] tab) {
        this.tab = tab;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
