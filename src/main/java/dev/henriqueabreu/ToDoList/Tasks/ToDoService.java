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

}
