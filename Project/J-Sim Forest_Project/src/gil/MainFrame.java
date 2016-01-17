package gil;

import bol.BOLObject;
import bol.utils.Case;
import gil.action.*;
import gil.units.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class MainFrame extends JFrame {

    private PanGraphic panGraphic;
    private PanMenu panMenu;
    private PanPara panPara;
    private PanProgBar panProgBar;
    private PanText panText;
    
    private JSplitPane splitBas;
    
    BOLObject BOLObj;
    private Case[][] tabToShow;
    private int gridWidth;
    private int gridLength;
    

    MainFrame(BOLObject BOLObj) {
        //this.setLocationRelativeTo(null);
        this.setTitle("J-Sim Forest");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 720);

        this.panGraphic = new PanGraphic();
        this.panMenu = new PanMenu();
        this.panPara = new PanPara();
        this.panProgBar = new PanProgBar();
        this.panText = new PanText();
        
        //ActionListener on component Application
        //this.panMenu.getReplayItem().addActionListener(null);
        this.panMenu.getQuitItem().addActionListener(new ButQuit());
        this.panMenu.getImportItem().addActionListener(new ImportFromDataBase(BOLObj, this));
        this.panMenu.getGeneItem().addActionListener(new ButGeneration(BOLObj, this));
        this.panMenu.getFireItem().addActionListener(new AddMode(BOLObj, this));
        this.panMenu.getInfectItem().addActionListener(new AddMode(BOLObj, this));
        this.getPanMenu().getReplayItem().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                GILObject GILObject = new GILObject(new BOLObject());
                dispose();
            }
        });
        this.panMenu.getCsvItem().addActionListener(new ExportCsv(BOLObj, this));
        this.panMenu.getExportItem().addActionListener(new ExportToDataBase(BOLObj, this));
        this.panMenu.getGeneItem().addActionListener(new ButGeneration(BOLObj, this));
        this.panMenu.getPlayItem().addActionListener(new ButNextStep(BOLObj, this));
        this.panMenu.getPauseItem().addActionListener(new ButPause(BOLObj, this));
        
        this.panPara.getButValid().addActionListener(new ValidParam(BOLObj, this));
        this.panPara.getButStepValid().addActionListener(new ValidStepParam(BOLObj, this));
        this.panPara.getCbFireMode().addActionListener(new AddMode(BOLObj, this));
        this.panPara.getCbInvasionMode().addActionListener(new AddMode(BOLObj, this));
        this.panPara.getButGeneration().addActionListener(new ButGeneration(BOLObj, this));
        this.panPara.getButPause().addActionListener(new ButPause(BOLObj, this));
        this.panPara.getButNext().addActionListener(new ButNextStep(BOLObj, this));

        this.splitBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panText, panProgBar);
        this.splitBas.setDividerLocation(550);

        this.setJMenuBar(panMenu);
        this.getContentPane().add(panGraphic, BorderLayout.CENTER);
        this.getContentPane().add(panPara, BorderLayout.EAST);        
        this.getContentPane().add(splitBas, BorderLayout.SOUTH);
    }

    
    public Case[][] getTabToShow() {
        this.tabToShow = this.panGraphic.getTabToShow();
        return this.tabToShow;
    }

    public int getGridLength() {

        this.gridLength = this.panGraphic.getGridLength();
        return gridLength;
    }

    public int getGridWidth() {
        this.gridWidth = this.panGraphic.getGridWidth();
        return gridWidth;
    }

    public PanGraphic getPanGraphic() {
        return panGraphic;
    }

    public PanMenu getPanMenu() {
        return panMenu;
    }

    public PanPara getPanPara() {
        return panPara;
    }

    public PanProgBar getPanProgBar() {
        return panProgBar;
    }

    public PanText getPanText() {
        return panText;
    }

    
    public void setTabToShow(Case[][] tabToShow, int gridLength, int gridWidth) {
        this.tabToShow = tabToShow;
        this.gridLength = gridLength;
        this.gridWidth = gridWidth;
        this.panGraphic.setGridLength(this.gridLength);
        this.panGraphic.setGridWidth(this.gridWidth);
        this.panGraphic.setTabToShow(this.tabToShow);        
        this.panGraphic.repaint();
    }
}
