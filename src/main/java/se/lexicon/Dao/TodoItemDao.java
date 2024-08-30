package se.lexicon.Dao;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface TodoItemDao {

    TodoItem persist(TodoItem todoItem);
    TodoItem findById(int id);
    List<TodoItem> findAll();
    List<TodoItem> findAllByDoneStatus(boolean done);
    List<TodoItem> findByTitleContains(String query);
    ArrayList<Person> findByPersonId(int id);
    List<TodoItem> findByDeadlineBefore(LocalDate date);
    List<TodoItem> findByDeadlineAfter(LocalDate date);
    void remove(int id);
}
