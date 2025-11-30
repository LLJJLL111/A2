import java.util.Comparator;

/**
 * VisitorComparator - Implements Comparator interface for sorting visitors
 * Part 4B: Single comparator class that handles multiple sorting criteria
 * Uses at least two instance variables in comparison as required
 */
public class VisitorComparator implements Comparator<Visitor> {
    private String sortType;

    /**
     * Constructor to specify sorting type
     * @param sortType The type of sorting: "name", "age", or "membership_age"
     */
    public VisitorComparator(String sortType) {
        this.sortType = sortType;
    }

    /**
     * Default constructor - uses membership and age sorting
     */
    public VisitorComparator() {
        this.sortType = "membership_age";
    }

    /**
     * Compares two visitors based on the specified sort type
     * Uses at least two instance variables in comparison as required
     * @param v1 First visitor to compare
     * @param v2 Second visitor to compare
     * @return Comparison result based on selected criteria
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        switch (sortType.toLowerCase()) {
            case "name":
                // Sort by name (alphabetical order)
                return v1.getName().compareToIgnoreCase(v2.getName());

            case "age":
                // Sort by age (ascending order) - using age instance variable
                return Integer.compare(v1.getAge(), v2.getAge());

            case "membership_age":
            default:
                // Sort by membership level (Premium first) and then by age (younger first)
                // Uses TWO instance variables: membershipLevel and age as required

                // First criteria: Membership level (Premium members first)
                int membershipCompare = getMembershipPriority(v2.getMembershipLevel()) -
                        getMembershipPriority(v1.getMembershipLevel());

                if (membershipCompare != 0) {
                    return membershipCompare;
                }

                // Second criteria: Age (younger visitors first)
                int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
                if (ageCompare != 0) {
                    return ageCompare;
                }

                // Third criteria: Name (alphabetical order) for tie-breaking
                return v1.getName().compareToIgnoreCase(v2.getName());
        }
    }

    /**
     * Helper method to assign priority to membership levels
     * @param membershipLevel The membership level to evaluate
     * @return Priority value (higher number = higher priority)
     */
    private int getMembershipPriority(String membershipLevel) {
        if (membershipLevel == null) return 0;

        switch (membershipLevel.toLowerCase()) {
            case "premium":
            case "gold":
            case "vip":
                return 3;
            case "standard":
                return 2;
            case "basic":
                return 1;
            default:
                return 0;
        }
    }

    /**
     * Gets the current sort type
     * @return The current sorting type
     */
    public String getSortType() {
        return sortType;
    }

    /**
     * Sets the sort type
     * @param sortType The sorting type to use
     */
    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}