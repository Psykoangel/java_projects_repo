package dataAccess;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import dataAccess.domain.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Psyko
 */
public class EmployeePreparedDAO implements EmployeeDAO {
    
    //Privates Attributes :
    
    private Connection connection;
    private Statement state;

    //Constructors :
    
    public EmployeePreparedDAO() {
        try {
            String url = "jdbc:mysql://localhost:3306/wsjdbcdb";
            String user = "root";
            String passwd = "";
            
            this.connection = DriverManager.getConnection(url, user, passwd);
            this.state = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            throw new RuntimeException("erreur dans l'obtention de la connexion -- le prog va s'arrêter");
        }
    }
    
    
    //Overrides : 

    @Override
    public List<Employee> listAllEmployees() throws SQLException {
        String qry = "SELECT * FROM employes";
        java.sql.PreparedStatement prepare = this.connection.prepareStatement(qry);
        List<Employee> list;
        try (ResultSet res = prepare.executeQuery()) {
            list = new LinkedList<>();
            int i = 0;
            while (res.next()) {
                Employee e = new Employee(res.getString(2), res.getString(3));
                list.add(e);
                list.get(i).setId(res.getInt(1));
                i++;
            }
            res.close();
            prepare.close();
        }
        return list;
    }

    @Override
    public void addEmployee(Employee e) throws SQLException {
        String qry = "INSERT INTO employes (nom, prenom) VALUES (?, ?)";
        try (java.sql.PreparedStatement prepare = this.connection.prepareStatement(qry)) {
            prepare.setString(1, e.getName());
            prepare.setString(2, e.getFirstName());
            prepare.executeUpdate();
            prepare.close();
        }
    }

    @Override
    public void removeEmployee(Employee e) throws SQLException {
        String qry = "DELETE FROM employes WHERE nom = ? AND prenom = ?";
        try (java.sql.PreparedStatement prepare = this.connection.prepareStatement(qry)) {
            prepare.setString(1, e.getName());
            prepare.setString(2, e.getFirstName());
            prepare.executeUpdate();
            prepare.close();
        }
    }

    @Override
    public void closeConnection() {
        try {
            this.state.close();
            this.connection.close();
        } catch (SQLException e) {
        }
    }
}
