package compasso.estoque.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;

import compasso.estoque.client.response.ViaCepResponse;
import compasso.estoque.models.Cliente;
import compasso.estoque.models.Loja;
import compasso.estoque.repository.ClienteRepository;
import compasso.estoque.repository.LojaRepository;

public class AtualizarForm {
	
	@NotNull
	@NotEmpty
	@Length(min = 8, max = 8)
	private String cep;
	
	@NotNull
	@NotEmpty
	private String numero;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

	public Cliente atualizarCliente(String cpf, ClienteRepository clienteRepository, ResponseEntity<ViaCepResponse> buscaCep) {
		Cliente cli = clienteRepository.getOne(cpf);
		cli.setEndereco(buscaCep.getBody().getLogradouro() + ", " + this.numero);
		cli.setCidade(buscaCep.getBody().getLocalidade());
		return cli;
	}
	
	public Loja atualizarLoja(String cnpj, LojaRepository lojaRepository, ResponseEntity<ViaCepResponse> buscaCep) {
		Loja loja = lojaRepository.getOne(cnpj);
		loja.setEndereco(buscaCep.getBody().getLogradouro() + ", " + this.numero);
		loja.setCidade(buscaCep.getBody().getLocalidade());
		return loja;
	}


}
