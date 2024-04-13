package hu.nye.progenv.dao;

import org.springframework.data.repository.CrudRepository;

import hu.nye.progenv.dao.DBEntity.Lesson;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryInterface extends CrudRepository<Lesson, Long> {

    public List<Lesson> findAllByName(String name);
}
