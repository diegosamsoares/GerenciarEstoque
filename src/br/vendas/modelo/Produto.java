package br.vendas.modelo;

public class Produto {

 private	Long id;
 private	String descricao;
 private	double valorcompra;
 private	double valorvenda;
 private	double peso;
 private    double saldo;

public double getSaldo() {
	return saldo;
}
public void setSaldo(double saldo) {
	this.saldo = saldo;
}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public double getValorcompra() {
	return valorcompra;
}
public void setValorcompra(double valorcompra) {
	this.valorcompra = valorcompra;
}
public double getValorvenda() {
	return valorvenda;
}
public void setValorvenda(double valorvenda) {
	this.valorvenda = valorvenda;
}
public double getPeso() {
	return peso;
}
public void setPeso(double peso) {
	this.peso = peso;
}

 

	
}
