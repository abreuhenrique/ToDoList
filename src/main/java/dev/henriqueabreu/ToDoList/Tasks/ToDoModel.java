package dev.henriqueabreu.ToDoList.Tasks;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_todo")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate prazo;

    @Enumerated(EnumType.STRING)

    private StatusTask status;

    private String descricao;
}
