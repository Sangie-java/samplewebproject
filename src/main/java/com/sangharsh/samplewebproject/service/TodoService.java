package com.sangharsh.samplewebproject.service;

import com.sangharsh.samplewebproject.mode.Todo;
import org.eclipse.jdt.internal.compiler.codegen.FloatCache;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "sangharsh", "Learn Spring MVC", LocalDate.now(),
                false));
        todos.add(new Todo(2, "sangharsh", "Learn SpringBoot", LocalDate.now(), false));
        todos.add(new Todo(3, "sangharsh", "Learn SpringBootJPA", LocalDate.now(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addTodo(String name, String desc, LocalDate targetDate,
                        boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}
