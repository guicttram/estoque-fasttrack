package compasso.estoque.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import compasso.estoque.client.ViaCepClient;
import compasso.estoque.client.response.ViaCepResponse;
import compasso.estoque.controller.dto.ClienteDto;
import compasso.estoque.controller.form.AtualizarForm;
import compasso.estoque.controller.form.ClienteForm;
import compasso.estoque.models.Cliente;
import compasso.estoque.repository.ClienteRepository;
import compasso.estoque.service.ClienteServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ViaCepClient viaCepClient;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<ClienteDto> lista() {

		List<Cliente> clientes = clienteRepository.findAll();
		return ClienteDto.converterLista(clientes);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
	
		ResponseEntity<ViaCepResponse> buscaCep = viaCepClient.buscaCep(form.getCep());
		Cliente cliente = new ClienteServiceImpl().criaCliente(form, buscaCep);	
		clienteRepository.save(cliente);

		URI uri = uriBuilder.path("/clientes/{cpf}").buildAndExpand(cliente.getCpf()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}

	@GetMapping("/{cpf}")
	public ClienteDto detalhar(@PathVariable String cpf) {

		Cliente cliente = clienteRepository.getOne(cpf);
		return ClienteDto.converter(cliente);

	}

	@PutMapping("/{cpf}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizar(@PathVariable String cpf,
			@RequestBody @Valid AtualizarForm form) {
		ResponseEntity<ViaCepResponse> buscaCep = viaCepClient.buscaCep(form.getCep());
		Cliente cli = form.atualizarCliente(cpf, clienteRepository, buscaCep);
		clienteRepository.save(cli);
		return ResponseEntity.ok(new ClienteDto(cli));
	}

	@DeleteMapping("/{cpf}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable String cpf) {
		clienteRepository.deleteByCpf(cpf);
		return ResponseEntity.ok().build();
	}

}
