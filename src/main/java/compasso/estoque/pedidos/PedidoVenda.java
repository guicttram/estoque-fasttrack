package compasso.estoque.pedidos;
//package compasso.estoque.models;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class PedidoVenda {
//	
//	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer codigo;
//	@ManyToOne
//	private Cliente cliente;
//	@ManyToOne
//	private Vendedor vendedor;
//	private List<Produto> pedido;
//	private BigDecimal valorTotal;
//	private LocalDate dataDoPedido;
//	
//	public PedidoVenda() {
//		
//	}
//	
//	public PedidoVenda(Cliente cliente, Vendedor vendedor, List<Produto> pedido, BigDecimal valorTotal,
//			LocalDate dataDoPedido) {
//		this.cliente = cliente;
//		this.vendedor = vendedor;
//		this.pedido = pedido;
//		this.valorTotal = valorTotal;
//		this.dataDoPedido = dataDoPedido;
//	}
//	
//	public String getVenda() {
//		return "Cliente: " + cliente.getNome() + " | Vendedor: " + vendedor.getNome() 
//			+ " | Produto(s): " + pedido.stream().map(p -> p.getNome()).collect(Collectors.toList()) + " | Valor total: R$" + valorTotal
//			+ "Data do pedido: " + dataDoPedido;
//	}
//
//	
//}
