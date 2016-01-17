package client;

import dataAccess.EmployeeDAO;
import dataAccess.EmployeePreparedDAO;
import dataAccess.EmployeeSimpleDAO;
import dataAccess.domain.Employee;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Psyko
 */
public class Test {
    public static void main(String[] args){
        
        //création d'employés par le client
        Employee e1 = new Employee("Smith", "John");
        Employee e2 = new Employee("Smithee", "Alan");
        Employee e3 = new Employee("Doe", "John");
        Employee e4 = new Employee("Dupont", "Jean");
        
        //obtention d'un DAO -- connexion ouverte
        EmployeeDAO dao = null;
        
        dao = new EmployeeSimpleDAO();//partie 1
        //dao = new EmployeePreparedDAO();
        
        try{//bloc gouverné dans lequel des exceptions levées peuvent être
        //gérées par les gestionnaires associés.
        //sauvegarde / persistance des employés en base
        dao.addEmployee(e1);
        dao.addEmployee(e2);
        dao.addEmployee(e3);
        dao.addEmployee(e4);
        
        //liste des employés sauvegardés.
        List<Employee> lEmp = dao.listAllEmployees();
        for(Employee e : lEmp) System.out.println(e);
        
        //suppression de John Smith -- en fait de tous les John Smith
        dao.removeEmployee(e1);
        }catch(SQLException e){
            e.printStackTrace();
        //throw new RuntimeException("erreur dans une opération SQL -- le prog va s'arrêter après fermeture de la connexion");
        }finally{
            dao.closeConnection();//fermeture de la connexion
        }
    }
    
}
