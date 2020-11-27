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

import compasso.estoque.controller.dto.LojaDto;
import compasso.estoque.controller.form.AtualizarLojaForm;
import compasso.estoque.controller.form.LojaForm;
import compasso.estoque.models.Loja;
import compasso.estoque.models.Vendedor;
import compasso.estoque.repository.LojaRepository;
import compasso.estoque.repository.VendedorRepository;

@RestController
@RequestMapping("/lojas")
public class LojasController {

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
		Loja loja = form.converter();
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
	public ResponseEntity<LojaDto> atualizar(@PathVariable String cnpj, @RequestBody @Valid AtualizarLojaForm form){
		Loja loja = form.atualizar(cnpj, lojaRepository);
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




