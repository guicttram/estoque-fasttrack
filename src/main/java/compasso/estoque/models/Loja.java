package compasso.estoque.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Loja {
	
	private String nome;
	private String endereco;
	private String cidade;
	private String cep;
	@Id
	private String cnpj;
	
	@Override
	public String toString() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public Loja() {
		
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	

}
