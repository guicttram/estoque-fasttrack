package compasso.estoque.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import compasso.estoque.client.response.ViaCepResponse;
import compasso.estoque.controller.form.LojaForm;
import compasso.estoque.models.Loja;


@Service
public class LojaServiceImpl implements LojaService {

	@Override
	public Loja criaLoja(LojaForm form, ResponseEntity<ViaCepResponse> buscaCep) {
		Loja loja = new Loja();
		loja.setNome(form.getNome());
		loja.setCnpj(form.getCnpj());
		loja.setCep(form.getCep());
		loja.setEndereco(buscaCep.getBody().getLogradouro() + ", " + form.getNumero());
		loja.setCidade(buscaCep.getBody().getLocalidade());
		return loja;
	}

}
