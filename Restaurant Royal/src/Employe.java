public class Employe {
    protected int id;
    public String lastName;
    public String firstName;
    public String role;
    protected String employmentDate;
    protected double salary;

    public Employe(int id, String lastName, String firstName, String role, String employmentDate, int salary) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.role = role;
        this.employmentDate = employmentDate;
        this.salary = salary;
    }

    public String EmployeToString(int id, String lastName, String firstName, String role, String employmentDate, int salary) {
        return "Id : " + id + "\nNom : " + lastName + "\nPrénom : " + firstName + "\nRôle : " + role + "\nDate d'embauche : " + employmentDate + "\nSalaire : " + salary;
    }

    public int getIdEmploye() {
        return this.id;
    }

    public void setIdEmploye(int id) {
        this.id = id;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmploymentDate() {
        return this.employmentDate;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}