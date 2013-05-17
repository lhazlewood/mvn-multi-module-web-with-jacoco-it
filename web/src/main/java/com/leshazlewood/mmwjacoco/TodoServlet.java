package com.leshazlewood.mmwjacoco;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class TodoServlet extends HttpServlet {

    private final TodoService todoService;

    public TodoServlet() {
        super();
        this.todoService = new InMemoryTodoService();

        //simulate some data to satisfy the get request:
        this.todoService.createTodo(new Todo("Get shit done."));
        this.todoService.createTodo(new Todo("Grab a beer."));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");

        PrintWriter pw = resp.getWriter();

        pw.println("{");
        pw.println("  " + quote("items") + ": [");

        Collection<Todo> todos = todoService.getTodos();

        Iterator<Todo> i = todos.iterator();

        while (i.hasNext()) {
            Todo todo = i.next();

            pw.println("    {");
            pw.println("      " + quote("id") + ": " + quote(todo.getId()) + ",");
            pw.println("      " + quote("title") + ": " + quote(todo.getTitle()) + ",");
            pw.println("      " + quote("completed") + ": " + todo.isComplete());
            pw.print("    }");
            if (i.hasNext()) {
                pw.print(",");
            }
            pw.println();
        }

        pw.println("  ]");
        pw.println("}");
    }

    private static String quote(String value) {
        return "\"" + value + "\"";
    }
}
