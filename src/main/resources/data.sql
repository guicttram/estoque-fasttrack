INSERT INTO LOJA(nome, endereco, cidade, cep, cnpj) VALUES('Amazon', 'Rua Morom, 2015', 'Passo Fundo', '99010035', '25600150000167');
INSERT INTO LOJA(nome, endereco, cidade, cep, cnpj) VALUES('Renner', 'Av. Brasil, 1486', 'Porto Alegre', '99066032','17140918000139');

INSERT INTO VENDEDOR(nome, salario, comissao, loja_cnpj) VALUES('João Silva', '2560.29', '347.77', '25600150000167');
INSERT INTO VENDEDOR(nome, salario, comissao, loja_cnpj) VALUES('Maria Almeida', '2589.99', '466.63', '17140918000139');

INSERT INTO CLIENTE(nome, cpf, endereco, cep, cidade) VALUES('Leonardo Marcondes', '27566027018', 'Rua Paissandu, 306', '99010035', 'Passo Fundo');
INSERT INTO CLIENTE(nome, cpf, endereco, cep, cidade) VALUES('Maria Luísa Amaral', '44599090069', 'Rua General, 745', '99010035', 'Marau');

INSERT INTO CATEGORIA(nome, descricao) VALUES('Eletrodomésticos', 'Produtos para a casa com diferentes voltagens e potências');
INSERT INTO CATEGORIA(nome, descricao) VALUES('Roupas', 'Produtos para todos os corpos, com qualidade e estilo');

INSERT INTO PRODUTO(nome, preco_unitario, quantidade, descricao, categoria_codigo) VALUES('Batedeira Brastemp', '345.49', 100, 'Batedeira vermelha com 1100W de potência, bivolt', 1);
INSERT INTO PRODUTO(nome, preco_unitario, quantidade, descricao, categoria_codigo) VALUES('Jaqueta Couro Gucci', '1255.49', 20, 'Jaqueta exclusivo, de luxo e material de alta qualidade', 2);

INSERT INTO FORNECEDOR(nome, endereco) VALUES ('Equipamentos Pedroso', 'RS-130');
INSERT INTO FORNECEDOR(nome, endereco) VALUES ('Gucci Filial', 'Avenida Grande, 899');
