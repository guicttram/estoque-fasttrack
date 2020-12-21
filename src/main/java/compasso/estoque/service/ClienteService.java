package compasso.estoque.service;

import org.springframework.http.ResponseEntity;

import compasso.estoque.client.response.ViaCepResponse;
import compasso.estoque.controller.form.ClienteForm;
import compasso.estoque.models.Cliente;

public interface ClienteService {
	
	public Cliente criaCliente(ClienteForm form, ResponseEntity<ViaCepResponse> buscaCep);

}
