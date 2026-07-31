package dev.henriqueabreu.ToDoList.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;

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

}
