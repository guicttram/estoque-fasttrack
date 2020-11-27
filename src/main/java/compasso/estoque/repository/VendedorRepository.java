package compasso.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import compasso.estoque.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, String>{

	List<Vendedor> findByLoja_Cnpj(String cnpj);

}
