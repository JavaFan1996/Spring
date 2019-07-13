package JDBC;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {


    private ApplicationContext context = null;
    private JdbcTemplate jdbcTemplate;
    private EmployeeDao employeeDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        context =
                new ClassPathXmlApplicationContext("applicationContextJdbc.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        employeeDao = context.getBean(EmployeeDao.class);
        namedParameterJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);
    }


    /**
     * 使用具名参数时可以使用 namedParameterJdbcTemplate.update(sql,paramSource);
     * SqlParameterSource paramSource = new BeanPropertySqlParameterSource(object);
     * 可以直接传入一个对象，只要求参数名与类的属性一致即可
     */
    @Test
    public void testNameparameterJdbctemplate() {
        String sql = "INSERT INTO employees(last_name,email,dept_id) " +
                "VALUES(:last_name,:email,:dept_id)";

        Employee employee = new Employee();
        employee.setLast_name("fzq");
        employee.setEmail("1057600474@qq.com");
        employee.setDept_id(1009);

        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql,paramSource);

    }

    /**
     * 有具名参数 可以直接在values后面加 VALUES(:ln,:email,:dept_id)"
     * 1。可以为参数取别名，便于维护
     * 2。
     */

    @Test
    public void testNameparameterJdbcTemplate() {
        String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(:ln,:email,:dept_id)";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("ln", "FF");
        paraMap.put("email", "FF@qq.com");
        paraMap.put("dept_id", "1006");
        namedParameterJdbcTemplate.update(sql, paraMap);

    }

    @Test
    public void testEmployeeGetwithId() {

        System.out.println(employeeDao.get(1));


    }

    /**
     * 获取单个的值，或者坐统计查询
     * queryForObject(sql,<>.class)
     */

    @Test
    public void testQueryForObject2() {


        String sql = "SELECT count(id) From employees";
        long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);

    }


    /**
     * 查询实体类的一组集合  注意调用的不是queryList方法
     * jdbcTemplate.query(sql, rowMapper, args);
     */
    @Test
    public void testQueryForList() {
        String sql = "SELECT id,last_name,email FROM employees WHERE id >?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees =
                (List<Employee>) jdbcTemplate.query(sql, rowMapper, 1);


        System.out.println(employees);
    }


    /**
     * 从数据库中获取一条记录，实际对应的得到一个对象
     * 注意不是调用jdbcTemplate.queryForObject(sql, Employee.class, 1);
     * 其中的RowMapper指定如何去映射结果集的行
     * JdbcTemplate不支持级联属性，只是一个JDBC工具，而不是ORM框架
     */
    @Test
    public void testQueryForObject() {


        String sql = "SELECT id,last_name,email  FROM employees WHERE id=?";
        RowMapper<Employee> rowMap = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMap, 1);
        System.out.println(employee);


    }


    /**
     * 执行批量更新 ：增删改都可以
     * 插入N条记录
     * 最后一个参数是object[]的list类型：因为修改一个记录需要一个object的数组，修改多条则需要对歌object的数组
     */
    @Test
    public void testBatchUpdate() {

        String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"AA", "aa@atguigu,com", 1003});
        batchArgs.add(new Object[]{"BB", "872489709", 1004});

        jdbcTemplate.batchUpdate(sql, batchArgs);

    }

    /**
     * 执行增删改
     */
    @Test
    public void testUpdate() {

        String sql = "UPDATE EMPLOYEES SET last_name = ? WHERE id=?";
        jdbcTemplate.update(sql, "Jack", 1);


    }


    @Test
    public void testDataSource() throws SQLException {

        DataSource dataSource = (DataSource) context.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);


    }


}
