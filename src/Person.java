/**
 * Abstract Person class - Base class for all person types in the theme park system
 * Contains common attributes and behaviors for all persons
 */
public abstract class Person {
    // Instance variables common to all persons
    private String name;
    private int age;
    private String id;

    /**
     * Default constructor - initializes with default values
     */
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.id = "0000";
    }

    /**
     * Parameterized constructor - initializes with provided values
     * @param name The person's name
     * @param age The person's age
     * @param id The person's identification
     */
    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Error: Age cannot be negative");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns string representation of the person
     * @return String containing person details
     */
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", id='" + id + "'}";
    }
}