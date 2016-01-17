package gil.units;

import gil.MainFrame;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanPara extends JPanel{
    
    private MainFrame mainframe;
    
    private JPanel radioPanel;
    
    private JButton butGeneration;
    private JButton butPause;
    private JButton butNext;
    private JButton butValid;
    private JButton butStepValid;
    
    private JLabel tfTailleX;
    private JLabel tfTailleY;
    private JLabel tfStep;
    private JLabel SliderNumber;
    
    private JTextField tailleX;
    private JTextField tailleY;
    private JTextField tfStepNumber;
    
    private JCheckBox cbFireMode;
    private JCheckBox cbInvasionMode;
    
    private JSlider slStepSpeed;
    
    private ButtonGroup caseGroup;
    
    private JRadioButton emptyCaserButton;
    private JRadioButton jeunePousseCaserButton;
    private JRadioButton arbustreCaserButton;
    private JRadioButton arbreCaserButton;
    private JRadioButton feuCaserButton;
    private JRadioButton cendreCaserButton;
    private JRadioButton insecteCaserButton;
    
    public PanPara() {
        this.setPreferredSize(new Dimension(270, 150));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.ipady = gbc.ipadx = 0; 
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.weightx = 0;
        gbc.weighty = 0;
        
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel title = new JLabel("Paramètres :");
        this.add(title ,gbc);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.tfTailleX = new JLabel("taille en abscisse :");
        this.add(tfTailleX ,gbc);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.tfTailleY = new JLabel("taille en ordonnée :");
        this.add(tfTailleY ,gbc);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        
        //---------------------------------------------
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.tailleX = new JTextField("100");
        this.add(tailleX ,gbc);
        //tailleX.getText()
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.tailleY = new JTextField("100");
        this.add(tailleY ,gbc);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------   
        gbc.insets = new Insets(2, 2, 10, 2);    
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.butValid = new JButton("Valider le repère");
        this.add(butValid, gbc);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        
        //--------------------------------------------- 
        gbc.insets = new Insets(2, 2, 2, 2);    
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.tfStep = new JLabel("Nombre de tour :");
        this.add(tfStep ,gbc);
        this.tfStep.setVisible(false);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.tfStepNumber = new JTextField("50");
        this.add(tfStepNumber ,gbc);
        this.tfStepNumber.setVisible(false);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        this.slStepSpeed = new JSlider(JSlider.HORIZONTAL, 200, 5000, 1000);
        this.add(slStepSpeed ,gbc);
        this.slStepSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                SliderNumber.setText(slStepSpeed.getValue() + " ms");
            }
        });
        this.slStepSpeed.setVisible(false);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.SliderNumber = new JLabel("1000 ms");
        this.add(SliderNumber ,gbc);
        this.SliderNumber.setVisible(false);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------   
        gbc.insets = new Insets(2, 2, 2, 2);     
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.butStepValid = new JButton("Valider paramètre \"Tour\"");
        this.add(butStepValid, gbc);
        this.butStepValid.setVisible(false);
                
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.cbFireMode = new JCheckBox("Mode Feux de forêts");
        this.add(cbFireMode ,gbc);
        this.cbFireMode.setVisible(false);
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.cbInvasionMode = new JCheckBox("Mode Invasion d'insectes");
        this.add(cbInvasionMode ,gbc);
        this.cbInvasionMode.setVisible(false);
        
        //---------------------------------------------
        gbc.weightx = 0;
        gbc.weighty = 1;
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridheight = 1;
        gbc.gridwidth = 3;
        
        emptyCaserButton = new JRadioButton("Case \"Vide\"");
        emptyCaserButton.setActionCommand("Vide");
        jeunePousseCaserButton = new JRadioButton("Case \"Jeune pousse\"");
        jeunePousseCaserButton.setSelected(true);
        jeunePousseCaserButton.setActionCommand("Jeune pousse");
        arbustreCaserButton = new JRadioButton("Case \"Arbustre\"");
        arbustreCaserButton.setActionCommand("Arbustre");
        arbreCaserButton = new JRadioButton("Case \"Arbre\"");
        arbreCaserButton.setActionCommand("Arbre");
        feuCaserButton = new JRadioButton("Case \"Feu\"");
        feuCaserButton.setActionCommand("Feu");
        cendreCaserButton = new JRadioButton("Case \"Cendre\"");
        cendreCaserButton.setActionCommand("Cendre");
        insecteCaserButton = new JRadioButton("Case \"Insectes\"");
        insecteCaserButton.setActionCommand("Insectes");
        
        caseGroup = new ButtonGroup();
        caseGroup.add(emptyCaserButton);
        caseGroup.add(jeunePousseCaserButton);
        caseGroup.add(arbustreCaserButton);
        caseGroup.add(arbreCaserButton);
        caseGroup.add(feuCaserButton);
        caseGroup.add(cendreCaserButton);
        caseGroup.add(insecteCaserButton);
        
        radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(emptyCaserButton);
        radioPanel.add(jeunePousseCaserButton);
        radioPanel.add(arbustreCaserButton);
        radioPanel.add(arbreCaserButton);
        radioPanel.add(feuCaserButton);
        radioPanel.add(cendreCaserButton);
        radioPanel.add(insecteCaserButton);
        
        this.add(radioPanel, gbc);
        this.feuCaserButton.setEnabled(false);
        this.cendreCaserButton.setEnabled(false);
        this.insecteCaserButton.setEnabled(false);
        this.radioPanel.setVisible(false);
        
        //---------------------------------------------      
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------        
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.butGeneration = new JButton("Génération");
        this.add(butGeneration, gbc);
        this.butGeneration.setEnabled(false);
        
        //---------------------------------------------      
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------        
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.butPause = new JButton("Pause");
        this.add(butPause, gbc);
        this.butPause.setVisible(false);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------        
        gbc.gridx = 2;
        gbc.gridy = 12;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.butNext = new JButton("Tour suivant");
        this.add(butNext, gbc);
        this.butNext.setEnabled(false);
    }

    public JButton getButGeneration() {
        return butGeneration;
    }

    public JButton getButNext() {
        return butNext;
    }

    public JButton getButValid() {
        return butValid;
    }

    public MainFrame getMainframe() {
        return mainframe;
    }

    public JTextField getTailleX() {
        return tailleX;
    }

    public JTextField getTailleY() {
        return tailleY;
    }

    public JLabel getTfTailleX() {
        return tfTailleX;
    }

    public JLabel getTfTailleY() {
        return tfTailleY;
    }

    public JRadioButton getArbreCaserButton() {
        return arbreCaserButton;
    }

    public JRadioButton getArbustreCaserButton() {
        return arbustreCaserButton;
    }

    public ButtonGroup getCaseGroup() {
        return caseGroup;
    }

    public JRadioButton getCendreCaserButton() {
        return cendreCaserButton;
    }

    public JRadioButton getEmptyCaserButton() {
        return emptyCaserButton;
    }

    public JRadioButton getFeuCaserButton() {
        return feuCaserButton;
    }

    public JRadioButton getInsecteCaserButton() {
        return insecteCaserButton;
    }

    public JRadioButton getJeunePousseCaserButton() {
        return jeunePousseCaserButton;
    }

    public JPanel getRadioPanel() {
        return radioPanel;
    }

    public JLabel getTfStep() {
        return tfStep;
    }

    public JTextField getTfStepNumber() {
        return tfStepNumber;
    }

    public JCheckBox getCbFireMode() {
        return cbFireMode;
    }

    public JCheckBox getCbInvasionMode() {
        return cbInvasionMode;
    }

    public JButton getButStepValid() {
        return butStepValid;
    }

    public JSlider getSlStepSpeed() {
        return slStepSpeed;
    }

    public JLabel getSliderNumber() {
        return SliderNumber;
    }

    public JButton getButPause() {
        return butPause;
    }
    
    
}
