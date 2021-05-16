package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacaoCliente {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Nico");
		cliente.setProfissao("Dev");
		cliente.setCpf("46532158660");
		
		// Serialização
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
		oos.writeObject(cliente);
		
		// Desserialização
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin"));
		Cliente cliente2 = (Cliente) ois.readObject();
		
		System.out.println(cliente2.getNome());
		System.out.println(cliente2.getCpf());
		System.out.println(cliente2.getProfissao());
		
		oos.close();
		ois.close();
		
	}
}
