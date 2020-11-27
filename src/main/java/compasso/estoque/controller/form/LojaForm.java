package compasso.estoque.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import compasso.estoque.models.Loja;

public class LojaForm {

	@NotNull @NotEmpty
	private String nome;
	private String endereco;
	private String cidade;
	@NotNull @NotEmpty @Length(min = 14, max = 14)
	private String cnpj;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Loja converter() {
		return new Loja(nome, endereco, cidade, cnpj);
	}
	
	
}
