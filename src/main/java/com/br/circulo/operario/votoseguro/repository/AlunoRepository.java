package com.br.circulo.operario.votoseguro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.circulo.operario.votoseguro.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	List<Aluno> findByNome(String nome);
	List<Aluno> findByMatricula(String matricula);
}
