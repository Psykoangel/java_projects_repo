
package bol;

import bol.utils.Case;
import bol.utils.Etat;
import bol.utils.Neighborhood;
import bol.utils.Tableau;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BOLObject {
    
    
    //Attributes
    
    private Step step;
    
    private Tableau tab;
    private Tableau updatedTab;
    
    ArrayList<String[]> CountStateGridCase;
    
    private boolean fireMode;
    private boolean invasionMode;
    
    private CaseCounter caseCounter;    
    
    // Constructors
    public BOLObject(){
        caseCounter = new CaseCounter();
        CountStateGridCase = new ArrayList<>();
        step = new Step();
        fireMode = false;
        invasionMode = false;
    }
    
    
    //Setter
    public void setTab(Case[][] tab, int l, int w) {
        this.tab.setTab(tab);
        this.tab.setX(l);
        this.tab.setY(w);
        //System.out.println("Tab updated !");
    }

    public void setUpdatedTab(Case[][] tab, int l, int w) {
        this.updatedTab.setTab(tab);
        this.updatedTab.setX(l);
        this.updatedTab.setY(w);
        //System.out.println("UpdatedTab updated !");
    }
    
    public void setUpdatedTabColorPosition(int positionX, int positionY, Etat e){
        this.updatedTab.getTab()[positionX][positionY].setEtat(e);
    }

    public void setFireMode(boolean fireMode) {
        this.fireMode = fireMode;
        //System.out.println("fireMode activated !");
    }

    public void setInvasionMode(boolean invasionMode) {
        this.invasionMode = invasionMode;
        //System.out.println("invasionMode updated !");
    }

    public void setCountStateGridCase(ArrayList<String[]> CountStateGridCase) {
        this.CountStateGridCase = CountStateGridCase;
    }
    
    
    //Getter
    public Tableau getTab() {
        return tab;
    }

    public Tableau getUpdatedTab() {
        return updatedTab;
    }

    public boolean isFireMode() {
        return fireMode;
    }

    public boolean isInvasionMode() {
        return invasionMode;
    }

    public Step getStep() {
        return step;
    }

    public CaseCounter getCaseCounter() {
        return caseCounter;
    }
    
        
    public Tableau emptyTabGen(){
        this.tab = new Tableau();
        this.updatedTab = new Tableau();
        return updatedTab;
    }
    
    public Tableau emptyTabGen(int x, int y){
        this.tab = new Tableau(x, y);
        this.updatedTab = new Tableau(x, y);
        //System.out.println("Empty Tables created !");
        return tab;
    }

    public ArrayList<String[]> getCountStateGridCase() {
        return CountStateGridCase;
    }
    
    //Methods
    public void CheckTab(){
        
        updatedTab = new Tableau(this.tab.getX(), this.tab.getY());
        
        ArrayList al = new ArrayList();
        HashMap countList = new HashMap();
        
        for (int width = 0; width < tab.getY(); width++) {
            for (int length = 0; length < tab.getX() ; length++) {
                
                    al = getVecinity(Neighborhood.Moore, length, width, tab.getX(), tab.getY());
                    countList = VecinityStateCount(al);
                    
                if (invasionMode) {
                    al = getVecinity(Neighborhood.VonNeumann, length, width, tab.getX(), tab.getY());
                    countList = VecinityStateCount(al);
                }
                    
                if (fireMode) {
                    al = getVecinity(Neighborhood.Moore, length, width, tab.getX(), tab.getY());
                    countList = VecinityStateCount(al);
                }
                UpdateCheckedCell(tab.getTab()[length][width], updatedTab.getTab()[length][width], countList);
            }
        }
    }
    
    private ArrayList getVecinity(Neighborhood nh, int length, int width, int xTabSize, int yTabSize){
        
        ArrayList<Case> VecinityList = new ArrayList<>();
        if (nh == Neighborhood.VonNeumann) {
            //System.out.println("Voisinage de Von Neumann demande !");
            
            if (length < xTabSize -1) {//   case droite
                VecinityList.add(tab.getTab()[length + 1][width]);
            }

            if (width < yTabSize -1) {//   case basse
                VecinityList.add(tab.getTab()[length][width + 1]);
            }

            if (length > 0) {//   case gauche
                VecinityList.add(tab.getTab()[length - 1][width]);
            }

            if (width > 0) {//   case haute
                VecinityList.add(tab.getTab()[length][width - 1]);
            }
            
        } else {
            //System.out.println("Voisinage de Moore demande !");
            
            if (length < xTabSize -1 && width > 0) {//   case droite haute
                VecinityList.add(tab.getTab()[length + 1][width - 1]);
            }

            if (length < xTabSize -1) {//   case droite
                VecinityList.add(tab.getTab()[length + 1][width]);
            }

            if (length < xTabSize -1 && width < yTabSize -1) {//   case droite basse
                VecinityList.add(tab.getTab()[length + 1][width + 1]);
            }

            if (width < yTabSize -1) {//   case basse
                VecinityList.add(tab.getTab()[length][width + 1]);
            }

            if (length > 0 && width < yTabSize -1) {//   case basse gauche
                VecinityList.add(tab.getTab()[length - 1][width + 1]);
            }

            if (length > 0) {//   case gauche
                VecinityList.add(tab.getTab()[length - 1][width]);
            }

            if (length > 0 && width > 0) {//   case gauche haute
                VecinityList.add(tab.getTab()[length - 1][width - 1]);
            }

            if (width > 0) {//   case haute
                VecinityList.add(tab.getTab()[length][width - 1]);
            }
        }
        
        //System.out.println("Recuperation du voisinage !");
        return VecinityList;// retourne les cases du voisinage de la case donne en parametre.
    }
    
    private HashMap VecinityStateCount(ArrayList l){
        int temp;
        HashMap countList = new HashMap();
        countList.put(Etat.vide, 0);
        countList.put(Etat.jeunePousse, 0);
        countList.put(Etat.arbuste, 0);
        countList.put(Etat.arbre, 0);
        countList.put(Etat.feu, 0);
        countList.put(Etat.cendre, 0);
        countList.put(Etat.infecte, 0);
        
        
        //System.out.println("Debut du comptage d etat dans le voisinage !");
        for (Iterator it = l.iterator(); it.hasNext();) {//   pr chaque case du voisinage, on cherche son etat
            Case c = (Case) it.next();
            switch(c.getEtat()){
                case vide:
                    temp = Integer.valueOf(countList.get(Etat.vide).toString());
                    temp++;
                    countList.put(Etat.vide, temp);
                break;
                case jeunePousse:
                    temp = Integer.valueOf(countList.get(Etat.jeunePousse).toString());
                    temp++;
                    countList.put(Etat.jeunePousse, temp);
                break;
                case arbuste:
                    temp = Integer.valueOf(countList.get(Etat.arbuste).toString());
                    temp++;
                    countList.put(Etat.arbuste, temp);
                break;
                case arbre:
                    temp = Integer.valueOf(countList.get(Etat.arbre).toString());
                    temp++;
                    countList.put(Etat.arbre, temp);
                break;
                case feu:
                    temp = Integer.valueOf(countList.get(Etat.feu).toString());
                    temp++;
                    countList.put(Etat.feu, temp);
                break;
                case cendre:
                    temp = Integer.valueOf(countList.get(Etat.cendre).toString());
                    temp++;
                    countList.put(Etat.cendre, temp);
                break;
                case infecte:
                    temp = Integer.valueOf(countList.get(Etat.infecte).toString());
                    temp++;
                    countList.put(Etat.infecte, temp);
                break;
            }
        }
        //System.out.println("Fin du comptage d etat du voisinage !");
        return countList;
    }
    
    private void UpdateCheckedCell(Case c, Case cc, HashMap hm){
        //System.out.println("Debut de modification d une cellule dans updatedTab !");
        cc.setEtat(c.getEtat());
        if (fireMode) {
        //System.out.println("modification en fireMode/InvasionMode !");
            switch(c.getEtat()){
                case jeunePousse:
                    if (Integer.valueOf(hm.get(Etat.feu).toString()) >= 1) {
                        if (Ignition(c.getEtat())) {
                            cc.setEtat(Etat.feu);
                        }
                    }
                break;
                case arbuste :
                    if (Integer.valueOf(hm.get(Etat.feu).toString()) >= 1) {
                        if (Ignition(c.getEtat())) {
                            cc.setEtat(Etat.feu);
                        }
                    }
                break;
                case arbre:
                    if (Integer.valueOf(hm.get(Etat.feu).toString()) >= 1) {
                        if (Ignition(c.getEtat())) {
                            cc.setEtat(Etat.feu);
                        }
                    }
                break;
                case feu:
                    cc.setEtat(Etat.cendre);
                break;
                case cendre:
                    cc.setEtat(Etat.vide);
                break;
            }
        } else if(invasionMode){
            switch(c.getEtat()){
                case jeunePousse:
                    if (Infected(c.getEtat())) {
                        cc.setEtat(Etat.infecte);
                    }
                break;
                case arbuste:
                    if (Infected(c.getEtat())) {
                        cc.setEtat(Etat.infecte);
                    }
                break;
                case arbre:
                    if (Infected(c.getEtat())) {
                        cc.setEtat(Etat.infecte);
                    }
                    break;
                case infecte:
                    cc.setEtat(Etat.vide);
                break;
            }
        } else {
        //System.out.println("Modification d une cellule en normal !");
            switch(c.getEtat()){
                case vide:
                    if (Integer.valueOf(hm.get(Etat.arbre).toString()) >= 2
                        || Integer.valueOf(hm.get(Etat.arbuste).toString()) >= 3
                        || (Integer.valueOf(hm.get(Etat.arbre).toString()) == 1 && Integer.valueOf(hm.get(Etat.arbuste).toString()) == 2)) {
                        cc.setEtat(Etat.jeunePousse);
                    }
                break;
                case jeunePousse:
                    if (Integer.valueOf(hm.get(Etat.arbre).toString()) + Integer.valueOf(hm.get(Etat.arbuste).toString()) <= 3) {
                        cc.setEtat(Etat.arbuste);
                    }
                break;
                case arbuste :
                    if (c.getElapsedTime() == 1) {
                        cc.setEtat(Etat.arbre);
                        cc.setElapsedTime(0);
                    } else{
                        cc.setElapsedTime(c.getElapsedTime() + 1);
                    }
                break;
                case feu:
                    cc.setEtat(Etat.vide);
                    break;
                case cendre:
                    cc.setEtat(Etat.vide);
                    break;
                case infecte:
                    cc.setEtat(Etat.vide);
                    break;
            }
        }
        
        //System.out.println("Fin de Modification de la cellule !");
    }
    
    private int CreateRandomNumber(){
        int lowerPct = 0, hightPct = 100;
        int temp = (int)(Math.random() * (hightPct - lowerPct)) + lowerPct;
        int temp2 = (int)(Math.random() * (hightPct - lowerPct)) + lowerPct;
        int temp3 = (int)(Math.random() * (hightPct - lowerPct)) + lowerPct;
        //System.out.println("Creation un nombre aléatoire termine !");
        return (int)((temp + temp2 + temp3)/3);
    }
    
    private boolean Ignition (Etat etat){
        int rdm = CreateRandomNumber();
        
        //System.out.println("Retour d un bouleen en fonction du pourcentage pour FireMode!");
        switch(etat){
            case jeunePousse:
                if (rdm > 0 && rdm < 25) {
                    return true;
                }
                if (rdm > 24 && rdm < 100) {
                    return false;
                }
            break;
            case arbuste:
                if (rdm > 0 && rdm < 50) {
                    return true;
                }
                if (rdm > 49 && rdm < 100) {
                    return false;
                }
            break;
            case arbre:
                if (rdm > 0 && rdm < 75) {
                    return true;
                }
                if (rdm > 74 && rdm < 100) {
                    return false;
                }
            break;
        }
        return false;
    }
    
    private boolean Infected (Etat etat){
        int rdm = CreateRandomNumber();
        
        //System.out.println("Retour d un bouleen en fonction du pourcentage pour InvasionMode!");
        switch(etat){
            case jeunePousse:
                if (rdm > 0 && rdm < 75) {
                    return true;
                }
                if (rdm > 74 && rdm < 100) {
                    return false;
                }
            break;
            case arbuste:
                if (rdm > 0 && rdm < 50) {
                    return true;
                }
                if (rdm > 49 && rdm < 100) {
                    return false;
                }
            break;
            case arbre:
                if (rdm > 0 && rdm < 25) {
                    return true;
                }
                if (rdm > 24 && rdm < 100) {
                    return false;
                }
            break;
        }
        return false;
    }
    public Case[][] TransformToTab(String stringTab, int tabX, int tabY){
        ArrayList<String[]> completeList = new ArrayList<>();
        String[] tab1 = stringTab.split(";");
        for (int i = 0; i < tab1.length; i++) {
            String[] tab2 = tab1[i].split(",");
            completeList.add(tab2);
        }
        
        Case[][] newtab = new Case[tabX][tabY];
        for (int j = 0; j < tabY; j++) {
            for (int i = 0; i < tabX; i++) {
                newtab[i][j] = new Case(Etat.vide);
            }
        }
        
        for (Iterator<String[]> it = completeList.iterator(); it.hasNext();) {
            String[] line = it.next();
            Etat temp = Etat.vide;
            switch(Integer.valueOf(line[2])) {
                case 0:
                    temp = Etat.vide;
                    break;
                case 1:
                    temp = Etat.jeunePousse;
                    break;
                case 2:
                    temp = Etat.arbuste;
                    break;
                case 3:
                    temp = Etat.arbre;
                    break;
                case 4:
                    temp = Etat.feu;
                    break;
                case 5:
                    temp = Etat.cendre;
                    break;
                case 6:
                    temp = Etat.infecte;
                    break;
            }
            int x = Integer.valueOf(line[0]);
            int y = Integer.valueOf(line[1]);
            newtab[x][y].setEtat(temp);
        }
        return newtab;
    }
}
