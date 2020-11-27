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

import compasso.estoque.controller.dto.ProdutoDto;
import compasso.estoque.controller.form.AtualizarProdutoForm;
import compasso.estoque.controller.form.ProdutoForm;
import compasso.estoque.models.Produto;
import compasso.estoque.repository.CategoriaRepository;
import compasso.estoque.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@GetMapping
	public List<ProdutoDto> lista(){
			List<Produto> produtos = produtoRepository.findAll();
			return ProdutoDto.converterLista(produtos);
			
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder){
		Produto prod = form.converter(categoriaRepository);
		produtoRepository.save(prod);
		
		URI uri = uriBuilder.path("/produtos/{codigo}").buildAndExpand(prod.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(prod));
	}
	
	@GetMapping("/{id}")
	public ProdutoDto detalhar(@PathVariable Long id) {
		Produto produtos = produtoRepository.getOne(id);
		return ProdutoDto.converter(produtos);

	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarProdutoForm form){
		Produto prod = form.atualizar(id, produtoRepository);
		return ResponseEntity.ok(new ProdutoDto(prod));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		produtoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
}
