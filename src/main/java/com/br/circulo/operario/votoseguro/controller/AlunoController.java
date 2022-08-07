package com.br.circulo.operario.votoseguro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.circulo.operario.votoseguro.DTO.AlunoPostDTO;
import com.br.circulo.operario.votoseguro.DTO.AlunoVotoDTO;
import com.br.circulo.operario.votoseguro.entity.Aluno;
import com.br.circulo.operario.votoseguro.exception.AlunoException;
import com.br.circulo.operario.votoseguro.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAllAlunos() {
		return new ResponseEntity<>(alunoService.findAllAlunos(), HttpStatus.OK);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Aluno> findAlunoById(@PathVariable String nome) {
		return new ResponseEntity<>(alunoService.findAlunoByNome(nome), HttpStatus.OK);
	}
	
	@GetMapping("/matricula/{matricula}")
	public ResponseEntity<Aluno> findAlunoByMatricula(@PathVariable String matricula) {
		return new ResponseEntity<>(alunoService.findAlunoByMatricula(matricula), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> postAluno(@RequestBody AlunoPostDTO alunoDTO) throws AlunoException {
		return new ResponseEntity<>(alunoService.postAluno(alunoDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("/voto")
	public ResponseEntity<Aluno> updateVotoAluno(@RequestBody AlunoVotoDTO alunoDTO) throws AlunoException {
		return new ResponseEntity<>(alunoService.updateVotoAluno(alunoDTO), HttpStatus.OK);
	}
}
