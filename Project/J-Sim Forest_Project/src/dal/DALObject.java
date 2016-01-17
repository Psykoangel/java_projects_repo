package dal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DALObject {
    private String url;
    private String username;
    private String password;
    private Connection cnx;
    private PreparedStatement preStmt;
    private ResultSet result;
    private ArrayList lst;
    private ArrayList<String[]> completeLst;

    //Constructeur
    public DALObject() {
        try {
            if (cnx == null) {
                System.out.println("Test de connexion au driver JDBC");
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver O.K.");
                try {
                    System.out.println("Test de connexion à la BDD");
                    url = "jdbc:mysql://localhost/jsimdb";
                    username = "root";
                    password = "";
                    cnx = DriverManager.getConnection(url, username, password);
                    System.out.println("BDD O.K.");
                } catch (SQLException e) {
                    // Si connexion BDD K.O.
                    System.out.println("SQLException: " + e.getMessage()); 
                    System.out.println("SQLState: " + e.getSQLState()); 
                    System.out.println("VendorError: " + e.getErrorCode()); 
                }
            }
            else {
                System.out.println("Une connexion est déjà ouverte");
            }
        } catch (Exception ex) { 
              // Si connexion driver K.O.
              System.out.println("Chargement du driver K.O.");
          }
    }
    
    //Récupération des information de la bdd pour générer le fichier .csv
    //Envoi DAL -> BOL
    public ArrayList<String[]> gridData() throws SQLException {
        completeLst = new ArrayList<>();
        String str = new String();
        String query = ("SELECT GRID FROM save;");
        preStmt = cnx.prepareStatement(query);
        result = preStmt.executeQuery();
        while (result.next()) {
            str = result.getString("GRID");
        }
        preStmt.close();
        String[] tab1 = str.split(";");
        for (int i = 0; i < tab1.length; i++) {
            String[] tab2 = tab1[i].split(",");
            completeLst.add(tab2);
        }
        return completeLst;
    }
    
    
    public void createCSVExport(String pName, ArrayList<String[]> tabCSV) throws IOException {
        String filename = new String();
        String path = new String();
        filename = pName+".csv";
        FileWriter writer;
        String targetDirectory = "C:\\J-SimForest\\CSVSave\\";
        path = targetDirectory + filename;
        File df = new File(targetDirectory);
        File newFile = new File(path);
        
        if (df.exists()) {
            newFile.createNewFile();
            writer = new FileWriter(path, true);
            writer.append("jeune pousse;arbuste;arbre;vide\n");
            for (int j = 0; j < tabCSV.size(); j++) {
                for (int i = 0; i < tabCSV.get(j).length; i++)
                {
                    writer.append(tabCSV.get(j)[i]);
                    writer.append(";");
                }
                writer.append("\n");
            }
        } else if (df.mkdirs()) {
            newFile.createNewFile();
            writer = new FileWriter(path, true);
            writer.append("jeune pousse;arbuste;arbre;vide");
            for (int j = 0; j < tabCSV.size(); j++) {
                for (int i = 0; i < tabCSV.get(j).length; i++)
                {
                    writer.append(tabCSV.get(j)[i]);
                    writer.append(";");
                }
                writer.append("\n");
            }
        } else {
            System.out.println("pas bon !!");
            throw new IOException("Le dossier n'a pas pu être créé !");
        }
        
        writer.flush();
	writer.close();
    }
    
    //Récupération des information de la bdd pour afficher les sauvegardes
    //Envoi DAL -> BOL
    public ArrayList showSave() throws SQLException {
        String query = ("SELECT NAME FROM save ORDER BY ID;");
        preStmt = cnx.prepareStatement(query);
        result = preStmt.executeQuery();
        lst = new ArrayList<>();
        while (result.next()) {
            lst.add(result.getString("NAME"));
        }
        preStmt.close();
        return lst;
    }
    
    //Récupération des information de la bdd pour récupérer les données de la sauvegarde
    //Envoi DAL -> BOL
    public ArrayList selectSave(String pName) throws SQLException {
        String query = ("SELECT TX, TY, STT, SN, GRID FROM save WHERE NAME = ?;");
        preStmt = cnx.prepareStatement(query);
        preStmt.setString(1, pName);
        result = preStmt.executeQuery();
        lst = new ArrayList<>();
        while (result.next()) {
            lst.add(result.getInt("TX"));
            lst.add(result.getInt("TY"));
            lst.add(result.getInt("STT"));
            lst.add(result.getInt("SN"));
            lst.add(result.getString("GRID"));
        }
        preStmt.close();
        return lst;
    }
    
    //Ajout d'une sauvegarde dans la BDD
    // BOL -> DAL
    public void insertSave(String pName, int pTx, int pTy, int pStt, int pSn, String pGrid) throws SQLException {
        String query = ("INSERT INTO save (NAME, TX, TY, STT, SN, GRID) VALUES (?, ?, ?, ?, ?, ?);");
        preStmt = cnx.prepareStatement(query);
        preStmt.setString(1, pName);
        preStmt.setInt(2, pTx);
        preStmt.setInt(3, pTy);
        preStmt.setInt(4, pStt);
        preStmt.setInt(5, pSn);
        preStmt.setString(6, pGrid);
        preStmt.execute();
        preStmt.close();
    }
    
    //Update pour modifier ou écraser les données en BDD
    //BOL -> DAL
    public void updateSave(String pName, int pTx, int pTy, int pStt, int pSn, String pGrid) throws SQLException {
        String req = ("UPDATE save SET NAME = ?, TX = ?, TY = ?, STT = ?, SN = ?, GRID = ? WHERE NAME = ?;");
        PreparedStatement preStmt = cnx.prepareStatement(req);
        preStmt.setString(1, pName);
        preStmt.setInt(2, pTx);
        preStmt.setInt(3, pTy);
        preStmt.setInt(4, pStt);
        preStmt.setInt(5, pSn);
        preStmt.setString(6, pGrid);
        preStmt.setString(7, pName);
        preStmt.execute();
        preStmt.close();
    }
    
    //Suppresion d'une sauvegarde
    //BOL -> DAL
    public void deleteSave(String pName) throws SQLException {
        String req = ("DELETE FROM save WHERE NAME = ?;");
        PreparedStatement preStmt = cnx.prepareStatement(req);
        preStmt.setString(1, pName);
        preStmt.execute();
        preStmt.close();
    }
    
    public void closeConnection() {
        try {
            this.cnx.close();
        } catch (SQLException e) {
        }
    }
}