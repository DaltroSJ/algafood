insert into cozinha (id, nome) values (1,'Tailandesa');
insert into cozinha (id, nome) values (2,'Chinesa');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Restaurante do Gaucho', 7.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Restaurante Caça Rola', 3.80, 2);

insert into forma_pagamento (descricao) values ('Dinheiro');
insert into forma_pagamento (descricao) values ('Cartão');

insert into permissao (nome, descricao) values ('Aceita Desconto','Usuario tem permissão para dar desconto nas vendas.')
insert into permissao (nome, descricao) values ('Permite trocar mercadoria do pedido','Usuario tem permissão para trocar produtos dos pedidos.')

insert into estado (nome) values ('Goiás')
insert into estado (nome) values ('Distrito Federal')

insert into cidade (nome, estado_id) values ('Águas Lindas de Goiás',1)
insert into cidade (nome, estado_id) values ('Brasília',2)