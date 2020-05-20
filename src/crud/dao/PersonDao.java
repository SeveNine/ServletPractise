package crud.dao;

import crud.dao.bean.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 人员信息Dao
 * created by xu-jp on 2020/5/9
 **/
public class PersonDao {
    // 构造函数初始化驱动
    public PersonDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 获取连接
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/servlet_practise?characterEncoding=UTF-8", "root",
                "root");
    }
    //新增
    public void add(Person person) {

        String sql = "insert into person values(null,?,?,?,?,?,?)";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {

            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.setInt(3, person.getGender());
            ps.setDate(4,  person.getBirthday());
            ps.setString(5, person.getMobile());
            ps.setString(6, person.getHome());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            // 将id回写到person中
            if (rs.next()) {
                int id = rs.getInt(1);
                person.setId(id);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    // 列表
    public List<Person> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Person> list(int start, int count) {
        List<Person> Persons = new ArrayList<Person>();

        String sql = "select * from person order by id desc limit ?,? ";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Person Person = new Person();
                Person.setId(rs.getInt(1));
                Person.setName(rs.getString(2));
                Person.setAge(rs.getInt(3));
                Person.setGender(rs.getInt(4));
                Person.setBirthday(rs.getDate(5));
                Person.setMobile(rs.getString(6));
                Person.setHome(rs.getString(7));
                Persons.add(Person);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return Persons;
    }

    // 删除
    public void delete(int id) {

        try (Connection c = getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from person where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Person get(int id) {
        Person person = new Person();

        try (Connection c = getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from person where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                person.setId(rs.getInt(1));
                person.setName(rs.getString(2));
                person.setAge(rs.getInt(3));
                person.setGender(rs.getInt(4));
                person.setBirthday(rs.getDate(5));
                person.setMobile(rs.getString(6));
                person.setHome(rs.getString(7));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return person;
    }
    
    // 更新
    public void update(Person person) {

        String sql = "update person set name= ?, age = ? , gender = ? , birthday = ? , mobile = ? , home = ? where id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.setInt(3, person.getGender());
            ps.setDate(4,  person.getBirthday());
            ps.setString(5, person.getMobile());
            ps.setString(6, person.getHome());
            ps.setInt(7, person.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}
