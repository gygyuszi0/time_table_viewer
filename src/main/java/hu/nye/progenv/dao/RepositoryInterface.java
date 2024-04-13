package hu.nye.progenv.dao;

import org.springframework.data.repository.CrudRepository;

import hu.nye.progenv.dao.DBEntity.Lesson;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInterface extends CrudRepository<Lesson, Long> {
}
