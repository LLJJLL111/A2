/**
 * Employee class representing theme park staff
 * Extends Person class to inherit common person attributes
 * Adds employee-specific attributes and behaviors
 */
public class Employee extends Person {
    // Employee-specific instance variables
    private String employeeId;  // Unique identifier for the employee
    private String department;  // Department where employee works
    private double salary;      // Employee's salary

    /**
     * Default constructor
     * Initializes employee with default values
     */
    public Employee() {
        super();  // Call parent class default constructor
        this.employeeId = "E000";
        this.department = "Unknown";
        this.salary = 0.0;
    }

    /**
     * Parameterized constructor
     * @param name Employee's name
     * @param age Employee's age
     * @param email Employee's email
     * @param employeeId Unique employee ID
     * @param department Department where employee works
     * @param salary Employee's salary
     */
    public Employee(String name, int age, String email, String employeeId, String department, double salary) {
        super(name, age, email);  // Call parent class parameterized constructor
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    // Getter and setter methods for employee-specific attributes

    /**
     * Gets the employee ID
     * @return The employee's unique ID
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the employee ID
     * @param employeeId The new employee ID to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the department
     * @return The employee's department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department
     * @param department The new department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the salary
     * @return The employee's salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary
     * @param salary The new salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns a string representation of the employee
     * @return String containing employee details
     */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}