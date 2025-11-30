/**
 * Interface defining the operations for a Ride
 * This interface enforces specific behaviors that all Ride implementations must provide
 */
public interface RideInterface {

    /**
     * Adds a visitor to the ride's waiting queue
     * @param visitor The visitor to add to the queue
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * Removes a visitor from the ride's waiting queue
     * Typically removes the first visitor in the queue (FIFO)
     */
    void removeVisitorFromQueue();

    /**
     * Prints all visitors currently in the waiting queue
     * Shows the order in which visitors will be served
     */
    void printQueue();

    /**
     * Adds a visitor to the ride's history
     * This is called after a visitor has taken the ride
     * @param visitor The visitor to add to the history
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * Checks if a visitor is in the ride's history
     * @param visitor The visitor to check
     * @return true if visitor is in history, false otherwise
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * Returns the number of visitors in the ride's history
     * @return The count of visitors who have taken the ride
     */
    int numberOfVisitors();

    /**
     * Prints all visitors in the ride's history
     * Shows complete record of visitors who have taken the ride
     */
    void printRideHistory();

    /**
     * Runs the ride for one cycle
     * Processes visitors from queue to ride history based on ride capacity
     */
    void runOneCycle();
}