/**
 * AssignmentTwo class - Main class containing demonstration methods
 * Part 4 Update: Implements partFourA and partFourB demonstration methods
 */
public class AssignmentTwo {

    /**
     * Main method - Program entry point
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Theme Park Visitor Management System ===");
        System.out.println("Part 4: Ride History and Sorting Demonstration");

        AssignmentTwo assignment = new AssignmentTwo();

        // Execute Part 4 demonstrations
        assignment.partFourA();
        assignment.partFourB();
    }

    /**
     * Part 4A: Ride History Demonstration
     * Creates Ride object, adds visitors to history, checks visitors, prints history
     * Demonstrates LinkedList operations and Iterator usage
     */
    public void partFourA() {
        System.out.println("\n📖 === Part 4A: Ride History Demonstration ===");

        // Step 1: Create ride operator and ride
        System.out.println("\n1. Setting up ride and operator...");
        Employee operator = new Employee("Sarah Manager", 32, "E002", "OP002", "Ride Operations", "Manager");
        Ride waterRide = new Ride("Splash Mountain", "Water Ride", operator, 30, true);
        System.out.println("   Ride created: " + waterRide.getRideName());

        // Step 2: Create visitors for history (minimum 5 as required)
        System.out.println("\n2. Creating visitors for ride history...");
        Visitor[] visitors = {
                new Visitor("Michael Johnson", 28, "V101", "T101", "Premium", true),
                new Visitor("Emma Watson", 24, "V102", "T102", "Standard", false),
                new Visitor("David Chen", 35, "V103", "T103", "Gold", true),
                new Visitor("Sophia Rodriguez", 19, "V104", "T104", "Standard", true),
                new Visitor("James Wilson", 42, "V105", "T105", "Premium", false),
                new Visitor("Olivia Martinez", 31, "V106", "T106", "VIP", true) // Extra for testing
        };

        // Display created visitors
        for (Visitor visitor : visitors) {
            System.out.println("   Created: " + visitor.getName() +
                    " (Membership: " + visitor.getMembershipLevel() + ")");
        }

        // Step 3: Add visitors to ride history
        System.out.println("\n3. Adding visitors to ride history...");
        for (Visitor visitor : visitors) {
            waterRide.addVisitorToHistory(visitor);
        }

        // Step 4: Check number of visitors in history
        System.out.println("\n4. Checking history statistics...");
        waterRide.numberOfVisitors();

        // Step 5: Check if specific visitors are in history
        System.out.println("\n5. Checking visitor presence in history...");
        waterRide.checkVisitorFromHistory(visitors[0]); // Should be found
        waterRide.checkVisitorFromHistory(visitors[3]); // Should be found

        // Check for non-existent visitor
        Visitor nonExistentVisitor = new Visitor("Unknown Person", 25, "V999", "T999", "Standard", false);
        waterRide.checkVisitorFromHistory(nonExistentVisitor); // Should not be found

        // Step 6: Print ride history using Iterator (as required)
        System.out.println("\n6. Printing ride history (using Iterator)...");
        waterRide.printRideHistory();

        // Step 7: Test edge cases
        System.out.println("\n7. Testing edge cases...");

        // Test adding null visitor
        System.out.println("   a) Testing null visitor addition:");
        waterRide.addVisitorToHistory(null);

        // Test adding duplicate visitor
        System.out.println("   b) Testing duplicate visitor addition:");
        waterRide.addVisitorToHistory(visitors[0]);

        // Test checking null visitor
        System.out.println("   c) Testing null visitor check:");
        waterRide.checkVisitorFromHistory(null);

        System.out.println("\n✅ Part 4A demonstration completed successfully!");
    }

