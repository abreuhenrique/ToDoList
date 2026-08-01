package dev.henriqueabreu.ToDoList.Tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDoDTO {

    private Long id;
    private String nome;
    private LocalDate prazo;
    private StatusTask status;
    private String descricao;

}
