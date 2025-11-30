/**
 * Ride class representing theme park rides
 * Contains ride attributes and manages ride operations
 */
public class Ride {
    // Ride instance variables
    private String rideName;    // Name of the ride
    private String rideType;    // Type of ride (e.g., Thrill, Water, Family)
    private int capacity;       // Maximum capacity of the ride
    private Employee operator;  // Employee assigned to operate the ride

    /**
     * Default constructor
     * Initializes ride with default values
     */
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Standard";
        this.capacity = 10;
        this.operator = null;  // No operator assigned by default
    }

    /**
     * Parameterized constructor
     * @param rideName Name of the ride
     * @param rideType Type of the ride
     * @param capacity Maximum capacity
     * @param operator Employee operating the ride
     */
    public Ride(String rideName, String rideType, int capacity, Employee operator) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.capacity = capacity;
        this.operator = operator;
    }

    // Getter and setter methods

    /**
     * Gets the ride name
     * @return The name of the ride
     */
    public String getRideName() {
        return rideName;
    }

    /**
     * Sets the ride name
     * @param rideName The new ride name to set
     */
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    /**
     * Gets the ride type
     * @return The type of ride
     */
    public String getRideType() {
        return rideType;
    }

    /**
     * Sets the ride type
     * @param rideType The new ride type to set
     */
    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    /**
     * Gets the ride capacity
     * @return The maximum capacity of the ride
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the ride capacity
     * @param capacity The new capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets the ride operator
     * @return The employee operating the ride
     */
    public Employee getOperator() {
        return operator;
    }

    /**
     * Sets the ride operator
     * @param operator The employee to assign as operator
     */
    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    /**
     * Returns a string representation of the ride
     * @return String containing ride details
     */
    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + '\'' +
                ", rideType='" + rideType + '\'' +
                ", capacity=" + capacity +
                ", operator=" + (operator != null ? operator.getName() : "None") +
                '}';
    }
}