package gil.units;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanText extends JPanel {
    
    private JLabel nbStep;
    private JLabel nbJeunePousse;
    private JLabel nbArbuste;
    private JLabel nbArbre;
    private JLabel nbFeu;
    private JLabel nbInfecte;

    public PanText() {
        this.setPreferredSize(new Dimension(400, 50));
        JPanel label = new JPanel(new GridLayout(1,6));
        nbStep = new JLabel("Tour :");
        nbJeunePousse = new JLabel("Jeune pousse ");
        nbJeunePousse.setOpaque(true);
        nbJeunePousse.setBackground(new Color(147, 208, 81, 90));
        nbJeunePousse.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black), BorderFactory.createEmptyBorder(10,10,10,10)));
        nbArbuste = new JLabel(" Arbuste ");
        nbArbuste.setOpaque(true);
        nbArbuste.setBackground(new Color(52, 153, 51, 90));
        nbArbuste.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black), BorderFactory.createEmptyBorder(10,10,10,10)));
        nbArbre = new JLabel(" Arbre ");
        nbArbre.setOpaque(true);
        nbArbre.setBackground(new Color(1, 73, 0, 90));
        nbArbre.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black), BorderFactory.createEmptyBorder(10,10,10,10)));
        nbFeu = new JLabel(" Feu ");
        nbFeu.setOpaque(true);
        nbFeu.setBackground(new Color(231, 31, 27, 90));
        nbFeu.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black), BorderFactory.createEmptyBorder(10,10,10,10)));
        nbFeu.setVisible(false);
        nbInfecte = new JLabel(" Infecté ");
        nbInfecte.setOpaque(true);
        nbInfecte.setBackground(new Color(109, 58, 150, 90));
        nbInfecte.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black), BorderFactory.createEmptyBorder(10,10,10,10)));
        nbInfecte.setVisible(false);
        label.add(nbStep);
        label.add(nbJeunePousse);
        label.add(nbArbuste);
        label.add(nbArbre);
        label.add(nbFeu);
        label.add(nbInfecte);
        
        this.add(label, BorderLayout.WEST);
        this.repaint();
    }

    public String getNbStep() {
        return nbStep.getText();
    }

    public JLabel getNbArbre() {
        return nbArbre;
    }

    public JLabel getNbArbuste() {
        return nbArbuste;
    }

    public JLabel getNbFeu() {
        return nbFeu;
    }

    public JLabel getNbInfecte() {
        return nbInfecte;
    }

    public JLabel getNbJeunePousse() {
        return nbJeunePousse;
    }

    public void setNbStep(String nbStep) {
        this.nbStep.setText(nbStep);
    }

    public void setNbArbre(String nbArbre) {
        this.nbArbre.setText(nbArbre);
    }

    public void setNbArbuste(String nbArbuste) {
        this.nbArbuste.setText(nbArbuste);
    }

    public void setNbFeu(String nbFeu) {
        this.nbFeu.setText(nbFeu);
    }

    public void setNbInfecte(String nbInfecte) {
        this.nbInfecte.setText(nbInfecte);
    }

    public void setNbJeunePousse(String nbJeunePousse) {
        this.nbJeunePousse.setText(nbJeunePousse);
    }
}
