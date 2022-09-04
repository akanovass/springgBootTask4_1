package bitlab.spring.springtask4_1.controllers;

import bitlab.spring.springtask4_1.db.DBUtil;
import bitlab.spring.springtask4_1.db.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model){
        ArrayList<Task> tasks = DBUtil.getTasks();
        model.addAttribute("taskList",tasks);

        return "index";
    }
    @GetMapping("/details/{id}")
    public String getDetails(@PathVariable(name="id") Long id,
                             Model model){
        Task task = DBUtil.getTaskByID(id);
        model.addAttribute("task", task);

        return "details";
    }
    @PostMapping("/add")
    public String addTask(@RequestParam(name="name") String name,
                          @RequestParam(name="description") String description,
                          @RequestParam(name = "date") String date){
        Task task = new Task();
        task.setId(DBUtil.getIndex());
        task.setName(name);
        task.setDeadlineDate(date);
        task.setCompleted(false);
        task.setDescription(description);

        DBUtil.addTask(task);

        return "redirect:/";
    }
    @PostMapping("/edit")
    public String addTask(@RequestParam(name="id") Long id,
                          @RequestParam(name="name") String name,
                          @RequestParam(name="description") String description,
                          @RequestParam(name = "date") String date,
                          @RequestParam(name="completed") boolean completed){
        DBUtil.edit(id,name,date,completed,description);

        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id){
        DBUtil.delete(id);

        return "redirect:/";
    }
}
