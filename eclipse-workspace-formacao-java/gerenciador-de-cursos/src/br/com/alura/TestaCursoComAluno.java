package br.com.alura;

import java.util.Set;

public class TestaCursoComAluno {
	
	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 24));
		
		// Tenho que criar 3 alunos.
		Aluno a1 = new Aluno("Luiz Henrique", 1001);
		Aluno a2 = new Aluno("Mariana Frotas", 1002);
		Aluno a3 = new Aluno("Maria Clara", 1003);
		Aluno a4 = new Aluno("Siliane Amboni", 1004);
		
		// Tenho que matricular esses três alunos no curso.
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		javaColecoes.matricula(a4);
		
		// Colocar um sysout com o texto todos alunos matriculados
		System.out.println("Todos alunos matrículados: ");
		// Um foreach para mostrar esses alunos
		javaColecoes.getAlunos().forEach(a -> {
			System.out.println(a);
			
		});
		
		javaColecoes.estaMatriculado(a1);

	}
}
