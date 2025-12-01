import java.util.*;
import java.io.*;

/**
 * Ride class - Complete implementation with all parts
 */
public class Ride implements RideInterface {
    // Basic attributes
    private String rideName;
    private String rideType;
    private Employee operator;
    private int capacity;
    private boolean isOperational;

    // Collections and management
    private Queue<Visitor> waitingQueue;
    private LinkedList<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;

    // Constructors
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "General";
        this.operator = null;
        this.capacity = 0;
        this.isOperational = false;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;
        this.numOfCycles = 0;
    }

    public Ride(String rideName, String rideType, Employee operator, int capacity, boolean isOperational) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.capacity = capacity;
        this.isOperational = isOperational;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;
        this.numOfCycles = 0;
    }

    public Ride(String rideName, String rideType, Employee operator, int capacity, boolean isOperational, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.capacity = capacity;
        this.isOperational = isOperational;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    // Getters and Setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }

    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) {
        this.operator = operator;
        this.isOperational = (operator != null);
    }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public boolean isOperational() { return isOperational; }
    public void setOperational(boolean operational) { isOperational = operational; }

    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) {
        if (maxRider >= 1) this.maxRider = maxRider;
    }

    public int getNumOfCycles() { return numOfCycles; }
    public Queue<Visitor> getWaitingQueue() { return waitingQueue; }
    public int getQueueSize() { return waitingQueue.size(); }
    public LinkedList<Visitor> getRideHistory() { return rideHistory; }
    public int getHistorySize() { return rideHistory.size(); }

    // Part 3: Queue operations
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingQueue.offer(visitor);
        }
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        return waitingQueue.poll();
    }

    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue for " + rideName + " is empty");
            return;
        }

        System.out.println("=== Waiting Queue for " + rideName + " ===");
        int position = 1;
        for (Visitor visitor : waitingQueue) {
            System.out.println(position + ". " + visitor.getName());
            position++;
        }
    }

    // Part 4: History operations
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null && !rideHistory.contains(visitor)) {
            rideHistory.add(visitor);
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return visitor != null && rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history for " + rideName + " is empty");
            return;
        }

        System.out.println("=== Ride History for " + rideName + " ===");
        Iterator<Visitor> iterator = rideHistory.iterator();
        int position = 1;

        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(position + ". " + visitor.getName());
            position++;
        }
    }

    // Part 4B: Sorting operations
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, comparator);
        }
    }

    public void sortRideHistoryByName() {
        sortRideHistory(new VisitorComparator("name"));
    }

    // Part 5: Ride cycle operations
    @Override
    public void runOneCycle() {
        if (operator == null || waitingQueue.isEmpty()) {
            return;
        }

        int ridersThisCycle = Math.min(maxRider, waitingQueue.size());

        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = waitingQueue.poll();
            if (rider != null) {
                rideHistory.add(rider);
            }
        }

        numOfCycles++;
    }

    // Part 6: File export operations
    public void exportRideHistory(String filename) {
        if (rideHistory.isEmpty()) {
            return;
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(filename));

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
            }

        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    // Part 7: File import operations
    public void importRideHistory(String filename) {
        BufferedReader reader = null;
        int importedCount = 0;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                // Skip empty lines and comment lines
                if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                    continue;
                }

                try {
                    Visitor visitor = parseVisitorFromCsv(line);
                    if (visitor != null && !rideHistory.contains(visitor)) {
                        rideHistory.add(visitor);
                        importedCount++;
                    }
                } catch (Exception e) {
                    System.out.println("Warning: Skipping invalid line - " + line);
                }
            }

            System.out.println("Successfully imported " + importedCount + " visitors from " + filename);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Parses a Visitor object from a CSV line
     * Expected format: name,age,id,ticketNumber,membershipLevel,hasFastPass
     */
    private Visitor parseVisitorFromCsv(String csvLine) {
        // Handle quoted fields
        List<String> fields = parseCsvLine(csvLine);

        if (fields.size() < 6) {
            throw new IllegalArgumentException("Invalid CSV format: expected 6 fields");
        }

        try {
            String name = fields.get(0);
            int age = Integer.parseInt(fields.get(1));
            String id = fields.get(2);
            String ticketNumber = fields.get(3);
            String membershipLevel = fields.get(4);
            boolean hasFastPass = Boolean.parseBoolean(fields.get(5));

            return new Visitor(name, age, id, ticketNumber, membershipLevel, hasFastPass);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in CSV line");
        }
    }

    /**
     * Parses a CSV line, handling quoted fields
     */
    private List<String> parseCsvLine(String csvLine) {
        List<String> fields = new ArrayList<>();
        StringBuilder currentField = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < csvLine.length(); i++) {
            char c = csvLine.charAt(i);

            if (c == '"') {
                // Handle escaped quotes
                if (inQuotes && i + 1 < csvLine.length() && csvLine.charAt(i + 1) == '"') {
                    currentField.append('"');
                    i++; // Skip next quote
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                fields.add(currentField.toString());
                currentField = new StringBuilder();
            } else {
                currentField.append(c);
            }
        }

        // Add last field
        fields.add(currentField.toString());
        return fields;
    }

    /**
     * Escapes special characters for CSV
     */
    private String escapeCsv(String field) {
        if (field == null) return "";

        if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }

        return field;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + '\'' +
                ", rideType='" + rideType + '\'' +
                ", operator=" + (operator != null ? operator.getName() : "None") +
                ", maxRider=" + maxRider +
                ", numOfCycles=" + numOfCycles +
                ", queueSize=" + waitingQueue.size() +
                ", historySize=" + rideHistory.size() +
                '}';
    }
}