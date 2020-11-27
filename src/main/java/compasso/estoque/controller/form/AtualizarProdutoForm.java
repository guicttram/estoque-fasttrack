package compasso.estoque.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import compasso.estoque.models.Produto;
import compasso.estoque.repository.ProdutoRepository;

public class AtualizarProdutoForm {

	@NotNull @NotEmpty
	private String precoUnitario;
	@NotNull
	private Integer quantidade;
	@NotNull @NotEmpty
	private String descricao;

	public String getPrecoUnitario() {
		return precoUnitario;
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
	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
		Produto prod = produtoRepository.getOne(id);
		prod.setPrecoUnitario(this.precoUnitario);
		prod.setQuantidade(this.quantidade);
		prod.setDescricao(this.descricao);
		return prod;
	}
	
	

}
