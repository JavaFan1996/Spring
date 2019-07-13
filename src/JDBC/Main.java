package JDBC;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
//
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("jdbcContext.xml");
//
//
//        DataSource dataSource = (DataSource) context.getBean("dataSource");
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);
//
//        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
//        String sql = "UPDATE employees set last_name=? where id=?";
//        jdbcTemplate.update(sql, "wwm", 1);


        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.get(1);
        System.out.println(employee);


    }

}
