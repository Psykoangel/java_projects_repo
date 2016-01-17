package gil.units;


import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PanMenu extends JMenuBar{
    
    JMenu file;
    JMenu generate;
    JMenu mode;
    
    JMenuItem ReplayItem;
    JMenuItem importItem;
    JMenuItem exportItem;
    JMenuItem csvItem;
    JMenuItem quitItem;
    JMenuItem geneItem;
    JMenuItem playItem;
    JMenuItem pauseItem;
    JMenuItem fireItem;
    JMenuItem infectItem;
    
    public PanMenu() {
        this.setPreferredSize(new Dimension(30, 30));
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        file = new JMenu("Fichiers");
        this.add(file);
        
        
            ReplayItem = new JMenuItem("Faire une autre simulation");
            file.add(ReplayItem);
        
            importItem = new JMenuItem("Importer depuis la base de données");
            file.add(importItem);

            exportItem = new JMenuItem("Export de la simulation en base de données");
            file.add(exportItem);
            exportItem.setEnabled(false);

            csvItem = new JMenuItem("Export de la simulation au format CSV");
            file.add(csvItem);
            csvItem.setEnabled(false);

            quitItem = new JMenuItem("Quitter");
            file.add(quitItem);
        
        
        generate = new JMenu("Simulation");
        this.add(generate);
        
            geneItem = new JMenuItem("Lancer la génération");
            generate.add(geneItem);
            geneItem.setEnabled(false);

            playItem = new JMenuItem("Lancer le pas suivant");
            generate.add(playItem);
            playItem.setEnabled(false);

            pauseItem = new JMenuItem("Pause");
            generate.add(pauseItem);
            pauseItem.setEnabled(false);
        
        
        mode = new JMenu("Modes de simulation");
        this.add(mode);
        
            fireItem = new JCheckBoxMenuItem("Mode feu");
            mode.add(fireItem);
            fireItem.setEnabled(false);

            infectItem = new JCheckBoxMenuItem("Mode invasion d'insects");
            mode.add(infectItem);
            infectItem.setEnabled(false);
    }

    public JMenuItem getReplayItem() {
        return ReplayItem;
    }

    public JMenuItem getCsvItem() {
        return csvItem;
    }

    public JMenuItem getExportItem() {
        return exportItem;
    }

    public JMenu getFile() {
        return file;
    }

    public JMenuItem getFireItem() {
        return fireItem;
    }

    public JMenuItem getGeneItem() {
        return geneItem;
    }

    public JMenu getGenerate() {
        return generate;
    }

    public JMenuItem getImportItem() {
        return importItem;
    }

    public JMenuItem getInfectItem() {
        return infectItem;
    }

    public JMenu getMode() {
        return mode;
    }

    public JMenuItem getPauseItem() {
        return pauseItem;
    }

    public JMenuItem getPlayItem() {
        return playItem;
    }

    public JMenuItem getQuitItem() {
        return quitItem;
    }
    
}
