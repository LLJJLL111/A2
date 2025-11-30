/**
 * RideInterface - Defines the contract for ride operations
 * All ride classes must implement these methods
 */
public interface RideInterface {

    /**
     * Adds a visitor to the waiting queue
     * @param visitor The visitor to add to the queue
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * Removes a visitor from the waiting queue
     * @return The removed visitor, or null if queue is empty
     */
    Visitor removeVisitorFromQueue();

    /**
     * Prints all visitors in the waiting queue
     */
    void printQueue();

    /**
     * Adds a visitor to the ride history
     * @param visitor The visitor to add to history
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * Checks if a visitor is in the ride history
     * @param visitor The visitor to check
     * @return true if visitor is in history, false otherwise
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * Returns the number of visitors in ride history
     * @return Number of visitors in history
     */
    int numberOfVisitors();

    /**
     * Prints all visitors in the ride history
     */
    void printRideHistory();

    /**
     * Runs the ride for one cycle
     */
    void runOneCycle();
}