
package bol;

import bol.utils.Etat;
import gil.MainFrame;
import java.util.HashMap;

public class CaseCounter {
    
    private BOLObject obj;
    private MainFrame frame;
    private HashMap caseCount;
    
    private int x;
    private int y;

    public CaseCounter() {
        x = 0;
        y = 0;
        caseCount = new HashMap<>();
        caseCount.put(Etat.jeunePousse, 0);
        caseCount.put(Etat.arbuste, 0);
        caseCount.put(Etat.arbre, 0);
        caseCount.put(Etat.feu, 0);
        caseCount.put(Etat.infecte, 0);
    }
    
    public HashMap CountStateGridCase(BOLObject obj, MainFrame frame){
        this.obj = obj;
        this.frame = frame;
        int temp;
        caseCount.put(Etat.vide, 0);
        caseCount.put(Etat.jeunePousse, 0);
        caseCount.put(Etat.arbuste, 0);
        caseCount.put(Etat.arbre, 0);
        caseCount.put(Etat.feu, 0);
        caseCount.put(Etat.infecte, 0);
        for (int j = 0; j < obj.getTab().getY(); j++) {
            for (int i = 0; i < obj.getTab().getX(); i++) {
                switch(obj.getTab().getTab()[i][j].getEtat()){
                    case vide:
                        temp = Integer.valueOf(caseCount.get(Etat.vide).toString());
                        temp++;
                        caseCount.put(Etat.vide, temp);
                        break;
                    case jeunePousse:
                        temp = Integer.valueOf(caseCount.get(Etat.jeunePousse).toString());
                        temp++;
                        caseCount.put(Etat.jeunePousse, temp);
                        break;
                    case arbuste:
                        temp = Integer.valueOf(caseCount.get(Etat.arbuste).toString());
                        temp++;
                        caseCount.put(Etat.arbuste, temp);
                        break;
                    case arbre:
                        temp = Integer.valueOf(caseCount.get(Etat.arbre).toString());
                        temp++;
                        caseCount.put(Etat.arbre, temp);
                        break;
                    case feu:
                        temp = Integer.valueOf(caseCount.get(Etat.feu).toString());
                        temp++;
                        caseCount.put(Etat.feu, temp);
                        break;
                    case infecte:
                        temp = Integer.valueOf(caseCount.get(Etat.infecte).toString());
                        temp++;
                        caseCount.put(Etat.infecte, temp);
                        break;
                }
            }
        }
        return caseCount;
    }
}
