/**
 * Visitor class - Represents theme park visitors
 * Extends Person class to inherit common attributes
 */
public class Visitor extends Person {
    // Visitor-specific instance variables
    private String ticketNumber;
    private String membershipLevel;
    private boolean hasFastPass;

    /**
     * Default constructor - initializes with default values
     */
    public Visitor() {
        super();
        this.ticketNumber = "T0000";
        this.membershipLevel = "Standard";
        this.hasFastPass = false;
    }

    /**
     * Parameterized constructor - initializes with provided values
     * @param name Visitor's name
     * @param age Visitor's age
     * @param id Visitor's personal ID
     * @param ticketNumber Visitor's ticket number
     * @param membershipLevel Visitor's membership level
     * @param hasFastPass Whether visitor has fast pass
     */
    public Visitor(String name, int age, String id, String ticketNumber, String membershipLevel, boolean hasFastPass) {
        super(name, age, id);
        this.ticketNumber = ticketNumber;
        this.membershipLevel = membershipLevel;
        this.hasFastPass = hasFastPass;
    }

    // Getter and setter methods
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public boolean hasFastPass() {
        return hasFastPass;
    }

    public void setFastPass(boolean hasFastPass) {
        this.hasFastPass = hasFastPass;
    }

    /**
     * Returns string representation of the visitor
     * @return String containing visitor details
     */
    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + getName() + "', " +
                "age=" + getAge() + ", " +
                "id='" + getId() + "', " +
                "ticketNumber='" + ticketNumber + "', " +
                "membershipLevel='" + membershipLevel + "', " +
                "hasFastPass=" + hasFastPass + "}";
    }
}