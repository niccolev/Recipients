package transferobjects;

/**
 * Data Transfer Object (DTO) for a recipient.
 * This class represents a recipient entity with fields for ID, name, year, city, and category.
 * It is used to transfer recipient data between different layers of the application.
 */
public class RecipientDTO {
    private int id;
    private String name;
    private int year;
    private String city;
    private String category;

    /**
     * Constructs a new object.
     *
     * @param id       The unique identifier for the recipient.
     * @param name     The name of the recipient.
     * @param year     The year the recipient was awarded.
     * @param city     The city associated with the recipient.
     * @param category The award category of the recipient.
     */
    public RecipientDTO(int id, String name, int year, String city, String category) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.city = city;
        this.category = category;
    }

    /**
     * Retrieves the recipient's ID.
     *
     * @return The recipient's unique ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the recipient's name.
     *
     * @return The recipient's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the year the recipient was awarded.
     *
     * @return The award year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Retrieves the city associated with the recipient.
     *
     * @return The recipient's city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Retrieves the award category of the recipient.
     *
     * @return The award category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns a formatted string representation of the recipient.
     *
     * @return A formatted string containing recipient details.
     */
    @Override
    public String toString() {
        return String.format("%-5d %-20s %-10d %-15s %-15s", id, name, year, city, category);
    }
}
