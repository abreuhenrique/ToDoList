package dev.henriqueabreu.ToDoList.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final ToDoMapper toDoMapper;

    public ToDoService(ToDoRepository toDoRepository, ToDoMapper toDoMapper) {
        this.toDoRepository = toDoRepository;
        this.toDoMapper = toDoMapper;
    }

    public ToDoDTO criarTask(ToDoDTO toDoDTO) {
        ToDoModel toDoModel = toDoMapper.map(toDoDTO);
        toDoRepository.save(toDoModel);
        return toDoMapper.map(toDoModel);
    }

    public List<ToDoDTO> listarTasks() {
        List<ToDoModel> tasks = toDoRepository.findAll();
        return tasks.stream()
                .map(toDoMapper::map)
                .collect(Collectors.toList());
    }

    public ToDoDTO listarId(Long id) {
        Optional<ToDoModel> toDoModel = toDoRepository.findById(id);
        return toDoModel.map(toDoMapper::map).orElse(null);
    }

    public ToDoDTO atualizarTask(Long id, ToDoDTO toDoDTO) {
        Optional<ToDoModel> taskExistente = toDoRepository.findById(id);
        if (taskExistente.isPresent()) {
            ToDoModel task = toDoMapper.map(toDoDTO);
            task.setId(id);
            toDoRepository.save(task);
            return toDoMapper.map(task);
        } else {
            return null;
        }
    }

    public void deletarTask(Long id) {
        toDoRepository.deleteById(id);
    }

}
