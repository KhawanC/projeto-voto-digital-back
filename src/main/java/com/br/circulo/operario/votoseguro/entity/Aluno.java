package com.br.circulo.operario.votoseguro.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome", unique = true)
	private String nome;

	@Column(name = "matricula", unique = true)
	private String matricula;

	@Column(name = "chapa")
	private String chapa;

	@Column(name = "voto")
	private boolean voto;

	@Column(name = "horario_votacao")
	private LocalDateTime horarioVotacao;

	public Aluno() {
	}

	public Aluno(Integer id, String nome, String matricula, String chapa, boolean voto, LocalDateTime horarioVotacao) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.chapa = chapa;
		this.voto = voto;
		this.horarioVotacao = horarioVotacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getChapa() {
		return chapa;
	}

	public void setChapa(String chapa) {
		this.chapa = chapa;
	}

	public boolean isVoto() {
		return voto;
	}

	public void setVoto(boolean voto) {
		this.voto = voto;
	}

	public LocalDateTime getHorarioVotacao() {
		return horarioVotacao;
	}

	public void setHorarioVotacao(LocalDateTime horarioVotacao) {
		this.horarioVotacao = horarioVotacao;
	}

}
