package compasso.estoque.service;

import org.springframework.http.ResponseEntity;

import compasso.estoque.client.response.ViaCepResponse;
import compasso.estoque.controller.form.LojaForm;
import compasso.estoque.models.Loja;

public interface LojaService {

	public Loja criaLoja(LojaForm form, ResponseEntity<ViaCepResponse> buscaCep);
}
