package compasso.estoque.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	private String nome;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String descricao;
	
	public Categoria() {
		
	}
	
	public Categoria(String nome, Integer codigo, String descricao) {
		this.nome = nome;
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
}
