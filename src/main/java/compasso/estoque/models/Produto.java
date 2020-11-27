package compasso.estoque.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
	
	private String nome;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal precoUnitario;
	private Integer quantidade;
	private String descricao;
	@ManyToOne
	private Categoria categoria;
	
	public Produto() {
		
	}
	
	public Produto(String nome, String precoUnitario, Integer quantidade, String descricao,
			Categoria categoria) {
		this.nome = nome;
		this.precoUnitario = new BigDecimal(precoUnitario);
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.categoria = categoria;
	}
	

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public String getNomeCategoria() {
		return categoria.getNome();
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPrecoUnitario(String precoUnitario) {
		this.precoUnitario = new BigDecimal(precoUnitario);
	}
	
	

}
