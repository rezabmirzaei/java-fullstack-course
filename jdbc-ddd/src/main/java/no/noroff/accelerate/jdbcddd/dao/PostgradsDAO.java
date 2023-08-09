package no.noroff.accelerate.jdbcddd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

}
