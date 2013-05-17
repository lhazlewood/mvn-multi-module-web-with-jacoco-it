package com.leshazlewood.mmwjacoco;

import java.util.List;

/**
 * @since 2013-05-17
 */
public interface TodoService {

    List<Todo> getTodos();

    Todo createTodo(Todo todo);
}
