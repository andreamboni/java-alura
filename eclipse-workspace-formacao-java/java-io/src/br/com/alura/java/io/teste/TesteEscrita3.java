package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class TesteEscrita3 {

	public static void main(String[] args) throws IOException {
//		PrintStream ps = new PrintStream("lorem2.txt");
		PrintWriter pw = new PrintWriter("lorem2.txt");
		
		pw.println("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium,");
		pw.println();
		pw.println("totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.");
		
		pw.close();
		
	}
}
