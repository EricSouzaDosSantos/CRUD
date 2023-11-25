package br.com.academy.funcionarios.funcionarioService;


import br.com.academy.funcionarios.FuncionarioRepository.FuncionarioRepository;
import br.com.academy.funcionarios.entidade.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarFuncionarioPorMatricula(long matricula) {
        return funcionarioRepository.findById(matricula).orElse(null);
    }

    public void salvarFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }
    public void atualizarFuncionario(Funcionario funcionario) {
        Long matricula = funcionario.getMatricula();
        if (matricula != null && funcionarioRepository.existsById(matricula)) {
            // Evitar a atualização da matrícula
            Funcionario funcionarioExistente = funcionarioRepository.getOne(matricula);
            funcionarioExistente.setNome(funcionario.getNome());
            funcionarioExistente.setEmail(funcionario.getEmail());
            funcionarioExistente.setTelefone(funcionario.getTelefone());
            funcionarioExistente.setCargo(funcionario.getCargo());
            funcionarioRepository.save(funcionarioExistente);
        } else {
            throw new RuntimeException("Funcionário não encontrado ou matrícula inválida.");
        }
    }

    public void excluirFuncionarioPorMatricula(long matricula) {
        funcionarioRepository.deleteById(matricula);
    }

}
