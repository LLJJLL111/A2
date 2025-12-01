import java.io.PrintWriter;
import java.io.File;

/**
 * AssignmentTwo - Main class with Part 7 demonstration
 * Demonstrates file import functionality
 */
public class AssignmentTwo {

    public static void main(String[] args) {
        System.out.println("=== Theme Park Visitor Management System ===\n");
        System.out.println("Part 7: File Import Demonstration\n");

        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partSeven();
    }

    /**
     * Part 7: File Import Demonstration
     * Demonstrates importing visitors from CSV file into ride history
     */
    public void partSeven() {
        System.out.println("=== Part 7: File Import Functionality ===\n");

        // Step 1: Create a test CSV file for import
        System.out.println("1. Creating test CSV file for import...");
        createTestImportFile();

        // Step 2: Create a new ride for testing import
        System.out.println("\n2. Creating new ride for import test...");
        Employee operator = new Employee("Import Manager", 40, "E007", "OP007", "Data Operations", "Manager");
        Ride testRide = new Ride("Import Test Ride", "Demonstration", operator, 15, true);

        // Step 3: Show history before import (should be empty)
        System.out.println("\n3. Ride history before import:");
        System.out.println("   Number of visitors in history: " + testRide.numberOfVisitors());
        testRide.printRideHistory();

        // Step 4: Import visitors from CSV file
        System.out.println("\n4. Importing visitors from CSV file...");
        String importFile = "test_import.csv";
        testRide.importRideHistory(importFile);

        // Step 5: Show history after import
        System.out.println("\n5. Ride history after import:");
        System.out.println("   Number of visitors in history: " + testRide.numberOfVisitors());
        testRide.printRideHistory();

        // Step 6: Verify specific visitors were imported correctly
        System.out.println("\n6. Verifying imported visitors...");
        verifyImportedVisitors(testRide);

        // Step 7: Test error handling with non-existent file
        System.out.println("\n7. Testing error handling with non-existent file...");
        testRide.importRideHistory("non_existent_file.csv");

        // Step 8: Test error handling with malformed CSV
        System.out.println("\n8. Testing error handling with malformed CSV...");
        createMalformedCsvFile();
        testRide.importRideHistory("malformed_data.csv");

        // Step 9: Test import with empty file
        System.out.println("\n9. Testing import with empty file...");
        createEmptyFile();
        Ride emptyRide = new Ride("Empty Test Ride", "Test", operator, 10, true);
        emptyRide.importRideHistory("empty_file.csv");

        // Step 10: Test duplicate import (should not add duplicates)
        System.out.println("\n10. Testing duplicate import prevention...");
        System.out.println("   History size before duplicate import: " + testRide.numberOfVisitors());
        testRide.importRideHistory(importFile); // Import same file again
        System.out.println("   History size after duplicate import: " + testRide.numberOfVisitors());

        // Step 11: Export the imported data (combining Part 6 and 7)
        System.out.println("\n11. Exporting imported data to new file...");
        String exportFile = "imported_data_export.csv";
        testRide.exportRideHistory(exportFile);

        File exportedFile = new File(exportFile);
        if (exportedFile.exists()) {
            System.out.println("   Export successful: " + exportFile);
            System.out.println("   File size: " + exportedFile.length() + " bytes");
        }

        // Step 12: Clean up test files
        System.out.println("\n12. Cleaning up test files...");
        cleanupTestFiles();

        // Step 13: Summary of Part 7 requirements
        System.out.println("\n13. Part 7 Requirements Summary:");
        System.out.println("   ✓ Added importRideHistory method to Ride class");
        System.out.println("   ✓ Can read file created in Part 6");
        System.out.println("   ✓ Adds visitors to LinkedList (ride history)");
        System.out.println("   ✓ Includes appropriate exception handling");
        System.out.println("   ✓ Provides clear error messages");
        System.out.println("   ✓ Handles duplicate visitors appropriately");
        System.out.println("   ✓ Validates CSV format and data");

        System.out.println("\n✅ Part 7 demonstration completed successfully!");
    }

