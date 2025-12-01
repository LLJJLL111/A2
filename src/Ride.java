import java.util.*;
import java.io.*;

/**
 * Ride class - Represents an amusement park ride
 * Part 6 Update: Implements file export functionality for ride history
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

    /**
     * Constructor with maxRider parameter
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

    public int getMaxRider() {
        return maxRider;
    }

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

    @Override
    public void runOneCycle() {
        System.out.println("\n🎢 === Running " + rideName + " Cycle ===");

        if (operator == null) {
            System.out.println("❌ Error: Cannot run ride - no operator assigned to " + rideName);
            return;
        }

        if (waitingQueue.isEmpty()) {
            System.out.println("❌ Error: Cannot run ride - no visitors in the waiting queue for " + rideName);
            return;
        }

        int ridersThisCycle = Math.min(maxRider, waitingQueue.size());
        System.out.println("🚀 Starting cycle with " + ridersThisCycle + " visitors (max capacity: " + maxRider + ")");

        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = waitingQueue.poll();
            if (rider != null) {
                rideHistory.add(rider);
                System.out.println("   ✅ " + rider.getName() + " is riding (Ticket: " + rider.getTicketNumber() + ")");
            }
        }

        numOfCycles++;

        System.out.println("\n📊 Cycle Summary:");
        System.out.println("   Riders this cycle: " + ridersThisCycle);
        System.out.println("   Remaining in queue: " + waitingQueue.size());
        System.out.println("   Total cycles run: " + numOfCycles);
        System.out.println("   Total visitors in history: " + rideHistory.size());
        System.out.println("✅ Cycle completed successfully!\n");
    }

    // Part 6: File Export Implementation

    /**
     * Exports ride history to a CSV file
     * Writes details of all visitors in the ride history to a file
     * Each visitor's details are written on their own line in CSV format
     * @param filename The name of the file to write to
     */
    public void exportRideHistory(String filename) {
        System.out.println("\n💾 === Exporting Ride History to File ===");
        System.out.println("File: " + filename);
        System.out.println("Ride: " + rideName);

        // Check if there is any history to export
        if (rideHistory.isEmpty()) {
            System.out.println("❌ Error: Cannot export - ride history is empty for " + rideName);
            return;
        }

        PrintWriter writer = null;
        try {
            // Create PrintWriter with FileWriter for writing to file
            writer = new PrintWriter(new FileWriter(filename));

            int exportedCount = 0;

            // Write each visitor to the file in CSV format
            for (Visitor visitor : rideHistory) {
                // Format: name,age,id,ticketNumber,membershipLevel,hasFastPass
                String line = String.format("%s,%d,%s,%s,%s,%b",
                        escapeCsv(visitor.getName()),
                        visitor.getAge(),
                        escapeCsv(visitor.getId()),
                        escapeCsv(visitor.getTicketNumber()),
                        escapeCsv(visitor.getMembershipLevel()),
                        visitor.hasFastPass()
                );

                writer.println(line);
                exportedCount++;
            }

            System.out.println("✅ Success: Exported " + exportedCount + " visitors to " + filename);
            System.out.println("   File location: " + new File(filename).getAbsolutePath());

        } catch (IOException e) {
            System.out.println("❌ Error: Failed to export ride history to " + filename);
            System.out.println("   Error details: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("❌ Error: Unexpected error during export");
            System.out.println("   Error details: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Always close the writer in finally block
            if (writer != null) {
                writer.close();
                System.out.println("   File writer closed successfully");
            }
        }
    }

    /**
     * Helper method to escape CSV special characters
     * @param field The field to escape
     * @return Escaped field suitable for CSV
     */
    private String escapeCsv(String field) {
        if (field == null) {
            return "";
        }

        // If field contains commas, quotes, or newlines, wrap in quotes and escape internal quotes
        if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }

        return field;
    }

    /**
     * Exports ride history with additional header information
     * @param filename The name of the file to write to
     */
    public void exportRideHistoryWithHeader(String filename) {
        System.out.println("\n💾 === Exporting Ride History with Header ===");
        System.out.println("File: " + filename);

        if (rideHistory.isEmpty()) {
            System.out.println("❌ Error: Cannot export - ride history is empty");
            return;
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(filename));

            // Write header information
            writer.println("# Ride History Export");
            writer.println("# Ride: " + rideName);
            writer.println("# Ride Type: " + rideType);
            writer.println("# Export Date: " + new Date());
            writer.println("# Total Visitors: " + rideHistory.size());
            writer.println("# Total Cycles: " + numOfCycles);
            writer.println("# Columns: name,age,id,ticketNumber,membershipLevel,hasFastPass");
            writer.println("# CSV Format");

            int exportedCount = 0;

            // Write data rows
            for (Visitor visitor : rideHistory) {
                String line = String.format("%s,%d,%s,%s,%s,%b",
                        escapeCsv(visitor.getName()),
                        visitor.getAge(),
                        escapeCsv(visitor.getId()),
                        escapeCsv(visitor.getTicketNumber()),
                        escapeCsv(visitor.getMembershipLevel()),
                        visitor.hasFastPass()
                );

                writer.println(line);
                exportedCount++;
            }

            System.out.println("✅ Success: Exported " + exportedCount + " visitors with header to " + filename);

        } catch (IOException e) {
            System.out.println("❌ Error: Failed to export ride history with header");
            System.out.println("   Error details: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * Exports ride statistics to a separate file
     * @param filename The name of the file to write statistics to
     */
    public void exportRideStatistics(String filename) {
        System.out.println("\n📊 === Exporting Ride Statistics ===");

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(filename));

            // Write comprehensive ride statistics
            writer.println("Ride Statistics Report");
            writer.println("======================");
            writer.println("Ride Name: " + rideName);
            writer.println("Ride Type: " + rideType);
            writer.println("Operator: " + (operator != null ? operator.getName() : "None"));
            writer.println("Capacity: " + capacity);
            writer.println("Max Riders Per Cycle: " + maxRider);
            writer.println("Operational: " + (isOperational ? "Yes" : "No"));
            writer.println("Total Cycles Run: " + numOfCycles);
            writer.println("Visitors in History: " + rideHistory.size());
            writer.println("Visitors Waiting: " + waitingQueue.size());
            writer.println("Export Date: " + new Date());
            writer.println();

            // Write visitor summary
            writer.println("Visitor Summary:");
            writer.println("----------------");
            for (Visitor visitor : rideHistory) {
                writer.println("- " + visitor.getName() +
                        " (Age: " + visitor.getAge() +
                        ", Membership: " + visitor.getMembershipLevel() +
                        ", FastPass: " + (visitor.hasFastPass() ? "Yes" : "No") + ")");
            }

            System.out.println("✅ Success: Exported ride statistics to " + filename);

        } catch (IOException e) {
            System.out.println("❌ Error: Failed to export ride statistics");
            System.out.println("   Error details: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    // Part 7 method - To be implemented in Part 7
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