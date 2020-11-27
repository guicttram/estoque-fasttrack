package compasso.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import compasso.estoque.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

	List<Cliente> findByCpf(String cpf);

	void deleteByCpf(String cpf);

}
