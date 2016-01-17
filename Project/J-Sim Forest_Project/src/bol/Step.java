
package bol;

import bol.utils.Etat;
import gil.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.swing.Timer;

public class Step implements ActionListener{
    
    int lastUpdate;
    int remainingTime;
    int stepSpeed;
    int stepNumber;
    int actualStepNumber;
    
    BOLObject BOLObj;
    MainFrame frame;
    
    Timer timer;

    // Constructors
    public Step() {
        remainingTime = 0;
        timer = new Timer(3000, this);
        timer.setInitialDelay(0);
    }
    
    public Step(int msTime, BOLObject calculate) {
        remainingTime = 0;
        this.actualStepNumber = 0;
        this.BOLObj = calculate;
        timer = new Timer(msTime, this);
        timer.setInitialDelay(0);
    }

    // Getter
    public int getActualStepNumber() {
        return actualStepNumber;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    // Setter
    public void setActualStepNumber(int actualStepNumber) {
        this.actualStepNumber = actualStepNumber;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
    
    public void updateBOLObject(BOLObject BOLobj){
        this.BOLObj = BOLobj;
    }
    
    public void setStepParameter(int stepNumber, int stepSpeed){
        this.remainingTime = this.stepNumber = stepNumber;
        this.stepSpeed = stepSpeed;
        this.actualStepNumber = 0;
        timer = new Timer(this.stepSpeed, this);
        timer.setInitialDelay(0);
    }
    
    
    public void start(BOLObject obj, MainFrame frame){
        this.BOLObj = obj;
        this.frame = frame;
        resume();
    }
    
    public void stop(){
        pause();
    }
    
    public void update(){
        if (remainingTime == 0) {
            this.frame.getPanPara().getButPause().setVisible(false);
            this.frame.getPanPara().getButGeneration().setVisible(true);
            this.frame.getPanPara().getTfStep().setEnabled(true);
            this.frame.getPanPara().getTfStepNumber().setEnabled(true);
            this.frame.getPanPara().getSlStepSpeed().setEnabled(true);
            this.frame.getPanPara().getSliderNumber().setEnabled(true);
            this.frame.getPanPara().getButStepValid().setVisible(true);
            this.frame.getPanPara().getButStepValid().setEnabled(true);
            
            this.frame.getPanPara().getCbFireMode().setVisible(false);
            this.frame.getPanPara().getCbInvasionMode().setVisible(false);
            
            this.frame.getPanMenu().getInfectItem().setEnabled(false);
            this.frame.getPanMenu().getFireItem().setEnabled(false);
            
            this.frame.getPanPara().getRadioPanel().setVisible(false);
            if (!(BOLObj.getTab().getX() > 49 && BOLObj.getTab().getY() > 49)) {
                this.frame.getPanPara().getButGeneration().setEnabled(false);
            }
            if (!(BOLObj.getTab().getX() > 49 && BOLObj.getTab().getY() > 49)) {
                this.frame.getPanPara().getButNext().setEnabled(false);
            }
            this.frame.getPanProgBar().setProgressNumber(0);

            this.frame.getPanMenu().getGeneItem().setEnabled(false);
            this.frame.getPanMenu().getPlayItem().setEnabled(false);
            this.frame.getPanMenu().getPauseItem().setEnabled(false);
            
            remainingTime = 0;
            this.actualStepNumber = 0;
            timer.stop();
        } else {
            this.frame.setTabToShow(this.BOLObj.getUpdatedTab().getTab(), this.BOLObj.getUpdatedTab().getX(), this.BOLObj.getUpdatedTab().getY());
            BOLObj.setTab(frame.getTabToShow(), frame.getGridWidth(), frame.getGridLength());
            BOLObj.CheckTab();
            this.frame.getPanGraphic().repaint();
            this.updateBOLObject(BOLObj);

            this.frame.getPanProgBar().setProgressNumber((int)(((double)actualStepNumber * 100.0)/(stepNumber/+ 1)));
            HashMap countResult = BOLObj.getCaseCounter().CountStateGridCase(BOLObj, frame);

            int nbMaxTabCase = BOLObj.getTab().getX()* BOLObj.getTab().getY();
            DecimalFormat df = new DecimalFormat("#.###");

            this.frame.getPanText().setNbStep("Tour : " + (actualStepNumber) + "/" + stepNumber);
            String a = df.format((double)Integer.valueOf(countResult.get(Etat.jeunePousse).toString())/(double)nbMaxTabCase);
            this.frame.getPanText().setNbJeunePousse("JP : " + a);
            String b = df.format((double)Integer.valueOf(countResult.get(Etat.arbuste).toString())/(double)nbMaxTabCase);
            this.frame.getPanText().setNbArbuste("Arbu. : " + b);
            String c = df.format((double)Integer.valueOf(countResult.get(Etat.arbre).toString())/(double)nbMaxTabCase);
            this.frame.getPanText().setNbArbre("Arbre : " + c);
            
            if (this.frame.getPanText().getNbFeu().isEnabled()) {
                this.frame.getPanText().setNbFeu("Feu : " + df.format((double)Integer.valueOf(countResult.get(Etat.feu).toString())/(double)nbMaxTabCase));
            }
            
            if (this.frame.getPanText().getNbInfecte().isEnabled()) {
                this.frame.getPanText().setNbInfecte("Inf. : " + df.format((double)Integer.valueOf(countResult.get(Etat.infecte).toString())/(double)nbMaxTabCase));
            }

            String[] csvSave = {a, b, c, df.format((double)Integer.valueOf(countResult.get(Etat.vide).toString())/(double)nbMaxTabCase)};
            this.BOLObj.getCountStateGridCase().add(csvSave);

            this.frame.getPanText().repaint();
            
            int now = this.actualStepNumber++;
            int elapsed = now - lastUpdate;
            remainingTime -= elapsed;
            lastUpdate = now;
        }
    }
    
    void resume(){
        lastUpdate = this.actualStepNumber;
        timer.start();
    }
    
    void pause(){
        int now = this.actualStepNumber;
        remainingTime -= (now - lastUpdate);
        timer.stop();
    }
    
    public void nextStep(BOLObject obj, MainFrame frame){
        this.BOLObj = obj;
        this.frame = frame;
        update();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
}
