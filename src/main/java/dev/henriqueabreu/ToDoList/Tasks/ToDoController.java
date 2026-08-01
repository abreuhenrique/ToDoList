package dev.henriqueabreu.ToDoList.Tasks;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "Bem vindo ao seu TODO List, que vai te ajudar a organizar suas tarefas de forma simples e fácil!";
    }

    @PostMapping("/criar")
    public String criar(@RequestBody ToDoModel toDoModel) {
        toDoService.criarTask(toDoModel);
        return "Task criada com sucesso!";
    }

    @GetMapping("/listar")
    public List<ToDoModel> listar() {
        return toDoService.listarTasks();
    }

    @GetMapping("/listar/{id}")
    public ToDoModel listarId(@PathVariable Long id) {
        return toDoService.listarID(id);
    }

    @PutMapping("/atualizar/{id}")
    public String atualizarTask(@PathVariable Long id, @RequestBody ToDoModel toDoModel) {
        return toDoService.atualizarTask(id, toDoModel);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarTask(@PathVariable Long id) {
        return toDoService.deletarTask(id);
    }
 
}
