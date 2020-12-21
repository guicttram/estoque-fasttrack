package compasso.estoque.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import compasso.estoque.client.response.ViaCepResponse;

@Service
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
