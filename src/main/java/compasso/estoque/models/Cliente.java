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
	private String cep;
	
	public Cliente() {
		
	}
//	
//	public Cliente(String nome, String cpf, String endereco, String cep) {
//		this.nome = nome;
//		this.cpf = cpf;
//		this.endereco = endereco;
//		this.cidade = cep.getCidade();
//		this.cep = cep;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String string) {
		this.cep = string;
	}

	
	

}
