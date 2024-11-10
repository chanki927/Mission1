package Database;

import java.sql.*;

public class DBConnect {
    private static final DBConnect CloseUtil = null;
	private static String url = "jdbc:mariadb://localhost:3306/wifi";
    private static String user = "wifiuser";
    private static String password = "wifi";

    public static Connection connectDB() {
        Connection connection = null;
        Statement statement = null;

        try {
            String driverClassName = "org.mariadb.jdbc.Driver";
            String url = "jdbc:mariadb://localhost:3306/wifi";
            String user = "wifiuser";
            String password = "wifi";
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB 연결 성공");
            System.out.println("** Driver:" + driverClassName + ", Connection:" + connection);
            statement = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("드라이버 로딩 실패");
            ex.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql 오류 : 이미 생성");
        }
		return connection;
       }
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}