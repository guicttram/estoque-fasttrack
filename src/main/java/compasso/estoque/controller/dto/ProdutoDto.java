package compasso.estoque.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import compasso.estoque.models.Categoria;
import compasso.estoque.models.Produto;

public class ProdutoDto {

	private String nome;
	private Long id;
	private BigDecimal precoUnitario;
	private Integer quantidade;
	private String descricao;
	private Categoria categoria;
	
	public ProdutoDto(Produto produto) {
		this.nome = produto.getNome();
		this.id = produto.getId();
		this.precoUnitario = produto.getPrecoUnitario();
		this.quantidade = produto.getQuantidade();
		this.descricao = produto.getDescricao();
		this.categoria = produto.getCategoria();
	}

	public String getNome() {
		return nome;
	}

	public Long getCodigo() {
		return id;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public static ProdutoDto converter(Produto prod) {
		return new ProdutoDto(prod);
	}
	
	public static List<ProdutoDto> converterLista(List<Produto> produtos) {
		return produtos.stream()
				.map(ProdutoDto::new)
				.collect(Collectors.toList());
	}
	
	
}
