package dev.henriqueabreu.ToDoList.Tasks;

import org.springframework.stereotype.Component;

@Component
public class ToDoMapper {

    public ToDoModel map(ToDoDTO toDoDTO) {

        ToDoModel toDoModel = new ToDoModel();

        toDoModel.setId(toDoDTO.getId());
        toDoModel.setNome(toDoDTO.getNome());
        toDoModel.setPrazo(toDoDTO.getPrazo());
        toDoModel.setDescricao(toDoDTO.getDescricao());
        toDoModel.setStatus(toDoDTO.getStatus());

        return toDoModel;
    }

    public ToDoDTO map(ToDoModel toDoModel) {

        ToDoDTO toDoDTO = new ToDoDTO();

        toDoDTO.setId(toDoModel.getId());
        toDoDTO.setNome(toDoModel.getNome());
        toDoDTO.setDescricao(toDoModel.getDescricao());
        toDoDTO.setPrazo(toDoModel.getPrazo());
        toDoDTO.setStatus(toDoModel.getStatus());

        return toDoDTO;

    }

}
