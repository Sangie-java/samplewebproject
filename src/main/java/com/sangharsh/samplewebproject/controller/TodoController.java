package com.sangharsh.samplewebproject.controller;

import com.sangharsh.samplewebproject.mode.Todo;
import com.sangharsh.samplewebproject.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService service;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap modelMap) {
        String name = getLoggedInUser();
        modelMap.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }

    private String getLoggedInUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap modelMap) {
        modelMap.addAttribute("todo", new Todo(0, getLoggedInUser(), "too lazy to think of something", new Date(), false));
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        service.addTodo(getLoggedInUser(), todo.getDesc(), todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        if(id==5){
            throw new RuntimeException();
        }
        service.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap modelMap) {
        Todo todo = service.retrieveTodos(id);
        modelMap.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUser(getLoggedInUser());
        service.updateTodo(todo);
        return "redirect:/list-todos";
    }

    @InitBinder
    public void fieldBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
