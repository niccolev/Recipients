package Lab1;

import businesslayer.RecipientService;
import transferobjects.RecipientDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * The main class to execute functionality related to managing award recipients.
 * This class retrieves and displays all recipients from the database, 
 * inserts a new recipient, and deletes the last recipient.
 */
public class PropertiesLab {

    /**
     * The main method executes database operations to manage recipients.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        RecipientService recipientService = new RecipientService();

        try {
            // Displaying all recipients
            List<RecipientDTO> recipients = recipientService.getAllRecipients();

            // Print table headers
            System.out.printf("%-5s %-20s %-10s %-15s %-15s\n", "ID", "Name", "Year", "City", "Category");
            System.out.println("-----------------------------------------------------------");

            for (RecipientDTO recipient : recipients) {
                System.out.println(recipient);
            }

            // Insert a new recipient
            RecipientDTO newRecipient = new RecipientDTO(0, "New Recipient", 2022, "New City", "Category");
            recipientService.insertRecipient(newRecipient);
            System.out.println("\nAfter Inserting New Recipient:");
            recipients = recipientService.getAllRecipients();
            for (RecipientDTO recipient : recipients) {
                System.out.println(recipient);
            }

            // Delete the last recipient
            recipientService.deleteLastRecipient();
            System.out.println("\nAfter Deleting Last Recipient:");
            recipients = recipientService.getAllRecipients();
            for (RecipientDTO recipient : recipients) {
                System.out.println(recipient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
