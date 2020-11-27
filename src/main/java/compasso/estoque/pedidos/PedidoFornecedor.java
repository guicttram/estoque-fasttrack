package compasso.estoque.pedidos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import compasso.estoque.models.Fornecedor;
import compasso.estoque.models.Loja;
import compasso.estoque.models.Produto;

@Entity
public class PedidoFornecedor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@ManyToOne
	private Loja loja;
	@ManyToOne
	private Fornecedor fornecedor;
	private List<Produto> pedido;
	private BigDecimal valorTotal;
	private LocalDate dataDoPedido;
	
	public PedidoFornecedor(Loja loja, Fornecedor fornecedor, List<Produto> pedido, BigDecimal valorTotal,
			LocalDate dataDoPedido) {
		this.loja = loja;
		this.fornecedor = fornecedor;
		this.pedido = pedido;
		this.valorTotal = valorTotal;
		this.dataDoPedido = dataDoPedido;
	}
}
