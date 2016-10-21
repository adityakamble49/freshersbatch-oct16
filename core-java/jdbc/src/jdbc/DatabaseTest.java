package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTest {

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "system";
    private static final String PASSWORD = "aditya";

    public static void main(String[] args) throws Exception {

        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME,
                PASSWORD);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM DEPT");

        while (rs.next()) {
            System.out.println(rs.getInt("ID") + " " + rs.getString("NAME")
                    + " " + rs.getString("LOCATION"));
        }

        int update = stmt.executeUpdate(
                "UPDATE DEPT SET NAME = 'Research And Development' WHERE ID = 3");

        System.out.println(update);

        int update2 = stmt.executeUpdate("DELETE FROM DEPT WHERE ID = 7");
        System.out.println(update2);

    }
}
