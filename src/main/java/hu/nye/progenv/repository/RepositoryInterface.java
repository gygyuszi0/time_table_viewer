package hu.nye.progenv.repository;

import java.util.List;

import hu.nye.progenv.model.Lesson;
public interface RepositoryInterface {

    public void createLesson(Lesson lesson);
    public void deleteLesson(Lesson lesson);
    public void updateLesson(Lesson lesson);
    public Lesson getLesson(int id);
    public List<Lesson> getAllLessons();
}
