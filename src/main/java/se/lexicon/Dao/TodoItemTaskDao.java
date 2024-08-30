package se.lexicon.Dao;

import se.lexicon.model.Person;

import java.util.List;

public interface TodoItemTaskDao {

    TodoItemTaskDao persist(TodoItemTaskDao todoItemTask);
    TodoItemTaskDao findById(int id);
    List<TodoItemTaskDao> findAll();
    List<TodoItemTaskDao> findByAssignedStatus(boolean assignedStatus);
    List<TodoItemTaskDao> findByPersonId(int id);
    TodoItemTaskDao addAssignee(int idTask, Person person);
    TodoItemTaskDao removeAssignee(int idTask);
    void remove(int id);
}
