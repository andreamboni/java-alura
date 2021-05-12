package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TesteLeituraEscrita {
	
	public static void main(String[] args) throws IOException {
		
		Socket s = new Socket();
		
		// Fluxo de entrada
		InputStream fis = s.getInputStream(); //System.in //new FileInputStream("dbz-intro.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		// Fluxo de escrita/saida
		OutputStream fus = s.getOutputStream(); //System.out //new FileOutputStream("dbz-intro-novo.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fus);
		BufferedWriter bw = new BufferedWriter(osw);
		
		String line = br.readLine();

		while(line != null && !line.isEmpty()) {
			bw.write(line);
			bw.newLine();
			line = br.readLine();
		}
		
		br.close();
		bw.close();
		
	}
}
