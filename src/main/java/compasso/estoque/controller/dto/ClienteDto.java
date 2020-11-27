package compasso.estoque.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import compasso.estoque.models.Cliente;

public class ClienteDto {
	
	private String nome;
	private String cpf;
	private String endereco;
	private String cidade;
	
	public ClienteDto(Cliente cli) {
		this.nome = cli.getNome();
		this.cpf = cli.getCpf();
		this.endereco = cli.getEndereco();
		this.cidade = cli.getCidade();
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public static ClienteDto converter(Cliente cliente) {
		return new ClienteDto(cliente);
	}
	public static List<ClienteDto> converterLista(List<Cliente> clientes) {
		return clientes.stream()
				.map(ClienteDto::new)
				.collect(Collectors.toList());
	}
	
	
}
