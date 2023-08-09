package no.noroff.accelerate.jdbcddd;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import no.noroff.accelerate.jdbcddd.dao.PostgradsDAO;
import no.noroff.accelerate.jdbcddd.dao.Student;

@Component
public class PostgradsService implements ApplicationRunner {

    private final PostgradsDAO pgDao;

    @Autowired
    public PostgradsService(PostgradsDAO pgDao) {
        this.pgDao = pgDao;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // pgDao.testDatabaseConnection();
        // pgDao.printAllStudents();
        // pgDao.getStudentById(6);
        // System.out.println(pgDao.getAllStudents());
        pgDao.printAllStudents();
        pgDao.insert(getStudent());
        pgDao.printAllStudents();
    }

    private Student getStudent() {
        Random random = new Random();
        return new Student(random.nextInt(), "Jane Doe", random.nextInt(1, 3));
    }

}
