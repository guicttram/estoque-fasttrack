package compasso.estoque.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import compasso.estoque.models.Cliente;
import compasso.estoque.repository.ClienteRepository;

public class AtualizarClienteForm {

	@NotEmpty
	@NotNull
	private String endereco;
	private String cidade;

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

	public Cliente atualizar(String cpf, ClienteRepository clienteRepository) {
		Cliente cli = clienteRepository.getOne(cpf);
		cli.setEndereco(this.endereco);
		cli.setCidade(this.cidade);
		return cli;
	}


}
