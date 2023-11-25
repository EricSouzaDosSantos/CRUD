package br.com.academy.funcionarios.entidade;

import jakarta.persistence.*;



@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricula")
    private Long matricula;

    @Column(length = 50)
    private String nome;


    @Column(length = 30)
    private String email;

    @Column(length = 15)
    private String telefone;

    @Column(length = 30)
    private String cargo;


    public Funcionario() {
    }


    public Funcionario(Long matricula, String nome, String email, String telefone, String cargo) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
