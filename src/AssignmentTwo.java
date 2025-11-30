/**
 * AssignmentTwo class - Main class containing all demonstration methods
 * Part 2 update: Added method placeholders for Part 3-7
 */
public class AssignmentTwo {
    
    public static void main(String[] args) {
        System.out.println("=== Theme Park Visitor Management System ===");
        System.out.println("Part 2: Abstract Class and Interface Implementation");
        
        // Test basic functionality of Part 2
        AssignmentTwo test = new AssignmentTwo();
        test.testPart2();
    }
    
    /**
     * Test functionality of Part 2
     */
    public void testPart2() {
        System.out.println("\n--- Testing Part 2: Abstract Classes and Interfaces ---");
        
        // Create employee - corrected parameter order and added email
        Employee operator = new Employee("John Smith", 28, "john.smith@themepark.com", "E001", "Ride Operations", 50000.0);
        
        // Create ride (implements RideInterface) - corrected parameter order
        Ride rollerCoaster = new Ride("Thunder Coaster", "Roller Coaster", 24, operator);
        
        // Test interface methods (to be implemented in later parts)
        System.out.println("Testing interface methods (to be implemented in later parts):");
        rollerCoaster.addVisitorToQueue(null); // To be implemented in Part 3
        rollerCoaster.runOneCycle(); // To be implemented in Part 5
        
        System.out.println("\nRide created: " + rollerCoaster);
    }
    
    // Method placeholders for Part 3-7
    public void partThree() {
        System.out.println("Part 3 method - To be implemented");
    }
    
    public void partFourA() {
        System.out.println("Part 4A method - To be implemented");
    }
    
    public void partFourB() {
        System.out.println("Part 4B method - To be implemented");
    }
    
    public void partFive() {
        System.out.println("Part 5 method - To be implemented");
    }
    
    public void partSix() {
        System.out.println("Part 6 method - To be implemented");
    }
    
    public void partSeven() {
        System.out.println("Part 7 method - To be implemented");
    }
}