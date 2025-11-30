/**
 * Visitor class representing theme park visitors
 * Extends Person class to inherit common person attributes
 * Adds visitor-specific attributes and behaviors
 */
public class Visitor extends Person {
    // Visitor-specific instance variables
    private String visitorId;      // Unique identifier for the visitor
    private String ticketType;     // Type of ticket purchased
    private boolean hasSeasonPass; // Whether visitor has season pass

    /**
     * Default constructor
     * Initializes visitor with default values
     */
    public Visitor() {
        super();  // Call parent class default constructor
        this.visitorId = "V000";
        this.ticketType = "Standard";
        this.hasSeasonPass = false;
    }

    /**
     * Parameterized constructor
     * @param name Visitor's name
     * @param age Visitor's age
     * @param email Visitor's email
     * @param visitorId Unique visitor ID
     * @param ticketType Type of ticket
     * @param hasSeasonPass Whether visitor has season pass
     */
    public Visitor(String name, int age, String email, String visitorId, String ticketType, boolean hasSeasonPass) {
        super(name, age, email);  // Call parent class parameterized constructor
        this.visitorId = visitorId;
        this.ticketType = ticketType;
        this.hasSeasonPass = hasSeasonPass;
    }

    // Getter and setter methods for visitor-specific attributes

    /**
     * Gets the visitor ID
     * @return The visitor's unique ID
     */
    public String getVisitorId() {
        return visitorId;
    }

    /**
     * Sets the visitor ID
     * @param visitorId The new visitor ID to set
     */
    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    /**
     * Gets the ticket type
     * @return The type of ticket
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * Sets the ticket type
     * @param ticketType The new ticket type to set
     */
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * Checks if visitor has season pass
     * @return true if visitor has season pass, false otherwise
     */
    public boolean isHasSeasonPass() {
        return hasSeasonPass;
    }

    /**
     * Sets the season pass status
     * @param hasSeasonPass The new season pass status to set
     */
    public void setHasSeasonPass(boolean hasSeasonPass) {
        this.hasSeasonPass = hasSeasonPass;
    }

    /**
     * Returns a string representation of the visitor
     * @return String containing visitor details
     */
    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", visitorId='" + visitorId + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", hasSeasonPass=" + hasSeasonPass +
                '}';
    }
}