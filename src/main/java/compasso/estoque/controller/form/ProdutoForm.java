package compasso.estoque.controller.form;

import java.math.BigDecimal;

import compasso.estoque.models.Categoria;
import compasso.estoque.models.Produto;
import compasso.estoque.repository.CategoriaRepository;

public class ProdutoForm {

	private String nome;
	private String precoUnitario;
	private Integer quantidade;
	private String descricao;
	private String nomeCategoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPrecoUnitario() {
		return new BigDecimal(precoUnitario);
	}

	public void setPrecoUnitario(String precoUnitario) {
		this.precoUnitario = precoUnitario;
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

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Produto converter(CategoriaRepository categoriaRepository) {
		Categoria categoria = categoriaRepository.findByNome(nomeCategoria);
		return new Produto(nome, precoUnitario, quantidade, descricao, categoria);
	}
	
	

}
