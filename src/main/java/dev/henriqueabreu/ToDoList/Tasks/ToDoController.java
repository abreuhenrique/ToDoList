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
                .body("Task adicionada ao ToDoList!");
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        if (toDoService.listarTasks().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma task foi encontrada.");
        } else {
            return ResponseEntity.ok(toDoService.listarTasks());
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarId(@PathVariable Long id) {
        if (toDoService.listarId(id) != null) {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(toDoService.listarId(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Task não encontrada.");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarTask(@PathVariable Long id, @RequestBody ToDoDTO toDoDTO) {
        toDoService.atualizarTask(id, toDoDTO);
        return ResponseEntity.ok("Task atualizada com sucesso!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarTask(@PathVariable Long id) {
        toDoService.deletarTask(id);
        return ResponseEntity.ok("Task deletada.");
    }
 
}
