package hu.nye.progenv.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import hu.nye.progenv.model.Lesson;

@Repository
@PropertySource("application.properties")
public class DataBaseRepository implements RepositoryInterface {


//    private final Connection connection;

    @Autowired
    @Value("${repository.url}")
    private String dbUrl;


    public DataBaseRepository() throws DBServiceException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new DBServiceException("SQLite JDBC Driver nem található.");
        }
        System.out.println("Repository url : " + dbUrl);

//        try {
//            connection = DriverManager.getConnection(dbUrl);
//        } catch (Exception e) {
//            throw new DBServiceException("Can not connect to database");
//        }

    }

    @Override
    public void connectDataBase() {
        System.out.println("Repository url : " + dbUrl);
    }

    @Override
    public void createLesson(Lesson lesson) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createLesson'");
    }

    @Override
    public void deleteLesson(Lesson lesson) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteLesson'");
    }

    @Override
    public void updateLesson(Lesson lesson) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateLesson'");
    }

    @Override
    public Lesson getLesson(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLesson'");
    }

    @Override
    public List<Lesson> getAllLessons() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllLessons'");
    }

 
}
