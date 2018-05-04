package pl.testaarosa.movierental;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertFalse;

public class MySQL {
  @Test
  public void testMySQLConnection() throws SQLException {

    Connection conn = null;
    try {
      String username = "root";
      String password = "Kropka123";
      String dbUrl = "jdbc:mysql://localhost:3306/testaarosa?serverTimezone=Europe/Warsaw&useSSL=False";
      conn = DriverManager.getConnection(dbUrl, username, password);

      assertFalse(conn.isClosed());

//      System.out.println("Connection Established to MYSQL Database");
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    } finally {
      assert conn != null;
      conn.close();
    }
  }
}

