package br.com.academy.funcionarios.funcionarioControler;

import br.com.academy.funcionarios.entidade.Funcionario;
import br.com.academy.funcionarios.funcionarioService.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }
    @GetMapping("/")
    public String exibirPagina() {
        return "Index";
    }
    @GetMapping("/cadastro")
    public String exibirCadastro() {
        return "cadOpcoes";
    }
    @GetMapping("/listagem")
    public String exibirListas() {
        return "listaOpcoes";
    }
    @GetMapping("/cadastroVeiculos")
    public String opcaoVeiculos() {
        return "cadastro";
    }

    @GetMapping("/atualizar/{matricula}")
    public String Atualizar(@PathVariable Long matricula, Model model) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorMatricula(matricula);
        model.addAttribute("funcionario", funcionario);
        return "atualizarFun";
    }

    @GetMapping("/ListarFuncionarios")
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioService.listarTodosFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "listagemFuncionarios";
    }

    @GetMapping("/detalhes/{matricula}")
    public String exibirDetalhesFuncionario(@PathVariable long matricula, Model model) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorMatricula(matricula);
        model.addAttribute("funcionario", funcionario);
        return "DetalhesDoFuncionario";
    }
    @GetMapping("/FuncionariosForm")
    public String exibirFormulario(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "cadastroFun";
    }
    @PostMapping("/salvar")
    public String salvarFuncionario(@ModelAttribute Funcionario funcionario) {
        funcionarioService.salvarFuncionario(funcionario);
        return "redirect:/ListarFuncionarios";
    }
    @PostMapping("/atualizar")
    public String processarAtualizacao(@ModelAttribute Funcionario funcionario) {
        funcionarioService.atualizarFuncionario(funcionario);
        return "redirect:/ListarFuncionarios";
    }
    @GetMapping("/excluir/{matricula}")
    public String excluirFuncionario(@PathVariable String matricula) {
        try {
            long matriculaLong = Long.parseLong(matricula);
            funcionarioService.excluirFuncionarioPorMatricula(matriculaLong);
            return "redirect:/ListarFuncionarios";
        } catch (NumberFormatException e) {
            return "redirect:/ListarFuncionarios";
        }
    }
}