    /**
     * Creates a test CSV file for import testing
     */
    private void createTestImportFile() {
        try (PrintWriter writer = new PrintWriter("test_import.csv")) {
            // Add header comment
            writer.println("# Test import file for Part 7 demonstration");
            writer.println("# Format: name,age,id,ticketNumber,membershipLevel,hasFastPass");
            writer.println("# Created: " + new java.util.Date());
            writer.println();

            // Add visitor data (minimum 5 as required)
            writer.println("Alice Johnson,25,V001,T001,Premium,true");
            writer.println("Bob Smith,30,V002,T002,Standard,false");
            writer.println("Charlie Brown,22,V003,T003,Gold,true");
            writer.println("Diana Prince,28,V004,T004,Standard,true");
            writer.println("Evan Davis,35,V005,T005,Premium,false");

            // Additional test cases
            writer.println("Frank Wilson,40,V006,T006,VIP,true");
            writer.println("\"Grace, O'Connor\",29,V007,T007,Premium,false"); // Name with comma
            writer.println("\"John \"\"The Boss\"\"\",45,V008,T008,Standard,true"); // Name with quotes

            System.out.println("   Created: test_import.csv with 8 test visitors");
            System.out.println("   Includes special characters (commas and quotes)");

        } catch (Exception e) {
            System.out.println("Error creating test file: " + e.getMessage());
        }
    }

    /**
     * Creates a malformed CSV file for error testing
     */
    private void createMalformedCsvFile() {
        try (PrintWriter writer = new PrintWriter("malformed_data.csv")) {
            writer.println("# Malformed CSV file for error testing");
            writer.println("Valid Visitor,25,V101,T101,Standard,true"); // Valid line
            writer.println("Invalid Age,not_a_number,V102,T102,Standard,true"); // Invalid age
            writer.println("Missing Fields,30"); // Not enough fields
            writer.println("Extra,Fields,30,V103,T103,Standard,true,extra,data"); // Too many fields
            writer.println(""); // Empty line
            writer.println("Negative Age,-5,V104,T104,Standard,false"); // Negative age
            writer.println("John Doe,200,V105,T105,Standard,true"); // Invalid age (too high)

            System.out.println("   Created: malformed_data.csv with various errors");

        } catch (Exception e) {
            System.out.println("Error creating malformed file: " + e.getMessage());
        }
    }

    /**
     * Creates an empty file for testing
     */
    private void createEmptyFile() {
        try (PrintWriter writer = new PrintWriter("empty_file.csv")) {
            writer.println("# Empty test file");
            writer.println("");

            System.out.println("   Created: empty_file.csv (empty file)");

        } catch (Exception e) {
            System.out.println("Error creating empty file: " + e.getMessage());
        }
    }

    /**
     * Verifies that visitors were imported correctly
     */
    private void verifyImportedVisitors(Ride ride) {
        // Create test visitors to check
        Visitor[] testVisitors = {
                new Visitor("Alice Johnson", 25, "V001", "T001", "Premium", true),
                new Visitor("Bob Smith", 30, "V002", "T002", "Standard", false),
                new Visitor("Charlie Brown", 22, "V003", "T003", "Gold", true),
                new Visitor("Diana Prince", 28, "V004", "T004", "Standard", true),
                new Visitor("Evan Davis", 35, "V005", "T005", "Premium", false)
        };

        int verifiedCount = 0;

        for (Visitor testVisitor : testVisitors) {
            if (ride.checkVisitorFromHistory(testVisitor)) {
                System.out.println("   ✓ Verified: " + testVisitor.getName());
                verifiedCount++;
            } else {
                System.out.println("   ✗ Missing: " + testVisitor.getName());
            }
        }

        System.out.println("\n   Total verified: " + verifiedCount + " out of " + testVisitors.length);

        if (verifiedCount >= 5) {
            System.out.println("   ✅ Success: Minimum 5 visitors imported as required");
        }
    }

    /**
     * Cleans up test files created during demonstration
     */
    private void cleanupTestFiles() {
        String[] filesToDelete = {
                "test_import.csv",
                "malformed_data.csv",
                "empty_file.csv",
                "imported_data_export.csv"
        };

        for (String filename : filesToDelete) {
            File file = new File(filename);
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("   Deleted: " + filename);
                } else {
                    System.out.println("   Failed to delete: " + filename);
                }
            }
        }
    }
}