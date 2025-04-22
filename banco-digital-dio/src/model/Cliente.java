package model;

public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	
	//CONSTRUCTOR
	public Cliente(String nome, String cpf, String dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}
	
	
}
