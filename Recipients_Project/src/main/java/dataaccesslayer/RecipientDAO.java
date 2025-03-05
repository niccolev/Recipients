package dataaccesslayer;

import transferobjects.RecipientDTO;
import java.sql.SQLException;
import java.util.List;

/**
 * Data Access Object (DAO) interface for managing recipients.
 * <p>
 * This interface defines the contract for performing CRUD operations on the Recipients table.
 * </p>
 */
public interface RecipientDAO {

    /**
     * Retrieves all recipients from the database.
     *
     * @return A list of {@code RecipientDTO} objects representing all recipients.
     * @throws SQLException If a database access error occurs.
     */
    List<RecipientDTO> getAllRecipients() throws SQLException;

    /**
     * Inserts a new recipient into the database.
     *
     * @param recipient The {@code RecipientDTO} object to be inserted.
     * @throws SQLException If a database access error occurs.
     */
    void insertRecipient(RecipientDTO recipient) throws SQLException;

    /**
     * Deletes a recipient from the database based on the provided ID.
     *
     * @param id The ID of the recipient to delete.
     * @throws SQLException If a database access error occurs.
     */
    void deleteRecipient(int id) throws SQLException;
}
