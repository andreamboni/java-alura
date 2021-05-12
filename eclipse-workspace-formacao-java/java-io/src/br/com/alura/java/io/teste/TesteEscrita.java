package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscrita {

	public static void main(String[] args) throws IOException {
		
		//Fluxo de escrita/saida
		OutputStream fis = new FileOutputStream("lorem2.txt");
		Writer osw = new OutputStreamWriter(fis);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium,");
		bw.newLine();
		bw.newLine();
		bw.write("totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.");
		
		bw.close();
	}

}
