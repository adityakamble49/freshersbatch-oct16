package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseTest2 {

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "system";
    private static final String PASSWORD = "aditya";

    public static void main(String[] args) throws Exception {

        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME,
                PASSWORD);

        PreparedStatement pstmt = conn
                .prepareStatement("UPDATE DEPT SET NAME = 'RnD' WHERE ID = ?");
        pstmt.setInt(1, 3);
        int update = pstmt.executeUpdate();
        System.out.println(update);

        PreparedStatement pstmt2 = conn.prepareStatement("SELECT * FROM DEPT");
        ResultSet rs = pstmt2.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("ID") + " " + rs.getString("NAME")
                    + " " + rs.getString("LOCATION"));
        }

        PreparedStatement pstmt3 = conn
                .prepareStatement("DELETE FROM DEPT WHERE ID = ?");
        pstmt3.setInt(1, 7);
        int update2 = pstmt3.executeUpdate();
        System.out.println(update2);

    }
}
