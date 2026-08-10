package dev.henriqueabreu.ToDoList.Tasks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criar(@RequestBody ToDoDTO toDoDTO) {
        toDoService.criarTask(toDoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Task criada!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ToDoDTO>> listar() {
        List<ToDoDTO> toDo = toDoService.listarTasks();
        return ResponseEntity.ok(toDo);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarId(@PathVariable Long id) {
        ToDoDTO task = toDoService.listarId(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Task não encontrada.");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarTask(@PathVariable Long id, @RequestBody ToDoDTO toDoDTO) {
        ToDoDTO taskAtualizada = toDoService.atualizarTask(id, toDoDTO);
        return ResponseEntity.ok("Task atualizada!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarTask(@PathVariable Long id) {
        toDoService.deletarTask(id);
        return ResponseEntity.ok("Task Deletada");
    }

    @PatchMapping("/concluir/{id}")
    public ResponseEntity<String> concluirTask(@PathVariable Long id, @RequestBody ToDoDTO toDoDTO) {
        toDoService.concluirTask(id, toDoDTO);
        return ResponseEntity.ok("Task concluída");
    }
 
}
