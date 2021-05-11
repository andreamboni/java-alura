package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exemplo {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("lorem.txt");
		InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br =  new BufferedReader(isr);

		String linha = br.readLine();
		
		System.out.println(linha);
		
		br.close();
	}

}
