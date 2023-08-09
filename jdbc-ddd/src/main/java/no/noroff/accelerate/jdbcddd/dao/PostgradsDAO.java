package no.noroff.accelerate.jdbcddd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PostgradsDAO {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    public void testDatabaseConnection() {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println(String.format("\n>>> Connected to database: %s\n", conn.getMetaData().getURL()));
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public void printAllStudents() {
        String sql = "SELECT * FROM student";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("\n");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
            System.out.println("\n");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public void getStudentById(int id) {
        String sql = "SELECT * FROM student WHERE stud_id = ?";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("\n");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }
            System.out.println("\n");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM student";
        List<Student> result = new ArrayList<Student>();
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3));
                result.add(student);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return result;
    }

    public int insert(Student student) {
        String sql = "INSERT INTO student VALUES (?, ?, ?)";
        int effectedRows = 0;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, student.id());
            statement.setString(2, student.name());
            statement.setInt(3, student.supervisorId());
            effectedRows = statement.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return effectedRows;
    }

}
