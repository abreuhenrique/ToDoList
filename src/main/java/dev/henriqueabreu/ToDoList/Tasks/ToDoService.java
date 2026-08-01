package dev.henriqueabreu.ToDoList.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public void criarTask(ToDoModel toDoModel) {
        toDoRepository.save(toDoModel);
    }

    public List<ToDoModel> listarTasks() {
        return toDoRepository.findAll();
    }

    public ToDoModel listarID(Long id) {
        Optional<ToDoModel> taskId = toDoRepository.findById(id);
        return taskId.orElse(null);
    }

    public String atualizarTask(Long id, ToDoModel toDoModel) {
        if (toDoRepository.findById(id).isPresent()) {
            ToDoModel task = toDoModel;
            task.setId(id);
            toDoRepository.save(task);
            return "Task atualizada com sucesso!";
        } else {
            return "Task não encontrada";
        }
    }
}
