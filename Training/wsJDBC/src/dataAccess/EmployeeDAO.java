package dataAccess;

import dataAccess.domain.Employee;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Psyko
 */
public interface EmployeeDAO {

    public List<Employee> listAllEmployees() throws SQLException;
    public void addEmployee(Employee e) throws SQLException;
    public void removeEmployee(Employee e) throws SQLException;
    public void closeConnection();
    
}
