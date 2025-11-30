import java.util.*;
import java.io.*;

/**
 * Ride class - Represents an amusement park ride
 * Part 4 Update: Implements ride history and sorting functionality
 */
public class Ride implements RideInterface {
    // Basic ride attributes
    private String rideName;
    private String rideType;
    private Employee operator;
    private int capacity;
    private boolean isOperational;

    // Part 3: Queue for managing waiting visitors
    private Queue<Visitor> waitingQueue;

    // Part 4: LinkedList for ride history
    private LinkedList<Visitor> rideHistory;

    // Part 5: Ride cycle management (to be implemented)
    private int maxRider;
    private int numOfCycles;

    /**
     * Default constructor - initializes all fields with default values
     */
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "General";
        this.operator = null;
        this.capacity = 0;
        this.isOperational = false;

        // Initialize collections
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;
        this.numOfCycles = 0;
    }

    /**
     * Parameterized constructor - initializes with provided values
     * @param rideName The name of the ride
     * @param rideType The type of the ride
     * @param operator The employee operating the ride
     * @param capacity The capacity of the ride
     * @param isOperational Whether the ride is operational
     */
    public Ride(String rideName, String rideType, Employee operator, int capacity, boolean isOperational) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.capacity = capacity;
        this.isOperational = isOperational;

        // Initialize collections
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;
        this.numOfCycles = 0;
    }

    // Getter and setter methods
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
        if (operator != null) {
            this.isOperational = true;
            System.out.println("Operator " + operator.getName() + " assigned to " + rideName);
        } else {
            this.isOperational = false;
            System.out.println("No operator assigned to " + rideName + " - Ride is not operational");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOperational() {
        return isOperational;
    }

    public void setOperational(boolean operational) {
        isOperational = operational;
    }

    public Queue<Visitor> getWaitingQueue() {
        return waitingQueue;
    }

    public int getQueueSize() {
        return waitingQueue.size();
    }

    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    public int getHistorySize() {
        return rideHistory.size();
    }

    // Part 3: Queue interface method implementations

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            boolean added = waitingQueue.offer(visitor);
            if (added) {
                System.out.println("✅ Success: " + visitor.getName() + " added to queue for " + rideName);
            } else {
                System.out.println("❌ Error: Failed to add " + visitor.getName() + " to queue");
            }
        } else {
            System.out.println("❌ Error: Cannot add null visitor to queue");
        }
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor removedVisitor = waitingQueue.poll();
            System.out.println("✅ Success: " + removedVisitor.getName() + " removed from queue for " + rideName);
            return removedVisitor;
        } else {
            System.out.println("❌ Error: Queue is empty, cannot remove visitor from " + rideName);
            return null;
        }
    }

    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("📭 Queue for " + rideName + " is empty");
            return;
        }

        System.out.println("\n📋 === Waiting Queue for " + rideName + " ===");
        System.out.println("Total visitors waiting: " + waitingQueue.size());
        System.out.println("----------------------------------------");

        int position = 1;
        for (Visitor visitor : waitingQueue) {
            System.out.println(position + ". " + visitor.getName() +
                    " (Age: " + visitor.getAge() +
                    ", Ticket: " + visitor.getTicketNumber() +
                    ", Membership: " + visitor.getMembershipLevel() + ")");
            position++;
        }
        System.out.println("========================================\n");
    }

    // Part 4A: Ride history implementation

    /**
     * Adds a visitor to the ride history LinkedList
     * @param visitor The visitor to add to history
     */
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            if (!rideHistory.contains(visitor)) {
                rideHistory.add(visitor);
                System.out.println("✅ Success: " + visitor.getName() + " added to ride history of " + rideName);
            } else {
                System.out.println("⚠️ Warning: " + visitor.getName() + " is already in ride history");
            }
        } else {
            System.out.println("❌ Error: Cannot add null visitor to history");
        }
    }

    /**
     * Checks if a visitor exists in the ride history
     * @param visitor The visitor to check
     * @return true if visitor is in history, false otherwise
     */
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor != null) {
            boolean found = rideHistory.contains(visitor);
            String result = found ? "FOUND" : "NOT FOUND";
            System.out.println("🔍 Check result: " + visitor.getName() + " is " + result + " in ride history");
            return found;
        } else {
            System.out.println("❌ Error: Cannot check null visitor in history");
            return false;
        }
    }

    /**
     * Returns the number of visitors in ride history
     * @return Number of visitors in history
     */
    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("📊 Number of visitors in ride history: " + count);
        return count;
    }

    /**
     * Prints all visitors in ride history using Iterator
     * Required: Must use Iterator for full marks
     */
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("📭 Ride history for " + rideName + " is empty");
            return;
        }

        System.out.println("\n📖 === Ride History for " + rideName + " ===");
        System.out.println("Total visitors in history: " + rideHistory.size());
        System.out.println("----------------------------------------");

        // Using Iterator as required by assignment
        Iterator<Visitor> iterator = rideHistory.iterator();
        int position = 1;

        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(position + ". " + visitor.getName() +
                    " (Age: " + visitor.getAge() +
                    ", Ticket: " + visitor.getTicketNumber() +
                    ", Membership: " + visitor.getMembershipLevel() +
                    ", FastPass: " + (visitor.hasFastPass() ? "Yes" : "No") + ")");
            position++;
        }
        System.out.println("========================================\n");
    }

    // Part 4B: Sorting implementation

    /**
     * Sorts the ride history using provided Comparator
     * @param comparator The comparator to use for sorting
     */
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, comparator);
            System.out.println("✅ Ride history sorted successfully using custom comparator");
        } else {
            System.out.println("ℹ️ Not enough visitors to sort (minimum 2 required)");
        }
    }

    /**
     * Sorts the ride history by name (alphabetical order)
     */
    public void sortRideHistoryByName() {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, new VisitorComparator("name"));
            System.out.println("✅ Ride history sorted by name (alphabetical order)");
        } else {
            System.out.println("ℹ️ Not enough visitors to sort (minimum 2 required)");
        }
    }

    /**
     * Sorts the ride history by age (ascending order)
     */
    public void sortRideHistoryByAge() {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, new VisitorComparator("age"));
            System.out.println("✅ Ride history sorted by age (ascending order)");
        } else {
            System.out.println("ℹ️ Not enough visitors to sort (minimum 2 required)");
        }
    }

    /**
     * Sorts the ride history by membership level and age
     */
    public void sortRideHistoryByMembershipAndAge() {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, new VisitorComparator("membership_age"));
            System.out.println("✅ Ride history sorted by membership level and age");
        } else {
            System.out.println("ℹ️ Not enough visitors to sort (minimum 2 required)");
        }
    }

    // Part 5 method - To be implemented in Part 5
    @Override
    public void runOneCycle() {
        System.out.println("runOneCycle method - To be implemented in Part 5");
    }

    // Part 6 & 7 methods - To be implemented
    public void exportRideHistory(String filename) {
        System.out.println("exportRideHistory method - To be implemented in Part 6");
    }

    public void importRideHistory(String filename) {
        System.out.println("importRideHistory method - To be implemented in Part 7");
    }

    /**
     * Returns string representation of the ride
     * @return String containing ride details
     */
    @Override
    public String toString() {
        String operatorInfo = (operator != null) ? operator.getName() : "No operator";
        return "Ride{" +
                "rideName='" + rideName + '\'' +
                ", rideType='" + rideType + '\'' +
                ", operator=" + operatorInfo +
                ", capacity=" + capacity +
                ", isOperational=" + isOperational +
                ", queueSize=" + waitingQueue.size() +
                ", historySize=" + rideHistory.size() +
                '}';
    }
}