package dataAccess.domain;

/**
 *
 * @author Psyko
 */
public class Employee {
    
    //Private Attributes :
    
    private int id;
    private String name;
    private String firstName;
    
    //Constructors :

    public Employee() {
    }

    public Employee(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
    }
    
    //Getters and Setters :
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //Methods :
    
    //Overrides :

    @Override
    public String toString() {
        return "Employee id: " + this.id + " -- " + this.name + " " + this.firstName;
    }
    
    
}
