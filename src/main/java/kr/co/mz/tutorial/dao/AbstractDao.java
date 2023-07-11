package kr.co.mz.tutorial.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import kr.co.mz.tutorial.db.QueryManager;

public abstract class AbstractDao {

  protected DataSource dataSource;
  protected QueryManager queryManager;

  public AbstractDao() {
  }

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void setQueryManager(QueryManager queryManager) {
    this.queryManager = queryManager;
  }

  public Connection getConnection() throws SQLException {
    return dataSource.getConnection();
  }

  public void closeConnection(Connection conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException sqle) {
        System.out.println("Failed to close Connection: " + sqle.getMessage());
        sqle.printStackTrace();
      }
    }
  }
}
