package hu.nye.progenv.repository;

import org.springframework.data.repository.CrudRepository;

import hu.nye.progenv.repository.DBEntity.Lesson;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInterface extends CrudRepository<Lesson, Long> {
}
