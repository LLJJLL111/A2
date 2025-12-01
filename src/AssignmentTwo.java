import java.io.File;
import java.io.PrintWriter;
/**
 * AssignmentTwo - Main class with demonstration methods for all parts
 */
public class AssignmentTwo {

    public static void main(String[] args) {
        System.out.println("=== Theme Park Visitor Management System ===\n");

        AssignmentTwo assignment = new AssignmentTwo();

        // Run all demonstration methods
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree() {
        System.out.println("=== Part 3: Queue Demonstration ===\n");

        Employee operator = new Employee("John Operator", 30, "E001", "OP001", "Ride Operations", "Operator");
        Ride ride = new Ride("Roller Coaster", "Thrill", operator, 20, true, 2);

        // Create and add visitors
        for (int i = 1; i <= 5; i++) {
            Visitor visitor = new Visitor("Visitor" + i, 20 + i, "V00" + i, "T00" + i, "Standard", false);
            ride.addVisitorToQueue(visitor);
        }

        System.out.println("Initial queue:");
        ride.printQueue();

        System.out.println("\nRemoving one visitor...");
        ride.removeVisitorFromQueue();

        System.out.println("\nQueue after removal:");
        ride.printQueue();
    }

    public void partFourA() {
        System.out.println("\n\n=== Part 4A: Ride History Demonstration ===\n");

        Employee operator = new Employee("Sarah Manager", 32, "E002", "OP002", "Ride Operations", "Manager");
        Ride ride = new Ride("Water Ride", "Water", operator, 15, true);

        // Add visitors to history
        for (int i = 1; i <= 5; i++) {
            Visitor visitor = new Visitor("HistoryVisitor" + i, 25 + i, "H00" + i, "TH00" + i, "Premium", true);
            ride.addVisitorToHistory(visitor);
        }

        System.out.println("Number of visitors in history: " + ride.numberOfVisitors());

        Visitor testVisitor = new Visitor("HistoryVisitor1", 26, "H001", "TH001", "Premium", true);
        System.out.println("Check visitor in history: " + ride.checkVisitorFromHistory(testVisitor));

        System.out.println("\nRide history:");
        ride.printRideHistory();
    }

    public void partFourB() {
        System.out.println("\n\n=== Part 4B: Sorting Demonstration ===\n");

        Employee operator = new Employee("Tom Coordinator", 29, "E003", "OP003", "Ride Operations", "Coordinator");
        Ride ride = new Ride("Ferris Wheel", "Observation", operator, 30, true);

        // Add visitors with different attributes
        Visitor[] visitors = {
                new Visitor("Zoe", 25, "V101", "T101", "Standard", false),
                new Visitor("Adam", 30, "V102", "T102", "Premium", true),
                new Visitor("Bob", 22, "V103", "T103", "Gold", false),
                new Visitor("Charlie", 35, "V104", "T104", "Standard", true),
                new Visitor("Diana", 28, "V105", "T105", "Premium", false)
        };

        for (Visitor visitor : visitors) {
            ride.addVisitorToHistory(visitor);
        }

        System.out.println("Before sorting:");
        ride.printRideHistory();

        ride.sortRideHistoryByName();
        System.out.println("\nAfter sorting by name:");
        ride.printRideHistory();
    }

    public void partFive() {
        System.out.println("\n\n=== Part 5: Ride Cycle Demonstration ===\n");

        Employee operator = new Employee("Alex Rider", 28, "E005", "OP005", "Ride Operations", "Operator");
        Ride ride = new Ride("Space Ride", "Simulation", operator, 12, true, 3);

        // Add 10 visitors to queue
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor("Rider" + i, 20 + i, "R00" + i, "TR00" + i, "Standard", i % 2 == 0);
            ride.addVisitorToQueue(visitor);
        }

        System.out.println("Before running cycle:");
        ride.printQueue();

        ride.runOneCycle();

        System.out.println("\nAfter running cycle:");
        System.out.println("Queue size: " + ride.getQueueSize());
        System.out.println("History size: " + ride.getHistorySize());
        System.out.println("Cycles run: " + ride.getNumOfCycles());
    }

