/**
 * Employee class - Represents theme park staff who operate rides
 * Extends Person class to inherit common attributes
 */
public class Employee extends Person {
    // Employee-specific instance variables
    private String employeeId;
    private String department;
    private String position;

    /**
     * Default constructor - initializes with default values
     */
    public Employee() {
        super();
        this.employeeId = "E0000";
        this.department = "Unknown";
        this.position = "Staff";
    }

    /**
     * Parameterized constructor - initializes with provided values
     * @param name Employee's name
     * @param age Employee's age
     * @param id Employee's personal ID
     * @param employeeId Employee's work ID
     * @param department Employee's department
     * @param position Employee's job position
     */
    public Employee(String name, int age, String id, String employeeId, String department, String position) {
        super(name, age, id);
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
    }

    // Getter and setter methods
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Returns string representation of the employee
     * @return String containing employee details
     */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + "', " +
                "age=" + getAge() + ", " +
                "id='" + getId() + "', " +
                "employeeId='" + employeeId + "', " +
                "department='" + department + "', " +
                "position='" + position + "'}";
    }
}