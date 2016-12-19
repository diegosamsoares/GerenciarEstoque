# GerenciarEstoque

dia 14/12/2016 ainda não concluído.
faltando validações , movimentação dos produtos , relatórios.
Segue o projeto de um Sistema para gerencia de um estoque
Se faz necessário o mysql,
Na classe ConnectionFactiory configurar o servidor , banco e senha criados
bem como no banco de dados criar as tabelas, segue o script das tabelas:


create table cad_produtos(
id int not null AUTO_INCREMENT,
descricao varchar(45) null,
peso float null,
valorcompra float null,
valorvenda float null,
saldo float null,
PRIMARY KEY (ID)


)




CREATE TABLE MOV_ESTOQUE (
	MOV_ID int NOT NULL auto_increment ,
	MOV_DATA varchar (20) NOT  NULL ,
  MOV_TIPO varchar(20) NOT NULL,
	primary key(VENDA_id)
	
	
) 


CREATE TABLE TB_MOVITENS (
	ITENS_ID int NOT NULL AUTO_INCREMENT ,
  MOV_ID INT NOT NULL,
  PRODID NOT ,
	
PRIMARY KEY (ITEM_ID)	
	
);
