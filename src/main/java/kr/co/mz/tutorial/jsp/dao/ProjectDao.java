package kr.co.mz.tutorial.jsp.dao;

import java.sql.SQLException;
import javax.sql.DataSource;
import kr.co.mz.tutorial.jsp.db.QueryManager;
import kr.co.mz.tutorial.jsp.dto.ProjectDto;

public class ProjectDao {

  public DataSource dataSource;

  public ProjectDao(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void insertOne(ProjectDto projectDto) {
    try (
        var conn = dataSource.getConnection();
        var pst = conn.prepareStatement(QueryManager.getQuery("INSERT_PROJECT"))
    ) {
      pst.setString(1, projectDto.getProjectName());
      pst.setString(2, projectDto.getProjectDescription());
      pst.setString(3, projectDto.getProjectStatus());
      pst.setBigDecimal(4, projectDto.getBudget());
      pst.setString(5, projectDto.getCreatedBy());
      var rs = pst.executeUpdate();
      System.out.println("Insert into project is complete for " + rs + " rows.");
    } catch (SQLException sqle) {
      System.out.println("Failed to insert." + sqle.getMessage());
      sqle.printStackTrace();
    }
  }

  public void deleteOneBySeq(long seq) {
    try (
        var conn = dataSource.getConnection();
        var pst = conn.prepareStatement(QueryManager.getQuery("DELETE_ONE_PROJECT"))
    ) {
      pst.setLong(1, seq);
      var rs = pst.executeUpdate();
      System.out.println("Delete from project is complete for " + rs + " rows.");
    } catch (SQLException sqle) {
      System.out.println("Failed to delete." + sqle.getMessage());
      sqle.printStackTrace();
    }
  }

  public void assignToDepartment(long departmentSeq, long projectSeq) {
    try (
        var conn = dataSource.getConnection();
        var pst = conn.prepareStatement(QueryManager.getQuery("INSERT_DP_RELATIONSHIP"))
    ) {
      pst.setLong(1, departmentSeq);
      pst.setLong(2, projectSeq);
      var rs = pst.executeUpdate();

      System.out.println("Project is assigned for " + rs + " department.");
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

  public void assignToEmployee(long employeeSeq, long projectSeq) {
    try (
        var conn = dataSource.getConnection();
        var pst = conn.prepareStatement(QueryManager.getQuery("INSERT_EP_RELATIONSHIP"))
    ) {
      pst.setLong(1, employeeSeq);
      pst.setLong(2, projectSeq);
      var rs = pst.executeUpdate();
      System.out.println("Project is assigned for " + rs + " employee.");
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

}
