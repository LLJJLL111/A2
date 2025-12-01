import java.util.*;
import java.io.*;

/**
 * Ride class - Represents an amusement park ride
 * Part 5 Update: Implements ride cycle functionality
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

    // Part 5: Ride cycle management
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
        this.maxRider = 2; // Default max riders per cycle
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
        this.maxRider = 2; // Default max riders per cycle
        this.numOfCycles = 0;
    }

    /**
     * Constructor with maxRider parameter for Part 5
     * @param rideName The name of the ride
     * @param rideType The type of the ride
     * @param operator The employee operating the ride
     * @param capacity The capacity of the ride
     * @param isOperational Whether the ride is operational
     * @param maxRider Maximum number of riders per cycle
     */
    public Ride(String rideName, String rideType, Employee operator, int capacity, boolean isOperational, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.capacity = capacity;
        this.isOperational = isOperational;

        // Initialize collections
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
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

    // Part 5: Getter and setter for maxRider and numOfCycles
    public int getMaxRider() {
        return maxRider;
    }

    /**
     * Sets the maximum number of riders per cycle
     * @param maxRider Maximum riders (must be at least 1)
     */
    public void setMaxRider(int maxRider) {
        if (maxRider >= 1) {
            this.maxRider = maxRider;
            System.out.println("Max riders per cycle set to: " + maxRider + " for " + rideName);
        } else {
            System.out.println("❌ Error: maxRider must be at least 1");
        }
    }

    public int getNumOfCycles() {
        return numOfCycles;
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

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("📊 Number of visitors in ride history: " + count);
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("📭 Ride history for " + rideName + " is empty");
            return;
        }

        System.out.println("\n📖 === Ride History for " + rideName + " ===");
        System.out.println("Total visitors in history: " + rideHistory.size());
        System.out.println("Total cycles run: " + numOfCycles);
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

    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, comparator);
            System.out.println("✅ Ride history sorted successfully using custom comparator");
        } else {
            System.out.println("ℹ️ Not enough visitors to sort (minimum 2 required)");
        }
    }

    public void sortRideHistoryByName() {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, new VisitorComparator("name"));
            System.out.println("✅ Ride history sorted by name (alphabetical order)");
        } else {
            System.out.println("ℹ️ Not enough visitors to sort (minimum 2 required)");
        }
    }

    public void sortRideHistoryByAge() {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, new VisitorComparator("age"));
            System.out.println("✅ Ride history sorted by age (ascending order)");
        } else {
            System.out.println("ℹ️ Not enough visitors to sort (minimum 2 required)");
        }
    }

    public void sortRideHistoryByMembershipAndAge() {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, new VisitorComparator("membership_age"));
            System.out.println("✅ Ride history sorted by membership level and age");
        } else {
            System.out.println("ℹ️ Not enough visitors to sort (minimum 2 required)");
        }
    }

    // Part 5: Run One Cycle Implementation

    /**
     * Runs the ride for one cycle
     * - Checks if operator is assigned
     * - Checks if there are waiting visitors
     * - Removes visitors from queue based on maxRider
     * - Adds visitors to ride history
     * - Increases cycle count
     */
    @Override
    public void runOneCycle() {
        System.out.println("\n🎢 === Running " + rideName + " Cycle ===");

        // Check if operator is assigned
        if (operator == null) {
            System.out.println("❌ Error: Cannot run ride - no operator assigned to " + rideName);
            System.out.println("   Please assign an operator before running the ride.");
            return;
        }

        // Check if there are waiting visitors in the queue
        if (waitingQueue.isEmpty()) {
            System.out.println("❌ Error: Cannot run ride - no visitors in the waiting queue for " + rideName);
            System.out.println("   Please add visitors to the queue before running the ride.");
            return;
        }

        // Calculate how many visitors can ride this cycle
        int ridersThisCycle = Math.min(maxRider, waitingQueue.size());
        System.out.println("🚀 Starting cycle with " + ridersThisCycle + " visitors (max capacity: " + maxRider + ")");
        System.out.println("Operator: " + operator.getName());

        // Process visitors for this cycle
        List<Visitor> currentRiders = new ArrayList<>();

        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = waitingQueue.poll();
            if (rider != null) {
                currentRiders.add(rider);
                // Add to ride history
                rideHistory.add(rider);
                System.out.println("   ✅ " + rider.getName() + " is riding (Ticket: " + rider.getTicketNumber() + ")");
            }
        }

        // Increase cycle count
        numOfCycles++;

        // Print cycle summary
        System.out.println("\n📊 Cycle Summary:");
        System.out.println("   Riders this cycle: " + currentRiders.size());
        System.out.println("   Remaining in queue: " + waitingQueue.size());
        System.out.println("   Total cycles run: " + numOfCycles);
        System.out.println("   Total visitors in history: " + rideHistory.size());

        if (!currentRiders.isEmpty()) {
            System.out.println("   Riders: " + currentRiders.stream()
                    .map(Visitor::getName)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("None"));
        }

        System.out.println("✅ Cycle completed successfully!\n");
    }

    /**
     * Runs multiple cycles at once
     * @param numberOfCycles Number of cycles to run
     */
    public void runMultipleCycles(int numberOfCycles) {
        if (numberOfCycles <= 0) {
            System.out.println("❌ Error: Number of cycles must be positive");
            return;
        }

        System.out.println("\n🔄 === Running " + numberOfCycles + " Cycles for " + rideName + " ===");

        for (int i = 1; i <= numberOfCycles; i++) {
            System.out.println("\n--- Cycle " + i + " of " + numberOfCycles + " ---");
            runOneCycle();

            // Stop if queue becomes empty
            if (waitingQueue.isEmpty()) {
                System.out.println("⏹️ Stopping cycles - waiting queue is empty");
                break;
            }
        }
    }

    /**
     * Gets ride statistics
     * @return String containing ride statistics
     */
    public String getRideStatistics() {
        return String.format(
                "Ride Statistics for %s:\n" +
                        "  - Total cycles run: %d\n" +
                        "  - Visitors in history: %d\n" +
                        "  - Visitors waiting: %d\n" +
                        "  - Max riders per cycle: %d\n" +
                        "  - Operator: %s\n" +
                        "  - Operational: %s",
                rideName, numOfCycles, rideHistory.size(), waitingQueue.size(), maxRider,
                (operator != null ? operator.getName() : "None"),
                (isOperational ? "Yes" : "No")
        );
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
                ", maxRider=" + maxRider +
                ", numOfCycles=" + numOfCycles +
                ", queueSize=" + waitingQueue.size() +
                ", historySize=" + rideHistory.size() +
                '}';
    }
}