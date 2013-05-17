package com.leshazlewood.mmwjacoco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryTodoService implements TodoService {

    private final List<Todo> todos;

    public InMemoryTodoService() {
        this.todos = new CopyOnWriteArrayList<Todo>();
    }

    public List<Todo> getTodos() {
        return Collections.unmodifiableList(new ArrayList<Todo>(this.todos));
    }

    public Todo createTodo(Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        todos.add(todo);
        return todo;
    }
}
