package JDBC;


public class Employee {


    private int id;
    private String last_name;
    private String email;


    private Integer dept_id;

    public Employee() {
    }

    public Employee(int id, String last_name, String email, Integer dept_id) {
        this.id = id;
        this.last_name = last_name;
        this.email = email;
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", dept_id=" + dept_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emails) {
        this.email = emails;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }
}
