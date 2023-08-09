package no.noroff.accelerate.jdbcddd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import no.noroff.accelerate.jdbcddd.dao.PostgradsDAO;

@Component
public class PostgradsService implements ApplicationRunner {

    private final PostgradsDAO pgDao;

    @Autowired
    public PostgradsService(PostgradsDAO pgDao) {
        this.pgDao = pgDao;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        pgDao.testDatabaseConnection();
    }

}
