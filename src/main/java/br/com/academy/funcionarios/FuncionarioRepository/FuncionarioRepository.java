package br.com.academy.funcionarios.FuncionarioRepository;

import br.com.academy.funcionarios.entidade.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}