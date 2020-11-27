package compasso.estoque.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import compasso.estoque.models.Loja;

public class LojaDto {

	private String nome;
	private String endereco;
	private String cidade;
	private String cnpj;

	public LojaDto(Loja loja) {

		this.nome = loja.getNome();
		this.endereco = loja.getEndereco();
		this.cidade = loja.getCidade();
		this.cnpj = loja.getCnpj();
	}
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public String getCnpj() {
		return cnpj;
	}
	
	public static List<LojaDto> converter(List<Loja> lojas) {
		return lojas.stream()
				.map(LojaDto::new)
				.collect(Collectors.toList());
	}
	
}
