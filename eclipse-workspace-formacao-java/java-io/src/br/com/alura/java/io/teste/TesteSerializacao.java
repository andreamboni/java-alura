package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacao {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// Transformando a string em um binário e gravando no arquivo .bin
		String nome = "Nico Steppat";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.bin"));
		oos.writeObject(nome);
		
		// Pegando o conteúdo binário do arquivo e atribuindo ele à uma string
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.bin"));
		String nome2 = (String) ois.readObject();// Como eu recebo um Objecto, a referência mais genérica possível, eu preciso fazer um casting 
		System.out.println(nome2);
		
		oos.close();
		ois.close();
		
	}
}
