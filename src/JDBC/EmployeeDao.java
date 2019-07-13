package JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


//    static {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContextJdbc.xml");
//       jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
//
//    }

    public  Employee get(Integer id) {
        String sql = "SELECT id,last_name,email from employees where id=?";
        System.out.println(jdbcTemplate);
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return employee;

    }



}
