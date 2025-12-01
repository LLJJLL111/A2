/**
 * Employee class - Represents theme park staff
 * Part 1: Extends Person class
 */
public class Employee extends Person {
    private String employeeId;
    private String department;
    private String position;

    public Employee() {
        super();
        this.employeeId = "E0000";
        this.department = "Unknown";
        this.position = "Staff";
    }

    public Employee(String name, int age, String id, String employeeId, String department, String position) {
        super(name, age, id);
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                ", employeeId='" + employeeId + "', department='" + department +
                "', position='" + position + "'}";
    }
}