    public void partSix() {
        System.out.println("\n\n=== Part 6: File Export Demonstration ===\n");

        Employee operator = new Employee("Data Expert", 35, "E006", "OP006", "Data Operations", "Expert");
        Ride ride = new Ride("Data Ride", "Educational", operator, 25, true);

        // Add visitors for export
        for (int i = 1; i <= 5; i++) {
            Visitor visitor = new Visitor("ExportVisitor" + i, 20 + i, "EX00" + i, "TEX00" + i, "VIP", true);
            ride.addVisitorToHistory(visitor);
        }

        String exportFile = "ride_history_export.csv";
        ride.exportRideHistory(exportFile);

        File file = new File(exportFile);
        if (file.exists()) {
            System.out.println("Export successful: " + exportFile);
            System.out.println("File size: " + file.length() + " bytes");
        }
    }

    public void partSeven() {
        System.out.println("\n\n=== Part 7: File Import Demonstration ===\n");

        // Step 1: Create a test CSV file
        createTestCsvFile();

        // Step 2: Import the file
        Employee operator = new Employee("Import Manager", 40, "E007", "OP007", "Data Operations", "Manager");
        Ride ride = new Ride("Import Ride", "Test", operator, 10, true);

        String importFile = "test_import.csv";
        System.out.println("Importing from file: " + importFile);

        // Check history before import
        System.out.println("History size before import: " + ride.getHistorySize());

        // Import the file
        ride.importRideHistory(importFile);

        // Check history after import
        System.out.println("History size after import: " + ride.getHistorySize());

        // Verify imported data
        System.out.println("\nImported visitors:");
        ride.printRideHistory();

        // Test with non-existent file
        System.out.println("\nTesting with non-existent file:");
        ride.importRideHistory("non_existent_file.csv");

        // Test with malformed CSV
        System.out.println("\nTesting with malformed CSV:");
        ride.importRideHistory("malformed_test.csv");
        createMalformedCsvFile();
        ride.importRideHistory("malformed_test.csv");

        // Clean up test files
        cleanUpTestFiles();
    }

    private void createTestCsvFile() {
        try (PrintWriter writer = new PrintWriter("test_import.csv")) {
            writer.println("# Test import file for Part 7");
            writer.println("# Format: name,age,id,ticketNumber,membershipLevel,hasFastPass");
            writer.println("Alice Johnson,25,V201,T201,Premium,true");
            writer.println("Bob Smith,30,V202,T202,Standard,false");
            writer.println("Charlie Brown,22,V203,T203,Gold,true");
            writer.println("Diana Prince,28,V204,T204,Standard,true");
            writer.println("Evan Davis,35,V205,T205,Premium,false");
            writer.println("\"Frank, Jr.\",40,V206,T206,VIP,true"); // Name with comma
            writer.println("\"John \"\"The Boss\"\"\",45,V207,T207,Premium,true"); // Name with quotes
            System.out.println("Created test CSV file: test_import.csv");
        } catch (Exception e) {
            System.out.println("Error creating test file: " + e.getMessage());
        }
    }

    private void createMalformedCsvFile() {
        try (PrintWriter writer = new PrintWriter("malformed_test.csv")) {
            writer.println("Valid Visitor,25,V301,T301,Standard,true");
            writer.println("Invalid Age,not_a_number,V302,T302,Standard,true");
            writer.println("Missing Fields,30"); // Not enough fields
            writer.println(""); // Empty line
            writer.println("# Comment line");
            System.out.println("Created malformed CSV file: malformed_test.csv");
        } catch (Exception e) {
            System.out.println("Error creating malformed file: " + e.getMessage());
        }
    }

    private void cleanUpTestFiles() {
        String[] files = {"test_import.csv", "malformed_test.csv", "ride_history_export.csv"};
        for (String file : files) {
            File f = new File(file);
            if (f.exists() && f.delete()) {
                System.out.println("Cleaned up: " + file);
            }
        }
    }
}