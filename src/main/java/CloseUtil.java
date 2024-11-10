import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseUtil {
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException se) {
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException se) {
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException se) {
            }
        }
    }
}