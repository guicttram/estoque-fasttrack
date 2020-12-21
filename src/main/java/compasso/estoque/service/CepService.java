package compasso.estoque.service;

import org.springframework.http.ResponseEntity;

import compasso.estoque.client.response.ViaCepResponse;

public interface CepService {

	public String criaRua(ResponseEntity<ViaCepResponse> buscaCep);
	public String criaCidade(ResponseEntity<ViaCepResponse> buscaCep);
}
