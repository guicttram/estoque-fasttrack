package compasso.estoque.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ClienteForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	@Length(min = 11, max = 11)
	private String cpf;
	
	@NotNull
	@NotEmpty
	private String numero;
	
	@NotNull
	@NotEmpty
	@Length(min = 8, max = 8)
	private String cep;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
