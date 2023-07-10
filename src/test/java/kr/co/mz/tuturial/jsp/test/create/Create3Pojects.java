package kr.co.mz.tuturial.jsp.test.create;

import java.io.IOException;
import java.sql.SQLException;
import kr.co.mz.tutorial.jsp.dao.ProjectDao;
import kr.co.mz.tutorial.jsp.db.HikariPoolFactory;

public class Create3Pojects {

  public static void main(String[] args) throws IOException, SQLException {
    // 부서 3개, 프로젝트 3개, 직원 5명, 협력사 2개.
    var ds = new HikariPoolFactory().createHikariDataSource();
    var projectDao = new ProjectDao(ds);
    var createProjectDto = new CreateProjectDto();

//    projectDao.insertOne(createProjectDto.nameMegaBird());
//    projectDao.insertOne(createProjectDto.nameDocsWave());
//    projectDao.insertOne(createProjectDto.nameAOAI_DA());

    projectDao.assignToDepartment(1, 1);
    projectDao.assignToDepartment(1, 2);
    projectDao.assignToDepartment(1, 3);
    projectDao.assignToDepartment(2, 1);
    projectDao.assignToDepartment(2, 2);
    projectDao.assignToDepartment(3, 1);

    
  }
}