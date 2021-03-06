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
import compasso.estoque.controller.dto.LojaDto;
import compasso.estoque.controller.form.AtualizarForm;
import compasso.estoque.controller.form.LojaForm;
import compasso.estoque.models.Loja;
import compasso.estoque.models.Vendedor;
import compasso.estoque.repository.LojaRepository;
import compasso.estoque.repository.VendedorRepository;
import compasso.estoque.service.LojaServiceImpl;

@RestController
@RequestMapping("/lojas")
public class LojasController {
	
	@Autowired
	private ViaCepClient viaCepClient;

	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;

	@GetMapping
	public List<LojaDto> lista() {

		List<Loja> lojas = lojaRepository.findAll();
		return LojaDto.converter(lojas);

	}

	@PostMapping
	@Transactional
	public ResponseEntity<LojaDto> cadastrar(@RequestBody @Valid LojaForm form, UriComponentsBuilder uriBuilder) {
	
		ResponseEntity<ViaCepResponse> buscaCep = viaCepClient.buscaCep(form.getCep());
		Loja loja = new LojaServiceImpl().criaLoja(form, buscaCep);
		lojaRepository.save(loja);

		URI uri = uriBuilder.path("/lojas/{cnpj}").buildAndExpand(loja.getCnpj()).toUri();
		return ResponseEntity.created(uri).body(new LojaDto(loja));
	}

	@GetMapping("/{nome}")
	public List<LojaDto> detalhar(@PathVariable String nome) {
		List<Loja> lojas = lojaRepository.findByNome(nome);
		return LojaDto.converter(lojas);

	}
	
	@PutMapping("/{cnpj}")
	@Transactional
	public ResponseEntity<LojaDto> atualizar(@PathVariable String cnpj, @RequestBody @Valid AtualizarForm form){
		ResponseEntity<ViaCepResponse> buscaCep = viaCepClient.buscaCep(form.getCep());
		Loja loja = form.atualizarLoja(cnpj, lojaRepository, buscaCep);
		lojaRepository.save(loja);
		return ResponseEntity.ok(new LojaDto(loja));
	}
	
	@DeleteMapping("/{cnpj}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable String cnpj){	
		List<Vendedor> vendedores = vendedorRepository.findByLoja_Cnpj(cnpj);
		vendedorRepository.deleteAll(vendedores);
		lojaRepository.deleteByCnpj(cnpj);
		return ResponseEntity.ok().build();
	}

}




