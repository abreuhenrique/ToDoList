package dev.henriqueabreu.ToDoList.Tasks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @GetMapping("/sobre")
    public String sobre() {
        return "Bem vindo ao seu TODO List, que vai te ajudar a organizar suas tarefas de forma simples e fácil!";
    }

}
