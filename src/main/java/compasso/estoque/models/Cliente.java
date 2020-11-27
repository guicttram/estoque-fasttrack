package compasso.estoque.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	private String nome;
	@Id
	private String cpf;
	private String endereco;
	private String cidade;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf, String endereco, String cidade) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCpf() {
		return this.cpf;
	}
	
	

}
