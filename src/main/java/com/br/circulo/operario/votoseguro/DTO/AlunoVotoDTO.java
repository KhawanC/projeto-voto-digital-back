package com.br.circulo.operario.votoseguro.DTO;

public class AlunoVotoDTO {

	private String matricula;
	private String chapa;

	public AlunoVotoDTO() {
	}

	public AlunoVotoDTO(String matricula, String chapa) {
		super();
		this.matricula = matricula;
		this.chapa = chapa;
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

}
