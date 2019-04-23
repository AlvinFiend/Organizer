package com.app.controller;

import com.app.domain.Task;
import com.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApplicationController {

    private final TaskService taskService;

    @Autowired
    public ApplicationController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("task", new Task());
        return "addTask";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Task task){
        taskService.save(task);
        return "result";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("tasks", taskService.getAll());
        return "list";
    }

    @RequestMapping(value = "/remove_task/{taskId}", method = RequestMethod.GET)
    public String remove(@PathVariable("taskId") String taskId){
        taskService.removeById(taskId);
        return "redirect:/list";
    }
}