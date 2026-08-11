package dev.henriqueabreu.ToDoList.Tasks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/todo/ui")
public class ToDoControllerUi {

    private final ToDoService toDoService;

    public ToDoControllerUi(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/listar")
    public String listarTasks(Model model) {
        List<ToDoDTO> tasks = toDoService.listarTasks();
        model.addAttribute("tasks", tasks);
        return "toDoList";
    }

    @GetMapping("/criar")
    public String criarToDo(Model model) {
        model.addAttribute("toDo", new ToDoDTO());
        return "criarToDo";
    }

    @PostMapping("/salvar")
    public String salvarToDo(@ModelAttribute ToDoDTO toDo, RedirectAttributes redirectAttributes) {
        toDoService.criarTask(toDo);
        redirectAttributes.addAttribute("mensagem", "Task adicionada!");
        return "redirect:/todo/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String verDetalhes(@PathVariable Long id, Model model) {
        ToDoDTO toDo = toDoService.listarId(id);

        if (toDo != null) {
            model.addAttribute("todo", toDo);
            return "detalhesTask";
        }
        else {
            model.addAttribute("mensagem", "Task não encontrada.");
            return "toDoList";
        }
    }

    @GetMapping("/atualizar/{id}")
    public String atualizarTask(@PathVariable Long id, Model model) {
        ToDoDTO todo = toDoService.listarId(id);
        if (todo == null) {
            return "redirect:/todo/ui/listar";
        }
        model.addAttribute("todo", todo);
        return "atualizarTask";
    }

    @PostMapping("/salvar-atualizacao/{id}")
    public String salvarAtualizacao(@PathVariable Long id, @ModelAttribute("todo") ToDoDTO toDoDTO) {
        toDoService.atualizarTask(id, toDoDTO);
        return "redirect:/todo/ui/listar";
    }

    @GetMapping("/concluir/{id}")
    public String concluirTask(@PathVariable Long id) {
        toDoService.concluirTask(id);
        return "redirect:/todo/ui/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluirTask(@PathVariable Long id) {
        toDoService.deletarTask(id);
        return "redirect:/todo/ui/listar";
    }

}
