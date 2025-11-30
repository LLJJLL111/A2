import java.util.LinkedList;
import java.util.Queue;

/**
 * Ride class - Represents an amusement park ride
 * Implements RideInterface for visitor management operations
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

    // For future parts (placeholders)
    private LinkedList<Visitor> rideHistory;
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

    // Part 3: Queue interface method implementations

    /**
     * Adds a visitor to the waiting queue
     * @param visitor The visitor to add to the queue
     */
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            boolean added = waitingQueue.offer(visitor);
            if (added) {
                System.out.println("✅ Success: " + visitor.getName() + " added to queue for " + rideName);
                System.out.println("   Current queue size: " + waitingQueue.size());
            } else {
                System.out.println("❌ Error: Failed to add " + visitor.getName() + " to queue");
            }
        } else {
            System.out.println("❌ Error: Cannot add null visitor to queue");
        }
    }

    /**
     * Removes and returns the next visitor from the waiting queue
     * @return The removed visitor, or null if queue is empty
     */
    @Override
    public Visitor removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor removedVisitor = waitingQueue.poll();
            System.out.println("✅ Success: " + removedVisitor.getName() + " removed from queue for " + rideName);
            System.out.println("   Remaining queue size: " + waitingQueue.size());
            return removedVisitor;
        } else {
            System.out.println("❌ Error: Queue is empty, cannot remove visitor from " + rideName);
            return null;
        }
    }

    /**
     * Views but does not remove the next visitor in queue
     * @return The next visitor in queue, or null if queue is empty
     */
    public Visitor peekVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor nextVisitor = waitingQueue.peek();
            System.out.println("Next in queue: " + nextVisitor.getName());
            return nextVisitor;
        } else {
            System.out.println("Queue is empty, no visitor to peek");
            return null;
        }
    }

    /**
     * Prints all visitors currently in the waiting queue
     */
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

    /**
     * Checks if the waiting queue is empty
     * @return true if queue is empty, false otherwise
     */
    public boolean isQueueEmpty() {
        return waitingQueue.isEmpty();
    }

    /**
     * Clears all visitors from the waiting queue
     */
    public void clearQueue() {
        int previousSize = waitingQueue.size();
        waitingQueue.clear();
        System.out.println("Queue for " + rideName + " has been cleared. Removed " + previousSize + " visitors.");
    }

    // Placeholder methods for future parts
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        System.out.println("addVisitorToHistory method - To be implemented in Part 4");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        System.out.println("checkVisitorFromHistory method - To be implemented in Part 4");
        return false;
    }

    @Override
    public int numberOfVisitors() {
        System.out.println("numberOfVisitors method - To be implemented in Part 4");
        return 0;
    }

    @Override
    public void printRideHistory() {
        System.out.println("printRideHistory method - To be implemented in Part 4");
    }

    @Override
    public void runOneCycle() {
        System.out.println("runOneCycle method - To be implemented in Part 5");
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
                '}';
    }
}