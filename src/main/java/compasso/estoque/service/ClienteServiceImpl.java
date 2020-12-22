package compasso.estoque.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import compasso.estoque.client.response.ViaCepResponse;
import compasso.estoque.controller.form.ClienteForm;
import compasso.estoque.models.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Override
	public Cliente criaCliente(ClienteForm form, ResponseEntity<ViaCepResponse> buscaCep) {
		Cliente cliente = new Cliente();
		cliente.setNome(form.getNome());
		cliente.setCpf(form.getCpf());
		cliente.setCep(form.getCep());
		cliente.setEndereco(buscaCep.getBody().getLogradouro() + ", " + form.getNumero());
		cliente.setCidade(buscaCep.getBody().getLocalidade());
		
		return cliente;
	}

}
