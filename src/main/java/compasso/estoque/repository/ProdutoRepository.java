package compasso.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import compasso.estoque.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto getOne(Long id);

}
