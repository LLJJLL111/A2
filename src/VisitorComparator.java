import java.util.Comparator;

/**
 * VisitorComparator - Implements Comparator for sorting visitors
 * Part 4B: Uses at least two instance variables in comparison
 */
public class VisitorComparator implements Comparator<Visitor> {
    private String sortType;

    public VisitorComparator(String sortType) {
        this.sortType = sortType;
    }

    public VisitorComparator() {
        this.sortType = "membership_age";
    }

    @Override
    public int compare(Visitor v1, Visitor v2) {
        switch (sortType.toLowerCase()) {
            case "name":
                return v1.getName().compareToIgnoreCase(v2.getName());

            case "age":
                return Integer.compare(v1.getAge(), v2.getAge());

            case "membership_age":
            default:
                // First: Membership level (Premium first)
                int membershipCompare = getMembershipPriority(v2.getMembershipLevel()) -
                        getMembershipPriority(v1.getMembershipLevel());
                if (membershipCompare != 0) return membershipCompare;

                // Second: Age (younger first)
                int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
                if (ageCompare != 0) return ageCompare;

                // Third: Name (alphabetical)
                return v1.getName().compareToIgnoreCase(v2.getName());
        }
    }

    private int getMembershipPriority(String membershipLevel) {
        if (membershipLevel == null) return 0;

        switch (membershipLevel.toLowerCase()) {
            case "premium":
            case "gold":
            case "vip": return 3;
            case "standard": return 2;
            case "basic": return 1;
            default: return 0;
        }
    }
}