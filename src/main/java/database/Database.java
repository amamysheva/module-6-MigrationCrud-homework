package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Database {
    private static final Database DATABASE = new Database();
    private Connection connection;
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("database_url");
    private static final String JDBC_URL = "jdbcURL";

    private Database() {
        try {
            connection = DriverManager.getConnection(resourceBundle.getString(JDBC_URL));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        return DATABASE;
    }

    public Connection getConnection() {
        return connection;
    }
}
