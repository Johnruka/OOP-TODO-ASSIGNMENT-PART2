package se.lexicon.impl;

import se.lexicon.Dao.TodoItemDao;
import se.lexicon.Sequencer.TodoItemSequencer;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;


public class TodoItemDaoImpl implements TodoItemDao {

    ArrayList<TodoItem> todoItems;

    public TodoItemDaoImpl(ArrayList<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        todoItem.setId(TodoItemSequencer.nextId());
        todoItems.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        int todoItemId = 0;
        for (TodoItem todoItem : todoItems) {
            if (todoItem.getId() == todoItemId) {
                return todoItem;
            }
        }
        return null;
    }

    @Override
    public List<TodoItem> findAll() {
        return new ArrayList<>(todoItems);
    }

    @Override
    public List<TodoItem> findAllByDoneStatus(boolean done) {
        ArrayList<TodoItem> doneTodoItems = new ArrayList<>();
        for (TodoItem todoItem : todoItems) {
            if (todoItem.isDone() == done) {
                doneTodoItems.add(todoItem);
            }
        }
        return doneTodoItems;
    }

    @Override
    public List<TodoItem> findByTitleContains(String query) {
        ArrayList<TodoItem> todoItemsWithTitle = new ArrayList<>();
        ArrayList<TodoItem> todoItem = todoItems;
        TodoItem TodoItem = null;
        todoItemsWithTitle.add(TodoItem);
        
        return todoItemsWithTitle;
    }

    @Override
    public ArrayList<Person> findByPersonId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid personId: " + id);
        }
        ArrayList<Person> todoItemsByPersonId = new ArrayList<>();
        for (TodoItem todoItem : todoItems) {
            if (Person.getId() == id) {
                todoItemsByPersonId.add(todoItem.getCreator());
            }
        }
        return todoItemsByPersonId;
    }


    @Override
    public List<TodoItem> findByDeadlineBefore(LocalDate date) {
        ArrayList<TodoItem> todoItemsBeforeDeadline = new ArrayList<>();
        for (TodoItem todoItem : todoItems) {
            ChronoLocalDate end = null;
            if (todoItem.getDeadLine().isBefore(end)) {
                todoItemsBeforeDeadline.add(todoItem);
            }
        }
        return todoItemsBeforeDeadline;
    }

    @Override
    public List<TodoItem> findByDeadlineAfter(LocalDate date) {
        ArrayList<TodoItem> todoItemsAfterDeadline = new ArrayList<>();
        for (TodoItem todoItem : todoItems) {
            ChronoLocalDate start = null;
            if (todoItem.getDeadLine().isAfter(start)) {
                todoItemsAfterDeadline.add(todoItem);
            }
        }
        return todoItemsAfterDeadline;    
    }

    @Override
    public void remove(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid todoItemId: " + id);
        }
        todoItems.removeIf(todoItem -> todoItem.getId() == id);

    }
}
