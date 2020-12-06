package compasso.estoque.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class LojaForm {

	@NotNull @NotEmpty
	private String nome;

	@NotNull @NotEmpty @Length(min = 14, max = 14)
	private String cnpj;
	
	@NotNull @NotEmpty
	private String numero;
	
	@NotNull @NotEmpty @Length(min = 8, max = 8)
	private String cep;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	
	
}
