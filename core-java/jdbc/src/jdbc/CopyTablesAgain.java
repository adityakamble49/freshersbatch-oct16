
package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CopyTablesAgain {

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "system";
    private static final String PASSWORD = "aditya";
    private static Connection conn;

    public static void main(String[] args) throws Exception {

        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

        // createTable();
        insertEntries();
        conn.close();

    }

    private static void insertEntries() throws Exception {

        conn.setAutoCommit(false);
        PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO EMP_COPY_1 VALUES(?,?,?,?,?,?,?,?)");

        Statement stmt2 = conn.createStatement();
        ResultSet rs = stmt2.executeQuery("SELECT * FROM EMP");

        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            int salary = rs.getInt("SALARY");
            int commision = rs.getInt("COMMISSION");
            String role = rs.getString("ROLE");
            int deptNo = rs.getInt("DEPT_NO");
            Date date = rs.getDate("HIRED_DATE");
            int managerID = rs.getInt("MANAGER_ID");

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, salary);
            pstmt.setInt(4, commision);
            pstmt.setString(5, role);
            pstmt.setInt(6, deptNo);
            pstmt.setDate(7, date);
            pstmt.setInt(8, managerID);

            pstmt.addBatch();
            pstmt.clearParameters();

        }

        pstmt.executeBatch();
        conn.commit();
    }

    private static void createTable() throws Exception {

        Statement stmt = conn.createStatement();
        int createResult = stmt.executeUpdate(
                "CREATE TABLE EMP_COPY_1 AS ( SELECT * FROM EMP )");

        System.out.println(createResult);

    }
}