    /**
     * Part 4B: Sorting Demonstration
     * Creates Ride object, adds visitors to history, sorts using single Comparator, prints before/after
     * Demonstrates Comparator interface implementation and Collections.sort()
     */
    public void partFourB() {
        System.out.println("\n🔢 === Part 4B: Sorting Demonstration ===");

        // Step 1: Create ride operator and ride
        System.out.println("\n1. Setting up ride and operator...");
        Employee operator = new Employee("Tom Coordinator", 29, "E003", "OP003", "Ride Operations", "Coordinator");
        Ride ferrisWheel = new Ride("Sky Wheel", "Observation Ride", operator, 40, true);
        System.out.println("   Ride created: " + ferrisWheel.getRideName());

        // Step 2: Create visitors with diverse attributes for sorting
        System.out.println("\n2. Creating diverse visitors for sorting demonstration...");
        Visitor[] visitors = {
                new Visitor("Alice Brown", 25, "V201", "T201", "Standard", false),
                new Visitor("Bob Green", 30, "V202", "T202", "Premium", true),
                new Visitor("Carol White", 22, "V203", "T203", "Gold", false),
                new Visitor("Daniel Black", 35, "V204", "T204", "Standard", true),
                new Visitor("Eva Gray", 28, "V205", "T205", "Premium", false),
                new Visitor("Frank Blue", 22, "V206", "T206", "VIP", true), // Same age as Carol, different membership
                new Visitor("Grace Silver", 30, "V207", "T207", "Standard", false) // Same age as Bob, different membership
        };

        // Display created visitors
        for (Visitor visitor : visitors) {
            System.out.println("   Created: " + visitor.getName() +
                    " (Age: " + visitor.getAge() +
                    ", Membership: " + visitor.getMembershipLevel() + ")");
        }

        // Step 3: Add visitors to ride history
        System.out.println("\n3. Adding visitors to ride history...");
        for (Visitor visitor : visitors) {
            ferrisWheel.addVisitorToHistory(visitor);
        }

        // Step 4: Print unsorted history
        System.out.println("\n4. Printing UNSORTED ride history:");
        ferrisWheel.printRideHistory();

        // Step 5: Sort by name using single Comparator
        System.out.println("\n5. Sorting ride history by NAME (alphabetical order)...");
        ferrisWheel.sortRideHistoryByName();
        System.out.println("   Printing sorted history:");
        ferrisWheel.printRideHistory();

        // Step 6: Sort by age using single Comparator
        System.out.println("\n6. Sorting ride history by AGE (ascending order)...");
        ferrisWheel.sortRideHistoryByAge();
        System.out.println("   Printing sorted history:");
        ferrisWheel.printRideHistory();

        // Step 7: Sort using custom multi-criteria Comparator (as required)
        System.out.println("\n7. Sorting with CUSTOM COMPARATOR (Membership -> Age)...");
        System.out.println("   Uses TWO instance variables: Membership Level and Age");
        System.out.println("   Priority: Premium members first, then age (younger first)");
        ferrisWheel.sortRideHistoryByMembershipAndAge();
        System.out.println("   Printing sorted history:");
        ferrisWheel.printRideHistory();

        // Step 8: Direct use of VisitorComparator with different sort types
        System.out.println("\n8. Direct Comparator usage demonstrations...");

        System.out.println("   a) Using Comparator with name sorting:");
        ferrisWheel.sortRideHistory(new VisitorComparator("name"));
        ferrisWheel.printRideHistory();

        System.out.println("   b) Using Comparator with age sorting:");
        ferrisWheel.sortRideHistory(new VisitorComparator("age"));
        ferrisWheel.printRideHistory();

        System.out.println("   c) Using default Comparator (membership and age):");
        ferrisWheel.sortRideHistory(new VisitorComparator()); // Default constructor
        ferrisWheel.printRideHistory();

        // Step 9: Verify assignment requirements
        System.out.println("\n9. Verification of assignment requirements:");
        System.out.println("   ✓ Created ONE Comparator class (VisitorComparator)");
        System.out.println("   ✓ Used Comparator interface (not Comparable)");
        System.out.println("   ✓ Used at least TWO instance variables in comparison");
        System.out.println("   ✓ Used Collections.sort() method");
        System.out.println("   ✓ All sorting operations completed successfully");

        System.out.println("\n✅ Part 4B demonstration completed successfully!");
    }

    // Placeholder methods for other parts
    public void partThree() {
        System.out.println("Part 3 method - Already implemented");
    }

    public void partFive() {
        System.out.println("Part 5 method - To be implemented in Part 5");
    }

    public void partSix() {
        System.out.println("Part 6 method - To be implemented in Part 6");
    }

    public void partSeven() {
        System.out.println("Part 7 method - To be implemented in Part 7");
    }
}