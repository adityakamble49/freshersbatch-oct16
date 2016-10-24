package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CopyTables {

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "system";
    private static final String PASSWORD = "aditya";

    public static void main(String[] args) throws Exception {

        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME,
                PASSWORD);

        Statement stmt = conn.createStatement();
        int createResult = stmt.executeUpdate(
                "CREATE TABLE EMP_COPY AS ( SELECT * FROM EMP )");
        int insertResult = stmt
                .executeUpdate("INSERT INTO EMP_COPY ( SELECT * FROM EMP )");

        System.out.println(createResult);
        System.out.println(insertResult);

        conn.close();

    }
}
