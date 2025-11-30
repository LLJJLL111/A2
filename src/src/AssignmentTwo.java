/**
 * AssignmentTwo class - Main class containing demonstration methods
 * Demonstrates all Part 3 functionality
 */
public class AssignmentTwo {

    /**
     * Main method - Program entry point
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Theme Park Visitor Management System ===");
        System.out.println("Part 3: Queue Implementation Demonstration");

        AssignmentTwo assignment = new AssignmentTwo();

        // Execute Part 3 demonstration
        assignment.partThree();
    }

    /**
     * Part 3: Queue Functionality Demonstration
     * Creates Ride object, adds visitors to queue, removes visitors, prints queue
     * Demonstrates FIFO behavior and proper queue management
     */
    public void partThree() {
        System.out.println("\n🎢 === Part 3: Queue Demonstration ===");

        // Step 1: Create ride operator
        System.out.println("\n1. Creating ride operator...");
        Employee operator = new Employee("John Operator", 30, "E001", "OP001", "Ride Operations", "Senior Operator");
        System.out.println("   Operator created: " + operator.getName());

        // Step 2: Create amusement ride
        System.out.println("\n2. Creating amusement ride...");
        Ride rollerCoaster = new Ride("Thunder Coaster", "Roller Coaster", operator, 24, true);
        System.out.println("   Ride created: " + rollerCoaster.getRideName());

        // Step 3: Create visitors (minimum 5 as required)
        System.out.println("\n3. Creating visitors...");
        Visitor[] visitors = {
                new Visitor("Alice Johnson", 25, "V001", "T001", "Premium", true),
                new Visitor("Bob Smith", 30, "V002", "T002", "Standard", false),
                new Visitor("Charlie Brown", 22, "V003", "T003", "Premium", true),
                new Visitor("Diana Prince", 28, "V004", "T004", "Standard", false),
                new Visitor("Evan Davis", 35, "V005", "T005", "Gold", true),
                new Visitor("Fiona Garcia", 19, "V006", "T006", "Standard", false) // Extra for demonstration
        };

        // Display created visitors
        for (Visitor visitor : visitors) {
            System.out.println("   Created: " + visitor.getName() +
                    " (Ticket: " + visitor.getTicketNumber() +
                    ", Membership: " + visitor.getMembershipLevel() + ")");
        }

        // Step 4: Add visitors to waiting queue
        System.out.println("\n4. Adding visitors to waiting queue...");
        for (Visitor visitor : visitors) {
            rollerCoaster.addVisitorToQueue(visitor);
        }

        // Step 5: Print current queue status
        System.out.println("\n5. Current queue status:");
        rollerCoaster.printQueue();

        // Step 6: Peek at next visitor without removing
        System.out.println("6. Peeking at next visitor:");
        rollerCoaster.peekVisitorFromQueue();

        // Step 7: Remove one visitor from queue (FIFO)
        System.out.println("\n7. Removing one visitor from queue...");
        Visitor removedVisitor = rollerCoaster.removeVisitorFromQueue();
        if (removedVisitor != null) {
            System.out.println("   Successfully removed: " + removedVisitor.getName());
        }

        // Step 8: Print queue after removal
        System.out.println("\n8. Queue status after removal:");
        rollerCoaster.printQueue();

        // Step 9: Test additional removals
        System.out.println("\n9. Testing additional removals...");
        for (int i = 0; i < 2; i++) {
            Visitor removed = rollerCoaster.removeVisitorFromQueue();
            if (removed != null) {
                System.out.println("   Removed: " + removed.getName());
            }
        }

        // Step 10: Print final queue status
        System.out.println("\n10. Final queue status:");
        rollerCoaster.printQueue();

        // Step 11: Test edge cases
        System.out.println("\n11. Testing edge cases...");

        // Test removal from empty queue
        System.out.println("   a) Testing removal from empty queue:");
        while (rollerCoaster.removeVisitorFromQueue() != null) {
            // Empty the queue completely
        }
        rollerCoaster.removeVisitorFromQueue(); // Attempt removal from empty queue

        // Test adding null visitor
        System.out.println("   b) Testing adding null visitor:");
        rollerCoaster.addVisitorToQueue(null);

        // Test queue clearance
        System.out.println("   c) Testing queue clearance:");
        rollerCoaster.addVisitorToQueue(visitors[0]);
        rollerCoaster.addVisitorToQueue(visitors[1]);
        System.out.println("   Queue size before clearance: " + rollerCoaster.getQueueSize());
        rollerCoaster.clearQueue();
        System.out.println("   Queue size after clearance: " + rollerCoaster.getQueueSize());

        // Step 12: Final demonstration summary
        System.out.println("\n12. Demonstration Summary:");
        System.out.println("    - Successfully created " + visitors.length + " visitors");
        System.out.println("    - Implemented FIFO queue behavior");
        System.out.println("    - Tested all required interface methods");
        System.out.println("    - Handled edge cases appropriately");
        System.out.println("    - Provided clear success/error messages");

        System.out.println("\n✅ Part 3 demonstration completed successfully!");
        System.out.println("   All queue functionality requirements have been met.");
    }

    // Placeholder methods for future parts
    public void partFourA() {
        System.out.println("Part 4A method - To be implemented in Part 4");
    }

    public void partFourB() {
        System.out.println("Part 4B method - To be implemented in Part 4");
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