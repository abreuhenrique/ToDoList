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
    public ToDoDTO criar(@RequestBody ToDoDTO toDoDTO) {
        toDoService.criarTask(toDoDTO);
        return toDoDTO;
    }

    @GetMapping("/listar")
    public List<ToDoDTO> listar() {
        return toDoService.listarTasks();
    }

    @GetMapping("/listar/{id}")
    public ToDoDTO listarId(@PathVariable Long id) {
        return toDoService.listarId(id);
    }

    @PutMapping("/atualizar/{id}")
    public ToDoDTO atualizarTask(@PathVariable Long id, @RequestBody ToDoDTO toDoDTO) {
        return toDoService.atualizarTask(id, toDoDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarTask(@PathVariable Long id) {
        return toDoService.deletarTask(id);
    }
 
}
