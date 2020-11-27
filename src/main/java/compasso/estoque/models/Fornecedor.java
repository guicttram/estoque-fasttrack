package compasso.estoque.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fornecedor {

	@Id
	private String nome;
	private String endereco;
	
	public Fornecedor(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Fornecedor() {
		
	}
	
	
}
