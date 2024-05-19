package hu.nye.progenv.dao;

import java.util.List;

import hu.nye.progenv.dao.DBEntity.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Lesson} entity.
 */
@Repository
public interface RepositoryInterface extends CrudRepository<Lesson, Long> {
    public List<Lesson> findAllByName(String name);
}
