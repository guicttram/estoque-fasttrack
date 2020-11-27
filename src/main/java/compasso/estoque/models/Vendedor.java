package compasso.estoque.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vendedor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal salario;
	private BigDecimal comissao;
	@ManyToOne
	private Loja loja;
	
	public Vendedor() {
		
	}
	
	public Vendedor(String nome, String salario, Loja loja) {
		this.nome = nome;
		this.salario = new BigDecimal(salario);
		this.comissao = new BigDecimal("0.0");
		this.loja = loja;
	}
	
	public void adicionarComissao(double valor) {
		this.comissao = this.comissao.add((new BigDecimal(String.valueOf(valor))));
	}
	
	public Loja getLoja() {
		return loja;
	}
	
	public String getNomeLoja() {
		return loja.getNome();
	}
	
	public String getNome() {
		return nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}
	
	public String getSalarioAsString() {
		return String.valueOf(salario);
	}

	public void setSalario(String salario) {
		this.salario = this.salario.add(new BigDecimal(salario));
	}

	public BigDecimal getComissao() {
		return comissao;
	}
	
	public String getComissaoAsString() {
		return String.valueOf(comissao);
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Long getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
	
	

}
