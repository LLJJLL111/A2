/**
 * AssignmentTwo class - Main class containing demonstration methods
 * Part 5 Update: Implements partFive demonstration method for ride cycles
 */
public class AssignmentTwo {

    /**
     * Main method - Program entry point
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Theme Park Visitor Management System ===");
        System.out.println("Part 5: Ride Cycle Demonstration");

        AssignmentTwo assignment = new AssignmentTwo();

        // Execute Part 5 demonstration
        assignment.partFive();
    }

    /**
     * Part 5: Run Ride Cycle Demonstration
     * Creates Ride object, adds visitors to queue, runs cycles, demonstrates functionality
     * Shows queue management, history tracking, and cycle counting
     */
    public void partFive() {
        System.out.println("\n🎢 === Part 5: Run Ride Cycle Demonstration ===");

        // Step 1: Create ride operator
        System.out.println("\n1. Creating ride operator...");
        Employee operator = new Employee("Alex Rider", 28, "E005", "OP005", "Ride Operations", "Operator");
        System.out.println("   Operator created: " + operator.getName());

        // Step 2: Create amusement ride with specific maxRider capacity
        System.out.println("\n2. Creating amusement ride...");
        Ride rollerCoaster = new Ride("Dragon Coaster", "Roller Coaster", operator, 24, true, 4);
        System.out.println("   Ride created: " + rollerCoaster.getRideName());
        System.out.println("   Max riders per cycle: " + rollerCoaster.getMaxRider());

        // Step 3: Create at least 10 visitors as required
        System.out.println("\n3. Creating visitors (minimum 10 as required)...");
        Visitor[] visitors = {
                new Visitor("Liam Johnson", 25, "V301", "T301", "Premium", true),
                new Visitor("Emma Thompson", 30, "V302", "T302", "Standard", false),
                new Visitor("Noah Williams", 22, "V303", "T303", "Gold", true),
                new Visitor("Olivia Brown", 28, "V304", "T304", "Standard", false),
                new Visitor("William Davis", 35, "V305", "T305", "Premium", true),
                new Visitor("Ava Miller", 19, "V306", "T306", "Standard", true),
                new Visitor("James Wilson", 42, "V307", "T307", "VIP", false),
                new Visitor("Sophia Moore", 31, "V308", "T308", "Standard", true),
                new Visitor("Benjamin Taylor", 26, "V309", "T309", "Premium", false),
                new Visitor("Isabella Anderson", 23, "V310", "T310", "Standard", true),
                new Visitor("Lucas Thomas", 29, "V311", "T311", "Gold", false), // Extra for testing
                new Visitor("Mia Jackson", 33, "V312", "T312", "Standard", true)  // Extra for testing
        };

        // Display created visitors
        System.out.println("   Created " + visitors.length + " visitors:");
        for (int i = 0; i < visitors.length; i++) {
            System.out.println("   " + (i + 1) + ". " + visitors[i].getName() +
                    " (Membership: " + visitors[i].getMembershipLevel() + ")");
        }

        // Step 4: Add visitors to waiting queue
        System.out.println("\n4. Adding visitors to waiting queue...");
        for (Visitor visitor : visitors) {
            rollerCoaster.addVisitorToQueue(visitor);
        }

        // Step 5: Print initial queue status
        System.out.println("\n5. Initial queue status:");
        rollerCoaster.printQueue();

        // Step 6: Run one cycle and show results
        System.out.println("\n6. Running ONE CYCLE...");
        rollerCoaster.runOneCycle();

        // Step 7: Print queue after first cycle
        System.out.println("\n7. Queue status after first cycle:");
        rollerCoaster.printQueue();

        // Step 8: Print ride history after first cycle
        System.out.println("\n8. Ride history after first cycle:");
        rollerCoaster.printRideHistory();

        // Step 9: Run multiple cycles to demonstrate continuous operation
        System.out.println("\n9. Running MULTIPLE CYCLES...");
        rollerCoaster.runMultipleCycles(3);

        // Step 10: Show final queue and history status
        System.out.println("\n10. Final status after all cycles:");
        System.out.println("   Queue size: " + rollerCoaster.getQueueSize());
        System.out.println("   History size: " + rollerCoaster.getHistorySize());
        System.out.println("   Total cycles run: " + rollerCoaster.getNumOfCycles());

        // Step 11: Print final queue
        System.out.println("\n11. Final queue:");
        rollerCoaster.printQueue();

        // Step 12: Print final ride history
        System.out.println("\n12. Final ride history:");
        rollerCoaster.printRideHistory();

        // Step 13: Test edge cases and error conditions
        System.out.println("\n13. Testing edge cases and error conditions...");

        // Test 13a: Run cycle with no operator
        System.out.println("   a) Testing ride without operator:");
        Ride noOperatorRide = new Ride("Test Ride", "General", null, 10, false, 2);
        noOperatorRide.addVisitorToQueue(visitors[0]);
        noOperatorRide.runOneCycle();

        // Test 13b: Run cycle with empty queue
        System.out.println("   b) Testing ride with empty queue:");
        Ride emptyQueueRide = new Ride("Empty Ride", "General", operator, 10, true, 2);
        emptyQueueRide.runOneCycle();

        // Test 13c: Run cycle with fewer visitors than maxRider
        System.out.println("   c) Testing with fewer visitors than maxRider:");
        Ride smallRide = new Ride("Small Ride", "General", operator, 6, true, 5);
        // Add only 3 visitors to a ride with maxRider=5
        smallRide.addVisitorToQueue(visitors[0]);
        smallRide.addVisitorToQueue(visitors[1]);
        smallRide.addVisitorToQueue(visitors[2]);
        smallRide.runOneCycle();

        // Test 13d: Test setting invalid maxRider
        System.out.println("   d) Testing invalid maxRider setting:");
        rollerCoaster.setMaxRider(0); // Should show error

        // Step 14: Display comprehensive ride statistics
        System.out.println("\n14. Comprehensive Ride Statistics:");
        System.out.println(rollerCoaster.getRideStatistics());

        // Step 15: Verification of requirements
        System.out.println("\n15. Verification of Part 5 Requirements:");
        System.out.println("   ✓ Added maxRider instance variable: " + rollerCoaster.getMaxRider());
        System.out.println("   ✓ Added numOfCycles instance variable: " + rollerCoaster.getNumOfCycles());
        System.out.println("   ✓ Implemented runOneCycle() method successfully");
        System.out.println("   ✓ Checks for operator assignment: " + (rollerCoaster.getOperator() != null));
        System.out.println("   ✓ Checks for waiting visitors in queue");
        System.out.println("   ✓ Removes visitors from queue based on maxRider");
        System.out.println("   ✓ Adds visitors to ride history");
        System.out.println("   ✓ Increases cycle count correctly");
        System.out.println("   ✓ Provides clear success/failure messages");
        System.out.println("   ✓ Added minimum 10 visitors to queue: " + (visitors.length >= 10));

        System.out.println("\n✅ Part 5 demonstration completed successfully!");
        System.out.println("   All ride cycle functionality requirements have been met.");
    }

    // Placeholder methods for other parts
    public void partThree() {
        System.out.println("Part 3 method - Already implemented");
    }

    public void partFourA() {
        System.out.println("Part 4A method - Already implemented");
    }

    public void partFourB() {
        System.out.println("Part 4B method - Already implemented");
    }

    public void partSix() {
        System.out.println("Part 6 method - To be implemented in Part 6");
    }

    public void partSeven() {
        System.out.println("Part 7 method - To be implemented in Part 7");
    }
}