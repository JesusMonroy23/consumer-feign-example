package com.consumer;

public class Response {
	private String valor;
	private String valor2;
	private String valor3;
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getValor2() {
		return valor2;
	}
	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}
	public String getValor3() {
		return valor3;
	}
	public void setValor3(String valor3) {
		this.valor3 = valor3;
	}
	public Response(String valor, String valor2, String valor3) {
		super();
		this.valor = valor;
		this.valor2 = valor2;
		this.valor3 = valor3;
	}
	public Response() {
		super();
	}
	
	
}
