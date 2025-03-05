package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

/**
 * Singleton class that manages the database connection.
 * <p>
 * This class ensures that only one instance of the database connection exists throughout the application.
 * It reads database credentials from a properties file.
 * </p>
 */
public class DataSource {

    private static DataSource instance;
    private Connection connection;

    /**
     * Private constructor to prevent external instantiation.
     * <p>
     * Loads database properties and establishes a connection to the database.
     * </p>
     */
    private DataSource() {
        try {
            Properties props = new Properties();
            try (InputStream in = getClass().getClassLoader().getResourceAsStream("Lab1/database.properties")) {
                if (in == null) {
                    System.out.println("Database properties file not found!");
                    return;
                }
                props.load(in);
            }

            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");

            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection only once
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the singleton instance of {@code DataSource}.
     *
     * @return The single instance of {@code DataSource}.
     */
    public static synchronized DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    /**
     * Retrieves the database connection.
     *
     * @return The active database connection.
     */
    public Connection getConnection() {
        return connection;
    }
}
