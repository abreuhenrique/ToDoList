package dev.henriqueabreu.ToDoList.Tasks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/todo/ui")
public class ToDoControllerUi {

    private final ToDoService toDoService;

    public ToDoControllerUi(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    public String listarTasks(Model model) {
        List<ToDoDTO> tasks = toDoService.listarTasks();
        model.addAttribute("tasks", tasks);
        return "toDoList";
    }

}
