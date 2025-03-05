package dataaccesslayer;

import transferobjects.RecipientDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) implementation for the {@code RecipientDTO} entity.
 * This class interacts with the database to perform CRUD operations on the Recipients table.
 */
public class RecipientDAOImpl implements RecipientDAO {

    /**
     * Retrieves all recipients from the database.
     *
     * @return A list of objects representing all recipients.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public List<RecipientDTO> getAllRecipients() throws SQLException {
        List<RecipientDTO> recipients = new ArrayList<>();
        String query = "SELECT * FROM Recipients";
        try (PreparedStatement pstmt = DataSource.getInstance().getConnection().prepareStatement(query);
             ResultSet resultSet = pstmt.executeQuery()) {
            while (resultSet.next()) {
                recipients.add(new RecipientDTO(
                        resultSet.getInt("AwardID"),
                        resultSet.getString("Name"),
                        resultSet.getInt("Year"),
                        resultSet.getString("City"),
                        resultSet.getString("Category")
                ));
            }
        }
        return recipients;
    }

    /**
     * Inserts a new recipient into the database.
     *
     * @param recipient The object to be inserted.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public void insertRecipient(RecipientDTO recipient) throws SQLException {
        String query = "INSERT INTO Recipients (Name, Year, City, Category) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = DataSource.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, recipient.getName());
            pstmt.setInt(2, recipient.getYear());
            pstmt.setString(3, recipient.getCity());
            pstmt.setString(4, recipient.getCategory());
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    recipient = new RecipientDTO(generatedKeys.getInt(1), recipient.getName(), recipient.getYear(), recipient.getCity(), recipient.getCategory());
                }
            }
        }
    }

    /**
     * Deletes a recipient from the database based on the provided ID.
     *
     * @param id The ID of the recipient to be deleted.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public void deleteRecipient(int id) throws SQLException {
        String query = "DELETE FROM Recipients WHERE AwardID = ?";
        try (PreparedStatement pstmt = DataSource.getInstance().getConnection().prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    /**
     * Deletes the most recently added recipient from the database.
     *
     * @throws SQLException If a database access error occurs.
     */
    public void deleteLastRecipient() throws SQLException {
        String query = "DELETE FROM Recipients ORDER BY AwardID DESC LIMIT 1";
        try (PreparedStatement pstmt = DataSource.getInstance().getConnection().prepareStatement(query)) {
            pstmt.executeUpdate();
        }
    }
}
