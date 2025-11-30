import java.util.LinkedList;
import java.util.Queue;

/**
 * Ride class representing theme park rides
 * Implements RideInterface to enforce specific ride behaviors
 * Contains ride attributes and manages ride operations including queue and history
 */
public class Ride implements RideInterface {
    // Ride instance variables
    private String rideName;    // Name of the ride
    private String rideType;    // Type of ride (e.g., Thrill, Water, Family)
    private int capacity;       // Maximum capacity of the ride
    private Employee operator;  // Employee assigned to operate the ride

    // Collections for managing visitors
    private Queue<Visitor> waitingQueue;    // Queue for visitors waiting to ride
    private LinkedList<Visitor> rideHistory; // List of visitors who have taken the ride

    /**
     * Default constructor
     * Initializes ride with default values and empty collections
     */
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Standard";
        this.capacity = 10;
        this.operator = null;  // No operator assigned by default
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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
     * Gets the waiting queue
     * @return The queue of waiting visitors
     */
    public Queue<Visitor> getWaitingQueue() {
        return waitingQueue;
    }

    /**
     * Gets the ride history
     * @return The list of visitors who have taken the ride
     */
    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    // RideInterface method implementations

    /**
     * Adds a visitor to the waiting queue
     * Implements FIFO (First-In-First-Out) principle
     * @param visitor The visitor to add to the queue
     */
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingQueue.add(visitor);
            System.out.println("Success: " + visitor.getName() + " added to queue for " + rideName);
        } else {
            System.out.println("Error: Cannot add null visitor to queue");
        }
    }

    /**
     * Removes a visitor from the waiting queue
     * Removes the first visitor in line (FIFO)
     */
    @Override
    public void removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor removedVisitor = waitingQueue.poll();
            System.out.println("Success: " + removedVisitor.getName() + " removed from queue");
        } else {
            System.out.println("Error: Queue is empty, cannot remove visitor");
        }
    }

    /**
     * Prints all visitors in the waiting queue
     * Shows the current waiting order
     */
    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting queue for " + rideName + " is empty");
            return;
        }

        System.out.println("Waiting queue for " + rideName + ":");
        int position = 1;
        for (Visitor visitor : waitingQueue) {
            System.out.println(position + ". " + visitor.getName() + " (ID: " + visitor.getVisitorId() + ")");
            position++;
        }
    }

    /**
     * Adds a visitor to the ride history
     * Called after a visitor has completed the ride
     * @param visitor The visitor to add to history
     */
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Success: " + visitor.getName() + " added to ride history");
        } else {
            System.out.println("Error: Cannot add null visitor to history");
        }
    }

    /**
     * Checks if a visitor is in the ride history
     * @param visitor The visitor to check
     * @return true if visitor is found in history, false otherwise
     */
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Cannot check null visitor");
            return false;
        }

        boolean found = rideHistory.contains(visitor);
        System.out.println("Visitor " + visitor.getName() + " in history: " + found);
        return found;
    }

    /**
     * Returns the number of visitors in ride history
     * @return Count of visitors who have taken the ride
     */
    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Number of visitors in history for " + rideName + ": " + count);
        return count;
    }

    /**
     * Prints all visitors in the ride history
     * Shows complete record of visitors who have experienced the ride
     */
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history for " + rideName + " is empty");
            return;
        }

        System.out.println("Ride history for " + rideName + ":");
        int position = 1;
        for (Visitor visitor : rideHistory) {
            System.out.println(position + ". " + visitor.getName() + " (ID: " + visitor.getVisitorId() + ")");
            position++;
        }
    }

    /**
     * Runs the ride for one cycle
     * Processes visitors from queue to ride history based on ride capacity
     * Implements the core ride operation logic
     */
    @Override
    public void runOneCycle() {
        // Check if operator is assigned
        if (operator == null) {
            System.out.println("Error: Cannot run " + rideName + " - no operator assigned");
            return;
        }

        // Check if there are visitors in queue
        if (waitingQueue.isEmpty()) {
            System.out.println("Error: Cannot run " + rideName + " - no visitors in queue");
            return;
        }

        // Calculate how many visitors can ride this cycle
        int ridersThisCycle = Math.min(capacity, waitingQueue.size());
        System.out.println("Running " + rideName + " for one cycle with " + ridersThisCycle + " visitors");

        // Process visitors from queue to history
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = waitingQueue.poll();
            if (rider != null) {
                addVisitorToHistory(rider);
                System.out.println("Visitor " + rider.getName() + " has taken the ride");
            }
        }

        System.out.println("Ride cycle completed successfully");
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
                ", waitingVisitors=" + waitingQueue.size() +
                ", historyVisitors=" + rideHistory.size() +
                '}';
    }
}