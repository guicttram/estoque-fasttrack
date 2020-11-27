package compasso.estoque.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import compasso.estoque.models.Cliente;

public class ClienteForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	@Length(min = 11, max = 11)
	private String cpf;
	private String endereco;
	private String cidade;

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

	public Cliente converter() {
		return new Cliente(nome, cpf, endereco, cidade);
	}

}
