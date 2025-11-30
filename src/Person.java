/**
 * Abstract class representing a general Person
 * This class serves as the base class for Employee and Visitor
 * It contains common attributes that all person types share
 * Made abstract as Person objects should not be instantiated directly
 */
public abstract class Person {
    // Instance variables for person attributes
    private String name;        // Name of the person
    private int age;           // Age of the person
    private String email;      // Email address of the person

    /**
     * Default constructor
     * Initializes person with default values
     */
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.email = "unknown@example.com";
    }

    /**
     * Parameterized constructor
     * @param name The name of the person
     * @param age The age of the person
     * @param email The email address of the person
     */
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getter and setter methods

    /**
     * Gets the name of the person
     * @return The person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person
     * @param name The new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the person
     * @return The person's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person
     * @param age The new age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the email of the person
     * @return The person's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the person
     * @param email The new email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of the person
     * @return String containing person details
     */
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}