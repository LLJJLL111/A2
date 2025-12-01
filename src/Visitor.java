/**
 * Visitor class - Represents theme park visitors
 * Part 1: Extends Person class
 */
public class Visitor extends Person {
    private String ticketNumber;
    private String membershipLevel;
    private boolean hasFastPass;

    public Visitor() {
        super();
        this.ticketNumber = "T0000";
        this.membershipLevel = "Standard";
        this.hasFastPass = false;
    }

    public Visitor(String name, int age, String id, String ticketNumber, String membershipLevel, boolean hasFastPass) {
        super(name, age, id);
        this.ticketNumber = ticketNumber;
        this.membershipLevel = membershipLevel;
        this.hasFastPass = hasFastPass;
    }

    public String getTicketNumber() { return ticketNumber; }
    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }

    public String getMembershipLevel() { return membershipLevel; }
    public void setMembershipLevel(String membershipLevel) { this.membershipLevel = membershipLevel; }

    public boolean hasFastPass() { return hasFastPass; }
    public void setFastPass(boolean hasFastPass) { this.hasFastPass = hasFastPass; }

    @Override
    public String toString() {
        return "Visitor{" + super.toString() +
                ", ticketNumber='" + ticketNumber + "', membershipLevel='" + membershipLevel +
                "', hasFastPass=" + hasFastPass + "}";
    }
}