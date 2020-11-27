package compasso.estoque.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import compasso.estoque.models.Loja;
import compasso.estoque.repository.LojaRepository;

public class AtualizarLojaForm {

	@NotNull
	@NotEmpty
	private String endereco;
	@NotNull
	@NotEmpty
	private String cidade;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Loja atualizar(String cnpj, LojaRepository lojaRepository) {
		Loja loja = lojaRepository.getOne(cnpj);
		loja.setEndereco(this.endereco);
		loja.setCidade(this.cidade);
		return loja;
	}

}
