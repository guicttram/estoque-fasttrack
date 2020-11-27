package compasso.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import compasso.estoque.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	Categoria findByNome(String nome);

}
