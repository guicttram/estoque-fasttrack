package compasso.estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import compasso.estoque.client.response.ViaCepResponse;
import compasso.estoque.controller.form.ClienteForm;
import compasso.estoque.models.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private CepServiceImpl cepService;
	
	@Override
	public Cliente criaCliente(ClienteForm form, ResponseEntity<ViaCepResponse> buscaCep) {
		Cliente cliente = new Cliente();
		cliente.setNome(form.getNome());
		cliente.setCpf(form.getCpf());
		cliente.setCep(form.getCep());
		cliente.setEndereco(cepService.criaRua(buscaCep) + ", " + form.getNumero());
		cliente.setCidade(cepService.criaCidade(buscaCep));
		
		return cliente;
	}

}
