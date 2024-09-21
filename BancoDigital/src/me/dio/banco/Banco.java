package me.dio.banco;

import java.util.List;

public class Banco {
	private String nome;
	private List<Cliente> listaDeClientes;
	
	public Banco(String nome, List<Cliente> listaDeClientes) {
		super();
		this.nome = nome;
		this.listaDeClientes = listaDeClientes;
	}
	
	public void adicionarCliente(Cliente cliente) {
		listaDeClientes.add(cliente);
		
	}

	public void listarClientes() {
		for(Cliente clientes : listaDeClientes) {
			System.out.println(clientes.getNome());
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(List<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
	
}
