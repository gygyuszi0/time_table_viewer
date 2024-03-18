package hu.nye.progenv.repository;

import org.springframework.data.repository.CrudRepository;

import hu.nye.progenv.repository.DBEntity.Lesson;

public interface RepositoryInterface extends CrudRepository<Lesson, Long> {

    
}
