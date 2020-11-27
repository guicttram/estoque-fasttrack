//package compasso.estoque.system;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import compasso.estoque.models.Categoria;
//import compasso.estoque.models.Cliente;
//import compasso.estoque.models.Fornecedor;
//import compasso.estoque.models.Loja;
//import compasso.estoque.models.PedidoFornecedor;
//import compasso.estoque.models.PedidoVenda;
//import compasso.estoque.models.Produto;
//import compasso.estoque.models.Vendedor;
//
//public class Sistema {
//
//	public static void main(String[] args) throws Exception {
//				
//		List<Loja> lojas = new ArrayList<Loja>();
//		lojas.add(new Loja("Amazon", "Rua das �rvores 3006", "Passo Fundo", "000.111/222-33"));
//		lojas.add(new Loja("Alura", "Av. Sete de Setembro 403", "Curitiba", "444.555/666-77"));
//		lojas.add(new Loja("Compasso", "Rua Grande 2810", "Mato Castelhano", "888.999/000-11"));
//
//		List<Cliente> clientes = new ArrayList<Cliente>();
//		clientes.add(new Cliente("Paulo Silveira", "000.111.222-33", "Av. Brasil 701", "S�o Paulo"));
//		clientes.add(new Cliente("Alexandre Ottoni", "444.555.666-77", "Rua das Alamedas 256", "Rio de Janeiro"));
//		clientes.add(new Cliente("Tommy Oliver", "888.999.000-11", "Rua das Corujas", "Gotham"));
//
//		List<Vendedor> vendedores = new ArrayList<Vendedor>();
//		vendedores.add(new Vendedor("Ednaldo Pereira", "2000.50", lojas.get(0), "EDP10"));
//		vendedores.add(new Vendedor("Barbara Gordon", "1750.63", lojas.get(1), "BARB5"));
//		vendedores.add(new Vendedor("Marcos Santos", "1565.49", lojas.get(2), "M4RC5"));
//
//		List<Categoria> categorias = new ArrayList<Categoria>();
//		categorias.add(new Categoria("Eletrodom�sticos", "EDOM35", "Produtos para a casa, principalmente a cozinha."));
//		categorias.add(new Categoria("Roupas", "ROUP45", "Vestu�rio casual completo, com qualidade."));
//		categorias.add(new Categoria("Video-Games", "GAM35",
//				"As novidades do mercado de games: consoles, jogos e acess�rios."));
//
//		List<Produto> produtos = new ArrayList<Produto>();
//		produtos.add(new Produto("Batedeira Brastemp", "BTD123", "349.99", 150, "220V e 1000W de pot�ncia",
//				categorias.get(0)));
//		produtos.add(new Produto("Roup�o de algod�o", "RP40", "79.99", 200, "Feito com material especial.",
//				categorias.get(1)));
//		produtos.add(new Produto("Console PlayStation 5", "PS5", "3999.99", 100, "Com leitor Blu-Ray e dupla voltagem.",
//				categorias.get(2)));
//
//		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
//		fornecedores.add(new Fornecedor("Shelby Company LTDA.", "Distrito de Birmingham, 1919"));
//		fornecedores.add(new Fornecedor("Wayne Enterprises", "Park Avenue, 1939"));
//		fornecedores.add(new Fornecedor("Boston Dynamics", "Boston Street, 2077"));
//
//		List<PedidoVenda> pedidosVenda = new ArrayList<PedidoVenda>();
//		List<PedidoFornecedor> pedidosFornecedor = new ArrayList<PedidoFornecedor>();
//
//		System.out.println("SISTEMA DE CONTROLE DE ESTOQUE");
//		System.out.println("------------------------------");
//		System.out.println("No menu principal, digite 'EXIT' para sair.\n"
//				+ "Cada comando tamb�m permite o cadastro do tipo selecionado.\n");
//
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//		while (true) {
//			List<String> comandos = Arrays.asList("EXIT", "VENDEDORES", "CLIENTES", "PRODUTOS", "PEDIDOS");
//			System.out.println("MENU PRINCIPAL\n");
//			System.out.println("COMANDOS:\n" + "LOJAS - Mostra a lista de lojas\n"
//					+ "VENDEDORES - Exibe a lista de vendedores, bem como a loja em que trabalham.\n"
//					+ "CLIENTES - Exibe a lista de clientes cadastrados no sistema.\n"
//					+ "PRODUTOS - Exibe a lista de categorias e produtos cadastrados no sistema.\n"
//					+ "PEDIDOS - Exibe o registro de pedidos de clientes e para fornecedores.");
//			String decisao = in.readLine().toUpperCase();
//
//			if (!comandos.contains(decisao))
//				System.out.println("Comando n�o indetificado ou no escopo incorreto.\nRetornando ao menu principal.");
//
//			if (decisao.equals("EXIT")) {
//				break;
//			}
//
//			if (decisao.equals("LOJAS")) {
//				List<String> comandos_scope = Arrays.asList("CADASTRAR", "ALTERAR", "REMOVER");
//				lojas.forEach(
//						l -> System.out.println("Loja: " + l.getNome() + " | N�mero da loja: " + lojas.indexOf(l)));
//				System.out.println("\nCOMANDOS:\n" + "CADASTRAR - Cadastra nova loja\n"
//						+ "ALTERAR - Altera informa��o de alguma loja j� cadastrada\n" + "REMOVER - Remove uma loja");
//				String comando = in.readLine().toUpperCase();
//				if (!comandos_scope.contains(comando))
//					System.out.println("Comando n�o indetificado ou no escopo incorreto.\nRetornando ao menu principal.");
//				if (comando.equals("CADASTRAR")) {
//					System.out.print("Nome da loja: ");
//					String nome = in.readLine();
//					System.out.print("Endere�o: ");
//					String endereco = in.readLine();
//					System.out.print("Cidade: ");
//					String cidade = in.readLine();
//					System.out.print("CNPJ: ");
//					String cnpj = in.readLine();
//					lojas.add(new Loja(nome, endereco, cidade, cnpj));
//				}
//
//				if (comando.equals("ALTERAR")) {
//					System.out.print("N�mero da loja a alterar: ");
//					Loja loja = lojas.get(Integer.parseInt(in.readLine()));
//					System.out.println("OP��ES:\n" + "CIDADE - Altera a cidade da loja\n"
//							+ "ENDERE�O - Altera o endereco da loja");
//					String opcao = in.readLine().toUpperCase();
//					if (opcao.equals("CIDADE")) {
//						System.out.println("Cidade a ser modificada: " + loja.getCidade());
//						System.out.print("Nova cidade: ");
//						loja.setCidade(in.readLine());
//					}
//					if (opcao.equals("ENDERECO")) {
//						System.out.println("Endereco a ser modificado: " + loja.getEndereco());
//						System.out.print("Novo endere�o: ");
//						loja.setEndereco((in.readLine()));
//					}
//				}
//
//				if (comando.equals("REMOVER")) {
//					System.out.print("N�mero da loja a remover: ");
//					lojas.remove(Integer.parseInt(in.readLine()));
//				}
//			}
//
//			if (decisao.toUpperCase().equals("VENDEDORES")) {
//				List<String> comandos_scope = Arrays.asList("CADASTRAR", "ALTERAR", "REMOVER");
//				vendedores.forEach(v -> System.out.println("Vendedor(a): " + v.getNome() + "  Loja: " + v.getNomeLoja()
//						+ "  N�mero do vendedor: " + vendedores.indexOf(v)));
//				System.out.println("\nCOMANDOS:\n" + "CADASTRAR - Cadastra novo vendedor\n"
//						+ "ALTERAR - Altera informa��o de algum vendedor j� cadastrado\n"
//						+ "REMOVER - Remove um vendedor");
//				String comando = in.readLine().toUpperCase();
//
//				if (comando.equals("CADASTRAR")) {
//					System.out.print("Nome do vendedor: ");
//					String nome = in.readLine();
//					System.out.print("Sal�rio: ");
//					String salario = in.readLine();
//					System.out.print("Loja n�mero: ");
//					Loja loja = lojas.get(Integer.parseInt(in.readLine()));
//					System.out.println("C�digo do vendedor: ");
//					String cod = in.readLine();
//					vendedores.add(new Vendedor(nome, salario, loja, cod));
//				}
//
//				if (comando.equals("ALTERAR")) {
//					System.out.print("N�mero do vendedor a alterar: ");
//					Vendedor vendedor = vendedores.get(Integer.parseInt(in.readLine()));
//					System.out.println("OP��ES:\n" + "SALARIO - Altera o sal�rio do vendedor\n"
//							+ "COMISSAO - Adiciona comiss�o\n" + "LOJA - Altera a loja de trabalho do funcion�rio");
//
//					String opcao = in.readLine().toUpperCase();
//					if (opcao.equals("SALARIO")) {
//						System.out.println("Sal�rio a ser modificado: R$" + vendedor.getSalario());
//						System.out.print("Novo sal�rio: ");
//						vendedor.setSalario(in.readLine());
//					}
//
//					if (opcao.equals("COMISSAO")) {
//						System.out.println("Comiss�o a ser modificada: R$" + vendedor.getComissao());
//						System.out.print("Valor a ser adicionado: R$");
//						vendedor.adicionarComissao(Double.parseDouble(in.readLine()));
//					}
//
//					if (opcao.equals("LOJA")) {
//						System.out.println("Loja de trabalho a ser alterada: " + vendedor.getNomeLoja());
//						System.out.print("N�mero da nova loja: ");
//						vendedor.setLoja(lojas.get(Integer.parseInt(in.readLine())));
//					}
//				}
//
//				if (comando.equals("REMOVER")) {
//					System.out.print("N�mero do vendedor a remover: ");
//					vendedores.remove(Integer.parseInt(in.readLine()));
//				}
//			}
//
//			if (decisao.equals("CLIENTES")) {
//				List<String> comandos_scope = Arrays.asList("CADASTRAR", "ALTERAR", "REMOVER");
//				clientes.forEach(
//						c -> System.out.println("Cliente: " + c.getNome() + " | N�mero: " + clientes.indexOf(c)));
//				System.out.println("\nCOMANDOS:\n" + "CADASTRAR - Cadastra novo cliente\n"
//						+ "ALTERAR - Altera informa��o de algum cliente j� cadastrado\n"
//						+ "REMOVER - Remove um cliente");
//				String comando = in.readLine().toUpperCase();
//				if (!comandos_scope.contains(comando))
//					System.out.println("Comando n�o indetificado ou no escopo incorreto.\nRetornando ao menu principal.");
//				if (comando.equals("CADASTRAR")) {
//					System.out.print("Nome do cliente: ");
//					String nome = in.readLine();
//					System.out.print("CPF: ");
//					String cpf = in.readLine();
//					System.out.print("Endere�o: ");
//					String endereco = in.readLine();
//					System.out.print("Cidade: ");
//					String cidade = in.readLine();
//					clientes.add(new Cliente(nome, cpf, endereco, cidade));
//				}
//
//				if (comando.equals("ALTERAR")) {
//					System.out.print("N�mero do cliente a alterar: ");
//					Cliente cliente = clientes.get(Integer.parseInt(in.readLine()));
//					System.out.println("OP��ES:\n" + "ENDERE�O - Altera o endere�o do cliente\n"
//							+ "CIDADE - Altera a cidade do cliente");
//
//					String opcao = in.readLine().toUpperCase();
//					if (opcao.equals("ENDERECO")) {
//						System.out.println("Endere�o a ser modificado: " + cliente.getEndereco());
//						System.out.print("Novo endere�o: ");
//						cliente.setEndereco(in.readLine());
//					}
//
//					if (opcao.equals("CIDADE")) {
//						System.out.println("Cidade a ser alterada: " + cliente.getCidade());
//						System.out.print("Nova cidade: ");
//						cliente.setCidade(in.readLine());
//						;
//					}
//				}
//
//				if (comando.equals("REMOVER")) {
//					System.out.print("N�mero do cliente a remover: ");
//					clientes.remove(Integer.parseInt(in.readLine()));
//				}
//			}
//
//			if (decisao.equals("PRODUTOS")) {
//				List<String> comandos_scope = Arrays.asList("CADASTRAR", "ALTERAR", "REMOVER");
//				categorias.forEach(c -> System.out
//						.println("Categoria: " + c.getNome() + " | N�mero de categoria: " + categorias.indexOf(c)));
//				System.out.println();
//				produtos.forEach(p -> System.out
//						.println("Produto: " + p.getNome() + " |  N�mero do produto: " + produtos.indexOf(p)
//								+ " | Categoria: " + p.getNomeCategoria() + " | Pre�o: R$" + p.getPrecoUnitario()));
//				System.out.println("\nCOMANDOS:\n" + "CADASTRAR - Cadastra novo produto\n"
//						+ "ALTERAR - Altera informa��o de algum produto j� cadastrado\n"
//						+ "REMOVER - Remove um produto");
//				String comando = in.readLine().toUpperCase();
//				if (!comandos_scope.contains(comando))
//					System.out.println("Comando n�o indetificado ou no escopo incorreto.\nRetornando ao menu principal.");
//				if (comando.equals("CADASTRAR")) {
//					System.out.print("Nome do produto: ");
//					String nome = in.readLine();
//					System.out.print("C�digo: ");
//					String codigo = in.readLine();
//					System.out.print("Pre�o unit�rio: R$");
//					String preco = in.readLine();
//					System.out.print("Quantidade no estoque: ");
//					Integer quantidade = Integer.parseInt(in.readLine());
//					System.out.print("Breve descri��o: ");
//					String descricao = in.readLine();
//					System.out.println("N�mero da categoria: ");
//					Categoria categoria = categorias.get(Integer.parseInt(in.readLine()));
//					produtos.add(new Produto(nome, codigo, preco, quantidade, descricao, categoria));
//				}
//
//				if (comando.equals("ALTERAR")) {
//					System.out.print("N�mero do produto a alterar: ");
//					Produto produto = produtos.get(Integer.parseInt(in.readLine()));
//					System.out.println(
//							"OP��ES:\n" + "NOME - Altera o nome do produto\n" + "PRECO - Altera o pre�o do produto\n"
//									+ "QUANTIDADE - Altera a quantidade do produto no estoque\n"
//									+ "DESCRICAO - Altera a descri��o do produto\n"
//									+ "CATEGORIA - Altera a categoria do produto");
//
//					String opcao = in.readLine().toUpperCase();
//					if (opcao.equals("NOME")) {
//						System.out.println("Nome a ser modificado: " + produto.getNome());
//						System.out.print("Novo nome: ");
//						produto.setNome(in.readLine());
//					}
//
//					if (opcao.equals("PRECO")) {
//						System.out.println("Pre�o a ser alterado: " + produto.getPrecoUnitario());
//						System.out.print("Novo pre�o: ");
//						produto.setPrecoUnitario(in.readLine());
//					}
//
//					if (opcao.equals("QUANTIDADE")) {
//						System.out.println("Quantidade a ser alterada: " + produto.getQuantidade());
//						System.out.print("Quantidade atual: ");
//						produto.setQuantidade(Integer.parseInt(in.readLine()));
//					}
//
//					if (opcao.equals("DESCRICAO")) {
//						System.out.println("Descri��o atual: " + produto.getDescricao());
//						System.out.print("Nova descri��o: ");
//						produto.setDescricao(in.readLine());
//					}
//
//					if (opcao.equals("CATEGORIA")) {
//						System.out.println("Categoria atual: " + produto.getCategoria());
//						System.out.print("Nova categoria: ");
//						produto.setCategoria(categorias.get(Integer.parseInt(in.readLine())));
//					}
//				}
//
//				if (comando.equals("REMOVER")) {
//					System.out.print("N�mero do produto a remover: ");
//					produtos.remove(Integer.parseInt(in.readLine()));
//				}
//			}
//
//			if (decisao.equals("PEDIDOS")) {
//				List<String> comandos_scope = Arrays.asList("VENDA", "REQUISICAO");
//				System.out.println("Hist�rico de pedidos de clientes:");
//				pedidosVenda.forEach(p -> System.out.println(p.getVenda()));
//				System.out.println("OP��ES:\n" + "VENDA - Registra um novo pedido de cliente, ou seja, uma venda\n"
//						+ "REQUISICAO - Registra um novo pedido da loja ao fornecedor");
//				String opcao = in.readLine().toUpperCase();
//				if (!comandos_scope.contains(opcao))
//					System.out.println("Comando n�o indetificado ou no escopo incorreto.\nRetornando ao menu principal.");
//				if (opcao.equals("VENDA")) {
//					System.out.print("N�mero do cliente que realizou o pedido: ");
//					Cliente cli = clientes.get(Integer.parseInt(in.readLine()));
//					System.out.print("N�mero do vendedor respons�vel: ");
//					Vendedor vend = vendedores.get(Integer.parseInt(in.readLine()));
//					System.out.print("N�mero de itens no pedido: ");
//					List<Produto> pedido = new ArrayList<Produto>();
//					Integer i = Integer.parseInt(in.readLine());
//					BigDecimal valorTotal = new BigDecimal("0.0");
//					System.out.println("Informe os n�meros dos produtos desejados:");
//					for (int c = 0; c < i; c++) {
//						Produto produtoAtual = produtos.get(Integer.parseInt(in.readLine()));
//						pedido.add(produtoAtual);
//						valorTotal.add(produtoAtual.getPrecoUnitario());
//					}
//					LocalDate dataDoPedido = LocalDate.now();
//					pedidosVenda.add(new PedidoVenda(cli, vend, pedido, valorTotal, dataDoPedido));
//				}
//
//				if (opcao.equals("REQUISICAO")) {
//					System.out.print("N�mero da loja requisitante: ");
//					Loja loja = lojas.get(Integer.parseInt(in.readLine()));
//					System.out.print("N�mero do fornecedor de escolha: ");
//					Fornecedor fornecedor = fornecedores.get(Integer.parseInt(in.readLine()));
//					System.out.print("N�mero de itens no pedido: ");
//					List<Produto> pedido = new ArrayList<Produto>();
//					Integer i = Integer.parseInt(in.readLine());
//					BigDecimal valorTotal = new BigDecimal("0.0");
//					System.out.println("Informe os n�meros dos produtos desejados:");
//					for (int c = 0; c < i; c++) {
//						Produto produtoAtual = produtos.get(Integer.parseInt(in.readLine()));
//						pedido.add(produtoAtual);
//						valorTotal.add(produtoAtual.getPrecoUnitario());
//					}
//					LocalDate dataDoPedido = LocalDate.now();
//					pedidosFornecedor.add(new PedidoFornecedor(loja, fornecedor, pedido, valorTotal, dataDoPedido));
//				}
//			}
//
//		}
//	}
//}
