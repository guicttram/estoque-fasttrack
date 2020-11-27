package compasso.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import compasso.estoque.models.Loja;

public interface LojaRepository extends JpaRepository<Loja, String>{

	List<Loja> findByNome(String nome);

	void deleteByCnpj(String cnpj);


}
