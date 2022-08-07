package com.br.circulo.operario.votoseguro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.circulo.operario.votoseguro.DTO.AlunoPostDTO;
import com.br.circulo.operario.votoseguro.DTO.AlunoVotoDTO;
import com.br.circulo.operario.votoseguro.entity.Aluno;
import com.br.circulo.operario.votoseguro.exception.AlunoException;
import com.br.circulo.operario.votoseguro.exception.NoSuchElementFoundException;
import com.br.circulo.operario.votoseguro.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public List<Aluno> findAllAlunos() {
		List<Aluno> listaAlunos = alunoRepository.findAll();
		return listaAlunos;
	}
	
	public Aluno findAlunoByNome(String nome) {
		List<Aluno> listaAlunos = alunoRepository.findByNome(nome);
		if(listaAlunos.isEmpty()) {
			throw new NoSuchElementFoundException("Não encontramos o aluno com o nome " + nome);
		} else {
			Aluno aluno = listaAlunos.get(0);
			return aluno;
		}
	}
	
	public Aluno findAlunoByMatricula(String matricula) {
		List<Aluno> listaAlunos = alunoRepository.findByMatricula(matricula);
		if(listaAlunos.isEmpty()) {
			throw new NoSuchElementFoundException("Não encontramos o aluno com a matricula " + matricula);
		} else {
			Aluno aluno = listaAlunos.get(0);
			return aluno;
		}
	}
 
	
	public Aluno postAluno(AlunoPostDTO alunoDTO) throws AlunoException {
		List<Aluno> listaMatricula = alunoRepository.findByNome(alunoDTO.getNome());
		List<Aluno> listaNome = alunoRepository.findByNome(alunoDTO.getNome());
		
		if(!listaMatricula.isEmpty() || !listaNome.isEmpty()) {
			throw new AlunoException("Esse aluno já foi matriculado");
		} else {
			return alunoRepository.save(DTOtoEntityPost(alunoDTO));
		}
	}
	
	public Aluno updateVotoAluno(AlunoVotoDTO alunoDTO) throws AlunoException {
		List<Aluno> listaAlunos = alunoRepository.findByMatricula(alunoDTO.getMatricula());
		if(listaAlunos.isEmpty()) {
			throw new NoSuchElementFoundException("Não encontramos o aluno com a matricula " + alunoDTO.getMatricula());
		} else if(listaAlunos.get(0).isVoto()) {
			throw new AlunoException("Esse aluno já votou, por favor, chame a coordenação");
		} else {
			Aluno aluno = listaAlunos.get(0);
			aluno.setChapa(alunoDTO.getChapa());
			aluno.setVoto(true);
			aluno.setHorarioVotacao(LocalDateTime.now());
			return alunoRepository.save(aluno);
			
		}
	}
	
	private Aluno DTOtoEntityPost(AlunoPostDTO alunoDTO) {
		Aluno aluno = new Aluno();
		
		aluno.setMatricula(alunoDTO.getMatricula());
		aluno.setNome(alunoDTO.getNome());
		aluno.setVoto(false);
		
		return aluno;
	}
}
