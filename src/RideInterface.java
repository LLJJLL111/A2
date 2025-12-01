/**
 * RideInterface - Defines contract for ride operations
 * Part 2: Created interface with all required methods
 */
public interface RideInterface {
    // Queue operations
    void addVisitorToQueue(Visitor visitor);
    Visitor removeVisitorFromQueue();
    void printQueue();

    // History operations
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();

    // Ride operation
    void runOneCycle();
}