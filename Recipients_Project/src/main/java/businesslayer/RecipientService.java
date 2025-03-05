package businesslayer;

import dataaccesslayer.RecipientDAO;
import dataaccesslayer.RecipientDAOImpl;
import transferobjects.RecipientDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Service layer for managing recipients.
 * This class provides methods to interact with the data access layer,
 * handling operations such as retrieving, inserting, and deleting recipients.
 */
public class RecipientService {
    private RecipientDAO recipientDAO;

    /**
     * Constructs a new {@code RecipientService} and initializes the DAO implementation.
     */
    public RecipientService() {
        recipientDAO = new RecipientDAOImpl();
    }

    /**
     * Retrieves all recipients from the database.
     *
     * @return A list of {@code RecipientDTO} objects.
     * @throws SQLException If a database access error occurs.
     */
    public List<RecipientDTO> getAllRecipients() throws SQLException {
        return recipientDAO.getAllRecipients();
    }

    /**
     * Inserts a new recipient into the database.
     *
     * @param recipient The recipient to insert.
     * @throws SQLException If a database access error occurs.
     */
    public void insertRecipient(RecipientDTO recipient) throws SQLException {
        recipientDAO.insertRecipient(recipient);
    }

    /**
     * Deletes a recipient from the database based on the provided ID.
     *
     * @param id The ID of the recipient to delete.
     * @throws SQLException If a database access error occurs.
     */
    public void deleteRecipient(int id) throws SQLException {
        recipientDAO.deleteRecipient(id);
    }

    /**
     * Deletes the most recently added recipient from the database.
     *
     * @throws SQLException If a database access error occurs.
     */
    public void deleteLastRecipient() throws SQLException {
        ((RecipientDAOImpl) recipientDAO).deleteLastRecipient();
    }
}
