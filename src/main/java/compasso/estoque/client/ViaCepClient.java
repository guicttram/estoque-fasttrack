package compasso.estoque.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import compasso.estoque.client.response.ViaCepResponse;

@FeignClient(name = "VieCepClient", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

	@GetMapping("/{cep}/json/")
	ResponseEntity<ViaCepResponse> buscaCep (@PathVariable String cep);
}
