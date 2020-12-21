package compasso.estoque.service;

import org.springframework.http.ResponseEntity;

import compasso.estoque.client.response.ViaCepResponse;

public class CepServiceImpl implements CepService {

	@Override
	public String criaRua(ResponseEntity<ViaCepResponse> buscaCep) {
		return buscaCep.getBody().getLogradouro();
	}
	
	@Override
	public String criaCidade(ResponseEntity<ViaCepResponse> buscaCep) {
		return buscaCep.getBody().getLocalidade();
	}

	
}
